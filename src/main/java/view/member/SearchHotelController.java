package view.member;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import Hotelblimpl.HotelServiceImpl;
import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import Roomblimpl.RoomType;
import blservice.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class SearchHotelController {

	private ObservableList<HotelTradeArea> tradeAreaList;
	private ObservableList<HotelRanking> rankingList;
	private ObservableList<RoomType> roomTypeList;
	private ObservableList<String> priceList;
	private String memberId;

	@FXML
	private Button HistoryButton;
	@FXML
	private ComboBox<HotelTradeArea> TradeAreaBar;
	@FXML
	private ComboBox<HotelRanking> rankingBar;
	@FXML
	private TextField HotelNameBar;
	@FXML
	private Button SearchButton;
	@FXML
	private ComboBox<RoomType> TypeBar;
	@FXML
	private ComboBox<String> PriceBar;
	@FXML
	private DatePicker InTimeBar;
	@FXML
	private DatePicker LeaveTimeBar;
	@FXML
	private AnchorPane ContentBar;
	@FXML
	private Pagination AdvertisementArea;
	@FXML
	private TextField AddressBar;
	@FXML
	private TextField roomNumBar;

	private HotelService hotelService;
	private Main main;
	public SearchHotelController() {
		main = Main.getMain();
		hotelService = new HotelServiceImpl();
		HistoryButton = new Button();
		TradeAreaBar = new ComboBox<HotelTradeArea>();
		rankingBar = new ComboBox<HotelRanking>();
		TypeBar = new ComboBox<RoomType>();
		PriceBar = new ComboBox<String>();
		HotelNameBar = new TextField();
		SearchButton = new Button();
		InTimeBar = new DatePicker();
		LeaveTimeBar = new DatePicker();
		ContentBar = new AnchorPane();
		AdvertisementArea = new Pagination();
		AddressBar = new TextField();
		roomNumBar = new TextField();
	}

	@FXML
	private void initialize() {
		InTimeBar.setValue(LocalDate.now());
		LeaveTimeBar.setValue(LocalDate.now().plusDays(1));
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                            if (item.isBefore(
	                            		InTimeBar.getValue().plusDays(1))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }
	                            long p = ChronoUnit.DAYS.between(
	                            		InTimeBar.getValue(), item
	                            );
	                            setTooltip(new Tooltip(
	                                "您预计入住" + p + " 天")
	                            );
	                    }
	                };
	            }
	        };
	        LeaveTimeBar.setDayCellFactory(dayCellFactory);
		tradeAreaList = FXCollections.observableArrayList(HotelTradeArea.仙林商圈, HotelTradeArea.夫子庙商圈,
				HotelTradeArea.新街口商圈, HotelTradeArea.桥北商圈, HotelTradeArea.河西商圈, HotelTradeArea.湖南路商圈,
				HotelTradeArea.百家湖商圈);
		rankingList = FXCollections.observableArrayList(HotelRanking.三星级, HotelRanking.四星级, HotelRanking.五星级);
		priceList = FXCollections.observableArrayList("100-199元", "200-299元", "300-399元", "400-499元", "500元以上");
		roomTypeList = FXCollections.observableArrayList(RoomType.单人间, RoomType.商务间, RoomType.标准间, RoomType.行政标准间,
				RoomType.高级套间);
		TypeBar.setItems(roomTypeList);
		TradeAreaBar.setItems(tradeAreaList);
		PriceBar.setItems(priceList);
		rankingBar.setItems(rankingList);
	}

	@FXML
	public void startHistorySearch() {
		HotelService hotelService = new HotelServiceImpl();
		String hotelName = HotelNameBar.getText();
		if (hotelName.equals("")) {
			hotelName = null;
		}
		String hotelAddress = AddressBar.getText();
		LocalDate inDate = InTimeBar.getValue();
		LocalDate outDate = LeaveTimeBar.getValue();
		RoomType roomType = TypeBar.getValue();
		HotelTradeArea tradeArea = TradeAreaBar.getValue();
		HotelRanking hotelRanking = rankingBar.getValue();
		int roomsNeeded = 0;
		double highPrice = 0;
		double lowPrice = 0;
		String priceStr = PriceBar.getValue();
		if (priceStr != null) {
			if (priceStr.equals("100-199元")) {
				highPrice = 199;
				lowPrice = 100;
			} else if (priceStr.equals("200-299元")) {
				highPrice = 299;
				lowPrice = 200;
			} else if (priceStr.equals("300-399元")) {
				highPrice = 399;
				lowPrice = 300;
			} else if (priceStr.equals("400-499元")) {
				highPrice = 499;
				lowPrice = 400;
			} else if (priceStr.equals("500元以上")) {
				highPrice = 1500;
				lowPrice = 500;
			}
		} else {
			highPrice = -1;
		}
		HotelSearchVo hotelSearchVo = new HotelSearchVo(hotelName, hotelAddress, inDate, outDate, roomType, tradeArea,
				highPrice, lowPrice, true, memberId, hotelRanking, roomsNeeded);
		ArrayList<HotelColumnVo> hotelList = hotelService.getHotelListInfo(hotelSearchVo);
		main.showBrowseHotel(hotelList, inDate, outDate);
		
		//跳转到浏览酒店界面
		

	}

	private Date localToDate(LocalDate time){
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		 java.util.Date nowDate = Date.from(instant);
		return new Date(nowDate.getTime());
	}
	@FXML
	public void startSearch() {
		HotelService hotelService = new HotelServiceImpl();
		String hotelName = HotelNameBar.getText();
		if (hotelName.equals("")) {
			hotelName = null;
		}
		String hotelAddress = AddressBar.getText();
		LocalDate inDate = InTimeBar.getValue();
		LocalDate outDate = LeaveTimeBar.getValue();
		RoomType roomType = TypeBar.getValue();
		HotelTradeArea tradeArea = TradeAreaBar.getValue();
		HotelRanking hotelRanking = rankingBar.getValue();
		int roomsNeeded = 0;
		double highPrice = 0;
		double lowPrice = 0;
		String priceStr = PriceBar.getValue();
		if (priceStr != null) {
			if (priceStr.equals("100-199元")) {
				highPrice = 199;
				lowPrice = 100;
			} else if (priceStr.equals("200-299元")) {
				highPrice = 299;
				lowPrice = 200;
			} else if (priceStr.equals("300-399元")) {
				highPrice = 399;
				lowPrice = 300;
			} else if (priceStr.equals("400-499元")) {
				highPrice = 499;
				lowPrice = 400;
			} else if (priceStr.equals("500元以上")) {
				highPrice = 1500;
				lowPrice = 500;
			}
		} else {
			highPrice = -1;
		}

		HotelSearchVo hotelSearchVo = new HotelSearchVo(hotelName, hotelAddress, inDate, outDate, roomType, tradeArea,
				highPrice, lowPrice, false, memberId, hotelRanking, roomsNeeded);
		ArrayList<HotelColumnVo> hotelList = hotelService.getHotelListInfo(hotelSearchVo);
		main.showBrowseHotel(hotelList, inDate, outDate);
		System.out.println(inDate.toString());
		//跳转到浏览酒店界面
	}
}
