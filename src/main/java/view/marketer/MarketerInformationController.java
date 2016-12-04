package view.marketer;

import java.io.IOException;

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
    @FXML private static BorderPane marketerMainPane;
    @FXML private Label marketerIdField;
    @FXML private Label marketerNameField;
    @FXML private PasswordField marketerPasswordField;
    
    private MarketerVO marketerVO=new MarketerVO("1111", "2222", "3333");
    
    public MarketerInformationController() {
        marketerMainPane=new BorderPane();
        marketerIdField=new Label(marketerVO.getUserId());
        marketerNameField=new Label(marketerVO.getName());
        marketerPasswordField=new PasswordField();
        marketerPasswordField.setText(marketerVO.getPassword());
    }
    
    @FXML
    private void revampPassword() throws Throwable{
    	Stage secondaryStage=new Stage();  
        Pane root1 = FXMLLoader.load(getClass().getResource("revampPasswordUi.fxml"));  
        
        Scene secondaryScene=new Scene(root1,500,500);  
        secondaryStage.setScene(secondaryScene);  
        secondaryStage.showAndWait();  
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
