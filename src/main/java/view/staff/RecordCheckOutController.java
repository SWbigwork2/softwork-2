package view.staff;

import java.time.LocalDate;

import Roomblimpl.RoomServiceImpl;
import blservice.RoomService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RecordCheckOutController {
	
	RoomService roomService = new RoomServiceImpl();
	@FXML
	private TextField orderIdBar;
	@FXML
	private DatePicker outTimeBar;
	@FXML
	private Button confirmButton;
	@FXML
	private TextField roomIdBar;
	
	public RecordCheckOutController(){
		orderIdBar = new TextField();
		outTimeBar = new DatePicker();
		confirmButton = new Button();
		roomIdBar = new TextField();
	}
	
	@FXML
	public void makeCheckOut(){
		String orderIdStr = orderIdBar.getText();
		String roomIdStr = roomIdBar.getText();
		LocalDate date = outTimeBar.getValue();
		
		if(orderIdStr==""||roomIdStr==""||date==null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("请填写完整退房信息");
			alert.showAndWait();
		}else{
		roomService.makeCheckOut(Integer.valueOf(orderIdStr),Integer.valueOf(roomIdStr) ,new java.util.Date(java.sql.Date.valueOf(date).getTime()));
		}
	}
	
}
