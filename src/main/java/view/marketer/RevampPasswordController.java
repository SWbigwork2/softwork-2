package view.marketer;

import Usersblimpl.MarketerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class RevampPasswordController {
    @FXML private PasswordField oldPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    
    private MarketerVO marketerVO;
    private MarketerMain  main;
	public RevampPasswordController(){
	    oldPasswordField=new PasswordField();
	    newPasswordField=new PasswordField();
        confirmPasswordField=new PasswordField();
	    main=main.getMain();
	}
	
	@FXML
	public void cancel(){
		//界面消失
		main.movetoInformation();
	}
	
	@FXML
	public void confirm(){
		String oldPassword=oldPasswordField.getText();
		String newPassword=newPasswordField.getText();
		String confirmPassword=confirmPasswordField.getText();
		
		if(oldPassword.length()>=1&&
				newPassword.length()>=1&&
				    confirmPassword.length()>=1){//判断是否输入内容
		    
			if(newPassword.equals(confirmPassword)){//判断两次密码是否一致
		        
				if(oldPassword.equals(this.marketerVO.getPassword())){//判断旧密码是否正确
			    
					this.marketerVO.setPassword(newPassword);
		            UserControllerblimpl userControllerMock=new UserControllerblimpl();
		            userControllerMock.revoke(this.marketerVO.getUserId(),this.marketerVO,UserType.valueOf( this.marketerVO.getType()));
		            main.showWaningInformation(AlertType.INFORMATION, "提示", "修改成功");
		            main.movetoInformation();
		        
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
	
	public void setManager(MarketerVO marketer){
		this.marketerVO=marketer;
		
	}
}

