package view.marketer;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.HotelService;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PromotionsviController  {
   @FXML
   private TextField hotelnameTextfield;
   @FXML
   private TextField vip1discountTextfield;
   @FXML
   private TextField vip2discountTextfield;
   @FXML
   private TextField vip3discountTextfield;
   @FXML
   private TextField vip4discountTextfield;
   @FXML
   private TextField vip5discountTextfield;
   @FXML
   private TextField vip6discountTextfield;
   @FXML
   private Button okButton;
   @FXML
   private Button cancelButton;
   @FXML
   private MarketerMain main;
   PromotionsService promotionsService=new PromotionsServiceImpl();
   HotelService hotelService=new HotelServiceImpl();
   public PromotionsviController(){
	   main=MarketerMain.getMain();
	   hotelnameTextfield=new TextField();
	   vip1discountTextfield=new TextField();
	   vip2discountTextfield=new TextField();
	   vip3discountTextfield=new TextField();
	   vip4discountTextfield=new TextField();
	   vip5discountTextfield=new TextField();
	   vip6discountTextfield=new TextField();
	   okButton=new Button();
	   cancelButton=new Button();
   }
   public void addPromotionsVI(){
    String hotel=hotelnameTextfield.getText();
    String discountstr1=vip1discountTextfield.getText();
    String discountstr2=vip2discountTextfield.getText();
    String discountstr3=vip3discountTextfield.getText();
    String discountstr4=vip4discountTextfield.getText();
    String discountstr5=vip5discountTextfield.getText();
    String discountstr6=vip6discountTextfield.getText();
    if(hotel.length()==0||discountstr1.length()==0||discountstr2.length()==0||discountstr3.length()==0
    		||discountstr4.length()==0||discountstr5.length()==0||discountstr6.length()==0){
    	Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText("策略信息填写不完整");
		alert.showAndWait();
    }else{
    	double discount1=Double.parseDouble(discountstr1);
    	double discount2=Double.parseDouble(discountstr2);
    	double discount3=Double.parseDouble(discountstr3);
    	double discount4=Double.parseDouble(discountstr4);
    	double discount5=Double.parseDouble(discountstr5);
    	double discount6=Double.parseDouble(discountstr6);
    	
    	if(discount1>0.99||discount1<0.1||discount2>0.99||discount2<0.1||
    			discount3>0.99||discount3<0.1||discount4>0.99||discount4<0.1||
    			discount5>0.99||discount5<0.1||discount6>0.99||discount6<0.1){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("折扣只能在0.1~0.99之间");
			alert.showAndWait();
		}
    	else if(hotelService.judgeHotelExists(hotel)){
			main.showWaningInformation(AlertType.INFORMATION, null, "不存在该酒店");
		}
    	else {
    	PromotionsVIVO promotionsVIVO1=new PromotionsVIVO(6, hotel,"VIP1 折扣 "+discountstr1, 1, discount1);
    	PromotionsVIVO promotionsVIVO2=new PromotionsVIVO(6, hotel,"VIP2 折扣 "+discountstr2, 2, discount2);
    	PromotionsVIVO promotionsVIVO3=new PromotionsVIVO(6, hotel,"VIP3 折扣 "+discountstr3, 3, discount3);
    	PromotionsVIVO promotionsVIVO4=new PromotionsVIVO(6, hotel,"VIP4 折扣 "+discountstr4, 4, discount4);
    	PromotionsVIVO promotionsVIVO5=new PromotionsVIVO(6, hotel,"VIP5 折扣 "+discountstr5, 5, discount5);
    	PromotionsVIVO promotionsVIVO6=new PromotionsVIVO(6, hotel,"VIP6 折扣 "+discountstr6, 6, discount6);
        Boolean result1=promotionsService.addPromotionsVI(promotionsVIVO1);
        Boolean result2=promotionsService.addPromotionsVI(promotionsVIVO2);
        Boolean result3=promotionsService.addPromotionsVI(promotionsVIVO3);
        Boolean result4=promotionsService.addPromotionsVI(promotionsVIVO4);
        Boolean result5=promotionsService.addPromotionsVI(promotionsVIVO5);
        Boolean result6=promotionsService.addPromotionsVI(promotionsVIVO6);
        if(result1&&result2&&result3&&result4&&result5&&result6){
        	Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略添加成功");
			alert.showAndWait();
			clearPromotionsVI();
        }else{
        	Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("已存在部分相同策略");
			alert.showAndWait();
        }
		}
    }   
}
   public void clearPromotionsVI(){
	   hotelnameTextfield.setText("");
		vip1discountTextfield.setText("");
		vip2discountTextfield.setText("");
		vip3discountTextfield.setText("");
		vip4discountTextfield.setText("");
		vip5discountTextfield.setText("");
		vip6discountTextfield.setText("");
   }
   
}
