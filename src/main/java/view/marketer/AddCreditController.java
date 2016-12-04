package view.marketer;

import MembersMock.MemberMock;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.Userblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCreditController {
    @FXML
    private TextField memberField;
    
    @FXML
    private TextField memberNameField;
    
    @FXML
    private TextField creditField;
	
    @FXML
	private void cancel(){
		
	}
	
	/**
	 *   未完成 
	 */
	@FXML
	private void confirm(){
		String memberId=memberField.getText();
		String memberName=memberNameField.getText();
		String credit=creditField.getText();
        
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		MemberInformationVO member=(MemberInformationVO)userControllerMock.find(memberId, UserType.member);
		if(member.getName().equals(memberName)&&isLegal(credit)){
 			
		}
	}
	
	private boolean isLegal(String str){
		String reg = "[^a-zA-Z]";
        if(str.replaceAll(reg,"").length()!=0){
        	return false;
        }else{
        	return true;
        }
	}
}
