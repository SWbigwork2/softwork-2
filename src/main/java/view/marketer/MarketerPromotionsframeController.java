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
	 * ҳ����ʾ�ƶ������ػݲ���
	 */
	@FXML
	public void showPromotionsv(){
		main.movetoPromotionsv();
		promotionsv.setDisable(true);//�Ѱ�ť����Ϊ���ɲ����������������󽫰�ť��ԭ
	    promotionsvi.setDisable(false);
	    promotionsii2.setDisable(false);
	   
	}
	/**
	 * ҳ����ʾ�ƶ������ػݲ���
	 */
	@FXML
	public void showPromotionsvi(){
		main.movetoPromotionsvi();
		promotionsvi.setDisable(true);
		promotionsv.setDisable(false);
		promotionsii2.setDisable(false);
	    
		
	}
	/**
	 * ҳ����ʾ�ƶ�����ػݲ���
	 */
	@FXML
	public void showPromotionsii2(){
		main.movetoPromotionsii2();
		promotionsii2.setDisable(true);
	    promotionsv.setDisable(false);
		promotionsvi.setDisable(false);
		
	}
	
	
	
}
