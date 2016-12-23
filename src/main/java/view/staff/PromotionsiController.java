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
import javafx.scene.layout.AnchorPane;

public class PromotionsiController  {

	@FXML
	private AnchorPane PromotionsiPane;
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
	HotelService hotelService=new HotelServiceImpl();
	public PromotionsiController(){
		main=Main.getMain();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
	
	public void addPromotionsI(){
		String hotel=main.getHotelname();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(discountstr.length()==0||introduction.length()==0){
			main.showWaningInformation(AlertType.INFORMATION, "策略信息填写不完整");
	
	}else{
		double discount=Double.parseDouble(discountstr);
		if(discount>0.99||discount<0.1){
			
		main.showWaningInformation(AlertType.INFORMATION, "折扣只能在0.1~0.99之间");
			
		}
		else if(!hotelService.judgeHotelExists(hotel)){
			
			main.showWaningInformation(AlertType.INFORMATION, "不存在该酒店");
		}
		else {
	
		PromotionsIVO promotionsIVO=new PromotionsIVO(1, hotel, introduction, discount);
		Boolean result=promotionsService.addPromotionsI(promotionsIVO);
		if(result){
		 main.showWaningInformation(AlertType.INFORMATION, "策略添加成功");
			clearPromotionsI();
		}else{
			main.showWaningInformation(AlertType.INFORMATION, "策略已存在");
		}
	}
	}
}
	public void clearPromotionsI(){
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
