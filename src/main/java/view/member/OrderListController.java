package view.member;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import Usersblimpl.MemberInformationVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import ordersblimpl.OrderType;
import vo.OrderVo;

public class OrderListController {
	private ArrayList<OrderVo> infoList;
	private ObservableList<String> temp ;
	@FXML
	private ComboBox<String> orderTypeChoice;
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
	@FXML
	private SplitPane splitPane;
	private Main main ;
	private OrderVo orderVoInfo;
	private MemberInformationVO memberInformationVO;
	public OrderListController() {
		
		main = Main.getMain();
		
		//orderVoInfo = infoList.get(0);
		ID =new Label();
		name = new Label();
		level = new Label();
		orderId = new Label();
		beginDate = new Label();
		endDate = new Label();
		hotel = new Label();
		price = new Label();
		type = new Label();
		splitPane = new SplitPane();
		orderListView = new ListView<String>();
		orderTypeChoice = new ComboBox<String>();
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 初始化的方法
	 */
	
	
	 public void initialize(MemberInformationVO memberVo){
		
		memberInformationVO = memberVo;
		infoList = main.getOrderList(memberVo.getUserId());
		if(infoList.size()>=1){
		orderVoInfo = infoList.get(0);
		orderId.setText(orderVoInfo.getOrderId()+"");
		beginDate .setText(orderVoInfo.getBeginDate().toLocaleString());
		try{
		endDate.setText(orderVoInfo.getCompleteDate().toLocaleString());
		}catch (Exception e) {
			endDate.setText("尚未完成");
			// TODO: handle exception
		}
		hotel.setText(orderVoInfo.getHotel());
		price.setText(orderVoInfo.getPrice()+"");
		type.setText(orderVoInfo.getType());
		}
		ID.setText(memberVo.getUserId());
		name.setText(memberVo.getName());
		level.setText(memberVo.getLevel());
		
	
		orderTypeChoice.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				changeChoice();
			}
		});
		//OrderVo testinfo =  new OrderVo("lv3", 0002, "admin", "admin", "新月", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
		//infoList.add(orderVoInfo);
		//infoList.add(testinfo);
		temp = FXCollections.observableArrayList();
		for(OrderVo info:infoList){
			temp.add(simpleInfo(info));
		}
		
		
		
		orderTypeChoice.setItems(FXCollections.observableArrayList("已撤销订单","未执行订单","已完成订单","异常订单","全部订单","已评价订单"));
		orderTypeChoice.setValue("全部订单");
		orderListView.setItems(temp);
	}
	/**
	 * 选择orderTyoe之后的操作
	 */
	@FXML
	public void changeChoice(){
		String choice = orderTypeChoice.getSelectionModel().getSelectedItem();
		choice = nameToType(choice);
		temp = FXCollections.observableArrayList();
		temp.clear();
		for(OrderVo info:infoList){
			if(info.getType().equals(choice)||choice.equals("all")){
				temp.add(simpleInfo(info));
			}
		}
		
		orderListView.setItems(temp);
		
	}
	/**
	 * @param vo
	 * 设置用户信息的显示
	 */
	public void setMemberInfo(OrderVo vo){
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
	
	
	/**
	 * 订单列表鼠标点击的响应
	 */
	@FXML
	public void MouseClink(MouseEvent event){
		if(event.getClickCount()<2){
			showSelection();
			
		}
		else{
			showDetails();
			
		}
		
	}
	/**
	 * @param info
	 * @return vo转换成简略信息
	 */
	private String simpleInfo(OrderVo info){ 
		String orderId = info.getOrderId()+"";
		String hotelStr = info.getHotel();
		String beginStr = toForm(info.getInDate());
		String price = info.getPrice()+"";
		String type = typeToName(info.getType());
		
		return orderId+" "+hotelStr+" "+beginStr+" "+price+"元"+" "+type;
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
		case "appeal":
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
			return "appeal";
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
	 * 展示简略信息
	 */
	public void showSelection(){
		String selectedStr =orderListView.getSelectionModel().getSelectedItem();
		
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
		try{
		endDate.setText(resultInfo.getCompleteDate().toLocaleString());
		}catch (Exception e) {
			endDate.setText("暂无");
			// TODO: handle exception
		}
		hotel.setText(resultInfo.getHotel());
		price.setText(resultInfo.getPrice()+"");
		type.setText(typeToName(resultInfo.getType()));
		
		
	}

	/**
	 * 跳转到详细信息页面
	 */
	public void showDetails(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Look, an Exception Dialog");
		alert.setContentText("Could not find file blabla.txt!");

		try{
		String selectedStr =orderListView.getSelectionModel().getSelectedItem();
		
		int orderId = Integer.valueOf(selectedStr.split(" ")[0]);
		OrderVo resultInfo =null;
		for(OrderVo voInfo:infoList){
			if(voInfo.getOrderId()==orderId){
				resultInfo = voInfo;
				break;
			}
		}
		
		main.viewDetails(resultInfo);
		}catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
		}
	}
	public void setMain(Main main){
		this.main = main;
	}

}
