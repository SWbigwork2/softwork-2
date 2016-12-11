package view.staff;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class PromotionsiiController {
	
	@FXML
	private AnchorPane PromotionsiiPane;
	@FXML
	private TextField hotelnameTextField;
	@FXML
	private TextField discountTextField;
	@FXML	
	private DatePicker startdateDatePicker;
	@FXML
	private DatePicker enddateDatePicker;
	@FXML
	private TextField introductionTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	public PromotionsiiController(){
		main=Main.getMain();
		hotelnameTextField=new TextField();
		discountTextField=new TextField();
		enddateDatePicker=new DatePicker();
		enddateDatePicker=new DatePicker();
		introductionTextField=new TextField();
	}
	public void addPromotionsII(){
		String hotel=hotelnameTextField.getText();
		String discountstr=discountTextField.getText();
		String startdate=startdateDatePicker.getValue().toString();
		String enddate=enddateDatePicker.getValue().toString();
		String introduction=introductionTextField.getText();		
		if(hotel==null||startdate==null||enddate==null||discountstr==null||introduction==null){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
		}else{
			double discount=Double.parseDouble(discountstr);
			PromotionsIIVO promotionsIIVO=new PromotionsIIVO(2, hotel, introduction, startdate, enddate, discount);
			boolean result=promotionsService.addPromotionsII(promotionsIIVO);
			if(result){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略添加成功");
				alert.showAndWait();
				clearPromotionsII();
			}else{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略已存在");
				alert.showAndWait();
			}
		}
	
	}
	public void clearPromotionsII(){
		hotelnameTextField.setText("");
		discountTextField.setText("");
		startdateDatePicker.setValue(null);
		enddateDatePicker.setValue(null);
		introductionTextField.setText("");
	}
}
