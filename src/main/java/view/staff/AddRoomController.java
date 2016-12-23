package view.staff;

import java.util.ArrayList;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import view.member.RoomVo;

public class AddRoomController {

	private ObservableList<RoomType> roomTypeList;
	private int roomNum;
	private RoomType roomType;
	private double roomPrice;
	private String roomIntroduction;
	private String hotelName;

	@FXML
	private TextField RoomNumBar;
	@FXML
	private ChoiceBox<RoomType> RoomTypeBar;
	@FXML
	private TextField RoomIDBar;
	@FXML
	private Label HotelNameLabel;
	@FXML
	private Button ConfirmButton;
	@FXML
	private TextField RoomPriceBar;
	@FXML
	private TextArea RoomIntroductionBar;
	private Main main;

	/**
	 * 构造方法：初始化
	 */
	public AddRoomController() {
		main = Main.getMain();
		RoomNumBar = new TextField();
		RoomTypeBar = new ChoiceBox<RoomType>();
		RoomIDBar = new TextField();
		HotelNameLabel = new Label();
		ConfirmButton = new Button();
		RoomPriceBar = new TextField();
		RoomIntroductionBar = new TextArea();
	}

	@FXML
	private void initialize() {
		roomTypeList = FXCollections.observableArrayList();
		roomTypeList.add(RoomType.单人间);
		roomTypeList.add(RoomType.商务间);
		roomTypeList.add(RoomType.标准间);
		roomTypeList.add(RoomType.行政标准间);
		roomTypeList.add(RoomType.高级套间);
		RoomTypeBar.setItems(roomTypeList);
		HotelNameLabel.setText(hotelName);

	}

	@FXML
	public void confirmRoomInformation() {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomList = new ArrayList<RoomVo>();
		roomNum = Integer.valueOf(RoomNumBar.getText());
		roomType = RoomTypeBar.getValue();
		roomPrice = Double.valueOf(RoomPriceBar.getText());
		roomIntroduction = RoomIntroductionBar.getText();
		String[] list = null;

		if (roomNum == 1) {
			RoomVo roomVO = new RoomVo(Integer.valueOf(RoomIDBar.getText()), hotelName, roomType, roomIntroduction,
					roomPrice);
			roomList.add(roomVO);

		} else {
			try {
				list = RoomIDBar.getText().split(",");
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("分隔符为半角英文逗号");
				alert.showAndWait();
				return;
			}
			if (list.length != roomNum) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("请核对房间ID数目与与添加房间数目");
				alert.showAndWait();
				return;
			}	
			for (String cell : list) {
				RoomVo roomVo = new RoomVo(Integer.valueOf(cell), hotelName, roomType, roomIntroduction, roomPrice);
				roomList.add(roomVo);
			}
		}

		roomService.addNewRoom(roomList);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText("房间添加成功");
		alert.showAndWait();
		
		RoomIDBar.setText("");
		RoomTypeBar.setValue(null);
		RoomPriceBar.setText("");
		RoomIntroductionBar.setText("");
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
