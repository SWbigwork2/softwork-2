package view.staff;

import java.io.IOException;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StaffInformationController {
    @FXML private TextField staffIdField;
    @FXML private TextField staffNameField;
    @FXML private PasswordField staffPasswordField;
    @FXML private TextField hotelNameField;
    StaffVO staffVO= new StaffVO("1111","11111", "1111", "1111");
	
    public StaffInformationController() {
		// TODO Auto-generated constructor stub
	    staffIdField  =  new TextField();
	    staffNameField=new TextField();
	    staffPasswordField=new PasswordField();
	    
	    hotelNameField=new TextField();
    }
    
    @FXML
    private void initialize(){
        staffIdField.setText(staffVO.getUserId());
        staffNameField.setText(staffVO.getName());
        staffPasswordField.setText(staffVO.getPassword());
        hotelNameField.setText(staffVO.getHotelName());
        
        staffIdField.setEditable(false);
        staffNameField.setEditable(false);
        staffPasswordField.setEditable(false);
        hotelNameField.setEditable(false);
    }
    
	@FXML
	private void revampPassword() throws IOException{
		
		 newStage();
		//弹出修改密码窗口
        
	}
	
	@FXML
	private void cancel(){
		
		//跳转到其他界面，如果成功就保存；
	}
	
	private  void newStage() throws IOException{  
        Stage secondaryStage=new Stage();  
        Pane root1 = FXMLLoader.load(getClass().getResource("revampPasswordUi.fxml"));  
        
        Scene secondaryScene=new Scene(root1,500,500);  
        secondaryStage.setScene(secondaryScene);  
        secondaryStage.showAndWait();  
   
    }  
	
}
