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
		String type = info.getType();
		return orderId+" "+" "+beginStr+" "+outStr+" "+price+"元"+" "+type;
	}

}
