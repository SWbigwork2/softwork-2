package view.staff;

import Hotelblimpl.HotelServiceImpl;

import java.util.ArrayList;
import java.util.Date;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import Roomblimpl.RoomServiceImpl;
import blservice.HotelService;
import blservice.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import view.member.RoomVo;
import javafx.scene.control.Alert.AlertType;
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

	public UpdateHotelController() {
		introductionBar = new TextArea();
		hotelTradeAreaBar = new ComboBox<HotelTradeArea>();
		hotelServiceBar = new TextArea();
		hotelRankingBar = new ComboBox<HotelRanking>();
		confirmButton = new Button();
		hotelAddressBar = new TextArea();
		roomInfoLabel = new ListView<String>();
		hotelNameLabel = new Label();
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
		System.out.println(hotelName);
		initialized();

	}

	@FXML
	public void initialized() {

		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		RoomService roomService = new RoomServiceImpl();
		Date startTime = new Date(115,1,1);
		Date endTime = new Date(115,1,2);
        ArrayList<RoomVo> roomList = roomService.getRoomOfHotel(hotelName, startTime, endTime);
        if (roomList.size() != 0) {
            ObservableList<String> roomStrList = FXCollections.observableArrayList();
            for (RoomVo cell : roomList) {
                roomStrList
                .add("房间ID ：" + cell.getRoomId() + "        价格 ：" + String.valueOf(cell.getRoomPrice()) + "元");
            }
        } else {
            ObservableList<String> roomStrList = FXCollections.observableArrayList("酒店暂无房间");
        }
		

		hotelNameLabel.setText(hotelName);
		hotelAddressBar.setText(hotelVo.getAddress());
		introductionBar.setText(hotelVo.getIntroduction());
		hotelNameLabel.setText(hotelVo.getName());
		hotelServiceBar.setText(hotelVo.getServiceAndFacility());
		hotelRankingBar.setValue(hotelVo.getRanking());
		hotelTradeAreaBar.setValue(hotelVo.getTradeArea());
		roomInfoLabel.setItems(roomStrList);

		ObservableList<HotelRanking> rankingList = FXCollections.observableArrayList();
		rankingList.add(HotelRanking.三星级);
		rankingList.add(HotelRanking.四星级);
		rankingList.add(HotelRanking.五星级);
		hotelRankingBar.setItems(rankingList);
		ObservableList<HotelTradeArea> tradeAreaList = FXCollections.observableArrayList();
		tradeAreaList.add(HotelTradeArea.新街口商圈);
		tradeAreaList.add(HotelTradeArea.夫子庙商圈);
		tradeAreaList.add(HotelTradeArea.仙林商圈);
		tradeAreaList.add(HotelTradeArea.桥北商圈);
		tradeAreaList.add(HotelTradeArea.河西商圈);
		tradeAreaList.add(HotelTradeArea.湖南路商圈);
		tradeAreaList.add(HotelTradeArea.百家湖商圈);
		hotelTradeAreaBar.setItems(tradeAreaList);
	}
	//提交更新后的酒店信息
	@FXML
	public void confirmHotelInfo() {
		HotelService hotelService = new HotelServiceImpl();

		String hotelAddress = hotelAddressBar.getText();
		HotelTradeArea tradeArea = hotelTradeAreaBar.getValue();
		String introduction = introductionBar.getText();
		String service = hotelServiceBar.getText();
		HotelRanking ranking = hotelRankingBar.getValue();
		if ((hotelAddress == "") || (tradeArea == null) || (introduction == "") || (service == "")
				|| (ranking == null)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("请添加完整酒店信息");
			alert.showAndWait();
		} else {
			HotelVo hotelVo = new HotelVo(hotelName, hotelAddress, tradeArea, introduction, service, ranking);
			if (hotelService.updateHotel(hotelVo)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText(hotelName+" 信息已更新");
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText(hotelName+" 信息更新失败");
				alert.showAndWait();
			}
		}

	}

}
