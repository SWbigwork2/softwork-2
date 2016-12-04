package view.manager;

import Usersblimpl.ManagerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManagerInformationController {
    @FXML private  PasswordField managerPasswordField;
    @FXML private  Label managerIdField;
    @FXML private  Label managerNameField; 
	
    
    private ManagerVO manager;
    
	@FXML
	private void cancel(){
		
		managerPasswordField.setEditable(false);
	}
	
	@FXML
	private void confirm(){
		String managerId=managerIdField.getText();
		String managerName=managerNameField.getText();
		String managerPassword=managerPasswordField.getText();
		
		UserControllerblimpl userControllerMock=new UserControllerblimpl();
		userControllerMock.revoke(managerId,manager , UserType.manager);
		managerPasswordField.setEditable(false);
	}
	
	@FXML
	private void revampPassword(){
	     managerPasswordField.setEditable(true);	
	}
	
	public ManagerInformationController(ManagerVO managerVO){
		managerIdField=new Label(managerVO.getUserId());
		managerNameField=new Label(managerVO.getName());
		managerPasswordField=new PasswordField();
		managerPasswordField.setText(managerVO.getPassword());
	}
}
