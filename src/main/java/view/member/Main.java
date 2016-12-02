package view.member;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import blservice.OrderService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main extends Application {
	private static Main main;
	OrderService blService;
	OrderVo testOrder = new OrderVo("lv3", 0001, "admin", "admin", "皇朝", new Date(), new Date(), new Date(), new Date(), new Date(), 100.0, "正在进行","normal",1,1,false);
	private ObservableList<OrderVo> orderVolist = FXCollections.observableArrayList();
	private Parent root;
	private Stage primaryStage ;
	public Main() {
		blService = new OrderServiceImpl();
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
			this.primaryStage.setTitle("�����б�");
			initStage();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initStage(){
		orderVolist.add(testOrder);
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("orderList_V1.0.fxml"));
			OrderListController controller = loader.getController();
			
			root= (Parent)loader.load();
			
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

