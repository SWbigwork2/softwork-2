package view.marketer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketerMain extends Application {
  
	

	private static MarketerMain main;
	private static FXMLLoader loader;
	private static Stage primaryStage ;
	private static SplitPane mainPane;
	public  MarketerMain() {
		
		loader = new FXMLLoader();
	
	}
	public static MarketerMain getMain(){
		if(main==null){
			main = new MarketerMain();
			return main;
		}
		else{
			return main;
		}
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("制定网站促销策略界面");
		initmainPane();
		
		
		
	}
	/**
	 * @param
	 * @return 加载网站制定策略的初始界面
	 */
	public  void initmainPane() {
		// TODO Auto-generated method stub
		     loader=new FXMLLoader();
		try {
			//加载mainPane			
			loader.setLocation(MarketerMain.class.getResource("MarketerPromotionsframe.fxml"));
			mainPane=(SplitPane)loader.load();
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
		
			loader.setLocation(MarketerMain.class.getResource(fxml));
			return (Pane)loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	 public void movetoPromotionsv(){
	    	try {
	    		
	    		AnchorPane promotionsvPane=new AnchorPane();
				 promotionsvPane=(AnchorPane)loadPane("Promotionsv.fxml");
				mainPane.getItems().set(1, promotionsvPane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 public void movetoPromotionsvi(){
	    	try {
	    		
	    		AnchorPane promotionsviPane=new AnchorPane();
				 promotionsviPane=(AnchorPane)loadPane("Promotionsvi.fxml");
				mainPane.getItems().set(1, promotionsviPane);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 public void movetoPromotionsii2(){
	    	try {
	    		
	    		AnchorPane promotionsii2Pane=new AnchorPane();
				 promotionsii2Pane=(AnchorPane)loadPane("Promotionsii2.fxml");
				mainPane.getItems().set(1, promotionsii2Pane);
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