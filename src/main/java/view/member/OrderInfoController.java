package view.member;

import java.util.Date;
import java.util.Optional;

import blservice.OrdersService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;

public class OrderInfoController {
	@FXML
	private Label orderId;
	@FXML
	private Label beginDate;
	@FXML
	private Label outDate;
	@FXML
	private Label inDate;
	@FXML
	private Label type;
	@FXML
	private Label peopleNum;
	@FXML
	private Button revokeButton;
	@FXML
	private Label roomNum;
	@FXML
	private Label price;
	@FXML
	private Label hasChild;
	@FXML
	private Button evluateButton;
	@FXML
	private Label hotel;
	@FXML
	private Label deadline;
	@FXML
	private Label roomType;
	
	Main main;
	private OrdersService service;
	private OrderVo vo;
	public OrderInfoController() {
		main = Main.getMain();
		service = new OrderServiceImpl();
		orderId = new Label();
		beginDate = new Label();
		outDate = new Label();
		inDate = new Label();
		type = new Label();
		peopleNum = new Label();
		revokeButton = new Button();
		roomNum = new Label();
		price = new Label();
		hasChild = new Label();
		evluateButton = new Button();
		hotel = new Label();
		deadline = new Label();
		roomType = new Label();
		// TODO Auto-generated constructor stub
	}
	public void setOrderVo(OrderVo vo){
		
		this.vo = vo;
		initialize();
	}
	
	/**
	 * 点击撤回和取消按钮的响应
	 */
	@FXML
	public void cancelAndRevoke(){  
		if(revokeButton.getText().equals("撤回订单")){
			revoke();
		}
		else if(revokeButton.getText().equals("异常申诉")){
			appeal();
		}
		else{
			delete();
		}
	}
	/**
	 * 撤销订单的响应操作
	 */
	private void revoke(){ 
		Alert alert = new Alert(AlertType.CONFIRMATION);
		int hours = ((int)(vo.getDeadLine().getTime()-(new Date()).getTime()))/(3600*1000);
		if(hours<6){
			alert.setContentText("将扣除"+vo.getPrice()/2.0+"信用值");
		}
		else{
			alert.setContentText("不会扣除您的信用值");
		}
		alert.setTitle("确认撤销");
		alert.setHeaderText("确认要撤销订单么？");
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get()==ButtonType.CANCEL){
			return;
		}
		
		service.revoke(vo.getOrderId());
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("成功");
		infoAlert.setHeaderText(null);
		infoAlert.setContentText("订单已撤销！");
		infoAlert.showAndWait();
		main.showOrderList();
	}
	
	/**
	 * 删除订单的响应操作
	 */
	private void delete(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("确认删除");
		alert.setContentText("确认要删除订单么？");
		Optional<ButtonType> result=alert.showAndWait();
		if(result.get()==ButtonType.CANCEL){
			return;
		}
		service.delete(vo.getOrderId());
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("成功");
		infoAlert.setHeaderText(null);
		infoAlert.setContentText("订单已删除！");
		infoAlert.showAndWait();
		main.showOrderList();
	}
	
	/**
	 * 订单申诉
	 */
	private void appeal(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("确认申诉");
		alert.setHeaderText(null);
		alert.setContentText("确认要申诉订单么？");
		Optional<ButtonType> result=alert.showAndWait();
		if(result.get()==ButtonType.CANCEL){
			return;
		}
		vo.setType("appeal");
		
		service.update(vo);
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("成功");
		infoAlert.setHeaderText(null);
		infoAlert.setContentText("订单已申诉！");
		infoAlert.showAndWait();
		main.showOrderList();
	}
	
	/**
	 * 评价订单
	 */
	public void evaluate(){
		System.out.println();
		main.showEvaluate(vo);
	}
	
	 private void initialize(){
		 
		 orderId.setText(vo.getOrderId()+"");
		 beginDate.setText(vo.getBeginDate().toLocaleString());
		 outDate.setText(vo.getOutDate().toLocaleString());
		 inDate.setText(vo.getInDate().toLocaleString());
		 type.setText(typeToName(vo.getType()));
		 peopleNum.setText(vo.getPeopleNum()+"");
		 System.out.println(vo.getType());
		 revokeButton.setText("text");
		 if(vo.getType()!="normal"&&vo.getType()!="error"){
			 revokeButton.setText("删除订单");
			
			
		 }
		 else if(vo.getType().equals("error")){
			 revokeButton.setText("异常申诉");
		 }
		 else{
			 revokeButton.setText("撤回订单");
		 }
		 if(vo.getType()!="done"){
			 evluateButton.setDisable(true);
		 }
		 roomNum.setText(vo.getRoomNum()+"");
		 roomType.setText(vo.getRoomType());
		price.setText(vo.getPrice()+"");
		if(vo.isHasChild()){
			hasChild.setText("是");
		}else{
			hasChild.setText("否");
		}
		deadline.setText(vo.getDeadLine().toLocaleString());
		 hotel.setText(vo.getHotel());
	 }
	 /**
		 * @param type
		 * @return 将订单状态改为中文显示
		 */
		private String typeToName(String type){
			switch (type) {
			case "normal":
				return "未执行订单";
			case "error":
				return "异常订单";
			case "done":
				return "已完成订单";
			case "appel":
				return "已申请订单";
			case "all":
				return "全部订单";
			case "revoke":
				return "已撤销订单";
			case "evaluation":
				return "已评价订单";
			default:
				return null;
				
			}
		}
		private String nameToType(String name){
			switch (name) {
			case "未执行订单":
				return "normal";
			case "异常订单":
				return "error";
			case "已完成订单":
				return "done";
			case "已申请订单":
				return "appel";
			case "全部订单":
				return "all";
			case "已撤销订单":
				return "revoke";
			case "已评价订单":
				return "evaluation";
			default:
				return null;
				
			}
		}
	
}
