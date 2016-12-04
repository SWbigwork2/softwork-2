package view.member;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import blservice.OrdersService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main extends Application {
	private static Main main;
	OrdersService blService;
	OrderVo testOrder = new OrderVo("lv3", 0001, "admin", "admin", "皇朝", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
	private ObservableList<OrderVo> orderVolist = FXCollections.observableArrayList();
	private static Pane root;
	private static Stage primaryStage ;
	private static FXMLLoader loader;
	public Main() {
		blService = new OrderServiceImpl();
		loader = new FXMLLoader();
		orderVolist.add(testOrder);
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
	/**
	 * @return 该用户的全部订单信息
	 */
	public ArrayList<OrderVo> getOrderList(String userId){
		return blService.getOrderList(userId, OrderType.all);
		
	}

	

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Winter Studio");
			Pane loginPane = loadPane("MemberLogin.fxml");
			Scene scene = new Scene(loginPane,800,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		/*
			initStage();
			Stage testStage = new Stage();
			testStage.setTitle("test");
			testStage.initModality(Modality.APPLICATION_MODAL);
			Pane testRoot = loadPane("orderBuild.fxml");
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add("小");
			tempList.add("中");
			HotelVo hotelVo = new HotelVo("皇朝", "仙林大道163号", tempList,  HotelTradeArea.栖霞区, "这是介绍", "这是设施", HotelRanking.FiveStar);
			OrderBuilderController Ocontroller=loader.getController();
			Ocontroller.setHotelVo(hotelVo);
			Scene scene = new Scene(testRoot,600,400);
			testStage.setScene(scene);
			testStage.showAndWait();
			*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转查看详细信息
	 */
	public void viewDetails(OrderVo vo){
		
		try {
			SplitPane splitPane=(SplitPane)root.getChildren().get(0);
			
			
			Pane detailRoot =loadPane("orderInfo.fxml");
			OrderInfoController controller = loader.getController();
			controller.setOrderVo(vo);
			splitPane.getItems().remove(1);
			splitPane.getItems().add(1, detailRoot);
			/*
			Scene detailScene = new Scene(root,1200,800);
			detailScene.getStylesheets().add(getClass().getResource("orderinfo.css").toExternalForm());
			primaryStage.setScene(detailScene);
			primaryStage.show();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void initStage(){
		orderVolist.add(testOrder);
		
		try {
			root=loadPane("orderList_V1.0.fxml");
			OrderListController controller = loader.getController();
			
			
			
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
		launch(args);
	}
}

