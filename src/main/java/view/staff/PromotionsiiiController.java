package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PromotionsiiiController {

	@FXML
	private AnchorPane PromotionsiiiPane;
	@FXML
	private TextField hotelnameTextfield;
	@FXML
	private TextField roomsnumTextfield;
	@FXML
	private TextField discountTextfield;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	public PromotionsiiiController(){
		main=Main.getMain();
		hotelnameTextfield=new TextField();
		roomsnumTextfield=new TextField();
		discountTextfield=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
}
