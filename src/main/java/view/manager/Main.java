package view.manager;

import Usersblimpl.ManagerVO;
import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
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
	
	public  Main() {
		
		loader = new FXMLLoader();
	    managerVO=new ManagerVO("1111", "2222", "3333");
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
	
	public void showMainPane(){
		
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
	
	public void moveToFindMember(){
		
		BorderPane findMember=loadPane("FindMember.fxml");
//		BorderPane pane=(SplitPane)mainPane.getItems().get(1);
//		pane.getItems().set(1, findMember);
//		mainPane.set(Center)
		mainPane.setCenter(findMember);
	        
	}
	
	public void moveToFindStaff(){
		BorderPane findStaff=loadPane("FindStaff.fxml");
//		SplitPane pane=(SplitPane)mainPane.getItems().get(1);
		//pane.getItems().set(1, findStaff);
		mainPane.setCenter(findStaff);
		
	}
	
	public void moveToFindMarketer(){
		//初始化列表		
		
		BorderPane findMarketer=loadPane("FindMarketer.fxml");
//		SplitPane pane=(SplitPane)main/Pane.getItems().get(1);
//		pane.getItems().set(1, findMarketer);
		
		mainPane.setCenter(findMarketer);
		
	}
	
	public void moveToInformation(){
		try {
			BorderPane informationPane=loadPane("ManagerInformationUi.fxml");
		    
		    ManagerInformationController managerInformationController
		    		=loader.getController();
		    managerInformationController.setManagerVO(managerVO);
		    
//		    SplitPane pane=(SplitPane) mainPane.getItems().get(1);
//		    pane.getItems().set(1,informationPane);
		    
		    mainPane.setCenter(informationPane);
	    
		} catch (Exception e) {
			e.printStackTrace();
				// TODO: handle exception
		
	    }
	}
	
	public void moveToAddStaff(){
		BorderPane addStaff=loadPane("staffRegisterUi.fxml");
//		SplitPane pane=(SplitPane)mainPane.getItems().get(1);
//		pane.getItems().set(1, addStaff);
		
		mainPane.setCenter(addStaff);
	}
	
	public void moveToAddMarketer(){
		BorderPane addMarketer=loadPane("marketerRegisterUi.fxml");
		
//		SplitPane pane=(SplitPane)mainPane.getItems().get(1);
//		pane.getItems().set(1, addMarketer);
		
		mainPane.setCenter(addMarketer);
	}
	
	public Stage getPrimaryStage(){
	    return primaryStage;
	}
		
	public void  showMarketerDetais(MarketerVO marketerVO){		
	        BorderPane page = loadPane("MarketerInformationUi.fxml");
	        MarketerInformationController controller=loader.getController();
	        controller.setMarketer(marketerVO);
//	        SplitPane pane=(SplitPane)mainPane.getItems().get(1);
//			pane.getItems().set(1, page);
	        
	        mainPane.setCenter(page);
	}
	
	public void showStaffDetails(StaffVO staffVO){
		BorderPane page =loadPane("StaffInformation.fxml");
		StaffInformationController controller=loader.getController();
		controller.setStaff(staffVO);
//		SplitPane pane=(SplitPane)mainPane.getItems().get(1);
//		pane.getItems().set(1, page);
		
		mainPane.setCenter(page);
	}
	
	public void showRevamoPassword(ManagerVO managerVO){
		BorderPane page=loadPane("revampPasswordUi.fxml");
		RevampPasswordController controller=loader.getController();
		controller.setManager(managerVO);
		
		mainPane.setCenter(page);
	}
	
	public void showMemberDetails(MemberInformationVO member){
		BorderPane page=loadPane("memberInformationUi.fxml");
		MemberInformationController controller=loader.getController();
		controller.setMember(member);
//		SplitPane pane=(SplitPane)mainPane.getItems().get(1);
//		pane.getItems().set(1, page);
		
		
		mainPane.setCenter(page);
	}
	
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
	
	public void setManager(String managerId){
		UserService userService =new UserControllerblimpl();
		this.managerVO=(ManagerVO)userService.find(managerId, UserType.manager);
	}

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

