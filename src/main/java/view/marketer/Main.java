package view.marketer;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
	private static FXMLLoader loader;
	private static Main main;

	
	public Main(){
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
	
	public void start(Stage stage) throws Exception {  
        Parent root1 = loadPane("MarketerInformationUi.fxml"); 
  
        Scene scene = new Scene(root1, 600, 400);  
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.show();  
    }  
	
	private Pane loadPane(String FXML){
		loader.setLocation(Main.class.getResource(FXML));
		try {
			return (Pane)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String agrs[]){
		launch(agrs);
	}
    
}
