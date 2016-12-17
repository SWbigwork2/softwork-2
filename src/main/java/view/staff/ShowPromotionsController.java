package view.staff;

import java.util.ArrayList;
import java.util.Optional;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ShowPromotionsController {
      @FXML
	  private ObservableList<String> temp ;
      @FXML
      private TextField hotelnameTextField;
      @FXML
      private ListView< String> promotionslistListView;
      @FXML 
      private Button ShowButton;
      @FXML
      private Button deletePromotionsButton;
      @FXML 
      private Main main;
      PromotionsService promotionsService=new PromotionsServiceImpl();
      public ShowPromotionsController(){
    	  main=Main.getMain();
    	  hotelnameTextField=new TextField();
    	  ShowButton =new Button();
    	  deletePromotionsButton=new Button();
    	  promotionslistListView=new ListView<String>();
    	  
      }
      public void showpromotions(){
    	  String hotelname=hotelnameTextField.getText();
    	  if(hotelname.length()==0){
    		  Alert alert=new Alert(AlertType.INFORMATION);
  		    alert.setTitle("提示");
  			alert.setHeaderText(null);
  			alert.setContentText("请输入酒店名");
  			alert.showAndWait();
    	  }else{
//    	  ArrayList<String> hotelpromotions=new ArrayList<String>();
//    	  String x1="ssss";
//    	  String x2="xxxx";
//    	  hotelpromotions.add(x1);
//    	  hotelpromotions.add(x2);   	 
    	ArrayList<String> hotelpromotions= promotionsService.getHotelPromotion(hotelname);
    	temp = FXCollections.observableArrayList();
    	  for(String pro:hotelpromotions){
    		  temp.add(pro); 
    	  }
    	  promotionslistListView.setItems(temp);
    	  }
      }

  	/**
  	 * 策略列表选择点击删除的响应
  	 */
      @FXML
     public void deletepromotions(){
    		String selectedStr =promotionslistListView.getSelectionModel().getSelectedItem();

    		if(selectedStr==null){  
    			
    			Alert alert=new Alert(AlertType.INFORMATION);
    		    alert.setTitle("提示");
    			alert.setHeaderText(null);
    			alert.setContentText("请选择策略");
    			alert.showAndWait();
    		}
    		else{
    			
    			Alert alert2 = new Alert(AlertType.CONFIRMATION);
    			alert2.setTitle("删除确认");
    			alert2.setHeaderText(null);
    			alert2.setContentText("是否确定删除该策略？");
    			Optional<ButtonType> result = alert2.showAndWait();
    			if (result.get() == ButtonType.OK){
    	    		String typestr=selectedStr.substring(2, 3);
    	    		int  type=Integer.parseInt(typestr);
    	    		String introduction=selectedStr.substring(3);
    	    		String hotelname=hotelnameTextField.getText();
    	    		PromotionsVO promotionsVO=new PromotionsVO();
    	    		promotionsVO.setHotel(hotelname);
    	    		promotionsVO.setType(type);
    	    		promotionsVO.setDiscount(1);
    	    		promotionsVO.setIntroduction(introduction);
    	    		promotionsService.deletePromotions(promotionsVO);
    				promotionslistListView.getItems().remove(selectedStr);
    	    		Alert alert1=new Alert(AlertType.INFORMATION);
    			    alert1.setTitle("提示");
    				alert1.setHeaderText(null);
    				alert1.setContentText("策略删除成功");
    				alert1.showAndWait();
    			} else {
    			    // ... user chose CANCEL or closed the dialog
    			}
    		
    		}
    	 
     }
}
