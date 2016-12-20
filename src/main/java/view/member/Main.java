package view.member;
	
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.Stack;

import org.junit.Before;

import Roomblimpl.RoomType;
import Usersblimpl.MemberInformationVO;

import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;

import blservice.OrdersService;
import blservice.UserService;
import data.rmi.RemoteHelper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loginblimpl.LoginVo;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import rmiTest.linkTest;
import vo.HotelVo;
import vo.OrderVo;

import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;


public class Main extends Application {
	private static UserService userService;
	private static MemberInformationVO membervo;
	private static Stage tipStage;
	private static Main main;
	OrdersService blService;
	OrderVo testOrder = new OrderVo("lv3", 0001, "admin", "admin", "皇朝", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
	private ObservableList<OrderVo> orderVolist = FXCollections.observableArrayList();
	private static BorderPane root;
	private static Stage primaryStage ;
	private static Stage loginStage;
	private static FXMLLoader loader;
	private Stack<Pane> panes;
	private static Scene tempScene;
	private RemoteHelper remoteHelper;
	
	public void linkToServer(){
		final String ip = "localhost";
		try{
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://"+ip+":8888/DateRemoteObject"));
			System.out.println("linked");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public Main() {
		linkToServer();
		panes = new Stack<Pane>();
		blService = new OrderServiceImpl();
		loader = new FXMLLoader();
		orderVolist.add(testOrder);
		//blService.checkOrder();
		// TODO Auto-generated constructor stub
	}
	public static Main getMain(){
		if(main==null){
			main = new Main();
			return main;
		}
		else{
			return main;
		}
	}
	
	public ObservableList<OrderVo> getOrderVolist() {
		return orderVolist;
	}
	
	public void logout(){
		primaryStage.close();
		membervo = null;
		loginStage.showAndWait();
	}
	
	
	/**
	 * @return 该用户的全部订单信息
	 */
	public ArrayList<OrderVo> getOrderList(String userId){
		return blService.getOrderList(userId, OrderType.all);
		
	}

	/**
	 * 显示主界面
	 */
	public void showMain(){
		try{
			loginStage.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		root =(BorderPane) loadPane("MemberFrame.fxml");
		Scene scene = new Scene(root,1200,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * 显示个人信息
	 */
	public void showMemberInfo(){
		
		Pane infoPane = loadPane("memberInformationUi.fxml");
		MemberInformationController controller = loader.getController();
		controller.setMember(membervo);
		root.setCenter(infoPane);
		
		
		
	}
	
	/**
	 * 显示订单列表
	 */
	public void showOrderList(){
		Pane orderList = loadPane("orderList_V1.0.fxml");
		OrderListController controller = loader.getController();
		controller.initialize(membervo);
		root.setCenter(orderList);
	}
	
	/**
	 * @param vo
	 * @param type
	 * @param inDate
	 * @param outDate
	 * 显示订单生成页面
	 */
	public void showOrderBuilder(HotelVo vo,RoomType type,LocalDate inDate,LocalDate outDate){
		panes.push((Pane) root.getCenter());
		Pane OrderBuilderPane = loadPane("orderBuild.fxml");
		OrderBuilderController controller = loader.getController();
		controller.setHotelVo(vo, type, inDate, outDate,membervo);
		root.setCenter(OrderBuilderPane);
	}
	
	public void showOrderInfoConfirm(OrderVo orderVo,String introduction){
		panes.push((Pane) root.getCenter());
		Pane OrderInfoConfirm = loadPane("OrderInfoConfirm.fxml");
		OrderInfoConfirmController controller = loader.getController();
		controller.setVo(orderVo, introduction);
		root.setCenter(OrderInfoConfirm);
		
	}
	
	public void showHotelDetail(String hotelName,LocalDate startTime,LocalDate endTime){
		panes.push((Pane) root.getCenter());
		Pane hotelDetailPane = loadPane("BrowseHotelDetail.fxml");
		BrowseHotelDetailController controller = loader.getController();
		controller.setHotelNameAndDate(hotelName, startTime, endTime);
		root.setCenter(hotelDetailPane);
	}
	
	/**
	 * 显示浏览酒店界面
	 */
	public void showBrowseHotel(ArrayList<HotelColumnVo> hotelList,LocalDate startTime,LocalDate endTime){
		Pane browseHotelPane = loadPane("BrowseHotel.fxml");
		BrowseHotelController controller = loader.getController();
		controller.setHotelVo(hotelList, membervo.getUserId(), startTime, endTime);
		root.setCenter(browseHotelPane);
	}
    
    /**
     * 浏览历史酒店界面
     */
    public void seeHistoryHotel(){
        
        AnchorPane historyHotelPane = (AnchorPane)loadPane("BrowseHistoryHotel.fxml");
        BrowseHistoryHotelController controller = loader.getController();
        ordersService = new OrderServiceImpl();
        ArrayList<String> hotelList = new ArrayList<String>(ordersService.getHotelList(membervo.getUserId()).keySet());
        ArrayList<OrderVo> normalList =ordersService.getOrderList(membervo.getUserId(), OrderType.normal);
        ArrayList<OrderVo> abnormalList =ordersService.getOrderList(membervo.getUserId(), OrderType.error);
        ArrayList<OrderVo> revokedList =ordersService.getOrderList(membervo.getUserId(), OrderType.revoke);
        controller.setHotelVo(hotelList, normalList, abnormalList, revokedList);
        root.setCenter(historyHotelPane);
    }
	
	/**
	 * 显示搜索酒店界面
	 */
	public void showHotelSearch(){
		Pane hotelDetail = loadPane("SearchHotel.fxml");
		root.setCenter(hotelDetail);
	}
	
	
	
	
	
	/**
	 * 跳转查看详细信息
	 */
	public void viewDetails(OrderVo vo){
		
		Pane orderDetailPane = loadPane("OrderInfo.fxml");
		OrderInfoController controller = loader.getController();
	
		controller.setOrderVo(vo);
		root.setCenter(orderDetailPane);
	}
	
	/**
	 * @param vo
	 * 跳转到评价页面
	 */
	public void showEvaluate(OrderVo vo){
		panes.push((Pane) root.getCenter());
		Pane evalutePane = loadPane("evalauteUi.fxml");
		EvaluateController controller = loader.getController();
		controller.setOrderVo(vo);
		root.setCenter(evalutePane);
	}
	/**
	 * 更改密码
	 */
	public void showRevampPassword(){
		// TODO Auto-generated method stub
		BorderPane page=null;  
		loader=new FXMLLoader();
		  
		try {
		
			loader.setLocation(Main.class.getResource("revampPasswordUi.fxml"));
			
			page= (BorderPane)loader.load();
		    
			RevampPasswordController controller=loader.getController();
			controller.setMember(Main.membervo);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
		root.setCenter(page);
	}
	
	/**
	 * 回到上一个页面
	 */
	public void backPane(){
		root.setCenter(panes.pop());
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {/*
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Winter Studio");
			Pane loginPane = loadPane("MemberLogin.fxml");
			Scene scene = new Scene(loginPane,800,600);
			primaryStage.setScene(scene);
			primaryStage.show();*/
		Main.primaryStage = primaryStage;
	
			loginStage = new Stage();
			Pane loginPane = loadPane("MemberLogin.fxml");
			Scene scene = new Scene(loginPane,600,400);
			tempScene = scene;
			loginStage.setScene(scene);
			loginStage.showAndWait();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @param fxml
	 * 显示注册文件
	 */
	public void showRegister(String fxml){
		Pane registerPane = loadPane(fxml);
		Scene scene = new Scene(registerPane,800,600);
		loginStage.setScene(scene);
	}
	
	/**
	 * @param FXML
	 * 显示提示信息弹窗
	 */
	public void showTips(String FXML){
		Pane tipRoot = loadPane(FXML);
		Scene tipScene = new Scene(tipRoot,600,400);
		tipStage = new Stage();
		tipStage.setScene(tipScene);
		tipStage.showAndWait();
	}
	
	/**
	 * 关闭提示弹窗
	 */
	public void closeTips(){
		if(tipStage!=null){
			tipStage.close();
		}
	}
	
	/**
	 * @param FXML
	 * @return 加载XML文件
	 */
	private  Pane loadPane(String FXML){
		loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(FXML));
		try {
			return (Pane)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void setMemberVo(LoginVo vo){
		userService = new UserControllerblimpl();
		Main.membervo = (MemberInformationVO) userService.find(vo.getId(), UserType.member);
		
		
		
	}
	
	public void returnLogin(){
		loginStage.setScene(tempScene);
		System.out.println("test");
	}
	
	public void initStage(){
		orderVolist.add(testOrder);
		
		try {
			root=(BorderPane) loadPane("orderList_V1.0.fxml");
			OrderListController controller = loader.getController();
			controller.initialize(membervo);
			
			
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		main = new Main();
		launch(args);
	}
	public static MemberInformationVO getMembervo() {
		return membervo;
	}
	public static void setMembervo(MemberInformationVO membervo) {
		Main.membervo = membervo;
	}
}

