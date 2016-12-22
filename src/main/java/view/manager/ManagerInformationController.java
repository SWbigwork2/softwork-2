package view.manager;

import Usersblimpl.ManagerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ManagerInformationController {
    @FXML 
    private  PasswordField managerPasswordField;  //显示密码
    
    @FXML 
    private  Label managerIdField;   //显示账号
    
    @FXML 
    private  Label managerNameField;  //显示用户名 
	
    private ManagerVO manager;
    
    private Main main;
	
    /**
     * 返回主界面
     */
    @FXML
	private void cancel(){
    	
		main.initmainPane();
		
	}
	
	/**
	 * 返回主界面
	 */
	@FXML
	private void confirm(){
	    main.initmainPane();	
	}
	
	@FXML
	public void initialize(){
	    	
	}
	
	/**
	 * 修改密码
	 */
	@FXML
	private void revampPassword(){
	    main.showRevamoPassword(manager);
	}
	
	/**
	 * 构造方法
	 */
	@SuppressWarnings("static-access")
	public ManagerInformationController(){
		managerIdField=new Label();
		managerNameField=new Label();
		managerPasswordField=new PasswordField();
		main=main.getMain();
	}
	
	
	/**
	 * @param managerVO
	 * 设置信息
	 */
	public void setManagerVO(ManagerVO managerVO){
		this.manager=managerVO;
		
		managerPasswordField.setText(manager.getPassword());
		managerIdField.setText(manager.getUserId());
		managerNameField.setText(manager.getName());
		
		managerPasswordField.setEditable(false);
	}
}
