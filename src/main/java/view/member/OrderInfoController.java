package view.member;

import blservice.OrdersService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
		service.revoke(vo.getOrderId());
	}
	
	/**
	 * 删除订单的响应操作
	 */
	private void delete(){
		service.delete(vo.getOrderId());
		
	}
	
	/**
	 * 订单申诉
	 */
	private void appeal(){
		vo.setType("appeal");
		service.update(vo);
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
		 type.setText(vo.getType());
		 peopleNum.setText(vo.getPeopleNum()+"");
		 System.out.println(vo.getType());
		 revokeButton.setText("text");
		 if(vo.getType()!="normal"){
			 revokeButton.setText("删除订单");
			
			
		 }
		 else if(vo.getType()=="error"){
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
	
}
