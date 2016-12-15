package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import blservice.UserService;
import data.memberTester.getMemberTester;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class companyMemberRegisterController {
	@FXML private TextField memberIdField;
    @FXML private TextField memberNameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField companyName;
    @FXML private TextField contactField;
    String type;
    
    private Main main;
    public companyMemberRegisterController() {
		// TODO Auto-generated constructor stub
    	main = Main.getMain();
        memberIdField=new TextField();
        memberNameField=new TextField();
        passwordField=new PasswordField();
        contactField=new TextField();
        confirmPasswordField=new PasswordField();
        companyName=new TextField();
    }
	@FXML
	private void cancel(){
	    main.returnLogin();   
	}
	
	@FXML
	private void confirm(){
		//先验证写的对不对
		if(memberIdField.getText().length()>=1&&memberNameField.getText().length()>=1&&
				passwordField.getText().length()>=1&&confirmPasswordField.getText().length()>=1&&
				companyName.getText().length()>=1){
		    //验证密码是否一致
			if(passwordField.getText().equals(confirmPasswordField.getText())){
			     UserService userService=new UserControllerblimpl();
			     //验证账号是否可用
			     if(userService.find(memberIdField.getText(), UserType.member)==null){
			          MemberInformationVO member=new MemberInformationVO(memberIdField.getText(),
			        		  memberNameField.getText(), passwordField.getText(), 100
			        		  , contactField.getText(), "1", companyName.getText(), VipType.CompanyVip.name());
			          userService.addMember(member);
			          showWaningInformation(AlertType.INFORMATION, "成功", "欢迎你： "+memberNameField.getText()+"先生");
			          
			          cancel();
			     }else{//账号不可用
			    	 showWaningInformation(AlertType.ERROR, "错误", "账号不可用");
			     }
		    
			}else{//密码不一致
		    	showWaningInformation(AlertType.ERROR, "错误", "两次密码不一致");
		    }
		
		}else{//填写不完整
			showWaningInformation(AlertType.ERROR, "提示", "请填写完整");
		}
	}
	public void shutDown(){
		main.returnLogin();
	}
	//弹窗显示
	private void showWaningInformation(AlertType type,
			String headerText,String contentText){
		Alert alert = new Alert(type);
	    alert.setTitle("来自系统的提示");
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);

	    alert.showAndWait();
	}
}

