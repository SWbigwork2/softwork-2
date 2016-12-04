package view.manager;

import Usersblimpl.MarketerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

public class MarketerInformationController {
    @FXML private static BorderPane marketerMainPane;
    @FXML private Label marketerIdField;
    @FXML private Label marketerNameField;
    @FXML private PasswordField marketerPasswordField;
    
    public MarketerInformationController(MarketerVO marketerVO) {
        marketerMainPane=new BorderPane();
        marketerIdField=new Label(marketerVO.getUserId());
        marketerNameField=new Label(marketerVO.getName());
        marketerPasswordField=new PasswordField();
        marketerPasswordField.setText(marketerVO.getPassword());
    }
    
    @FXML
    private void revampPassword(){
        //跳转出修改密码界面    	
    }
    
    @FXML
    private void confirm(){
    	//返回上一界面
    }
    
    @FXML
    private void cancel(){
    	//返回上一界面
    }
    
    public static BorderPane getPane(){
    	return marketerMainPane;
    }
}
