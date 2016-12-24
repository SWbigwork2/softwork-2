package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * 酒店工作人员客户端的controller
 * @author xutianze
 *
 */
public class frameController {
      @FXML
      private Button checkInButton;
      @FXML
      private Button checkOutButton;
      @FXML
      private Button abnormalButton;
      @FXML
      private Button updateHotelButton;
      @FXML
      private Button addRoomButton;
      @FXML
      private Button addPromotionsButton;
      @FXML
      private Button deletePromotionsButton;
      @FXML
      private Main main;
      public frameController(){
    	  main=Main.getMain();
    	  checkInButton=new Button();
    	  checkOutButton=new Button();
    	  abnormalButton=new Button();
    	  updateHotelButton=new Button();
    	  addRoomButton=new Button();
    	  addPromotionsButton=new Button();
    	  deletePromotionsButton=new Button();
      }
      @FXML
      public void addPromotionsView(){
    	  main.movetoAddPromotions();
      }
      @FXML
      public void deletePromotionsView(){
    	  main.movetoDeletePromotions();
      }
      
      @FXML
      private void showInfomation(){
    	  main.showInformation();
      }
      @FXML
      private void showCheckIn(){
    	  main.showCheckIn();
      }
      @FXML
      private void showCheckOut(){
    	  main.showCheckOut();
      }
      @FXML
      private void showAddRoom(){
    	  main.showAddRoom();
      }
      @FXML
      private void showUpdateHotel(){
    	  main.showUpdateHotel();
      }
      @FXML
      public void showList(){
    	  main.showList();
      }
      @FXML
      public void showPromotionView(){
    	  
    	  main.movetoLookPromotions();
      }
}
