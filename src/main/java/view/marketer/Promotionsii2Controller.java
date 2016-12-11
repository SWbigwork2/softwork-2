package view.marketer;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Promotionsii2Controller {
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
	private MarketerMain main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	public Promotionsii2Controller(){
		main=MarketerMain.getMain();
		hotelnameTextField=new TextField();
		discountTextField=new TextField();
		startdateDatePicker=new DatePicker();
		enddateDatePicker=new DatePicker();
		introductionTextField=new TextField();
	}
	public void addPromotionsII2(){
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
			System.out.println(hotel+discount);
			PromotionsII2VO promotionsII2VO=new PromotionsII2VO(2, hotel, introduction, startdate, enddate, discount);
			boolean result=promotionsService.addPromotionsII2(promotionsII2VO);
			if(result){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略添加成功");
				alert.showAndWait();
				clearPromotionsII2();
			}else{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略已存在");
				alert.showAndWait();
			}
		}
	
	}
	public void clearPromotionsII2(){
		hotelnameTextField.setText("");
		discountTextField.setText("");
		startdateDatePicker.setValue(null);
		enddateDatePicker.setValue(null);
		introductionTextField.setText("");
	}
	
}
