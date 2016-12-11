package view.member;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Map;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelServiceImpl;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.HotelService;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.HotelVo;

public class BrowseHotelController {

	private ArrayList<HotelColumnVo> hotelList;
	private String userName;
	private String hotelName;
	private LocalDate startTime;
	private LocalDate endTime;

	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button2;
	@FXML
	private Button remarkButton;
	@FXML
	private Button button3;
	@FXML
	private Label roomLabel4;
	@FXML
	private Label roomLabel3;
	@FXML
	private Label roomLabel2;
	@FXML
	private TableView<HotelColumnVo> hotelLabel;
	@FXML
	private Label roomLabel1;
	@FXML
	private Label remarkLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Button rankingButton;
	@FXML
	private Label priceLabel2;
	@FXML
	private Label priceLabel1;
	@FXML
	private Label roomLabel5;
	@FXML
	private Label hotelAddressLabel;
	@FXML
	private Label priceLabel5;
	@FXML
	private Label priceLabel4;
	@FXML
	private Label priceLabel3;
	@FXML
	private Button button1;
	@FXML
	private Button priceButton;
	@FXML
	private TableColumn<HotelColumnVo, String> hotelNameColumn;
	@FXML
	private TableColumn<HotelColumnVo, String> hotelPriceColumn;
	@FXML
	private TableColumn<HotelColumnVo, String> hotelRankingColumn;
	@FXML
	private TableColumn<HotelColumnVo, String> hotelRemarkColumn;
	@FXML
	private Button detailButton;
	@FXML
	private Label orderLabel1;
	@FXML
	private Label orderLabel2;
	@FXML
	private Label orderLabel3;

	private Main main;
	private HotelService service;
	
	public BrowseHotelController() {
		service = new HotelServiceImpl();
		main = Main.getMain();
		button4 = new Button();
		button5 = new Button();
		button2 = new Button();
		remarkButton = new Button();
		button3 = new Button();
		roomLabel4 = new Label();
		roomLabel3 = new Label();
		roomLabel2 = new Label();
		hotelLabel = new TableView<>();
		roomLabel1 = new Label();
		remarkLabel = new Label();
		hotelNameLabel = new Label();
		rankingButton = new Button();
		priceLabel2 = new Label();
		priceLabel1 = new Label();
		roomLabel5 = new Label();
		hotelAddressLabel = new Label();
		priceLabel5 = new Label();
		priceLabel4 = new Label();
		priceLabel3 = new Label();
		button1 = new Button();
		priceButton = new Button();
		hotelNameColumn = new TableColumn<HotelColumnVo, String>();
		hotelPriceColumn = new TableColumn<HotelColumnVo, String>();
		hotelRankingColumn = new TableColumn<HotelColumnVo, String>();
		hotelRemarkColumn = new TableColumn<HotelColumnVo, String>();
		detailButton = new Button();
		orderLabel1 = new Label();
		orderLabel2 = new Label();
		orderLabel3 = new Label();
	}
	
	public void setHotelVo(ArrayList<HotelColumnVo> hotelList,String userName,LocalDate startTime,LocalDate endTime) {
		this.hotelList = hotelList;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userName = userName;
		initialized();
	}

