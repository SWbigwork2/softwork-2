package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
	boolean isRevampedTel;
	boolean isRevampName;
	private Main main;
	
	public MemberInformationController() {
		main=this.main.getMain();
		
        memberId=new Label();
        memberName=new TextField();
        memberPassword=new PasswordField();
        memberLevel=new Label();
        contactInformation=new TextField();
        credit=new Label();
        special=new Label();
        isRevampName=false;
        isRevampedTel=false;
	}
	
	@FXML
    private void cancel(){
        //返回到xxx	
		main.showMain();
    }
    
	@FXML
	private void confirm(){
		
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		if(isRevampName){
			String Content="名字";
			member.setName(memberName.getText());
			if(isRevampedTel){
				member.setContactInformation(contactInformation.getText());
				Content=Content+"和联系方式";
			}
			userControllerMock.revoke(member.getUserId(), member,UserType.valueOf( member.getType()));
			Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("系统提示");
		    alert.setHeaderText("修改成功");
		    alert.setContentText(Content+"已经修改");
		    alert.showAndWait();
		    main.showMain();
		}
	    
		//对resultMessage进行判断
	}
	
	/**
	 * 修改用户名，直接在界面里修改
	 */
	@FXML
	private void revampName(){
        memberName.setEditable(true);
        isRevampName=true;
	}
	
	/**
	 * 修改密码，在另一个界面里修改
	 */
	@FXML
	private void revampPassword(){
		main.showRevampPassword();
	}
	
	/**
	 * 修改联系方式，直接在界面里修改
	 */
	@FXML
	private void revampContactInformation(){
		contactInformation.setEditable(true);
	    isRevampedTel=true;
	}
	
	public void setMember(MemberInformationVO member){
		this.member=member;
		memberId.setText(member.getUserId());
		memberName.setText(member.getName());
		memberPassword.setText(member.getPassword());
		
		if(member.getVipType().equals(VipType.CompanyVip.name())){
			memberType.setText("企业会员");
		}else{
			memberType.setText("个人会员");
		}
		
		memberLevel.setText(member.getLevel());
		
		if(!member.getContactInformation().equals("null")){
		    contactInformation.setText(member.getContactInformation());
		}else{
			contactInformation.setText("");
		}
		
		credit.setText(Double.toString(member.getCredit()));
		
		special.setText(member.getSpecial());
	}
	
}
