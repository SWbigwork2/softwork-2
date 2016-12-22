package view.manager;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.Users;
import Usersblimpl.VipType;
import blservice.UserService;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberInformationController {
    
	@FXML 
	private Label memberId;
	
	@FXML 
	private TextField memberName;
	
	@FXML 
	private PasswordField memberPassword;
	
	@FXML 
	private Label memberType;
	
	@FXML 
	private Label memberLevel;
	
	@FXML 
	private TextField contactInformation;//会员的联系方式
	
	@FXML 
	private Label credit;
	
	@FXML 
	private Label special;//会员的生日
	
	boolean isRevamped;
	
	private MemberInformationVO memeber;
	
	private Main main;
	
	public MemberInformationController() {
        memberId=new Label();
        memberName=new TextField();
        memberPassword=new PasswordField();

        memberLevel=new Label();
        contactInformation=new TextField();
        credit=new Label();
        special=new Label();
        isRevamped=false;
        
        main=main.getMain();
	}
	
	@FXML
    private void cancel(){
        main.moveToFindMember();
    }
    
	/**
	 * 确认修改信息
	 */
	@FXML
	private void confirm(){
		if(isRevamped){
			memeber.setContactInformation(contactInformation.getText());
			memeber.setName(memberName.getText());
			UserService userService=new UserControllerblimpl();
			ResultMessage resultMessage=userService.revoke(memeber.getUserId(), memeber, UserType.member);
            
		    if(resultMessage.equals(ResultMessage.success)){
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText("成功");
		    	alert.setContentText("修改成功");

		    	alert.showAndWait();
		    }
		}
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
	 * 修改联系方式，直接在界面里修改
	 */
	@FXML
	private void revampContactInformation(){
		contactInformation.setEditable(true);
	    isRevamped=true;
	}
    
	
	/**
	 * @param memberInformationVO
	 * 设置初始信息
	 */
	public void setMember(MemberInformationVO memberInformationVO){
		this.memeber=memberInformationVO;
		
		memberId.setText(memeber.getUserId());
		memberName.setText(memeber.getName());
		memberPassword.setText(memeber.getPassword());
		memberLevel.setText(memeber.getLevel());
		
		//设置会员类型
		if(memeber.getVipType().equals("CompanyVip")){
    		memberType.setText(("企业会员"));
    	}else{
    		memberType.setText(("普通会员"));
    	}
		
		//如果有联系方式
		if(memeber.getContactInformation()!=null){
		    contactInformation.setText(memeber.getContactInformation());
		}else{
			contactInformation.setText("");
		}
		
		if(memberInformationVO.getSpecial()!=null){
		    special.setText(memberInformationVO.getSpecial());
		}else{
			special.setText("");
		}
		
		credit.setText(Double.toString(memberInformationVO.getCredit()));
	}
}
