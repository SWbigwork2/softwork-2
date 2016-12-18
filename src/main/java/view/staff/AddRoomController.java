package view.staff;

import java.util.ArrayList;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	private void initialize(){
		roomTypeList = FXCollections.observableArrayList();
		roomTypeList.add(RoomType.单人间);
		roomTypeList.add(RoomType.商务间);
		roomTypeList.add(RoomType.标准间);
		roomTypeList.add(RoomType.行政标准间);
		roomTypeList.add(RoomType.高级套间);
		RoomTypeBar.setItems(roomTypeList);
		
	}

	@FXML
	public void confirmRoomInformation() {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomList = new ArrayList<RoomVo>();
		roomNum = Integer.valueOf(RoomNumBar.getText());
		roomType = RoomTypeBar.getValue();
		roomPrice = Double.valueOf(RoomPriceBar.getText());
		roomIntroduction = RoomIntroductionBar.getText();
		
		if (roomNum == 1) {
			RoomVo roomVO = new RoomVo(Integer.valueOf(RoomIDBar.getText()), hotelName, roomType, roomIntroduction, roomPrice);
			roomList.add(roomVO);
			
		}else{
			String[] list =  RoomIDBar.getText().split(",");
			for(String cell:list){
				RoomVo roomVo = new RoomVo(Integer.valueOf(cell), hotelName, roomType, roomIntroduction, roomPrice);
				roomList.add(roomVo);
			}
		}
		roomService.addNewRoom(roomList);
	}
	
	public void setHotelName(String hotelName){
		this.hotelName=hotelName;
	}
	

}
