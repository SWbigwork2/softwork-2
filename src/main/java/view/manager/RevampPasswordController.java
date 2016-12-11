package view.manager;

import Usersblimpl.ManagerVO;
import Usersblimpl.MarketerVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RevampPasswordController {
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    
    private ManagerVO managerVO;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private Main main;
    
	public RevampPasswordController(){
	    oldPasswordField=new PasswordField();
	    newPasswordField=new PasswordField();
	    confirmPasswordField=new PasswordField();
	    main=Main.getMain();
	}
	
	@FXML
	public void cancel(){
		main.moveToInformation();
		//界面消失
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
		        
				if(oldPassword.equals(this.managerVO.getPassword())){//判断旧密码是否正确
			    
					managerVO.setPassword(newPassword);
		            UserControllerblimpl userControllerMock=new UserControllerblimpl();
		            userControllerMock.revoke(managerVO.getUserId(),managerVO,UserType.valueOf( managerVO.getType()));
		            main.showWaningInformation(AlertType.INFORMATION, "提示", "修改成功");
		            main.moveToInformation();
		        
				}else{//输出原密码错误的提示信息
		    	    main.showWaningInformation(AlertType.ERROR, "提醒","原密码错误" );
		        }
		    
			}else{//输出密码不一致的信息
			    main.showWaningInformation(AlertType.WARNING, "提醒", "两次输入的新密码不一致");
		    }
		
		}else{//输出提示输入完整的信息
			main.showWaningInformation(AlertType.ERROR, "提示", "请输入完整");
		}
	}
	
	public void setManager(ManagerVO manager){
		this.managerVO=manager;	
	}
}
