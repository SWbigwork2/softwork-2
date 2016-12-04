package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RevampPasswordController {
	@FXML private TextField oldPasswordField;
    @FXML private TextField newPasswordField;
    @FXML private TextField confirmPasswordField;
	
    private MemberInformationVO member;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    
	public RevampPasswordController(MemberInformationVO member){
	    this.member=member;
	    oldPassword=oldPasswordField.getText();
	    newPassword=newPasswordField.getText();
	    confirmPassword=confirmPasswordField.getText();
	}
	
	@FXML
	public void cancel(){
		
	}
	
	@FXML
	public void confirm(){
		if(oldPassword.equals(this.member.getPassword())&&newPassword.equals(confirmPassword)){
		    member.setPassword(newPassword);
		    UserControllerblimpl userControllerMock=new UserControllerblimpl();
		    ResultMessage resultMessage =userControllerMock.revoke
		    		      (member.getUserId(), member, UserType.valueOf(member.getType()));
	        
		}
	}
}
