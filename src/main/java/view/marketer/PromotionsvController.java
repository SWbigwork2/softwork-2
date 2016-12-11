package view.marketer;

import org.omg.CORBA.PUBLIC_MEMBER;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PromotionsvController  {
  @FXML
  private TextField hotelnameTextField;
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
 public PromotionsvController(){
	 main=MarketerMain.getMain();
	 hotelnameTextField=new TextField();
	 areaTextField=new TextField();
	 viplevelTextField=new TextField();
	 discountTextField=new TextField();
	 introductionTextField=new TextField();
	 okButton=new Button();
	 cancelButton=new Button();
 }
  public void addPromotionsV(){
	  String hotel=hotelnameTextField.getText();
	  String area=areaTextField.getText();
	  String viplevelstr=viplevelTextField.getText();
	  String discountstr=discountTextField.getText();
	  String introduction=introductionTextField.getText();
	  if(hotel==null||area==null||viplevelstr==null||discountstr==null||introduction==null){
		  Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
	  }else{
		  double discount=Double.parseDouble(discountstr);
		  int viplevel=Integer.parseInt(viplevelstr);
		  PromotionsVVO promotionsVVO=new PromotionsVVO(5, hotel, introduction, viplevel, area, discount);
	      boolean result=promotionsService.addPromotionsV(promotionsVVO);
	      if(result){
	    	  Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("添加成功");
				alert.showAndWait();
				clearPromotionsV();
	      }else{
	    	  Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略已存在");
				alert.showAndWait();
	      }
	  }
	  
  }
  public void clearPromotionsV(){
	  hotelnameTextField.setText("");
		areaTextField.setText("");
		viplevelTextField.setText("");
		discountTextField.setText("");
		introductionTextField.setText("");
  }
  
}
