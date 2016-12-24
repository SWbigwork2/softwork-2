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
//	@FXML
//	private TextField hotelnameTextField;
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
	private Main main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	HotelService hotelService=new HotelServiceImpl();
	public PromotionsivController(){
		main=Main.getMain();
//		hotelnameTextField=new TextField();
		companynameTextField=new TextField();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelbutton=new Button();
		
	}
	/**
	 * 添加策略
	 */
	public void addPromotionsIV(){
		String hotel=main.getHotelname();
		String companyname=companynameTextField.getText();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(companyname.length()==0||discountstr.length()==0||introduction.length()==0){
			main.showWaningInformation(AlertType.INFORMATION, "策略信息填写不完整");
		}else{
			double discount=Double.parseDouble(discountstr);
			if(discount>0.99||discount<0.1){
			main.showWaningInformation(AlertType.INFORMATION, "折扣只能在0.1~0.99之间");
			}
			
			else {
			PromotionsIVVO promotionsIVVO=new PromotionsIVVO(4, hotel, introduction, companyname, discount);
			boolean result=promotionsService.addPromotionsIV(promotionsIVVO);
			if(result){
				main.showWaningInformation(AlertType.INFORMATION, "策略添加成功");
				clearPromotionsIV();
			}else{
				main.showWaningInformation(AlertType.INFORMATION, "策略已存在");
			}
		}
		}
	}
	/**清空制定策略信息
	 * 
	 */
	public void clearPromotionsIV(){
		companynameTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
