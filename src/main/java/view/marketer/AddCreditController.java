package view.marketer;

import Membersblimpl.MemberServiceImpl;
import Usersblimpl.ManagerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.MembersService;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddCreditController {
    
	@FXML
    private TextField memberIdField;
    
    @FXML
    private TextField memberNameField;
    
    @FXML
    private TextField creditField;
	
    private MarketerMain main; 
    
    
    public AddCreditController() {
        main=main.getMain();
        
        memberIdField=new TextField();
        memberNameField=new TextField();
        creditField=new TextField();
    }
    
    @FXML
	private void cancel(){
	    //返回上一界面	
    	main.initmainPane();
	}
	
	/**
	 *   确定增加信用 
	 */
	@FXML
	private void confirm(){
	
		String memberId=memberIdField.getText();
		String memberName=memberNameField.getText();
		String credit=creditField.getText();
        
		UserService userService=new UserControllerblimpl();
		MemberInformationVO member=(MemberInformationVO)userService.find(memberId, UserType.member);
		MembersService membersService=new MemberServiceImpl();
		if(member.getName().equals(memberName)){
			if(isLegal(credit)){
 			    membersService.updateMemberCredit(memberId, Double.parseDouble(credit),0,"信用充值");
 			
 			    MemberInformationVO membervo=(MemberInformationVO)userService.find(memberId, UserType.member);
		    
 			    String nowCredit=Double.toString(membervo.getCredit());
		        main.showWaningInformation(AlertType.INFORMATION, "成功", "当前信用值为 "+nowCredit);
			}else{
				main.showWaningInformation(AlertType.ERROR, "错误", "请正确输入金额");
			}
		}else{
			main.showWaningInformation(AlertType.ERROR, "错误", "用户名或者账户错误");
		}
	}
	
	/**
	 * @param str金额的字符串
	 * @return 是否有除了数字之外的其他字符
	 */
	private boolean isLegal(String str){
		String reg = "[^a-zA-Z]";
        if(str.replaceAll(reg,"").length()!=0){
        	return false;
        }else{
        	return true;
        }
	}
	
	
	
	
	
}
