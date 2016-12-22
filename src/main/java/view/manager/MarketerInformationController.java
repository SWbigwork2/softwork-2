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

	@FXML 
	private  Label marketerIdField;
    
	@FXML 
    private TextField marketerNameField;
    
    @FXML 
    private PasswordField marketerPasswordField;
    
    private MarketerVO marketerVO;
    private Main main;
    private boolean isRevomp;  //是否有过改动
    
    /**
     * 初始化
     */
    public MarketerInformationController() {
        marketerIdField=new Label();
        marketerNameField=new TextField();
        marketerPasswordField=new PasswordField();
        main=main.getMain();
        isRevomp=false;
    }
    
    
    /**
     * 确定修改，保存
     */
    @FXML
    private void confirm(){
    	
    	if (isRevomp) {
			marketerVO.setName(marketerNameField.getText());
			UserService userService=new UserControllerblimpl();
			userService.revoke(marketerVO.getUserId(), marketerVO, UserType.marketer);	
		}
    	main.showWaningInformation(AlertType.INFORMATION, "提示", "成功");
			this.main.moveToFindMarketer();
		
    }
    
    /**
     * 取消修改，返回
     */
    @FXML
    private void cancel(){
        this.main.moveToFindMarketer();
    }
    
    /**
     * 修改密码
     */
    @FXML
    private void revampName(){
    	marketerNameField.setEditable(true);
    	isRevomp=true;
    }
    
    /**
     * @param marketerVO
     * 设置初始信息
     */
    public void setMarketer(MarketerVO marketerVO){
    	this.marketerVO=marketerVO;
    	
    	marketerIdField.setText(marketerVO.getUserId());
    	marketerNameField.setText(marketerVO.getName());
    	marketerPasswordField.setText(marketerVO.getPassword());
    	marketerPasswordField.setEditable(false);
    }
    
}
