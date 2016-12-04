package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberInformationController {
    
	@FXML private Label memberId;
	@FXML private TextField memberName;
	@FXML private PasswordField memberPassword;
	@FXML private Label memberType;
	@FXML private Label memberLevel;
	@FXML private TextField contactInformation;
	@FXML private Label credit;
	@FXML private Label special;
	
	private MemberInformationVO member;
	boolean isRevamped;
	
	public MemberInformationController() {
		
        memberId=new Label(member.getUserId());
        memberName=new TextField(member.getName());
        memberPassword=new PasswordField();
        memberPassword.setText(member.getPassword());
        
        if(member.getVipType().equals(VipType.ConmmentVip)){
        	memberType=new Label("企业会员");
        }else {
        	memberType=new Label("个人会员");
        }
        
        memberLevel=new Label(member.getLevel());
        contactInformation=new TextField(member.getContactInformation());
        credit=new Label(Double.toString(member.getCredit()));
        special=new Label(member.getSpecial());
        isRevamped=false;
	}
	
	@FXML
    private void cancel(){
        //返回到xxx	
    }
    
	@FXML
	private void confirm(){
		
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		ResultMessage resultMessage=userControllerMock.revoke(member.getUserId(), member,UserType.valueOf( member.getType()));
	    
		//对resultMessage进行判断
	}
	
	/**
	 * 修改用户名，直接在界面里修改
	 */
	@FXML
	private void revampName(){
		memberName.setEditable(true);
		isRevamped=true;
	}
	
	/**
	 * 修改密码，在另一个界面里修改
	 */
	@FXML
	private void revampPassword(){
		//跳出窗口
	}
	
	/**
	 * 修改联系方式，直接在界面里修改
	 */
	@FXML
	private void revampContactInformation(){
		contactInformation.setEditable(true);
	    isRevamped=true;
	}
	
}
