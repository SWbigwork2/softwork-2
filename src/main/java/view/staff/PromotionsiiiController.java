package view.staff;

import Promotionsblimpl.PromotionsServiceImpl;
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
	@FXML
	private TextField hotelnameTextField;
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
	public PromotionsiiiController(){
		main=Main.getMain();
		hotelnameTextField=new TextField();
		roomsnumTextField=new TextField();
		discountTextField=new TextField();
		introductionTextField=new TextField();
		okButton=new Button();
		cancelButton=new Button();
	}
	public void addPromotionsIII(){
		String hotel=hotelnameTextField.getText();
		String roomsnum=roomsnumTextField.getText();
		String discountstr=discountTextField.getText();
		String introduction=introductionTextField.getText();
		if(hotel.length()==0||roomsnum.length()==0||discountstr.length()==0||introduction.length()==0){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
		}else{
        int nums=Integer.parseInt(roomsnum);
        double discount=Double.parseDouble(discountstr);
        PromotionsIIIVO promotionsIIIVO=new PromotionsIIIVO(3, hotel, introduction, nums, discount);
        boolean result=promotionsService.addPromotionsIII(promotionsIIIVO);
        if(result){
        	Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略添加成功");
			alert.showAndWait();
			clearPromotionsIII();
        }else{
        	Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略已存在");
			alert.showAndWait();
        }
	}
}
	public void clearPromotionsIII(){
		hotelnameTextField.setText("");
		roomsnumTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
	}
}
