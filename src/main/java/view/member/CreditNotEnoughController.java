package view.member;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CreditNotEnoughController {
	@FXML 
	private Label nowCredit;
	@FXML
	private Label requestCredit;
	@FXML
	private Button confirmButton;
	
	private Main main;
	public CreditNotEnoughController(){
		nowCredit = new Label();
		requestCredit = new Label();
		confirmButton = new Button();
		double credit = main.getMembervo().getCredit();
		nowCredit.setText(credit+"");
		requestCredit.setText(0.0+"");
	}
	
	
	
	@FXML
	public void close(){
		main = Main.getMain();
		main.closeTips();
		
	}
	

}
