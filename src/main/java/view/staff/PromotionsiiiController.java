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

public class PromotionsiiiController {

	@FXML
	private AnchorPane PromotionsiiiPane;
//	@FXML
//	private TextField hotelnameTextField;
	@FXML
	private TextField roomsnumTextField;
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
	public PromotionsiiiController(){
		main=Main.getMain();
//		hotelnameTextField=new TextField();
		roomsnumTextField=new TextField();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
	public void addPromotionsIII(){
		String hotel=main.getHotelname();
		String roomsnum=roomsnumTextField.getText();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(roomsnum.length()==0||discountstr.length()==0||introduction.length()==0){
			main.showWaningInformation(AlertType.INFORMATION, "策略信息填写不完整");
		}else{
        int nums=Integer.parseInt(roomsnum);
        double discount=Double.parseDouble(discountstr);
        if(discount>0.99||discount<0.1){
			main.showWaningInformation(AlertType.INFORMATION, "折扣只能在0.1~0.99之间");
		}
      
        else if(nums<=0){
        	main.showWaningInformation(AlertType.INFORMATION, "房间数量必须大于0");
        }
        else {
        PromotionsIIIVO promotionsIIIVO=new PromotionsIIIVO(3, hotel, introduction, nums, discount);
        boolean result=promotionsService.addPromotionsIII(promotionsIIIVO);
        if(result){
        	main.showWaningInformation(AlertType.INFORMATION, "策略添加成功");
			clearPromotionsIII();
        }else{
        	main.showWaningInformation(AlertType.INFORMATION, "策略已存在");
        }
	}
		}
}
	public void clearPromotionsIII(){
//		hotelnameTextField.setText("");
		roomsnumTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
