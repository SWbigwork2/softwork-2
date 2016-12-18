package view.staff;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class PromotionsiController  {

	@FXML
	private AnchorPane PromotionsiPane;
	@FXML
	private TextField hotelnameTextField;
	@FXML
	private TextField discountTextField;
	@FXML
	private TextField introductionTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	public PromotionsiController(){
		main=Main.getMain();
		hotelnameTextField=new TextField();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
	public void addPromotionsI(){
		String hotel=hotelnameTextField.getText();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(hotel.length()==0||discountstr.length()==0||introduction.length()==0){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
	}else{
		double discount=Double.parseDouble(discountstr);
		if(discount>0.99||discount<0.1){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("折扣只能在0.1~0.99之间");
			alert.showAndWait();
		}else {
	
		PromotionsIVO promotionsIVO=new PromotionsIVO(1, hotel, introduction, discount);
		Boolean result=promotionsService.addPromotionsI(promotionsIVO);
		if(result){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略添加成功");
			alert.showAndWait();
			clearPromotionsI();
		}else{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略已存在");
			alert.showAndWait();
		}
	}
	}
}
	public void clearPromotionsI(){
		hotelnameTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
