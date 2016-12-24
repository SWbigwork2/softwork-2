package view.marketer;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.HotelService;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PromotionsvController  {
  @FXML
  private TextField areaTextField;
  @FXML
  private TextField viplevelTextField;
  @FXML
  private TextField discountTextField;
  @FXML
  private TextField introductionTextField;
  @FXML
  private Button okButton;
  @FXML
  private Button cancelButton;
  @FXML
  private MarketerMain main;
  PromotionsService promotionsService=new PromotionsServiceImpl();
  HotelService hotelService=new HotelServiceImpl();
 public PromotionsvController(){
	 main=MarketerMain.getMain();
	 areaTextField=new TextField();
	 viplevelTextField=new TextField();
	 discountTextField=new TextField();
	 introductionTextField=new TextField();
	 okButton=new Button();
	 cancelButton=new Button();
 }
  /**
 * 添加策略
 */
public void addPromotionsV(){
	  String hotel="网站";
	  String area=areaTextField.getText();
	  String viplevelstr=viplevelTextField.getText();
	  String discountstr=discountTextField.getText();
	  String introduction=introductionTextField.getText();
	  if(area.length()==0||viplevelstr.length()==0||discountstr.length()==0||introduction.length()==0){
		  main.showWaningInformation(AlertType.INFORMATION, null, "策略信息填写不完整");
		 
	  }else{
		  double discount=Double.parseDouble(discountstr);
		  int viplevel=Integer.parseInt(viplevelstr);
		  if(discount>0.99||discount<0.1){
			  main.showWaningInformation(AlertType.INFORMATION, null,"折扣只能在0.1~0.99之间");
				
			}
		 else if(viplevel<0||viplevel>6){
				main.showWaningInformation(AlertType.INFORMATION, null, "会员等级在0-6之间");
			}
		  else {
		 
			  
		  PromotionsVVO promotionsVVO=new PromotionsVVO(5, hotel, introduction, viplevel, area, discount);
	      boolean result=promotionsService.addPromotionsV(promotionsVVO);
	      if(result){
	    	  main.showWaningInformation(AlertType.INFORMATION, null, "策略添加成功");
	    	 
				clearPromotionsV();
	      }else{
	    	  main.showWaningInformation(AlertType.INFORMATION, null, "策略已存在");
	    	  
	      }
	  }
	  }
	  
  }
  /**
 * 清空信息
 */
public void clearPromotionsV(){
		areaTextField.setText("");
		viplevelTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
  }
  
}
