package view.staff;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.OrdersService;
import blservice.UserService;
import data.rmi.RemoteHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import loginblimpl.LoginVo;
import ordersblimpl.OrderServiceImpl;

public class Main extends Application {
  
	

	private static Main main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static SplitPane mainPane;
	private static BorderPane staffBorderPane;
	private static StaffVO staff;
	private static Stage loginStage;
	private UserService userService;
	private OrdersService ordersService;
	private static String hotelName;
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
	
	public  Main() {
		ordersService = new OrderServiceImpl();
		userService = new UserControllerblimpl();
		loader = new FXMLLoader();
	  
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
	public void setMemberVo(LoginVo vo){
		userService = new UserControllerblimpl();
		this.staff = (StaffVO) userService.find(vo.getId(), UserType.staff);
		this.hotelName=staff.getHotelName();
	}

	public void logout(){
		primaryStage.close();
		loginStage.showAndWait();
		staff = null;
	}
	
	public void showMain(){
		this.primaryStage.setTitle("酒店工作人员主界面");
		try {
			loginStage.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		initmainPane();
	}
	@Override
	public void start(Stage primaryStage) {
		linkToServer();
		loginStage = new Stage();
		Pane loginPane = loadPane("StaffLogin.fxml");
		Scene loginScene = new Scene(loginPane,600,400);
		loginStage.setScene(loginScene);
		loginStage.show();
		this.primaryStage=primaryStage;
		
		
		
		
		
	}
	
	public void showList(){
		 loader=new FXMLLoader();
		 SplitPane pane = null;
	loader.setLocation(Main.class.getResource("OrderErrorlist.fxml"));
	try {
		pane = loader.load();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		OrderErrorListController controller = loader.getController();
		controller.initialize(ordersService.getHotelOrder(hotelName), hotelName);
		
		staffBorderPane.setCenter(pane);
	}
	
	/**
	 * @param
	 * @return 加载制定策略的初始界面
	 */
	public  void initmainPane() {
		// TODO Auto-generated method stub
		     loader=new FXMLLoader();
		try {
			//加载mainPane			
			loader.setLocation(Main.class.getResource("frame.fxml"));
			staffBorderPane=(BorderPane)loader.load();
			
			//展现
			Scene scene=new Scene(staffBorderPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private   Pane loadPane(String fxml) {
		// TODO Auto-generated method stub
		  loader=new FXMLLoader();
		try {
		
			loader.setLocation(Main.class.getResource(fxml));
			return (Pane)loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
    public void movetoPromotionsi(){
    	try {
    		
    		AnchorPane promotionsiPane=new AnchorPane();
			 promotionsiPane=(AnchorPane)loadPane("Promotionsi.fxml");
			mainPane.getItems().set(1, promotionsiPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsii(){
    	try {	
    		
    		AnchorPane promotionsiiPane=new AnchorPane();
			 promotionsiiPane=(AnchorPane)loadPane("Promotionsii.fxml");			
			mainPane.getItems().set(1, promotionsiiPane);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsiii(){
    	try {	
    		
    		AnchorPane promotionsiiiPane=new AnchorPane();
			 promotionsiiiPane=(AnchorPane)loadPane("Promotionsiii.fxml");			
			mainPane.getItems().set(1, promotionsiiiPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsiv(){
    	try {	
    		
    		AnchorPane promotionsivPane=new AnchorPane();
			 promotionsivPane=(AnchorPane)loadPane("Promotionsiv.fxml");			
			mainPane.getItems().set(1, promotionsivPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoAddPromotions(){
    	try {
    		 loader=new FXMLLoader();
			 loader.setLocation(Main.class.getResource("StaffPromotionsframe.fxml"));
			 mainPane=(SplitPane)loader.load();		
			 staffBorderPane.setCenter(mainPane);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
    public void movetoDeletePromotions(){
    	 try {
 			AnchorPane DeletePromotionsPane=new AnchorPane();
 			DeletePromotionsPane=(AnchorPane)loadPane("DeletePromotions.fxml");
 			staffBorderPane.setCenter(DeletePromotionsPane);
 		} catch (Exception e) {
 			e.printStackTrace();
 			// TODO: handle exception
 		}
    }
    public void movetoLookPromotions(){
    	try{
    		AnchorPane showPromotionsPane=new AnchorPane();
    		showPromotionsPane=(AnchorPane)loadPane("ShowPromotions.fxml");
    		staffBorderPane.setCenter(showPromotionsPane);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
   public void showInformation(){
	   try {
		Pane page=new BorderPane();
		page=(BorderPane)loadPane("StaffInformation.fxml");
		
		staffBorderPane.setCenter(page);
		
		StaffInformationController controller=loader.getController();
		controller.setStaffVO(staff);
	} catch (Exception e) {
		// TODO: handle exception
	}
   }
   
   public void revampPassword(){
	   try {
		Pane page=new BorderPane();
		page=(BorderPane)loadPane("revampPasswordUi.fxml");
		
		staffBorderPane.setCenter(page);
		
		StaffInformationController controller=loader.getController();
		controller.setStaffVO(staff);
	} catch (Exception e) {
		// TODO: handle exception
	}
   }
	
	
  public Stage getPrimaryStage(){
	  return primaryStage;
  }
	public static void main(String[] args) {
		launch(args);
	}
	public void showCheckIn() {
		try {
			AnchorPane page=new AnchorPane();
			page=(AnchorPane)loadPane("RecordCheckIn.fxml");
			
			staffBorderPane.setCenter(page);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showCheckOut() {
		try {
			AnchorPane page=new AnchorPane();
			page=(AnchorPane)loadPane("RecordCheckOut.fxml");
			
			staffBorderPane.setCenter(page);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showAddRoom() {
		try {
			AnchorPane page=new AnchorPane();
			page=(AnchorPane)loadPane("AddRoom.fxml");
			
			staffBorderPane.setCenter(page);
			
			AddRoomController controller=loader.getController();
			controller.setHotelName(hotelName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showUpdateHotel() {
		try {
			AnchorPane page=new AnchorPane();
			page=(AnchorPane)loadPane("UpdateHotel.fxml");
			UpdateHotelController controller  = loader.getController();
			controller.setHotelName(hotelName);
			
			staffBorderPane.setCenter(page);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
