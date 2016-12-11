package view.member;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;


import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PriceInfo;
import Roomblimpl.RoomType;
import Usersblimpl.MemberInformationVO;
import blservice.HotelService;
import blservice.OrdersService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import ordersblimpl.OrderServiceImpl;
import vo.HotelVo;
import vo.OrderVo;

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
	
	private Main main;
	private HotelVo hotelVo;
	private HotelService hotelService;
	private OrderVo orderVo;
	private OrdersService service;
	private MemberInformationVO memberInformationVO;
	private ArrayList<RoomVo> roomList;
	private RoomType type;
	private LocalDate inDateInfo;
	private LocalDate outDateInfo;
	public void setHotelVo(HotelVo vo,RoomType type,LocalDate inDate,LocalDate outDate,MemberInformationVO memberVo){
		memberInformationVO = memberVo;
		this.type = type;
		hotelVo = vo;
		inDateInfo = inDate;
		outDateInfo = outDate;
		roomList = hotelService.getRoomOfHotel(hotelVo.getName(),new java.sql.Date(localToDate(inDateInfo).getTime()),new java.sql.Date(localToDate(outDateInfo).getTime()));
		initialized();
	}
	public OrderBuilderController() {
		main=Main.getMain();
		service = new OrderServiceImpl();
		hotelService = new HotelServiceImpl();
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
	@FXML
	private void initialized(){
		hotel.setText(hotelVo.getName());
		String location = hotelVo.getAddress();
		introduction.setText(location+"\n"+hotelVo.getIntroduction());
		beginDate.setValue(inDateInfo);
		outDate.setValue(outDateInfo);
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
	        RoomVo selectVo = null;
	        ArrayList<String> showString = new ArrayList<String>();
	        for(RoomVo vo:roomList){
	        	if(vo.getRoomType().equals(type)){
	        		selectVo = vo;
	        	}
	        	String str = vo.getRoomType().toString()+" "+vo.getRoomPrice();
	        	if(!showString.contains(str)){
	        		showString.add(str);
	        	}
	        }
	        outDate.setDayCellFactory(dayCellFactory);
	        roomNum.setItems(FXCollections.observableArrayList("1","2","3","4","5"));
	        roomType.setItems(FXCollections.observableArrayList(showString));
	        roomNum.getSelectionModel().select(0);
	        roomType.setValue(type.toString()+" "+selectVo.getRoomPrice());
	        peopleNum.setItems(FXCollections.observableArrayList("1","2","3","4","5"));
	        peopleNum.getSelectionModel().select(0);
		
		
	}
	
	public void cancel(){
		main.backPane();
	}
	
	/**
	 * 设置房间类型列表
	 */
	public void setTypeList(){
		Date inDateTime = localToDate(beginDate.getValue());
		Date outDateTime = localToDate(outDate.getValue());
		roomList = hotelService.getRoomOfHotel(hotelVo.getName(),new java.sql.Date(inDateTime.getTime()),new java.sql.Date(inDateTime.getTime()));
		ArrayList<String> showString = new ArrayList<String>();
        for(RoomVo vo:roomList){
        	
        	String str = vo.getRoomType().toString()+" "+vo.getRoomPrice();
        	if(!showString.contains(str)){
        		showString.add(str);
        	}
        }
       
       
        roomType.setItems(FXCollections.observableArrayList(showString));
       
       
    
	}
	
	/**
	 * @param time
	 * @return 将localDate转换成date
	 */
	private Date localToDate(LocalDate time){
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return Date.from(instant);
	}
	/**
	 * 添加订单的方法
	 */
	@FXML
	public void addOrder(){
		double credit = memberInformationVO.getCredit();
		if(credit<0){
			main.showTips("creditNotEnough.fxml");
			return;
		}
		String hotelString = hotel.getText();
		String roomTypeString = roomType.getSelectionModel().getSelectedItem();
		String[] typeInfo = roomTypeString.split(" ");
		double onePrice = Double.valueOf(typeInfo[1]);
		roomTypeString = typeInfo[0];
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
		PriceInfo priceInfo = service.getPrice(hotelString, onePrice, roomNumber, memberInformationVO.getUserId(),calDays(inDateTime, outDateTime) );
		//double price = priceInfo.getPrice();
		//String promotionIntro = priceInfo.getIntroduction();
		double price = 100.0;
		String promotionIntro = "hha";
		orderVo = new OrderVo();
		orderVo.setUserId(memberInformationVO.getUserId());
		orderVo.setName(memberInformationVO.getName());
		orderVo.setType("normal");
		orderVo.setOrderId(orderIdCreate());
		orderVo.setHotel(hotelString);
		orderVo.setRoomType(roomTypeString);
		orderVo.setPrice(price);
		orderVo.setRoomNum(roomNumber);
		orderVo.setPeopleNum(peopleNumber);
		orderVo.setInDate(inDateTime);
		orderVo.setBeginDate(beginDateTime);
		orderVo.setOutDate(outDateTime);
		orderVo.setDeadLine(deadLine);
		main.showOrderInfoConfirm(orderVo, promotionIntro);
		
		
	}
	
	private int orderIdCreate(){
		Date date = new Date();
		int day = date.getDate()*10000+date.getHours()*100+date.getSeconds();
		return day;
	}
	/**
	 * @param inDate
	 * @param outDate
	 * @return 计算天数的方法
	 */
	private int calDays(Date inDate,Date outDate){
		long time1 = outDate.getTime();
		long time2 = inDate.getTime();
		int days =  ((int)(time1-time2)/(1000*60*60*24));
		return days;
	}

}
