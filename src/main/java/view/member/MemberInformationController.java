package view.member;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
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
	private TextField contactInformation;
	@FXML 
	private Label credit;
	@FXML 
	private Label special;
	
	private MemberInformationVO member;
	private Main main;
	private boolean isRevampName;
	private boolean isRevampedTel;
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
	
	/**
	 * 返回主界面
	 */
	@FXML
    private void cancel(){
        //返回到xxx	
		main.showMemberInfo();
    }
    
	/**
	 * 初始化方法
	 * 
	 */
	@FXML
	public void initialize(){
		memberName.setEditable(false);
		contactInformation.setEditable(false);
	}
	/**
	 * 确认修改
	 */
	@FXML
	private void confirm(){
		
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		String Namecontent="";
		
		//判断是否修改名称
		if(isRevampName){
			//如果修改不为空
			if(memberName.getText().length()>=1){
		        //如果不一样
		    	if(!memberName.getText().equals(member.getName())){
		    		member.setName(memberName.getText());
		    		Namecontent="名字";
			        userControllerMock.revoke(member.getUserId(), member,UserType.valueOf( member.getType()));
			    }
		    }else{
		    	//修改为空就提醒，并恢复
		    	Alert alert = new Alert(AlertType.ERROR);
		    	alert.setTitle("系统提示");
		    	alert.setHeaderText("提示");
			    alert.setContentText("修改不能为空");
			    alert.showAndWait();
			    memberName.setText(member.getName());
		    }
		}
		
		String contact="";
		//和修改Name一样
		if(isRevampedTel){
			if(contactInformation.getText().length()>=1){
				if(!contactInformation.getText().equals(member.getContactInformation())){
			    	member.setContactInformation(contactInformation.getText());
			    	contact="联系方式";
			    	userControllerMock.revoke(member.getUserId(), member,UserType.valueOf( member.getType()));
		        }
			}else{
				Alert alert = new Alert(AlertType.ERROR);
		    	alert.setTitle("系统提示");
		    	alert.setHeaderText("提示");
			    alert.setContentText("修改不能为空");
			    alert.showAndWait();
			    if(!member.getContactInformation().equals("null")){
				    contactInformation.setText(member.getContactInformation());
				}else{
					contactInformation.setText("");
				}
			}
		}
		
		//如果有修改提示修改了哪里
		if(Namecontent.length()>=1||contact.length()>=1){
			
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("系统提示");
	    	alert.setHeaderText("修改成功");
		    alert.setContentText(Namecontent+" "+contact+"已经修改");
		    alert.showAndWait();
		}
		memberName.setEditable(false);
		contactInformation.setEditable(false);
//		main.showMain();
	}
		
	
	/**
	 * 修改用户名，直接在界面里修改
	 */
	@FXML
	private void revampName(){
        
		memberName.setEditable(true);
		isRevampName = true;
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
		
		if(!member.getSpecial().equals("null")&&member.getSpecial()!=null)
		special.setText(member.getSpecial());
	}
	
}
