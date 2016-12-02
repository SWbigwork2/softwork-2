package view.member;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;

public class OrderListController {
	private ArrayList<OrderVo> infoList;
	private ObservableList<String> temp ;
	@FXML
	private Label ID;
	@FXML
	private Label name;
	@FXML
	private Label level;
	@FXML
	private ListView<String> orderListView;
	@FXML
	private Label orderId;
	@FXML
	private Label beginDate;
	@FXML
	private Label endDate;
	@FXML
	private Label hotel;
	@FXML
	private Label price;
	@FXML
	private Label type;
	
	private Main main ;
	private OrderVo orderVoInfo;
	public OrderListController() {
		
		main = Main.getMain();
		infoList = main.getOrderList("admin");
		orderVoInfo = infoList.get(0);
		ID =new Label();
		name = new Label();
		level = new Label();
		orderId = new Label();
		beginDate = new Label();
		endDate = new Label();
		hotel = new Label();
		price = new Label();
		type = new Label();
		orderListView = new ListView<String>();
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 初始化的方法
	 */
	@FXML
	 private void initialize(){
		
		
		
		
		ID.setText(orderVoInfo.getUserId());
		name.setText(orderVoInfo.getName());
		level.setText(orderVoInfo.getUserLevel());
		orderId.setText(orderVoInfo.getOrderId()+"");
		beginDate .setText(orderVoInfo.getBeginDate().toLocaleString());
		endDate.setText(orderVoInfo.getCompleteDate().toLocaleString());
		hotel.setText(orderVoInfo.getHotel());
		price.setText(orderVoInfo.getPrice()+"");
		type.setText(orderVoInfo.getType());
		type.setText("test");
		type.setText("test");
		
		//OrderVo testinfo =  new OrderVo("lv3", 0002, "admin", "admin", "新月", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
		//infoList.add(orderVoInfo);
		//infoList.add(testinfo);
		temp = FXCollections.observableArrayList();
		for(OrderVo info:infoList){
			temp.add(simpleInfo(info));
		}
		
		
		
		orderListView.setItems(temp);
	}
	
	/**
	 * @param vo
	 * 设置用户信息的显示
	 */
	private void setMemberInfo(OrderVo vo){
		ID.setText(vo.getUserId());
		name.setText(vo.getName());
		level.setText(vo.getUserLevel());
		
		
	}
	
		/**
		 * 设置订单列表的显示
		 */
		private void setOrderList(){
	
		ID.setText(orderVoInfo.getUserId());
		name.setText(orderVoInfo.getName());
		level.setText(orderVoInfo.getUserLevel());
		orderId.setText(orderVoInfo.getOrderId()+"");
		beginDate .setText(orderVoInfo.getBeginDate().toLocaleString());
		endDate.setText(orderVoInfo.getCompleteDate().toLocaleString());
		hotel.setText(orderVoInfo.getHotel());
		price.setText(orderVoInfo.getPrice()+"");
		type.setText(orderVoInfo.getType());
		type.setText("test");
		type.setText("test");
		infoList = new ArrayList<OrderVo>();
		OrderVo testinfo =  new OrderVo("lv3", 0002, "admin", "admin", "新月", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
		infoList.add(orderVoInfo);
		infoList.add(testinfo);
		temp = FXCollections.observableArrayList();
		for(OrderVo info:infoList){
			temp.add(simpleInfo(info));
		}
	}
	
	@FXML
	public void clink(){
		ID.setText("");
	}
	/**
	 * 选中订单显示预览的方法
	 */
	@FXML
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
		this.orderId.setText(resultInfo.getOrderId()+"");
		beginDate.setText(resultInfo.getBeginDate().toLocaleString());
		endDate.setText(resultInfo.getCompleteDate().toLocaleString());
		hotel.setText(resultInfo.getHotel());
		price.setText(resultInfo.getPrice()+"");
		type.setText(resultInfo.getType());
		ID.setText("test");
		
	}
	/**
	 * @param info
	 * @return vo转换成简略信息
	 */
	private String simpleInfo(OrderVo info){ 
		String orderId = info.getOrderId()+"";
		String hotelStr = info.getHotel();
		String beginStr = toForm(info.getBeginDate());
		String price = info.getPrice()+"";
		String type = info.getType();
		return orderId+" "+hotelStr+" "+beginStr+" "+price+"元"+" "+type;
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
	public void setMain(Main main){
		this.main = main;
	}

}
