package view.staff;

import java.sql.Date;

import Roomblimpl.RoomServiceImpl;
import blservice.RoomService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
	private Main main;
	
	public RecordCheckOutController(){
		main = Main.getMain();
		orderIdBar = new TextField();
		outTimeBar = new DatePicker();
		confirmButton = new Button();
		roomIdBar = new TextField();
	}
	
	@FXML
	public void makeCheckOut(){
		roomService.makeCheckOut(orderIdBar.getText(), roomIdBar.getText(),Date.valueOf(outTimeBar.getValue()));
	}
	
}
