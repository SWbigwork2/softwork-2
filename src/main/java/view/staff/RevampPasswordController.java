package view.staff;

import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class RevampPasswordController {
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
	
    private StaffVO staffVO;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    
    private Button cancel;
    
	public RevampPasswordController(){
	   oldPasswordField    = new PasswordField();
	   newPasswordField    = new PasswordField();
	   confirmPasswordField= new PasswordField();
	   cancel=new Button();
	}
	
	@FXML
	public void cancel(){

	}
	
	public   void setStaffVO(StaffVO staffVO) {
		this.staffVO = staffVO;
	}
	
	@FXML
	public void confirm(){
		
		oldPassword=oldPasswordField.getText();
		System.out.println(oldPassword);
		newPassword=newPasswordField.getText();
		confirmPassword=confirmPasswordField.getText();
		
	    if(oldPassword.equals(this.staffVO.getPassword())&&newPassword.equals(confirmPassword)){
		    staffVO.setPassword(newPassword);
		    UserControllerblimpl userControllerMock=new UserControllerblimpl();
		    ResultMessage resultMessage =userControllerMock.revoke
		    		      (staffVO.getUserId(), staffVO, UserType.valueOf(staffVO.getType()));
	        System.out.println(resultMessage);
	        
		}
	}
}
