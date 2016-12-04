package view.marketer;

import Usersblimpl.MarketerVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RevampPasswordController {
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    
    private MarketerVO marketerVO;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    
	public RevampPasswordController(){
	    oldPasswordField=new PasswordField();
	    newPasswordField=new PasswordField();
        confirmPasswordField=new PasswordField();
	}
	
	@FXML
	public void cancel(){
		//界面消失
	}
	
	@FXML
	public void confirm(){
		if(oldPassword.equals(this.marketerVO.getPassword())&&newPassword.equals(confirmPassword)){
		    marketerVO.setPassword(newPassword);
		    UserControllerblimpl userControllerMock=new UserControllerblimpl();
		    ResultMessage resultMessage =userControllerMock.revoke
		    		      (marketerVO.getUserId(), marketerVO, UserType.valueOf(marketerVO.getType()));
	        
		}
	}
}

