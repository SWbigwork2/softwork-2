package view.staff;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class RevampPasswordController {
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
	
    private StaffVO staffVO;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private Main main;
    private Button cancel;
    
	public RevampPasswordController(){
	   oldPasswordField    = new PasswordField();
	   newPasswordField    = new PasswordField();
	   confirmPasswordField= new PasswordField();
	   cancel=new Button();
	   main=main.getMain();
	}
	
	@FXML
	public void cancel(){
        main.showInformation();
	}
	
	@FXML
	public void confirm(){
		oldPassword=oldPasswordField.getText();
		newPassword=newPasswordField.getText();
		confirmPassword=confirmPasswordField.getText();
		
		if(oldPassword.length()>=1&&
				newPassword.length()>=1&&
				    confirmPassword.length()>=1){//判断是否输入内容
		    
			if(newPassword.equals(confirmPassword)){//判断两次密码是否一致
		        
				if(oldPassword.equals(this.staffVO.getPassword())){//判断旧密码是否正确
			    
					staffVO.setPassword(newPassword);
		            UserControllerblimpl userControllerMock=new UserControllerblimpl();
		            userControllerMock.revoke(staffVO.getUserId(),staffVO,UserType.valueOf( staffVO.getType()));
		            this.showWaningInformation(AlertType.INFORMATION, "提示", "修改成功");
		            main.showInformation();
		        
				}else{//输出原密码错误的提示信息
					this.showWaningInformation(AlertType.ERROR, "提醒","原密码错误" );
		        }
		    
			}else{//输出密码不一致的信息
				this.showWaningInformation(AlertType.WARNING, "提醒", "两次输入的新密码不一致");
		    }
		
		}else{//输出提示输入完整的信息
			this.showWaningInformation(AlertType.ERROR, "提示", "请输入完整");
		}
	}
		
	
	
	public   void setStaffVO(StaffVO staffVO) {
		this.staffVO = staffVO;
	}
	
	private void showWaningInformation(AlertType type,
			String headerText,String contentText){
		Alert alert = new Alert(type);
	    alert.setTitle("来自系统的提示");
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);

	    alert.showAndWait();
	}
}
