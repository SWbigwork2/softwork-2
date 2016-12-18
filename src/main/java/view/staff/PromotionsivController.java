package view.staff;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.HotelService;
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
	HotelService hotelService=new HotelServiceImpl();
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
			if(discount>0.99||discount<0.1){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("折扣只能在0.1~0.99之间");
				alert.showAndWait();
			}
			else if(hotelService.judgeHotelExists(hotel)){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("不存在该酒店");
				alert.showAndWait();
			}
			else {
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
	}
	public void clearPromotionsIV(){
		hotelnameTextField.setText("");
		companynameTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
