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
	 * ҳ����ʾ�ƶ������ػݲ���
	 */
	@FXML
	public void showPromotionsi(){
		main.movetoPromotionsi();
		promotionsi.setDisable(true);//�Ѱ�ť����Ϊ���ɲ����������������󽫰�ť��ԭ
	    promotionsii.setDisable(false);
	    promotionsiii.setDisable(false);
	    promotionsiv.setDisable(false);
	}
	/**
	 * ҳ����ʾ�ƶ������ػݲ���
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
	 * ҳ����ʾ�ƶ�����ػݲ���
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
	 * ҳ����ʾ�ƶ���ҵ�ػݲ���
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
