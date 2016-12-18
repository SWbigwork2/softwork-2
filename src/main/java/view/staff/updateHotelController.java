package view.staff;

import Hotelblimpl.HotelServiceImpl;
import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import blservice.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import vo.HotelVo;


public class UpdateHotelController {
	
	private String hotelName;
	private HotelService hotelService = new HotelServiceImpl();
	
	@FXML
	private TextArea introductionBar;
	@FXML
	private ComboBox<HotelTradeArea> hotelTradeAreaBar;
	@FXML
	private TextArea hotelServiceBar;
	@FXML
	private ComboBox<HotelRanking> hotelRankingBar;
	@FXML
	private Button confirmButton;
	@FXML
	private TextArea hotelAddressBar;
	@FXML
	private ListView<String> roomInfoLabel;
	@FXML
	private Label hotelNameLabel;
	
	public UpdateHotelController(){
		introductionBar = new TextArea();
		hotelTradeAreaBar = new ComboBox<HotelTradeArea>();
		hotelServiceBar = new TextArea();
		hotelRankingBar = new ComboBox<HotelRanking>();
		confirmButton = new Button();
		hotelAddressBar = new TextArea();
		roomInfoLabel = new ListView<String>();
		hotelNameLabel = new Label();
	}
	
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
		System.out.println(hotelName);
		initialized();
		
	}
	@FXML
	public void initialized(){
		
		
		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		
		hotelNameLabel.setText(hotelName);
		hotelAddressBar.setText(hotelVo.getAddress());
		introductionBar.setText(hotelVo.getIntroduction());
		hotelNameLabel.setText(hotelVo.getName());
		hotelServiceBar.setText(hotelVo.getServiceAndFacility());
		hotelRankingBar.setValue(hotelVo.getRanking());
		hotelTradeAreaBar.setValue(hotelVo.getTradeArea());
		
		ObservableList<HotelRanking> rankingList= FXCollections.observableArrayList();
		rankingList.add(HotelRanking.三星级);
		rankingList.add(HotelRanking.四星级);
		rankingList.add(HotelRanking.五星级);
		hotelRankingBar.setItems(rankingList);
		ObservableList<HotelTradeArea> tradeAreaList= FXCollections.observableArrayList();
		tradeAreaList.add(HotelTradeArea.新街口商圈);
		tradeAreaList.add(HotelTradeArea.夫子庙商圈);
		tradeAreaList.add(HotelTradeArea.仙林商圈);
		tradeAreaList.add(HotelTradeArea.桥北商圈);
		tradeAreaList.add(HotelTradeArea.河西商圈);
		tradeAreaList.add(HotelTradeArea.湖南路商圈);
		tradeAreaList.add(HotelTradeArea.百家湖商圈);
		hotelTradeAreaBar.setItems(tradeAreaList);
	}
	
	@FXML
	public void confirmHotelInfo(){
		HotelService hotelService = new HotelServiceImpl();
		
		HotelVo hotelVo = new HotelVo(hotelName, hotelAddressBar.getText(), hotelTradeAreaBar.getValue() , introductionBar.getText(), hotelServiceBar.getText(),hotelRankingBar.getValue());
		if(!hotelService.updateHotel(hotelVo)){
			
		}else{
			
		}
	}

}
