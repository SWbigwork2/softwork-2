package view.member;

import java.awt.TextArea;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Map;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.HotelService;
import blservice.PromotionsService;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import vo.HotelVo;

public class BrowseHotelDetailController {
	
	private LocalDate startTime;
	private LocalDate endTime;

	private String hotelName;
	@FXML
	private Pane base;
	@FXML
	private Button Button1;
	@FXML
	private TextArea IntroductionLabel;
	@FXML
	private Label roomType5;
	@FXML
	private AnchorPane ContentBar;
	@FXML
	private TabPane InformationBar;
	@FXML
	private Label roomType1;
	@FXML
	private Label priceLabel2;
	@FXML
	private Label priceLabel1;
	@FXML
	private Label roomType2;
	@FXML
	private Label roomType3;
	@FXML
	private Label AddressLabel;
	@FXML
	private Label roomType4;
	@FXML
	private Button Button5;
	@FXML
	private Button Button4;
	@FXML
	private Label priceLabel5;
	@FXML
	private Button Button3;
	@FXML
	private Label priceLabel4;
	@FXML
	private ListView<String> CommentList;
	@FXML
	private Label HotelNameLabel;
	@FXML
	private Button Button2;
	@FXML
	private Label priceLabel3;
	@FXML
	private TextArea ServiceLabel;
	@FXML
	private Label RemarkLabel;
	@FXML
	private ListView<String> promotionList;
	/**@FXML
	private ImageView picArea1;
	@FXML
	private ImageView picArea2;
	@FXML
	private ImageView picArea3;
	**/
	@FXML
	private Main main;
	
	private HotelService service;
	
	public BrowseHotelDetailController() {
		service = new HotelServiceImpl();
		main = Main.getMain();
		base = new Pane();
		/**
		picArea1 = new ImageView();
		picArea2 = new ImageView();
		picArea3 = new ImageView();
		**/
		Button1 = new Button();
		IntroductionLabel = new TextArea();
		roomType5 = new Label();
		ContentBar = new AnchorPane();
		InformationBar = new TabPane();
		roomType1 = new Label();
		priceLabel2 = new Label();
		priceLabel1 = new Label();
		roomType2 = new Label();
		roomType3 = new Label();
		AddressLabel = new Label();
		roomType4 = new Label();
		Button5 = new Button();
		Button4 = new Button();
		priceLabel5 = new Label();
		Button3 = new Button();
		priceLabel4 = new Label();
		CommentList = new ListView<String>();
		HotelNameLabel = new Label();
		Button2 = new Button();
		priceLabel3 = new Label();
		ServiceLabel = new TextArea();
		RemarkLabel = new Label();
		promotionList = new ListView<String>();
	}

	public void setHotelNameAndDate(String hotelName,LocalDate startTime,LocalDate endTime) {
		this.hotelName = hotelName;
		this.startTime = startTime;
		this.endTime = endTime;
		initialized();
	}

	@FXML
	public void initialized() {
		HotelService hotelService = new HotelServiceImpl();
		RoomService roomService  = new RoomServiceImpl();
		PromotionsService  promotionsService = new PromotionsServiceImpl();
		ArrayList<String> promotionStrList = promotionsService.getHotelPromotion(hotelName);
		ObservableList<String> promotion = FXCollections.observableArrayList(promotionStrList);
		promotionList.setItems(promotion);
		
		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		ArrayList<String> commentList = hotelService.getHotelComment(hotelName);
		ObservableList<String> comment = FXCollections.observableArrayList(commentList);
		HotelNameLabel.setText(hotelVo.getName());
		AddressLabel.setText(hotelVo.getAddress());
		RemarkLabel.setText(String.valueOf(hotelService.getHotelRemark(hotelName)).substring(0,3)+"分");
		CommentList.setItems(comment);
		IntroductionLabel.setText(hotelVo.getIntroduction());
		ServiceLabel.setText(hotelVo.getServiceAndFacility());
		
		Map<RoomType, Integer> numOfType = roomService.getNumOfRoom(hotelName,new Date(localToDate(startTime).getTime()),new Date(localToDate(endTime).getTime()));
		Map<RoomType, Double> priceOfType = roomService.getPriceOfRoom(hotelName,new Date(localToDate(startTime).getTime()),new Date(localToDate(endTime).getTime()));
		
		if (numOfType.get(RoomType.单人间) != 0) {
			Button1.setVisible(false);
			priceLabel1.setText("房间暂无");
		} else {
			priceLabel1.setText(String.valueOf(priceOfType.get(RoomType.单人间))+"元");
		}
		if (numOfType.get(RoomType.标准间) == 0) {
			Button2.setVisible(false);
			priceLabel2.setText("房间暂无");
		} else {
			priceLabel2.setText(String.valueOf(priceOfType.get(RoomType.标准间))+"元");
		}
		if (numOfType.get(RoomType.商务间) == 0) {
			Button3.setVisible(false);
			priceLabel3.setText("房间暂无");
		} else {
			priceLabel2.setText(String.valueOf(priceOfType.get(RoomType.商务间))+"元");
		}
		if (numOfType.get(RoomType.行政标准间) == 0) {
			Button4.setVisible(false);
			priceLabel4.setText("房间暂无");
		} else {
			priceLabel4.setText(String.valueOf(priceOfType.get(RoomType.行政标准间))+"元");
		}
		if (numOfType.get(RoomType.高级套间) == 0) {
			Button5.setVisible(false);
			priceLabel5.setText("房间暂无");
		} else {
			priceLabel5.setText(String.valueOf(priceOfType.get(RoomType.高级套间))+"元");
		}
	}

	@FXML
	public void makeOrder1() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo,RoomType.单人间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder2() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo,RoomType.标准间, startTime, endTime);
		//跳转动订单界面
	}

	@FXML
	public void makeOrder3() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo,RoomType.商务间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder4() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo,RoomType.行政标准间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder5() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo,RoomType.高级套间, startTime, endTime);
		//跳转到订单界面
	}
	private java.util.Date localToDate(LocalDate time){
		System.out.println("test1"+time.toString());
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return java.util.Date.from(instant);
	}
}
