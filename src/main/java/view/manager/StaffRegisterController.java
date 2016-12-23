package view.manager;

import Hotelblimpl.HotelServiceImpl;
import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.HotelService;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class StaffRegisterController {
    
	@FXML private TextField staffIdField;
	@FXML private TextField staffNameField;
	@FXML private PasswordField staffPasswordField;
	@FXML private PasswordField staffConfirmField;
	@FXML private TextField hotelNameField;
	
	private Main main;
	
	public StaffRegisterController() {
        staffIdField=new TextField();
        staffNameField=new TextField();
        staffPasswordField=new PasswordField();
        staffConfirmField=new PasswordField();
        hotelNameField=new TextField();
	    
        main=main.getMain();
	}
	
	/**
	 * StaffRegister
	 */
	@FXML
	public void cancel(){
		staffIdField.setText("");
		staffNameField.setText("");
		staffPasswordField.setText("");
		staffConfirmField.setText("");
		
	}
	
	/**
	 * StaffRegister
	 */
	@FXML
	public void confirm(){
		if(staffIdField.getText().length()>0&&staffNameField.getText().length()>0
				&&staffPasswordField.getText().length()>0&&staffConfirmField.getText().length()>0
				&&hotelNameField.getText().length()>0){
			
			if(staffConfirmField.getText().equals(staffPasswordField.getText())){
			        
			    UserService userService=new UserControllerblimpl();
			    	
			    if(!userService.isStaffExist(hotelNameField.getText())){
			    	if(userService.find(staffIdField.getText(), UserType.staff)==null){
			            StaffVO staffVO=new StaffVO(staffIdField.getText()
			   			    , staffPasswordField.getText(), 
						    staffNameField.getText(), hotelNameField.getText());
		    	        ResultMessage resultMessage=userService.addStaff(staffVO);
		    	        
		    	        if(resultMessage.equals(ResultMessage.hotelNotExist)){
		    	        	this.showDialog(AlertType.WARNING, "酒店不存在", "现在添加酒店");		
		    	        	main.moveAddHotel();
		    	        	
		    	        }else{
			    	     
		    	        	this.showDialog(AlertType.INFORMATION, "成功", "成功添加一名工作人员");
		    	        	cancel();
			    	    }
			    	        
			    		}else{
			    			//这个账号不可用
			    			this.showDialog(AlertType.WARNING, "提醒", "这个账号不可用");
			    		}
			        }else{
			        	//提示酒店已存在工作人员
			        	this.showDialog(AlertType.WARNING, "提醒", "酒店已存在工作人员");
			        }
			}else{
				//密码不一致
				this.showDialog(AlertType.WARNING, "提醒", "密码不一致");
			}
		}else{
			//提示输入不完整
			this.showDialog(AlertType.ERROR, "提醒", "输入未完成");
		}
	}
	
	private void showDialog(AlertType type,String Headertext,String Content){
		Alert alert = new Alert(type);
	    alert.setTitle("来自系统的消息");
	    alert.setHeaderText(Headertext);
	    alert.setContentText(Content);

	    alert.showAndWait();
	}
	
	public void setHotel(String Hotel){
		hotelNameField.setText(Hotel);
	}
	
}
