package view.staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;





//@FXML
//private FXMLLoader loader;


public class StaffMainframeController {

	@FXML
	private Button promotionsi;
	@FXML
	private Button promotionsii;
	@FXML
	private Button promotionsiii;
	@FXML
	private Button promotionsiv;
	@FXML
	private Main main;
	public StaffMainframeController(){
		main=Main.getMain();
		promotionsi=new Button();
		promotionsii=new Button();
		promotionsiii=new Button();
		promotionsiv=new Button();
	}
	/**
	 * 页面显示制定生日特惠策略
	 */
	@FXML
	public void showPromotionsi(){
		main.movetoPromotionsi();
		promotionsi.setDisable(true);//把按钮设置为不可操作，在其他操作后将按钮复原
	    promotionsii.setDisable(false);
	    promotionsiii.setDisable(false);
	    promotionsiv.setDisable(false);
	}
	/**
	 * 页面显示制定节日特惠策略
	 */
	@FXML
	public void showPromotionsii(){
		main.movetoPromotionsii();
		promotionsii.setDisable(true);
		promotionsi.setDisable(false);
		promotionsiii.setDisable(false);
	    promotionsiv.setDisable(false);
		
	}
	/**
	 * 页面显示制定多间特惠策略
	 */
	@FXML
	public void showPromotionsiii(){
		main.movetoPromotionsiii();
		promotionsiii.setDisable(true);
	    promotionsi.setDisable(false);
		promotionsii.setDisable(false);
		promotionsiv.setDisable(false);
	}
	/**
	 * 页面显示制定企业特惠策略
	 */
	@FXML
	public void showPromotionsiv(){
		main.movetoPromotionsiv();
		promotionsiv.setDisable(true);
		promotionsi.setDisable(false);
		promotionsii.setDisable(false);
		promotionsiii.setDisable(false);
	}
	
	
}
