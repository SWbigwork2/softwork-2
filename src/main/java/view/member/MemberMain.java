package view.member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MemberMain extends Application {
	private Stage stage;
	private static FXMLLoader loader;
	private static Pane mainRoot;
	private static MemberMain main;
	
	public static MemberMain getInstance(){
		if(main==null){
			main = new MemberMain();
			return main;
		}
		else {
			return main;
		}
	}
	
	private Pane loadPane(String FXML){
		loader = new FXMLLoader();
		loader.setLocation(MemberMain.class.getResource(FXML));
		try {
			return (Pane)loader.load();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		mainRoot = loadPane("AddRoom.fxml");
		
		Scene scene = new Scene(mainRoot,1200,800);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
