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

public class RecordCheckInController {

	RoomService roomService = new RoomServiceImpl();
	private String hotelName;

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
	@FXML
	private TextField offlineOrderBar;

	public RecordCheckInController() {
		orderIdBar = new TextField();
		onlineButton = new Button();
		roomTypeBar = new ComboBox<RoomType>();
		offlineButton = new Button();
		offlineInTimeBar = new DatePicker();
		inTimeBar = new DatePicker();
		offlineOutTimeBar = new DatePicker();
		offlineOrderBar = new TextField();
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@FXML
	public void initialize() {
		ObservableList<RoomType> list = FXCollections.observableArrayList(RoomType.单人间, RoomType.商务间, RoomType.标准间,
				RoomType.行政标准间, RoomType.高级套间);
		roomTypeBar.setItems(list);
	}

	@FXML
	public void onlineCheckIn() {
		int orderId = Integer.valueOf(orderIdBar.getText());
		Date startTime = Date.valueOf(inTimeBar.getValue());
		roomService.makeCheckIn(orderId, startTime);
	}

	@FXML
	public void offlineCheckIn() {

		roomService.makeReservation(Integer.valueOf(offlineOrderBar.getText()), hotelName, roomTypeBar.getValue(),
				Date.valueOf(offlineInTimeBar.getValue()), Date.valueOf(offlineOutTimeBar.getValue()), 1);
		roomService.makeCheckIn(Integer.valueOf(offlineOrderBar.getText()), Date.valueOf(offlineInTimeBar.getValue()));
	}

}
