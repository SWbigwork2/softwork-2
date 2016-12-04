package view.manager;

import Usersblimpl.ManagerVO;
import Usersblimpl.MarketerVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RevampPasswordController {
    @FXML private TextField oldPasswordField;
    @FXML private TextField newPasswordField;
    @FXML private TextField confirmPasswordField;
    
    private ManagerVO managerVO;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    
	public RevampPasswordController(ManagerVO managerVO){
	    this.managerVO=managerVO;
	    oldPassword=oldPasswordField.getText();
	    newPassword=newPasswordField.getText();
	    confirmPassword=confirmPasswordField.getText();
	}
	
	@FXML
	public void cancel(){
		//界面消失
	}
	
	@FXML
	public void confirm(){
		if(oldPassword.equals(this.managerVO.getPassword())&&newPassword.equals(confirmPassword)){
		    managerVO.setPassword(newPassword);
		    UserControllerblimpl userControllerMock=new UserControllerblimpl();
		    ResultMessage resultMessage =userControllerMock.revoke
		    		      (managerVO.getUserId(),managerVO,UserType.valueOf( managerVO.getType()));
	        
		}
	}
}
