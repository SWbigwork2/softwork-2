package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PromotionsivController {
	@FXML
	private TextField hotelnameTextfield;
	@FXML
	private TextField companynameTextfield;
	@FXML
	private TextField discountTextfield;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelbutton;
	@FXML
	private Main mian;
	public PromotionsivController(){
		mian=Main.getMain();
		hotelnameTextfield=new TextField();
		companynameTextfield=new TextField();
		discountTextfield=new TextField();
		okButton=new Button();
		cancelbutton=new Button();
		
	}
	
	
	
}
