package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;

public class RevampPasswordController {
	@FXML private PasswordField oldPassword;
    @FXML private PasswordField newPassword;
    @FXML private PasswordField confirmPassword;
	
    private MemberInformationVO member;
    private Main main;
    
	public RevampPasswordController(){
	    main=main.getMain();
	    oldPassword=new PasswordField();
	    newPassword=new PasswordField();
	    confirmPassword=new PasswordField();
	}
	
	@FXML
	public void cancel(){
		main.showMemberInfo();
	}
	
	@FXML
	public void confirm(){
		String oldPasswordValue=oldPassword.getText();
		String newPasswordValue=newPassword.getText();
		String confirmPasswordValue=confirmPassword.getText();
		System.out.println(oldPassword.getText());
		System.out.println(oldPasswordValue+" "+newPasswordValue+" "+confirmPasswordValue);
		if(oldPasswordValue.length()>=1&&
				newPasswordValue.length()>=1&&
				    confirmPasswordValue.length()>=1){//判断是否输入内容
		    
			if(newPasswordValue.equals(confirmPasswordValue)){//判断两次密码是否一致
		        
				if(oldPasswordValue.equals(this.member.getPassword())){//判断旧密码是否正确
			    
					member.setPassword(newPasswordValue);
		            UserControllerblimpl userControllerMock=new UserControllerblimpl();
		            userControllerMock.revoke(member.getUserId(),member,UserType.valueOf( member.getType()));
		            
		            showWaningInformation(AlertType.INFORMATION, "提示", "修改成功");
		            main.showMemberInfo();
		        
				}else{//输出原密码错误的提示信息
		    	    showWaningInformation(AlertType.ERROR, "提醒","原密码错误" );
		        }
		    
			}else{//输出密码不一致的信息
			    showWaningInformation(AlertType.WARNING, "提醒", "两次输入的新密码不一致");
		    }
		
		}else{//输出提示输入完整的信息
			showWaningInformation(AlertType.ERROR, "提示", "请输入完整");
		}
	}
	
	
	public void setMember(MemberInformationVO member){
		this.member=member;
	}
	
	public void showWaningInformation(AlertType type,
			String headerText,String contentText){
		Alert alert = new Alert(type);
	    alert.setTitle("来自系统的提示");
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);

	    alert.showAndWait();
	}

}
