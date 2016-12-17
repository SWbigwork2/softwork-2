package view.staff;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PromotionsivController {
	@FXML
	private TextField hotelnameTextField;
	@FXML
	private TextField companynameTextField;
	@FXML
	private TextField discountTextField;
	@FXML
	private TextField introductionTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelbutton;
	@FXML
	private Main mian;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	public PromotionsivController(){
		mian=Main.getMain();
		hotelnameTextField=new TextField();
		companynameTextField=new TextField();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelbutton=new Button();
		
	}
	public void addPromotionsIV(){
		String hotel=hotelnameTextField.getText();
		String companyname=companynameTextField.getText();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(hotel.length()==0||companyname.length()==0||discountstr.length()==0||introduction.length()==0){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
		}else{
			double discount=Double.parseDouble(discountstr);
			PromotionsIVVO promotionsIVVO=new PromotionsIVVO(4, hotel, introduction, companyname, discount);
			boolean result=promotionsService.addPromotionsIV(promotionsIVVO);
			if(result){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略添加成功");
				alert.showAndWait();
				clearPromotionsIV();
			}else{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略已存在");
				alert.showAndWait();
			}
		}
	}
	public void clearPromotionsIV(){
		hotelnameTextField.setText("");
		companynameTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
