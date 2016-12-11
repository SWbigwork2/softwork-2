package view.manager;


import Hotelblimpl.HotelServiceImpl;
import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import blservice.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vo.HotelVo;

public class addHotelController {
	
    private Main main;
	
	@FXML
	private TextArea introductionBar;
	@FXML
	private TextArea hotelServiceBar;
	@FXML
	private TextField hotelAddressBar;
	@FXML 
	private TextField hotelNameBar;
	@FXML
	private ComboBox<HotelTradeArea> hotelTradeAreaBar;
	@FXML
	private ComboBox<HotelRanking> hotelRankingBar;
	@FXML
	private Button confirmButton;
	@FXML
	private ListView<String> roomInfoLabel;	
	
	public addHotelController(){
		introductionBar = new TextArea();
		hotelTradeAreaBar = new ComboBox<HotelTradeArea>();
		hotelServiceBar = new TextArea();
		hotelRankingBar = new ComboBox<HotelRanking>();
		confirmButton = new Button();
		hotelAddressBar = new TextField();
		roomInfoLabel = new ListView<String>();
		
		main=main.getMain();
	}
	
	
	@FXML
	public void initialize(){
		ObservableList<HotelRanking> rankingList= FXCollections.observableArrayList();
		rankingList.add(HotelRanking.三星级);
		rankingList.add(HotelRanking.四星级);
		rankingList.add(HotelRanking.五星级);
		ObservableList<HotelTradeArea> tradeAreaList= FXCollections.observableArrayList();
		tradeAreaList.add(HotelTradeArea.新街口商圈);
		tradeAreaList.add(HotelTradeArea.夫子庙商圈);
		tradeAreaList.add(HotelTradeArea.仙林商圈);
		tradeAreaList.add(HotelTradeArea.桥北商圈);
		tradeAreaList.add(HotelTradeArea.河西商圈);
		tradeAreaList.add(HotelTradeArea.湖南路商圈);
		tradeAreaList.add(HotelTradeArea.百家湖商圈);
		
		hotelRankingBar.setItems(rankingList);
		hotelTradeAreaBar.setItems(tradeAreaList);
	}
	
	@FXML
	public void confirmHotelInfo(){
		HotelService hotelService = new HotelServiceImpl();
		
		HotelVo hotelVo = new HotelVo(hotelNameBar.getText()
				, hotelAddressBar.getText(), null,introductionBar.getText(), hotelServiceBar.getText(),hotelRankingBar.getValue());
		
		hotelService.addHotel(hotelVo);
		
		main.moveToAddStaff();
	}

}
