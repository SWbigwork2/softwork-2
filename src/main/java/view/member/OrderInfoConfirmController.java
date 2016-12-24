package view.member;

import java.text.DecimalFormat;
import java.util.Date;

import blservice.OrdersService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;

public class OrderInfoConfirmController {
	@FXML
	private Button cancelButton;
	@FXML
	private Label roomNum;
	@FXML
	private Label orderId;
	@FXML
	private Label price;
	@FXML
	private Label inDate;
	@FXML
	private Label hotel;
	@FXML
	private Label days;
	@FXML
	private Button confirmButton;
	@FXML
	private Label roomType;
	@FXML
	private Label promotion;
	
	private OrderVo vo;
	
	private String introduction;
	private Stage stage;
	private OrdersService service;
	private Main main;
	public void setVo(OrderVo orderVo,String introduction){
		
		vo = orderVo;
		this.introduction = introduction;
		setup();
	}
	
	public OrderInfoConfirmController(){
		main = Main.getMain();
		service = new OrderServiceImpl();
		cancelButton = new Button();
		roomNum = new Label();
		orderId = new Label();
		price = new Label();
		inDate = new Label();
		hotel = new Label();
		days = new Label();
		confirmButton = new Button();
		roomType = new Label();
		promotion = new Label();
	}
	
	/**
	 * 初始化信息
	 */
	private void setup(){
		DecimalFormat df = new DecimalFormat("#.00");  
		roomNum.setText(vo.getRoomNum()+"");
		roomType.setText(vo.getRoomType());
		promotion.setText(introduction);
		orderId.setText(vo.getOrderId()+"");
		price.setText(df.format(vo.getPrice()));
		inDate.setText(vo.getInDate().toLocaleString());
		hotel.setText(vo.getHotel());
		days.setText(calDays(vo.getInDate(), vo.getOutDate())+"天");
		
	}
	/**
	 * 取消订单生成
	 */
	@FXML
	public void cancel(){
		main.backPane();
		
	}
	
	/**
	 * 确认添加订单
	 */
	@FXML
	public void confirmAdd(){
		service.confirmAdd(vo);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("成功");
		alert.setHeaderText("添加订单成功!");
		alert.setContentText("成功生成订单，您可以在订单浏览界面查看");
		alert.showAndWait();
		main.showHotelSearch();
		
		
	}
	
	/**
	 * @param inDate
	 * @param outDate
	 * @return 计算天数
	 */
	private int calDays(Date inDate,Date outDate){
		long time1 = outDate.getTime();
		long time2 = inDate.getTime();
		int days =  ((int)(time1-time2)/(1000*60*60*24));
		return days;
	}
	
	

}
