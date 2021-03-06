package view.member;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
import blservice.OrdersService;
import blservice.PromotionsService;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import vo.HotelVo;
import vo.OrderVo;

public class BrowseHotelDetailController {

	private LocalDate startTime;
	private LocalDate endTime;
	private String userId;
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
	@FXML
	private ListView<String> orderListView;

	@FXML
	private Main main;
	@FXML
	private Label rankingBar;

	private HotelService service;

	public BrowseHotelDetailController() {
		service = new HotelServiceImpl();
		main = Main.getMain();
		base = new Pane();
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
		orderListView = new ListView<String>();
		rankingBar = new Label();
	}

	public void setHotelNameAndDate(String hotelName, LocalDate startTime, LocalDate endTime, String userId) {
		this.hotelName = hotelName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userId = userId;
		initialized();
	}
	/**
	 * @param type
	 * @return 将订单状态改为中文显示
	 */
	private String typeToName(String type){
		switch (type) {
		case "normal":
			return "未执行订单";
		case "error":
			return "异常订单";
		case "done":
			return "已完成订单";
		case "appeal":
			return "已申请订单";
		case "all":
			return "全部订单";
		case "revoke":
			return "已撤销订单";
		case "evaluation":
			return "已评价订单";
		default:
			return null;
			
		}
	}
	private String nameToType(String name){
		switch (name) {
		case "未执行订单":
			return "normal";
		case "异常订单":
			return "error";
		case "已完成订单":
			return "done";
		case "已申请订单":
			return "appeal";
		case "全部订单":
			return "all";
		case "已撤销订单":
			return "revoke";
		case "已评价订单":
			return "evaluation";
		default:
			return null;
			
		}
	}
	@FXML
	public void initialized() {
		HotelService hotelService = new HotelServiceImpl();
		RoomService roomService = new RoomServiceImpl();
		OrdersService ordersService = new OrderServiceImpl();
		PromotionsService promotionsService = new PromotionsServiceImpl();

		// 得到界面上的促销列表
		ArrayList<String> promotionStrList = promotionsService.getHotelPromotion(hotelName);
		if (promotionStrList.size() != 0) {
			ObservableList<String> promotion = FXCollections.observableArrayList(promotionStrList);
			promotionList.setItems(promotion);
		} else {
			ObservableList<String> promotion = FXCollections.observableArrayList("暂无促销策略");
			promotionList.setItems(promotion);
		}

		// 得到界面上的评价列表
		ArrayList<String> commentList = hotelService.getHotelComment(hotelName);
		if (commentList.size() != 0) {
			ObservableList<String> comment = FXCollections.observableArrayList(commentList);
			CommentList.setItems(comment);
		} else {
			ObservableList<String> comment = FXCollections.observableArrayList("暂无评价信息");
			CommentList.setItems(comment);
		}

		// 得到界面上的历史订单列表
		ArrayList<OrderVo> orderList = ordersService.getHotelOrderList(hotelName, userId, OrderType.all);
		if (orderList.size() != 0) {
			ArrayList<String> orderStrList = new ArrayList<String>();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for (OrderVo cell : orderList) {
				orderStrList.add(cell.getOrderId() + " 类型：" + typeToName(cell.getType()) + " 起始："
						+ formatter.format(cell.getInDate()) + " 结束：" + formatter.format(cell.getOutDate()));
			}
			ObservableList<String> order = FXCollections.observableArrayList(orderStrList);
			orderListView.setItems(order);
		} else {
			ObservableList<String> order = FXCollections.observableArrayList("您在该酒店无历史订单");
			orderListView.setItems(order);
		}

		// 设置界面上的酒店基本信息
		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		HotelNameLabel.setText(hotelVo.getName());
		AddressLabel.setText(hotelVo.getAddress());
		rankingBar.setText(hotelVo.getRanking().toString());
		RemarkLabel.setText(String.valueOf(hotelService.getHotelRemark(hotelName)).substring(0, 3) + "分");
		IntroductionLabel.setText(hotelVo.getIntroduction());
		ServiceLabel.setText(hotelVo.getServiceAndFacility());

		Map<RoomType, Integer> numOfType = roomService.getNumOfRoom(hotelName,
				new Date(localToDate(startTime).getTime()), new Date(localToDate(endTime).getTime()));
		Map<RoomType, Double> priceOfType = roomService.getPriceOfRoom(hotelName,
				new Date(localToDate(startTime).getTime()), new Date(localToDate(endTime).getTime()));

		if (numOfType.get(RoomType.单人间) == 0) {
			Button1.setVisible(false);
			priceLabel1.setText("暂无空房");
		} else {
			priceLabel1.setText(String.valueOf(priceOfType.get(RoomType.单人间)) + "元");
			Button1.setVisible(true);
		}
		if (numOfType.get(RoomType.标准间) == 0) {
			Button2.setVisible(false);
			priceLabel2.setText("暂无空房");
		} else {
			priceLabel2.setText(String.valueOf(priceOfType.get(RoomType.标准间)) + "元");
			Button2.setVisible(true);
		}
		if (numOfType.get(RoomType.商务间) == 0) {
			Button3.setVisible(false);
			priceLabel3.setText("暂无空房");
		} else {
			priceLabel3.setText(String.valueOf(priceOfType.get(RoomType.商务间)) + "元");
			Button3.setVisible(true);
		}
		if (numOfType.get(RoomType.行政标准间) == 0) {
			Button4.setVisible(false);
			priceLabel4.setText("暂无空房");
		} else {
			priceLabel4.setText(String.valueOf(priceOfType.get(RoomType.行政标准间)) + "元");
			Button4.setVisible(true);
		}
		if (numOfType.get(RoomType.高级套间) == 0) {
			Button5.setVisible(false);
			priceLabel5.setText("暂无空房");
		} else {
			priceLabel5.setText(String.valueOf(priceOfType.get(RoomType.高级套间)) + "元");
			Button5.setVisible(true);
		}
	}

	@FXML
	public void makeOrder1() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo, RoomType.单人间, startTime, endTime);
		// 跳转到订单界面
	}

	@FXML
	public void makeOrder2() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo, RoomType.标准间, startTime, endTime);
		// 跳转动订单界面
	}

	@FXML
	public void makeOrder3() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo, RoomType.商务间, startTime, endTime);
		// 跳转到订单界面
	}

	@FXML
	public void makeOrder4() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo, RoomType.行政标准间, startTime, endTime);
		// 跳转到订单界面
	}

	@FXML
	public void makeOrder5() {
		HotelVo vo = service.getHotelInfo(hotelName);
		main.showOrderBuilder(vo, RoomType.高级套间, startTime, endTime);
		// 跳转到订单界面
	}

	private java.util.Date localToDate(LocalDate time) {
		System.out.println("test1" + time.toString());
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return java.util.Date.from(instant);
	}
}
