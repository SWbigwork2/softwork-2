package view.member;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MemberFrameController {
	@FXML
	private Button totalOrderButton;
	@FXML
	private Button MyInformationButton;
	@FXML
	private Button CreditButton;
	@FXML
	private Button FindHotelButton;
	@FXML
	private Button creditListButton;
	
	private Main main;
	public MemberFrameController() {
		main = Main.getMain();
		totalOrderButton = new Button();
		MyInformationButton = new Button();
		CreditButton = new Button();
		FindHotelButton = new Button();
		creditListButton = new Button();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 显示订单列表
	 */
	public void showOrderList(){
		main.showOrderList();
	}
	
	/**
	 * 显示个人信息
	 */
	public void showInfo(){
		main.showMemberInfo();
	}
	
	public void logout(){
		main.logout();
	}
	
	/**
	 * 显示搜索酒店界面
	 */
	public void showHotelSearch(){
		main.showHotelSearch();
	}
	public void showCreditList(){
		main.showCreditList();
	}
	
	public void showHistoryHotel(){
		main.seeHistoryHotel();
	}
	

}
