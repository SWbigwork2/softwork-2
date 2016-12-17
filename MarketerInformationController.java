package view.marketer;

import Usersblimpl.MarketerVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketerInformationController {
    @FXML private Label marketerIdField;
    @FXML private Label marketerNameField;
    @FXML private PasswordField marketerPasswordField;
    
    
    private MarketerVO marketer;
    private MarketerMain main;
    
    
    public MarketerInformationController() {
        marketerIdField=new Label();
        marketerNameField=new Label();
        marketerPasswordField=new PasswordField();
        main=main.getMain();
    }
    
    @FXML
    private void revampPassword() {
        main.movetoRevampPassword();
    }
    
    @FXML
    private void confirm(){
    	//返回上一界面
    	main.initmainPane();
    }
    
    @FXML
    private void cancel(){
    	main.movetoInformation();
    	//返回上一界面
    	main.initmainPane();
    }
    
    
    public void setMarketer(MarketerVO marketerVO){
    	
    	this.marketer = marketerVO;
    	
    	marketerIdField.setText(marketer.getUserId());
    	marketerNameField.setText(marketer.getName());
    	marketerPasswordField.setText(marketer.getPassword());
        marketerPasswordField.setEditable(false);
    
    }
}
