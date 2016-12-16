package view.member;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Roomblimpl.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import po.RoomPO;

public class AddRoomController{

	private int roomNum;
	private RoomType roomType;
	private double roomPrice;
	private String roomIntroduction;
	private ObservableList<RoomType> list;
	
	
	@FXML
	private TextArea RoomNumBar;
	@FXML
	private ToolBar toolBar;
	@FXML
	private Label GroupNameLabel;
	@FXML
	private ChoiceBox<RoomType> RoomTypeBar;
	@FXML
	private TextArea RoomIDBar;
	@FXML
	private Label HotelNameLabel;
	@FXML
	private Button ConfirmButton;
	@FXML
	private TextArea RoomPriceBar;
	@FXML
	private TextArea RoomIntroductionBar;
	
	@FXML
	private AnchorPane baseBar;
	@FXML
	private AnchorPane ContentBar;
	
	private Main main;

	/**
	 * 构造方法：初始化
	 */
	public AddRoomController() {
		System.out.println("test");
		baseBar = new AnchorPane();
		ContentBar = new AnchorPane();
		
		list = FXCollections.observableArrayList();
		list.add(RoomType.单人间);
		list.add(RoomType.商务间);
		list.add(RoomType.标准间);
		list.add(RoomType.行政标准间);
		list.add(RoomType.高级套间);
		
		main = Main.getMain();
		RoomNumBar = new TextArea();
		RoomNumBar.setText("text");
		toolBar = new ToolBar();
		GroupNameLabel = new Label();
		GroupNameLabel.setText("text");
		RoomTypeBar = new ChoiceBox<RoomType>(list);
		RoomIDBar = new TextArea();
		HotelNameLabel = new Label();
		ConfirmButton = new Button();
		RoomPriceBar = new TextArea();
		RoomIntroductionBar = new TextArea();
	}
	 @FXML
	    private void initialize(){
		RoomNumBar.setText("test");
	}
	

	@FXML
	public ArrayList<RoomPO> confirmRoomInformation() {
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		roomNum = Integer.valueOf(RoomNumBar.getText());
		roomType = RoomTypeBar.getValue();
		roomPrice = Double.valueOf(RoomPriceBar.getText());
		roomIntroduction = RoomIntroductionBar.getText();
		
		if (roomNum == 1) {
			RoomPO roomPO = new RoomPO(RoomIDBar.getText(), HotelNameLabel.getText(), roomType, roomIntroduction, roomPrice, null);
			roomList.add(roomPO);
			
		}else{
			String[] list =  RoomIDBar.getText().split(",");
			for(String cell:list){
				RoomPO roomPO = new RoomPO(cell, HotelNameLabel.getText(), roomType, roomIntroduction, roomPrice, null);
				roomList.add(roomPO);
			}
		}
		return roomList;
	}
	
}
