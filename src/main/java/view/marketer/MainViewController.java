package view.marketer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {
    @FXML
    private Button addPromotionsButton;
    @FXML
    private Button deletePromotionsButton;
    @FXML
    private Button abnormalOrderButton;
    @FXML
    private Button creditButton;
    @FXML
    private Button infoButton;
    @FXML
    private MarketerMain main;
    @FXML
    private Button logoutButton;
    
    public MainViewController(){
    	main=MarketerMain.getMain();
    	addPromotionsButton=new Button();
    	deletePromotionsButton=new Button();
    	abnormalOrderButton=new Button();
    	creditButton=new Button();
    	infoButton=new Button();
    	
    }
    
    @FXML
    public void logout(){
    	main.logout();
    }
    @FXML
    public void addPromotionsView(){
    	main.movetoAddPromotions();
    }
    @FXML
    public void deletePromotionsView(){
    	System.out.println(1);
    	main.movetoDeletePromotions();
    }
    @FXML
    public void addCredit(){
    	main.movetoAddCredit();
    }
    @FXML
    public void showInfo(){
    	main.movetoInformation();
    }
    public void showList(){
    	main.showList();
    }

}
