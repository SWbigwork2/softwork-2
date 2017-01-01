package view.member;

import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import vo.OrderVo;

public class OrderListViewController {
	@FXML
	private ListView<String> orderListView;
	
	public OrderListViewController() {
		orderListView = new ListView<String>();
		// TODO Auto-generated constructor stub
	}
	public void setUp(ArrayList<OrderVo> list){
		ObservableList<String> orderList = FXCollections.observableArrayList();
		for(OrderVo vo:list){
			orderList.add(simpleInfo(vo));
		}
		orderListView.setItems(orderList);
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
	 * @param info
	 * @return vo转换成简略信息
	 */
	private String simpleInfo(OrderVo info){ 
		String orderId = info.getOrderId()+"";
		
		String beginStr = toForm(info.getInDate());
		String outStr = toForm(info.getOutDate());
		String price = info.getPrice()+"";
		String type = typeToName(info.getType());
		return orderId+" "+" "+beginStr+" "+outStr+" "+price+"元"+" "+type;
	}

}
