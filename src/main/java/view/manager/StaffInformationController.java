package view.manager;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StaffInformationController {
    @FXML private TextField staffIdField;
    @FXML private TextField staffNameField;
    @FXML private TextField staffPasswordField;
    @FXML private TextField hotelNameField;
    String oldName;
	
    public StaffInformationController(StaffVO staffVO) {
		// TODO Auto-generated constructor stub
	    staffIdField=new TextField(staffVO.getUserId());
	    staffNameField=new TextField(staffVO.getName());
	    staffPasswordField=new TextField(staffVO.getPassword());
	    
	    oldName=staffPasswordField.getText();
	    hotelNameField=new TextField(staffVO.getHotelName());
    }
    
    
	@FXML
	private void revampPassword(){
		
		//弹出修改密码窗口
        
	}
	
	@FXML
	private void cancel(){
		
		//跳转到其他界面，如果成功就保存；
	}
	
	@FXML
	private void confirm(){
			//跳出一个确认界面，然后保存
			
		    String staffId=staffIdField.getText();
		    String staffName=staffNameField.getText();
		    String staffPassword=staffPasswordField.getText();
		    String hotelName=hotelNameField.getText();
		
		    StaffVO staffVO=new StaffVO(staffId, staffPassword, staffName, hotelName);
		    UserControllerblimpl userControllerMock=new UserControllerblimpl();
		    userControllerMock.revoke(staffId, staffVO, UserType.staff);
	    
	}
	
}
