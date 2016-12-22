package view.manager;


import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StaffInformationController {
    
	@FXML 
    private Label staffIdField;
    
    @FXML 
    private TextField staffNameField;
    
    @FXML 
    private PasswordField staffPasswordField;
    
    @FXML 
    private Label hotelNameField;
    
    private StaffVO staff;
	private Main main;
    private boolean isRevamp;
    
    public StaffInformationController() {
		// TODO Auto-generated constructor stub
	    staffIdField=new Label();
	    staffNameField=new TextField();
	    staffPasswordField=new PasswordField();	    
	    hotelNameField=new Label();
	
	    isRevamp=false;
	    main=main.getMain();
    }
    
    
	/**
	 * 修改用户名
	 */
	@FXML
	private void revampName(){
		staffNameField.setEditable(true);
		isRevamp=true;
        
	}
	
	@FXML
	private void cancel(){
        staffNameField.setEditable(false);
        main.moveToFindStaff();
	}
	
	@FXML
	private void confirm(){
			//跳出一个确认界面，然后保存
		
		ResultMessage resultMessage=ResultMessage.fail;
		
		if(isRevamp){
		    staff.setName(staffNameField.getText());			

		    UserService userService=new UserControllerblimpl();
		
		    resultMessage=userService.revoke(staff.getUserId(), staff, UserType.staff);
		}		
		
		main.moveToFindStaff();
		
	}
	
	public  void setStaff(StaffVO staffVO){
		this.staff=staffVO;
		
		this.staffIdField.setText(staffVO.getUserId());
		this.staffNameField.setText(staffVO.getName());
		this.staffPasswordField.setText(staffVO.getPassword());
		this.hotelNameField.setText(staffVO.getHotelName());
	}
	
}
