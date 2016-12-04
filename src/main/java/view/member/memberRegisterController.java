package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class memberRegisterController {
    @FXML private TextField memberIdField;
    @FXML private TextField memberNameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private ChoiceBox<String> memberTypeBox;
    @FXML private TextField memberSpecialField;
    @FXML private TextField contactField;
    String[] meberType={"普通会员","企业会员"};
    String type;
    
    
    public memberRegisterController() {
        memberIdField=new TextField();
        memberNameField=new TextField();
        passwordField=new PasswordField();
        contactField=new TextField();
        confirmPasswordField=new PasswordField();
        memberTypeBox= new ChoiceBox<String>(FXCollections.observableArrayList(
        	    "个人用户", "企业用户"));
        memberTypeBox.getSelectionModel().selectedIndexProperty().addListener(
        		new ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
					    type=meberType[new_val.intValue()];	
					}
				});
        memberSpecialField=new TextField();
    }
	@FXML
	private void cancel(){
	
		//跳转到什么方法里
	    
	}
	
	@FXML
	private void confirm(){
		//先验证写的对不对
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		VipType tempType=VipType.ConmmentVip;
		if(userControllerMock.find(memberIdField.getText(), UserType.member)==null){
		    //提示错误，重新输入
		}else{
			if(type.equals(meberType[1])){
				tempType=VipType.CompanyVip;
			}
			MemberInformationVO member=new MemberInformationVO(memberIdField.getText()
					, passwordField.getText(), memberNameField.getText(), tempType.name()
					, 100.0, contactField.getText(), 1+"", memberSpecialField.getText(),null);
            ResultMessage resultMessage=userControllerMock.addMember(member);
            
            //对resultMessgae进行判断
		}
	}
}
