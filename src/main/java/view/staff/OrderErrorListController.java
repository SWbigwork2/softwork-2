package view.staff;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import blservice.OrdersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class OrderErrorListController {
	@FXML
	private Button concelButton;
	@FXML
	private Label orderType;
	@FXML
	private Button recoverButton;
	@FXML
	private ListView<String> orderListView;
	@FXML
	private Label orderId;
	@FXML
	private Label inDateLabel;
	@FXML
	private DatePicker inDate;
	@FXML
	private ComboBox<String> orderTypeChoice;
	@FXML
	private Label userId;
	@FXML
	private Label roomType;
	private Main main;
	private String hotel;
	private ArrayList<OrderVo> infoList;
	private OrderVo selectVo;
	private OrdersService service;
	public OrderErrorListController() {
		main = Main.getMain();
		concelButton = new Button();
		service = new OrderServiceImpl();
		orderType = new Label();
		recoverButton = new Button();
		orderListView = new ListView<String>();
		orderId = new Label();
		inDateLabel = new Label();
		inDate = new DatePicker();
		orderTypeChoice = new ComboBox<String>();
		userId = new Label();
		roomType = new Label();
		// TODO Auto-gen                      erated constructor stub
	}

	public void initialize(ArrayList<OrderVo> orderList,String hotel){
		infoList = orderList;
		this.hotel = hotel;
		System.out.println(infoList.size());
		ObservableList<String> viewList = FXCollections.observableArrayList();
		for(OrderVo vo:infoList){
			viewList.add(simpleInfo(vo));
		}
		orderListView.setItems(viewList);
		
	}
	
	/**
	 * 展示简略信息
	 */
	public void showSelection(){
		String selectedStr =orderListView.getSelectionModel().getSelectedItem();
		System.out.println(selectedStr);
		int orderId = Integer.valueOf(selectedStr.split(" ")[0]);
		OrderVo resultInfo =null;
		for(OrderVo voInfo:infoList){
			if(voInfo.getOrderId()==orderId){
				resultInfo = voInfo;
				break;
			}
		}
		selectVo = resultInfo;
		userId.setText(resultInfo.getUserId());
		this.orderId.setText(orderId+"");
		orderType.setText(resultInfo.getType());
		roomType.setText(resultInfo.getRoomType());
		if(resultInfo.getType()=="done"){
			inDateLabel.setText("入住时间");
		}
		else{
			inDateLabel.setText("预计入住时间");
		}
		inDate.setValue(DateToLocalDate(resultInfo.getInDate()) );
		if(resultInfo.getType()=="error"){
			recoverButton.setDisable(false);
		}
		else{
			recoverButton.setDisable(true);
		}
		
	}
	
	/**
	 * @param date
	 * @return 将date转换成localDate
	 */
	private LocalDate DateToLocalDate(Date date) {
	   
	    Instant instant = date.toInstant();
	    ZoneId zone = ZoneId.systemDefault();
	    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
	    LocalDate localDate = localDateTime.toLocalDate();
	    return localDate;
	}
	
	/**
	 * 点击补登记按钮的响应
	 */
	@FXML
	public void recoverClink(){
		if(!recoverButton.getText().equals("确认")){
		inDate.setEditable(true);
		inDate.requestFocus();
		recoverButton.setText("确认");
		inDate.setEditable(true);
		inDate.setDisable(false);
		concelButton.setVisible(true);
		}
		else{
			confirmClink();
		}
	}
	@FXML
	public void cancel(){
		inDate.setEditable(false);
		concelButton.setVisible(false);
		recoverButton.setText("补登记");
	}
	
	@FXML
	public void confirmClink(){
		Alert tipAlert = new Alert(AlertType.CONFIRMATION);
		tipAlert.setTitle("确认补登记");
		tipAlert.setHeaderText("您确认要对该订单进行补登记么？");
		tipAlert.setContentText("登记入住时间为："+inDate.getValue().toString());
		Optional<ButtonType> result = tipAlert.showAndWait();
		if(result.get()==ButtonType.CANCEL){
			tipAlert.close();
			return;
		}
		else{
		Date selectDate = localToDate(inDate.getValue());
		selectVo.setInDate(selectDate);
		selectVo.setCompleteDate(new Date());
		selectVo.setType("done");
		orderType.setText("done");
		//更新数据库
		service.update(selectVo);
		recoverButton.setText("补登记");
		recoverButton.setDisable(false);
		main.showList();
		}
	}
	
	private Date localToDate(LocalDate time){
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return Date.from(instant);
	}
	/**
	 * @param info
	 * @return 得到简略信息
	 */
	private String simpleInfo(OrderVo info){ 
		String orderId = info.getOrderId()+"";
		String userIdStr = info.getUserId();
		String beginStr = toForm(info.getBeginDate());
		String price = info.getPrice()+"";
		String type = info.getType();
		return orderId+" "+beginStr+" "+userIdStr+" "+price+"元"+" "+type;
	}
	/**
	 * @param date
 	 * @return 将date转换成标准的年月日格式
	 */
	private String toForm(Date date){  
		String result="";
		result = date.toLocaleString();
		result = result.split(" ")[0];
		return result;
	}
	
	
	

}
