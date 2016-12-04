package view.member;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import UsersMock.MemberInformationVO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class OrderBuilderController {
	@FXML
	private ImageView hotelImage;
	@FXML
	private Label hotel;
	@FXML
	private TextArea introduction;
	@FXML
	private DatePicker beginDate;
	@FXML
	private DatePicker outDate;
	@FXML
	private ComboBox<String>roomNum;
	@FXML
	private CheckBox hasChild;
	@FXML
	private Button addOrderButton;
	@FXML
	private Button returnButton;
	@FXML
	private Label deadline;
	@FXML
	private ComboBox<String> peopleNum;
	@FXML
	private ComboBox<String> roomType;
	
	private HotelVo hotelVo;
	
	private MemberInformationVO memberInformationVO;
	public void setHotelVo(HotelVo vo){
		hotelVo = vo;
		initialize();
	}
	public OrderBuilderController() {
		hotelImage = new ImageView();
		hotel = new Label();
		introduction = new TextArea();
		beginDate = new DatePicker();
		outDate = new DatePicker();
		roomNum = new ComboBox<String>();
		hasChild = new CheckBox();
		addOrderButton = new Button();
		returnButton = new Button();
		deadline =  new Label();
		peopleNum =new ComboBox<String>();
		roomType = new ComboBox<String>();
		
		// TODO Auto-generated constructor stub
	}
	
	private void initialize(){
		hotel.setText(hotelVo.getName());
		String location = hotelVo.getAddress();
		introduction.setText(location+"\n"+hotelVo.getIntroduction());
		beginDate.setValue(LocalDate.now());
		outDate.setValue(beginDate.getValue().plusDays(1));
		String deadLine = beginDate.getValue()+"24:00";
		deadline.setText(deadLine);
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                            if (item.isBefore(
	                                    beginDate.getValue().plusDays(1))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }
	                            long p = ChronoUnit.DAYS.between(
	                                    beginDate.getValue(), item
	                            );
	                            setTooltip(new Tooltip(
	                                "您预计入住" + p + " 天")
	                            );
	                    }
	                };
	            }
	        };
	        outDate.setDayCellFactory(dayCellFactory);
	        roomNum.setItems(FXCollections.observableArrayList("1","2","3","4","5"));
	        roomType.setItems(FXCollections.observableArrayList(hotelVo.getRoomType()));
	        roomNum.getSelectionModel().select(0);
	        roomType.getSelectionModel().select(0);
	        peopleNum.setItems(FXCollections.observableArrayList("1","2","3","4","5"));
	        peopleNum.getSelectionModel().select(0);
		
		
	}
	private Date localToDate(LocalDate time){
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return Date.from(instant);
	}
	@FXML
	public void addOrder(){
		String hotelString = hotel.getText();
		String roomTypeString = roomType.getSelectionModel().getSelectedItem();
		int roomNumber = Integer.valueOf(roomNum.getSelectionModel().getSelectedItem());
		int peopleNumber = Integer.valueOf(peopleNum.getSelectionModel().getSelectedItem());
		Date inDateTime = localToDate(beginDate.getValue());
		Date outDateTime = localToDate(outDate.getValue());
		Date beginDateTime = new Date();
		Date deadLine = new Date(inDateTime.getTime());
		deadLine.setHours(24);
		System.out.println(deadLine.toLocaleString());
		boolean isHasChild = false;
		if(hasChild.isSelected()){
			isHasChild = true;
		}
		
	}

}
