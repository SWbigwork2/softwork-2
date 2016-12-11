package view.marketer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import blservice.OrdersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;
import javafx.scene.control.Alert.AlertType;

public class OrderRecoverListController {
	@FXML
	private Label orderType;
	@FXML
	private Button recoverButton;
	@FXML
	private ListView<String> orderListView;
	@FXML
	private Label orderId;
	@FXML
	private Label inDate;
	@FXML
	private ComboBox<String> orderTypeChoice;
	@FXML
	private Label hotel;
	@FXML
	private Button concelButton;
	@FXML
	private Label userId;
	@FXML
	private Label roomType;
	
	private OrderVo orderVo;
	private ArrayList<OrderVo> infoList;
	private OrdersService service;
	public OrderRecoverListController() {
		service = new OrderServiceImpl();
		orderType = new Label();
		recoverButton = new Button();
		orderListView = new ListView<String>();
		orderId = new Label();
		inDate = new Label();
		orderTypeChoice = new ComboBox<String>();
		hotel = new Label();
		concelButton = new Button();
		userId = new Label();
		roomType = new Label();
		// TODO Auto-generated constructor stub
	}
	
	public void initialize(ArrayList<OrderVo> orderList){
		infoList = orderList;
		
		ObservableList<String> viewList = FXCollections.observableArrayList();
		for(OrderVo vo:infoList){
			viewList.add(simpleInfo(vo));
		}
		orderListView.setItems(viewList);
		
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
	
	/**
	 * 显示选中订单信息的响应
	 */
	public void showSelection(){
		String selectedStr =orderListView.getSelectionModel().getSelectedItem();
		System.out.println(selectedStr);
		int orderId = Integer.valueOf(selectedStr.split(" ")[0]);
		
		for(OrderVo voInfo:infoList){
			if(voInfo.getOrderId()==orderId){
				orderVo = voInfo;
				break;
			}
		}
		
		userId.setText(orderVo.getUserId());
		this.orderId.setText(orderId+"");
		hotel.setText(orderVo.getHotel());
		roomType.setText(orderVo.getRoomType());
		inDate.setText(orderVo.getInDate().toLocaleString());
		orderType.setText(orderVo.getType());
		
	}
	
	/**
	 * 点击撤销按钮的响应
	 * 
	 */
	public void ClinkRecover(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("撤销成功");
		alert.setHeaderText(null);
		alert.setContentText("订单撤销成功");
		
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("一半");
		choices.add("全部");
		
		ChoiceDialog<String> tipAlert = new ChoiceDialog<>("一半",choices);
		tipAlert.setTitle("确认撤销");
		tipAlert.setHeaderText("确认撤销该订单么？");
		tipAlert.setContentText("请选择恢复的信用值");
		Optional<String> result = tipAlert.showAndWait();
		
		if(!result.isPresent()){
			return;
		}
		else{
			if(result.get()=="一半"){
				
				service.recover(orderVo.getOrderId(), 0.5);
				//恢复一半信用值		
				orderVo.setType("revoke");
				orderVo.setCompleteDate(new Date());
				alert.showAndWait();
				showSelection();
			}
			else{
				//恢复一半信用值
				orderVo.setType("revoke");
				orderVo.setCompleteDate(new Date());
				alert.showAndWait();
				showSelection();
			}
		}
	}
}
