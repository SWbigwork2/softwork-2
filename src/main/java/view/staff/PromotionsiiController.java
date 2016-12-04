package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PromotionsiiController {
	
	@FXML
	private AnchorPane PromotionsiiPane;
	@FXML
	private TextField hotelnameTextfield;
	@FXML
	private TextField discountTextfield;
	@FXML	
	private DatePicker startdateDatePicker;
	@FXML
	private DatePicker enddateDatePicker;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	public PromotionsiiController(){
		main=Main.getMain();
		hotelnameTextfield=new TextField();
		discountTextfield=new TextField();
		enddateDatePicker=new DatePicker();
		enddateDatePicker=new DatePicker();
	}
	public void designPromotionsii(){
		
	}
}
