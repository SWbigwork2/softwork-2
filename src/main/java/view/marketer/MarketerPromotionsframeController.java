package view.marketer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MarketerPromotionsframeController  {
	@FXML
	private Button promotionsv;
	@FXML
	private Button promotionsvi;
	@FXML
	private Button promotionsii2;
	@FXML

	private MarketerMain main;
	public MarketerPromotionsframeController(){
		main=MarketerMain.getMain();
		promotionsv=new Button();
		promotionsvi=new Button();
		promotionsii2=new Button();
		
	}
	/**
	 * 页面显示制定生日特惠策略
	 */
	@FXML
	public void showPromotionsv(){
		main.movetoPromotionsv();
		promotionsv.setDisable(true);//把按钮设置为不可操作，在其他操作后将按钮复原
	    promotionsvi.setDisable(false);
	    promotionsii2.setDisable(false);
	   
	}
	/**
	 * 页面显示制定节日特惠策略
	 */
	@FXML
	public void showPromotionsvi(){
		main.movetoPromotionsvi();
		promotionsvi.setDisable(true);
		promotionsv.setDisable(false);
		promotionsii2.setDisable(false);
	    
		
	}
	/**
	 * 页面显示制定多间特惠策略
	 */
	@FXML
	public void showPromotionsii2(){
		main.movetoPromotionsii2();
		promotionsii2.setDisable(true);
	    promotionsv.setDisable(false);
		promotionsvi.setDisable(false);
		
	}
	
	
	
}
