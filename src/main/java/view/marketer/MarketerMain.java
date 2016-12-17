package view.marketer;

import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
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

public class MarketerMain extends Application {
  
	

	private static MarketerMain main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static SplitPane mainPane;
	private static BorderPane marketerBorderPane;
	private static MarketerVO marketer;
	private static Stage loginStage;
	private UserService userService;
	
	public  MarketerMain() {
		userService = new UserControllerblimpl();
		loader = new FXMLLoader();
	
	
	}
	public void showList(){
		 loader=new FXMLLoader();
		 SplitPane pane = null;
			try {
			
				loader.setLocation(MarketerMain.class.getResource("OrderRecoverlist.fxml"));
				pane = loader.load();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		marketerBorderPane.setCenter(pane);
	}
	public void setMemberVo(LoginVo vo){
		userService = new UserControllerblimpl();
		this.marketer =(MarketerVO) userService.find(vo.getId(), UserType.marketer);
		
		
		
	}
	public void showMain(){
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
//		loginStage = new Stage();
//		Pane loginPane = loadPane("MarketLogin.fxml");
//		Scene loginScene = new Scene(loginPane,600,400);
//		loginStage.setScene(loginScene);
//		loginStage.show();
		
		this.primaryStage=primaryStage;
	    showMain();
		
		
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
	 public void movetoPromotionsv(){
	    	try {
	    		
	    		AnchorPane promotionsvPane=new AnchorPane();
				 promotionsvPane=(AnchorPane)loadPane("Promotionsv.fxml");
				 promotionsvPane.setPrefSize(556, 598);
//				 promotionsvPane.setMaxSize(556, 598);
//				 promotionsvPane.setMinSize(556, 598);
				mainPane.getItems().set(1, promotionsvPane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 public void movetoPromotionsvi(){
	    	try {
	    		
	    		AnchorPane promotionsviPane=new AnchorPane();
				 promotionsviPane=(AnchorPane)loadPane("Promotionsvi.fxml");
				 promotionsviPane.setPrefSize(556, 598);
//				 promotionsviPane.setMaxSize(556, 598);
//				 promotionsviPane.setMinSize(556, 598);
				mainPane.getItems().set(1, promotionsviPane);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 public void movetoPromotionsii2(){
	    	try {
	    		
	    		AnchorPane promotionsii2Pane=new AnchorPane();
				 promotionsii2Pane=(AnchorPane)loadPane("Promotionsii2.fxml");
				 promotionsii2Pane.setPrefSize(556, 598);
//				 promotionsii2Pane.setMaxSize(556, 598);
//				 promotionsii2Pane.setMinSize(556, 598);
				 mainPane.getItems().set(1, promotionsii2Pane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
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
//	 public void movetoDeletePromotions(){
//		 try {
//			AnchorPane DeletePromotionsPane=new AnchorPane();
//			DeletePromotionsPane=(AnchorPane)loadPane("DeleteMarketPromotions.fxml");
//			marketerBorderPane.setCenter(DeletePromotionsPane);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//	 }
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
		launch(args);
	}
	
	
}