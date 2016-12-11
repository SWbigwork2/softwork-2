package view.manager;

import Usersblimpl.UserType;
import blservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import loginblimpl.LoginControllerimpl;
import loginblimpl.LoginVo;

public class ManagerLoginController {
	@FXML
	private PasswordField password;
	@FXML
	private Button loginButton;
	@FXML
	private Button signUpButton;
	@FXML
	private TextField userId;
	@FXML
	private Label idTipLabel; //提示用户名不为空的标签
	@FXML
	private Label passwordTipLabel; //提示密码不为空的标签
	@FXML
	private Label errorMessage; //提示登陆错误
	private Main main;
	private LoginService service;
	public ManagerLoginController() {
		service = new LoginControllerimpl();
		main =Main.getMain();
		password = new PasswordField();
		loginButton = new Button();
		signUpButton = new Button();
		userId = new TextField();
		idTipLabel = new Label();
		passwordTipLabel = new Label();
		errorMessage = new Label();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 登陆按钮的监听
	 */
	@FXML
	public void login(){
		if(userId.getText().trim().length()<1 || password.getText().trim().length()<1){
			if(userId.getText().trim().length()<1){
				idTipLabel.setVisible(true);
			}
			if(password.getText().trim().length()<1){
				passwordTipLabel.setVisible(true);
			}
			return;
				
		}
		String idString = userId.getText();
		String passwordString = password.getText();
		
		LoginVo resultVo = service.login(idString, passwordString, UserType.manager);
		if(resultVo==null){
			errorMessage.setVisible(true);
		}
		else{
			main.setManager(resultVo.getId());
			main.loginFrame();
			System.out.println("success");
		}
	}
	
	/**
	 * 监听是否输入用户名
	 */
	@FXML
	public void userFieldListener(){
		errorMessage.setVisible(false);
		if(userId.getText().trim().length()<1){
			//idTipLabel.setVisible(true);
		}
		else{
			idTipLabel.setVisible(false);
		}
	}
	/**
	 * 监听是否输入密码
	 */
	@FXML
	public void passWordListener(){
		errorMessage.setVisible(false);
		if(password.getText().trim().length()<1){
			//passwordTipLabel.setVisible(true);
		}
		else{
			passwordTipLabel.setVisible(false);
		}
		
	}
	

}
