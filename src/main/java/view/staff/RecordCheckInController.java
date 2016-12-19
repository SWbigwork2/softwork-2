package view.staff;
import java.time.LocalDate;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
		String orderIdStr = orderIdBar.getText();
		LocalDate inTime = inTimeBar.getValue();
		if ((orderIdStr == "") || (inTime == null)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("请填写完整入住信息");
			alert.showAndWait();
		} else {
			
			roomService.makeCheckIn(Integer.valueOf(orderIdStr), new java.util.Date(java.sql.Date.valueOf(inTime).getTime()));

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("入住信息更新成功");
			alert.showAndWait();
		}
	}

	@FXML
	public void offlineCheckIn() {

		String orderId = offlineOrderBar.getText();
		RoomType roomType = roomTypeBar.getValue();
		LocalDate inDate = offlineInTimeBar.getValue();
		LocalDate outDate = offlineOutTimeBar.getValue();

		if ((orderId == "") || (roomType == null) || (inDate == null) || (outDate == null)) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("请填写完整入住信息");
			alert.showAndWait();
		} else {
			roomService.makeReservation(Integer.valueOf(orderId), hotelName, roomType, new java.util.Date(java.sql.Date.valueOf(inDate).getTime()),
					new java.util.Date(java.sql.Date.valueOf(outDate).getTime()), 1);
			roomService.makeCheckIn(Integer.valueOf(offlineOrderBar.getText()),
					new java.util.Date(java.sql.Date.valueOf(inDate).getTime()));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("入住信息更新成功");
			alert.showAndWait();
		}
	}

}
