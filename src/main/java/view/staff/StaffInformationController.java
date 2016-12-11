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
    
    private StaffVO staff;
    private Main main;
    	
    public StaffInformationController() {
		// TODO Auto-generated constructor stub
	    staffIdField  =  new TextField();
	    staffNameField=new TextField();
	    staffPasswordField=new PasswordField();
	    
	    hotelNameField=new TextField();
    }
    
    @FXML
    private void initialize(){
        
        
        this.main=Main.getMain();
    }
    
	@FXML
	private void revampPassword() throws IOException{
		
		//弹出修改密码窗口
        main.revampPassword();
	}
	
	@FXML
	private void cancel(){		
		//跳转到其他界面，如果成功就保存；
		main.initmainPane();
	}
	
	@FXML
	public void confirm(){
		main.initmainPane();
	}
	
	public void setStaffVO(StaffVO staffVO){
		this.staff=staffVO;
		
		staffIdField.setText(staffVO.getUserId());
        staffNameField.setText(staffVO.getName());
        staffPasswordField.setText(staffVO.getPassword());
        hotelNameField.setText(staffVO.getHotelName());	
	}
	
}
