package view.staff;

import java.sql.Date;

import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RecordCheckInController{
	
	RoomService roomService = new RoomServiceImpl();

	@FXML
	private TextField orderIdBar;
	@FXML
	private Button onlineButton;
	@FXML
	private ComboBox<RoomType> roomTypeBar;
	@FXML
	private Button offlineButton;
	@FXML
	private DatePicker offlineInTimeBar;
	@FXML
	private DatePicker inTimeBar;
	@FXML
	private DatePicker offlineOutTimeBar;

	
	private Main main;
	
	public RecordCheckInController() {
		main = Main.getMain();
		orderIdBar = new TextField();
		onlineButton = new Button();
		roomTypeBar = new ComboBox<RoomType>();
		offlineButton = new Button();
		offlineInTimeBar = new DatePicker();
		inTimeBar = new DatePicker();
		offlineOutTimeBar = new DatePicker();
	}
	
	@FXML
	public void initialize(){
		ObservableList<RoomType> list = FXCollections.observableArrayList(RoomType.单人间,RoomType.商务间,RoomType.标准间,RoomType.行政标准间,RoomType.高级套间);
		roomTypeBar.setItems(list);
	}
	@FXML
	public void onlineCheckIn(){
		String orderId = orderIdBar.getText();
		Date startTime = Date.valueOf(inTimeBar.getValue());
		roomService.makeCheckIn(orderId, startTime);
	}
	@FXML
	public void offlineCheckIn(){
		roomService.makeReservation("0000", "金陵饭店", roomTypeBar.getValue(), Date.valueOf(offlineInTimeBar.getValue()), Date.valueOf(offlineOutTimeBar.getValue()), 1);
		roomService.makeCheckIn("0000", Date.valueOf(offlineInTimeBar.getValue()));
	}
	
}
