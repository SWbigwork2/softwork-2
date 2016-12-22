package view.manager;

import Usersblimpl.ManagerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.Users;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WorkSapceController {
    @FXML private Button ManagerInformationButton;
    @FXML private Button checkMembersButton;
    @FXML private Button checkStaffsButton;
    @FXML private Button checkMarketersButton;
    @FXML private Button addStaffbutton;
    @FXML private Button addManagerButton;
    @FXML private Button addHotelButton;
    private Main main;
    
    public WorkSapceController(){
    	
    	main=Main.getMain();
    	ManagerInformationButton=new Button();
    	checkMarketersButton=new Button();
    	checkMembersButton=new Button();
    	checkStaffsButton=new Button();
    	addManagerButton=new Button();
    	addStaffbutton=new Button();
    
    }
    
    /**
     * 展示个人信息界面
     */
    @FXML
    private void showInformation(){
        main.moveToInformation();
    }
    
    /**
     * 会员列表界面
     */
    @FXML
    private void showMembers(){
    	main.moveToFindMember();
    }
    
    /**
     * 酒店工作人员列表界面
     */
    @FXML
    private void showStaffs(){
    	main.moveToFindStaff();
    }
    
    /**
     * 营销人员 列表
     */
    @FXML 
    private void showMarketers(){
    	main.moveToFindMarketer();
    }
    
    /**
     * 添加酒店工作人员
     */
    @FXML
    private void showAddStaff(){
    	main.moveToAddStaff();
    }
    
    /**
     * 添加营销人员
     */
    @FXML
    private void showAddMarketer(){
    	main.moveToAddMarketer();
    }
    
    /**
     * 添加酒店
     */
    @FXML 
    private void showAddHotel(){
    	main.moveAddHotel();
    }
    
}
