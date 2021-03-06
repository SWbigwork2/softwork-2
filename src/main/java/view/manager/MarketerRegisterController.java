package view.manager;

import Usersblimpl.MarketerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import blservice.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author lenovo
 *
 */
public class MarketerRegisterController {
    
	@FXML 
	private TextField marketerIdField;
	
	@FXML 
	private TextField marketerNameField;
	
	@FXML 
	private PasswordField marketerPasswordField;
	
	@FXML 
	private PasswordField marketerConfirmField;
	
	@FXML 
	private Button marketerCommitButton;
	
	private Main main;
	
	public MarketerRegisterController() {
		marketerIdField=new TextField();
		marketerNameField=new TextField();
		marketerPasswordField=new PasswordField();
		marketerConfirmField=new PasswordField();
		marketerCommitButton=new Button();
	    main=main.getMain();
	}
	
	@FXML
	public void initialize(){

	}
	/**
	 * MarketerRegister���ذ�ť�ļ���
	 */
	@FXML
	public void cancel(){
		main.initmainPane();
	}
	
	/**
	 * 确认添加一个marketer
	 */
	@FXML
	public void confirm(){
        //判断是否填写完整
		if(marketerIdField.getText().length()>=1&&marketerNameField.getText().length()>=1
        		&&marketerPasswordField.getText().length()>=1
        		&&marketerConfirmField.getText().length()>=1){
		    UserService userService=new UserControllerblimpl();
		    MarketerVO marketerVO=new MarketerVO(marketerIdField.getText(), marketerPasswordField.getText()
				, marketerNameField.getText());
		    
		    //判断两次密码是否相同
		    if(marketerPasswordField.getText().equals(marketerConfirmField.getText())){
			    
		    	//判断该账号是否可用
		    	if(userService.find(marketerVO.getUserId(), UserType.marketer)==null){
			        userService.addMarketer(marketerVO);
			        main.showWaningInformation(AlertType.INFORMATION, "哦耶", "添加成功");
			        main.initmainPane();
		    
			    }else{//提示账号不可用
		    	    main.showWaningInformation(AlertType.ERROR, "Error", "这个账号不可用，因为它已经存在");
			    }
		    
		    }else{//显示密码不一致
			    main.showWaningInformation(AlertType.ERROR, "Error", "两次的密码不一致");
		    }
        }else{//显示输入不完整
        	main.showWaningInformation(AlertType.WARNING, "Warning", "请输入完整");
        }
	}
}
