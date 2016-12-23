package view.marketer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.OrdersService;
import blservice.UserService;
import data.rmi.RemoteHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import loginblimpl.LoginVo;
import ordersblimpl.OrderServiceImpl;
import view.staff.Main;

public class MarketerMain extends Application {
  
	

	private static MarketerMain main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static SplitPane mainPane;
	private static BorderPane marketerBorderPane;
	private static MarketerVO marketer;
	private static Stage loginStage;
	private UserService userService;
	private OrdersService ordersService;
private RemoteHelper remoteHelper;
	
/**
 * 连接到服务器
 */
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
	public  MarketerMain() {
	
		linkToServer();
		ordersService = new OrderServiceImpl();
		userService = new UserControllerblimpl();
		loader = new FXMLLoader();
	
	
	}
	/**
	 * 加载订单列表
	 */
	public void showList(){
		 loader=new FXMLLoader();
		 SplitPane pane = null;
			try {
			
				loader.setLocation(MarketerMain.class.getResource("OrderRecoverlist.fxml"));
				pane = loader.load();
				OrderRecoverListController controller = loader.getController();
				controller.initialize(ordersService.getUndoList());
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		marketerBorderPane.setCenter(pane);
	}
	/**
	 * @param vo
	 * 设置memberVO
	 */
	public void setMemberVo(LoginVo vo){
		userService = new UserControllerblimpl();
		this.marketer =(MarketerVO) userService.find(vo.getId(), UserType.marketer);
		
		
		
	}
	/**
	 * 登出
	 */
	public void logout(){
		primaryStage.close();
		loginStage.showAndWait();
	}
	/**
	 * 展示营销人员主界面
	 */
	public void showMain(){
		loginStage.close();
		this.primaryStage.setTitle("营销人员主界面");
		initmainPane();
	}
	public static MarketerMain getMain(){
		if(main==null){
			main = new MarketerMain();
			return main;
		}
		else{
			return main;
		}
	}
	@Override
	public void start(Stage primaryStage) {
		loginStage = new Stage();
		Pane loginPane = loadPane("MarketLogin.fxml");
		Scene loginScene = new Scene(loginPane,600,400);
		loginStage.setScene(loginScene);
		loginStage.show();
		
		this.primaryStage=primaryStage;
	
		
		
	}
	/**
	 * @param
	 * @return 加载网站制定策略的初始界面
	 */
	public  void initmainPane() {
		// TODO Auto-generated method stub
		     loader=new FXMLLoader();
		try {
			//加载mainPane
			loader.setLocation(MarketerMain.class.getResource("MainView.fxml"));			
			marketerBorderPane=(BorderPane)loader.load();		
			//展现
			Scene scene=new Scene(marketerBorderPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	/**
	 * 跳转到显示网站策略
	 */
	public void movetoLookPromotions(){
		 
		 try {
			AnchorPane showPromotionsPane=new AnchorPane();
			showPromotionsPane=(AnchorPane)loadPane("ShowMarketPromotions.fxml");
			marketerBorderPane.setCenter(showPromotionsPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	/**
	 * @param fxml
	 * @return  加载界面
	 */
	private   Pane loadPane(String fxml) {
		// TODO Auto-generated method stub
		  loader=new FXMLLoader();
		try {
		
			loader.setLocation(MarketerMain.class.getResource(fxml));
			return (Pane)loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	 /**
	 *   跳转到制定商圈策略
	 */
	public void movetoPromotionsv(){
	    	try {
	    		
	    		AnchorPane promotionsvPane=new AnchorPane();
				 promotionsvPane=(AnchorPane)loadPane("Promotionsv.fxml");
				 promotionsvPane.setPrefSize(556, 598);
				mainPane.getItems().set(1, promotionsvPane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 /**
	 *   跳转到会员等级策略界面
	 */
	public void movetoPromotionsvi(){
	    	try {
	    		
	    		AnchorPane promotionsviPane=new AnchorPane();
				 promotionsviPane=(AnchorPane)loadPane("Promotionsvi.fxml");
				 promotionsviPane.setPrefSize(556, 598);
				mainPane.getItems().set(1, promotionsviPane);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 /**
	 * 跳转到制定节日特惠策略界面
	 */
	public void movetoPromotionsii2(){
	    	try {
	    		
	    		AnchorPane promotionsii2Pane=new AnchorPane();
				 promotionsii2Pane=(AnchorPane)loadPane("Promotionsii2.fxml");
				 promotionsii2Pane.setPrefSize(556, 598);
				 mainPane.getItems().set(1, promotionsii2Pane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 /**
	 * 跳转到添加策略主界面
	 */
	public void movetoAddPromotions(){
		 try {					 
			 loader=new FXMLLoader();
			 loader.setLocation(MarketerMain.class.getResource("MarketerPromotionsframe.fxml"));
			 mainPane=(SplitPane)loader.load();		
			 marketerBorderPane.setCenter(mainPane);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	 
	 /**
	 *  跳转到充值信用界面
	 */
	public void movetoAddCredit(){
		 try{
			 loader =new FXMLLoader();
			 loader.setLocation(MarketerMain.class.getResource("AddCredit.fxml"));
			 BorderPane page=(BorderPane)loader.load();
			 marketerBorderPane.setCenter(page);
			 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 /**
	 * 跳转营销人员个人信息
	 */
	public void movetoInformation(){
		 try{
			 loader =new FXMLLoader();
			 loader.setLocation(MarketerMain.class.getResource("MarketerInformationUi.fxml"));
			 BorderPane page=(BorderPane)loader.load();
			 marketerBorderPane.setCenter(page);
			 
			 MarketerInformationController controller=loader.getController();
			 controller.setMarketer(marketer);
		 
		 }catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		 }
	 }
	
	 public void setMarketer(String id){
		 UserService userService=new UserControllerblimpl();
		 this.marketer=(MarketerVO)userService.find(id, UserType.marketer);
	 }
	 
	 /**
	 * 跳转到修改密码界面
	 */
	public void movetoRevampPassword(){
		 try{
			 loader =new FXMLLoader();
			 loader.setLocation(MarketerMain.class.getResource("revampPasswordUi.fxml"));
			 BorderPane page=(BorderPane)loader.load();
			 marketerBorderPane.setCenter(page);
			 
			 RevampPasswordController controller =loader.getController();
			 controller.setManager(marketer);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }


	 /**
	 * @param type
	 * @param headerText
	 * @param contentText
	 * 提示框
	 */
	public void showWaningInformation(AlertType type,
				String headerText,String contentText){
			 Alert alert = new Alert(type);
		     alert.setTitle("来自系统的提示");
		     alert.setHeaderText(headerText);
		     alert.setContentText(contentText);

		     alert.showAndWait();
		 }


  public Stage getPrimaryStage(){
	  return primaryStage;
  }
	public static void main(String[] args) {
		main = new MarketerMain();
		launch(args);
	}
	
	
}