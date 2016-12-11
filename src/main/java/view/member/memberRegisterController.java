package view.member;

import java.time.LocalDate;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;

public class memberRegisterController {
    @FXML private TextField memberIdField;
    @FXML private TextField memberNameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField contactField;
    @FXML private DatePicker birthday;
    String type;
    private Main main;
    public memberRegisterController() {
        memberIdField=new TextField();
        memberNameField=new TextField();
        passwordField=new PasswordField();
        contactField=new TextField();
        confirmPasswordField=new PasswordField();
        birthday=new DatePicker();
        
        final Callback<DatePicker, DateCell> dayCellFactory
        = new Callback<DatePicker, DateCell>() {
			public DateCell call(final DatePicker datePicker) {
			return new DateCell() {
			public void updateItem(LocalDate item, boolean empty) {
			super.updateItem(item, empty);
			if (item.isAfter(LocalDate.now().plusDays(1))) {
				setDisable(true);setStyle("-fx-background-color: #ffc0cb;");}}};}};
        birthday.setDayCellFactory(dayCellFactory);
        
        main=main.getMain();
    }
	@FXML
	private void cancel(){
		main.returnLogin();
		
		//跳转到什么方法里
	    
	}
	
	@FXML
	private void confirm(){
		UserService userService=new UserControllerblimpl();
		if(isfull()){//判断是否填写完整
			
			if(passwordField.getText().equals(confirmPasswordField.getText())){
				//判断两次密码是否一致
				
				
				if(userService.find(memberIdField.getText(), UserType.member)==null){
				     userService.addMember(getMember());	 
					 this.showWaningInformation(AlertType.INFORMATION, "注册成功", "欢迎你："+memberNameField.getText());
			         main.showMain();		
			         main.setMembervo(getMember());
				}else{
					//提示账号不可用
				    this.showWaningInformation(AlertType.ERROR, "提醒", "账号不可用");
				}
			}else{
				//提示两次密码不一致
				this.showWaningInformation(AlertType.ERROR, "提醒", "密码不一致");
			}
		}else{
			//未填写完整的提示信息
			this.showWaningInformation(AlertType.WARNING, "提醒", "请输入完整");
		}
	}
	
	private boolean  isfull(){
		
		if(memberIdField.getText().length()>=1&&
		   memberNameField.getText().length()>=1&&
		   passwordField.getText().length()>=1&&
		   confirmPasswordField.getText().length()>=1){
			try {
				String date=birthday.getValue().toString();
				return true;
			} catch (NullPointerException e) {
				//提示信息输入格式 xxxx-xx-xx
				this.showWaningInformation(AlertType.ERROR, "提示", "请按照正确的格式输入，例如：1993-10-24");
		        return false;
			}
		}else{
		    return false;
	    }
		
	}
	
	private MemberInformationVO getMember(){
		MemberInformationVO memberInformationVO=new MemberInformationVO(memberIdField.getText()
				, memberNameField.getText()
				, passwordField.getText(), 100,contactField.getText()
				, "1", birthday.getValue().toString()
				, VipType.ConmmentVip.name());
		return memberInformationVO;
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

