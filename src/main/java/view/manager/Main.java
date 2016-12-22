package view.manager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Usersblimpl.ManagerVO;
import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
import data.rmi.RemoteHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	private static Main main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static BorderPane mainPane;
	private ManagerVO managerVO;
	private static String userId;
	private static Stage loginStage;
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
		linkToServer();
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
	
	public void loginFrame(){
		loginStage.close();
		initmainPane();	
	}
	
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("网站营销人员主界面");
		loginStage = new Stage();
		Pane loginPane = loadPane("ManagerLogin.fxml");
		Scene loginScene = new Scene(loginPane,600,400);
		loginStage.setScene(loginScene);
		loginStage.showAndWait();
		
		
	}
	
    public static void main(String agrs[]){
    	main = new Main();
	    	launch(agrs);
	}
	/**
	 * @param
	 * @return �����ƶ����Եĳ�ʼ����
	 */
	public  void initmainPane() {
		// TODO Auto-generated method stub
		     loader=new FXMLLoader();
		try {
			//����mainPane			
			loader.setLocation(Main.class.getResource("frame.fxml"));
			mainPane=(BorderPane)loader.load();

			Scene scene=new Scene(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	private   BorderPane loadPane(String fxml) {
		// TODO Auto-generated method stub
		  loader=new FXMLLoader();
		  
		try {
		
			loader.setLocation(Main.class.getResource(fxml));
			return (BorderPane)loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 跳转到查看会员界面
	 */
	public void moveToFindMember(){
		
		BorderPane findMember=loadPane("FindMember.fxml");
		mainPane.setCenter(findMember);
	        
	}
	
	/**
	 * 跳转到查看酒店工作人员界面
	 */
	public void moveToFindStaff(){

		BorderPane findStaff=loadPane("FindStaff.fxml");
		mainPane.setCenter(findStaff);
		
	}
	
	/**
	 *跳转到查看营销人员界面 
	 */
	public void moveToFindMarketer(){
		
		BorderPane findMarketer=loadPane("FindMarketer.fxml");
		
		mainPane.setCenter(findMarketer);
		
	}
	
	/**
	 * 跳转到个人信息界面
	 */
	public void moveToInformation(){
		try {
			BorderPane informationPane=loadPane("ManagerInformationUi.fxml");
		    
		    ManagerInformationController managerInformationController
		    		=loader.getController();
		    managerInformationController.setManagerVO(managerVO);
		    
		    
		    mainPane.setCenter(informationPane);
	    
		} catch (Exception e) {
			e.printStackTrace();
				// TODO: handle exception
		
	    }
	}
	
	/**
	 * 添加酒店工作人员
	 */
	public void moveToAddStaff(){
		BorderPane addStaff=loadPane("staffRegisterUi.fxml");
		
		mainPane.setCenter(addStaff);
	}
	
	/**
	 * 添加营销人员
	 */
	public void moveToAddMarketer(){
		BorderPane addMarketer=loadPane("marketerRegisterUi.fxml");
		
		mainPane.setCenter(addMarketer);
	}
	
	public Stage getPrimaryStage(){
	    return primaryStage;
	}
		
	/**
	 * @param marketerVO
	 * 营销人员个人信息
	 */
	public void  showMarketerDetais(MarketerVO marketerVO){		
	        BorderPane page = loadPane("MarketerInformationUi.fxml");
	        MarketerInformationController controller=loader.getController();
	        controller.setMarketer(marketerVO);
	        
	        mainPane.setCenter(page);
	}
	
	/**
	 * @param staffVO
	 * 酒店工作人员个人信息
	 */
	public void showStaffDetails(StaffVO staffVO){
		BorderPane page =loadPane("StaffInformation.fxml");
		StaffInformationController controller=loader.getController();
		controller.setStaff(staffVO);
		
		mainPane.setCenter(page);
	}
	
	/**
	 * @param managerVO
	 * 修改密码
	 */
	public void showRevamoPassword(ManagerVO managerVO){
		BorderPane page=loadPane("revampPasswordUi.fxml");
		RevampPasswordController controller=loader.getController();
		controller.setManager(managerVO);
		
		mainPane.setCenter(page);
	}
	
	/**
	 * @param member
	 * 会员个人信息
	 */
	public void showMemberDetails(MemberInformationVO member){
		BorderPane page=loadPane("memberInformationUi.fxml");
		MemberInformationController controller=loader.getController();
		controller.setMember(member);
		
		
		mainPane.setCenter(page);
	}
	
	/**
	 * 添加酒店
	 */
	public void moveAddHotel(){
		  loader=new FXMLLoader();
		  AnchorPane page=null;
		  
		  try {
			  loader.setLocation(Main.class.getResource("addHotel.fxml"));
			  page=(AnchorPane)loader.load();
		  } catch (Exception e) {
				// TODO: handle exception
			  e.printStackTrace();
		  }
		  mainPane.setCenter(page);
	}
	
	/**
	 * @param managerId
	 * 设置管理人员信息
	 */
	public void setManager(String managerId){
		UserService userService =new UserControllerblimpl();
		this.managerVO=(ManagerVO)userService.find(managerId, UserType.manager);
	}

	/**
	 * @param type
	 * @param headerText
	 * @param contentText
	 * 显示提示信息
	 */
	public void showWaningInformation(AlertType type,
			String headerText,String contentText){
		Alert alert = new Alert(type);
	    alert.setTitle("来自系统的提示");
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);

	    alert.showAndWait();
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		Main.userId = userId;
	}
}

