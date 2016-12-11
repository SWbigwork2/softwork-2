package view.manager;

import Usersblimpl.MarketerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MarketerInformationController {
//    @FXML private static BorderPane marketerMainPane;
    @FXML private  Label marketerIdField;
    @FXML private TextField marketerNameField;
    @FXML private PasswordField marketerPasswordField;
    
    private MarketerVO marketerVO;
    private Main main;
    private boolean isRevomp;
    
    public MarketerInformationController() {
//        marketerMainPane=new BorderPane();
        marketerIdField=new Label();
        marketerNameField=new TextField();
        marketerPasswordField=new PasswordField();
        main=main.getMain();
        isRevomp=false;
    }
    
    
    @FXML
    private void confirm(){
    	
    	if (isRevomp) {
			marketerVO.setName(marketerNameField.getText());
			UserService userService=new UserControllerblimpl();
			userService.revoke(marketerVO.getUserId(), marketerVO, UserType.marketer);	
		}
    	main.showWaningInformation(AlertType.INFORMATION, "哦耶", "成功");
			this.main.moveToFindMarketer();
		
    }
    
    @FXML
    private void cancel(){
        this.main.moveToFindMarketer();
    }
    
    @FXML
    private void revampName(){
    	marketerNameField.setEditable(true);
    	isRevomp=true;
    }
    
    public void setMarketer(MarketerVO marketerVO){
    	this.marketerVO=marketerVO;
    	
    	marketerIdField.setText(marketerVO.getUserId());
    	marketerNameField.setText(marketerVO.getName());
    	marketerPasswordField.setText(marketerVO.getPassword());
//    	marketerNameField.setEditable(false);
    	marketerPasswordField.setEditable(false);
    }
    
//    public static BorderPane getPane(){
//    	return marketerMainPane;
//    }
}
