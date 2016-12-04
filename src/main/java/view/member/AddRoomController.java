package view.member;

import java.util.ArrayList;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import Roomblimpl.RoomType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import po.RoomPO;

public class AddRoomController {

	private int roomNum;
	private RoomType roomType;
	private ArrayList<RoomPO> roomList;
	private double roomPrice;
	private String roomIntroduction;
	
	
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
	private MemberMain main;

	/**
	 * 构造方法：初始化
	 */
	public AddRoomController() {
		main = MemberMain.getInstance();
		RoomNumBar = new TextArea();
		toolBar = new ToolBar();
		GroupNameLabel = new Label();
		RoomTypeBar = new ChoiceBox<RoomType>();
		RoomIDBar = new TextArea();
		HotelNameLabel = new Label();
		ConfirmButton = new Button();
		RoomPriceBar = new TextArea();
		RoomIntroductionBar = new TextArea();
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