	@FXML
	public void initialized() {
		HotelColumnVo hotelColumnVo = new HotelColumnVo("金陵饭店", 708, HotelRanking.五星级, 4.9);
		ArrayList< HotelColumnVo> hotelList = new ArrayList<HotelColumnVo>();
		hotelList.add(hotelColumnVo);
		
		ObservableList<HotelColumnVo> hotelColumList = FXCollections.observableArrayList();

		for (HotelColumnVo cell : hotelList) {
			hotelColumList.add(cell);
		}

		hotelLabel.setItems(hotelColumList);
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelName());
		hotelPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelPrice());
		hotelRankingColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelRanking());
		hotelRemarkColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelRemark());
		
		System.out.print(hotelColumList.get(0).getHotelName().get());
		setLabel(hotelColumList.get(0).getHotelName().get());

		hotelLabel.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> setLabel(newValue.getHotelName().toString()));
	}

	private void setLabel(String hotelName) {
		
		HotelService hotelService = new HotelServiceImpl();
		RoomService roomService = new RoomServiceImpl();
		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		hotelNameLabel.setText(hotelName);
		hotelAddressLabel.setText(hotelVo.getAddress());
		remarkLabel.setText(String.valueOf(hotelService.getHotelRemark(hotelName)));
		Map<RoomType, Double> roomPrice = roomService.getPriceOfRoom(hotelName,new Date(localToDate(startTime).getTime()),new Date(localToDate(endTime).getTime()));
		Map<RoomType, Integer> roomNum = roomService.getNumOfRoom(hotelName,new Date(localToDate(startTime).getTime()),new Date(localToDate(endTime).getTime()));
		
		if (roomNum.get(RoomType.单人间) == 0) {
			priceLabel1.setText("房间暂无");
			button1.setVisible(false);
		} else {
			priceLabel1.setText(String.valueOf((roomPrice.get(RoomType.单人间))));
		}

		if (roomNum.get(RoomType.标准间) == 0) {
			priceLabel2.setText("房间暂无");
			button2.setVisible(false);
		} else {
			priceLabel2.setText(String.valueOf(roomPrice.get(RoomType.标准间)));
		}

		if (roomNum.get(RoomType.商务间) == 0) {
			priceLabel3.setText("房间暂无");
			button3.setVisible(false);
		} else {
			priceLabel3.setText(String.valueOf(roomPrice.get(RoomType.商务间)));
		}

		if (roomNum.get(RoomType.行政标准间) == 0) {
			priceLabel4.setText("房间暂无");
			button4.setVisible(false);
		} else {
			priceLabel4.setText(String.valueOf(roomPrice.get(RoomType.行政标准间)));
		}

		if (roomNum.get(RoomType.高级套间) == 0) {
			priceLabel5.setText("房间暂无");
			button5.setVisible(false);
		} else {
			priceLabel5.setText(String.valueOf(roomPrice.get(RoomType.高级套间)));
		}
	}

	@FXML
	public void makeOrder1() {
		HotelVo vo = service.getHotelInfo(hotelNameLabel.getText());
		main.showOrderBuilder(vo,RoomType.单人间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder2() {
		HotelVo vo = service.getHotelInfo(hotelNameLabel.getText());
		main.showOrderBuilder(vo,RoomType.标准间, startTime, endTime);
		//跳转动订单界面
	}

	@FXML
	public void makeOrder3() {
		HotelVo vo = service.getHotelInfo(hotelNameLabel.getText());
		main.showOrderBuilder(vo,RoomType.商务间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder4() {
		HotelVo vo = service.getHotelInfo(hotelNameLabel.getText());
		main.showOrderBuilder(vo,RoomType.行政标准间, startTime, endTime);
		//跳转到订单界面
	}

	@FXML
	public void makeOrder5() {
		HotelVo vo = service.getHotelInfo(hotelNameLabel.getText());
		main.showOrderBuilder(vo,RoomType.高级套间, startTime, endTime);
		//跳转到订单界面
	}
	
	@FXML
	public void seeDetail(){
		
		main.showHotelDetail(hotelNameLabel.getText(), startTime,endTime);
		//跳转到查看详细信息界面
	}
	
	@FXML
	public void setPriceOrder(){
		
	}
	@FXML
	public void setRankingOrder(){
		
	}
	@FXML
	public void setRemarkOrder(){
		
	}
	private java.util.Date localToDate(LocalDate time){
		System.out.println("test1"+time.toString());
		Instant instant = Instant.from(time.atStartOfDay(ZoneId.systemDefault()));
		return java.util.Date.from(instant);
	}

}
