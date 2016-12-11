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
    
    @FXML
    private void showInformation(){
        main.moveToInformation();
    }
    
    @FXML
    private void showMembers(){
    	main.moveToFindMember();
    }
    
    @FXML
    private void showStaffs(){
    	main.moveToFindStaff();
    }
    
    @FXML 
    private void showMarketers(){
    	main.moveToFindMarketer();
    }
    
    @FXML
    private void showAddStaff(){
    	main.moveToAddStaff();
    }
    
    @FXML
    private void showAddMarketer(){
    	main.moveToAddMarketer();
    }
    
    @FXML 
    private void showAddHotel(){
    	main.moveAddHotel();
    }
    
}
