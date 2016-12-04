package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PromotionsiController  {

	@FXML
	private AnchorPane PromotionsiPane;
	@FXML
	private TextField hotelnameTextfield;
	@FXML
	private TextField discountTextfield;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	public PromotionsiController(){
		main=Main.getMain();
		hotelnameTextfield=new TextField();
		discountTextfield=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
	public void designPromotionsi(){
		String hotelname=hotelnameTextfield.getText();
		double discount=Double.parseDouble(discountTextfield.getText());
	}
}
