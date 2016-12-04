package view.staff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
  
	

	private static Main main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static SplitPane mainPane;
	public  Main() {
		
		loader = new FXMLLoader();
	
	}
	public static Main getMain(){
		if(main==null){
			main = new Main();
			return main;
		}
		else{
			return main;
		}
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("制定酒店促销策略界面");
		initmainPane();
		
		
		
	}
	/**
	 * @param
	 * @return 加载制定策略的初始界面
	 */
	public  void initmainPane() {
		// TODO Auto-generated method stub
		     loader=new FXMLLoader();
		try {
			//加载mainPane			
			loader.setLocation(Main.class.getResource("StaffMainframe.fxml"));
			mainPane=(SplitPane)loader.load();
			StaffMainframeController controller=loader.getController();
			//展现
			Scene scene=new Scene(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private   Pane loadPane(String fxml) {
		// TODO Auto-generated method stub
		  loader=new FXMLLoader();
		try {
		
			loader.setLocation(Main.class.getResource(fxml));
			return (Pane)loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
    public void movetoPromotionsi(){
    	try {
    		
    		AnchorPane promotionsiPane=new AnchorPane();
			 promotionsiPane=(AnchorPane)loadPane("Promotionsi.fxml");
			mainPane.getItems().set(1, promotionsiPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsii(){
    	try {	
    		
    		AnchorPane promotionsiiPane=new AnchorPane();
			 promotionsiiPane=(AnchorPane)loadPane("Promotionsii.fxml");			
			mainPane.getItems().set(1, promotionsiiPane);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsiii(){
    	try {	
    		
    		AnchorPane promotionsiiiPane=new AnchorPane();
			 promotionsiiiPane=(AnchorPane)loadPane("Promotionsiii.fxml");			
			mainPane.getItems().set(1, promotionsiiiPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void movetoPromotionsiv(){
    	try {	
    		
    		AnchorPane promotionsivPane=new AnchorPane();
			 promotionsivPane=(AnchorPane)loadPane("Promotionsiv.fxml");			
			mainPane.getItems().set(1, promotionsivPane);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

	
	
  public Stage getPrimaryStage(){
	  return primaryStage;
  }
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
