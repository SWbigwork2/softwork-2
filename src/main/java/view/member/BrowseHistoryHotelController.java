package view.member;

import java.util.ArrayList;
import Hotelblimpl.HotelServiceImpl;
import blservice.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import vo.HotelVo;
import vo.OrderVo;

public class BrowseHistoryHotelController {

	private ArrayList<String> hotelList;
	private ArrayList<OrderVo> normalList;
	private ArrayList<OrderVo> abnormalList;
	private ArrayList<OrderVo> revokedList;

	@FXML
	private ListView<String> hotelLabel;
	@FXML
	private Label remarkLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label hotelAddressLabel;

	@FXML
	private ListView<String> normalOrderList;
	@FXML
	private ListView<String> abnormalOrderList;
	@FXML
	private ListView<String> revokedOrderList;

	public BrowseHistoryHotelController() {
		hotelLabel = new ListView<String>();
		remarkLabel = new Label();
		hotelNameLabel = new Label();
		hotelAddressLabel = new Label();
		normalOrderList = new ListView<String>();
		abnormalOrderList = new ListView<String>();
		revokedOrderList = new ListView<String>();
	}

	public void setHotelVo(ArrayList<String> hotelList, ArrayList<OrderVo> normalList, ArrayList<OrderVo> abnormalList,
			ArrayList<OrderVo> revokedList) {
		this.hotelList = hotelList;
		this.normalList = normalList;
		this.abnormalList = abnormalList;
		this.revokedList = revokedList;
		initialized();
	}

	@FXML
	public void initialized() {
		ObservableList<String> hotelColumList = FXCollections.observableArrayList();
		if (hotelList.size() != 0) {
			hotelColumList.addAll(hotelList);
			hotelLabel.setItems(hotelColumList);
			setLabel(hotelColumList.get(0));
		} else {
			hotelColumList.add("无历史预定酒店");
		}

		ObservableList<String> normalOrderStrList = FXCollections.observableArrayList();
		ObservableList<String> abnormalOrderStrList = FXCollections.observableArrayList();
		ObservableList<String> revokedOrderStrList = FXCollections.observableArrayList();

		if (normalList.size() != 0) {
			for (OrderVo cell : normalList) {
				normalOrderStrList.add(cell.getOrderId() + "     " + cell.getPrice());
			}
		} else {
			normalOrderStrList.add("不存在正常订单");
		}

		if (abnormalList.size() != 0) {
			for (OrderVo cell : abnormalList) {
				abnormalOrderStrList.add(cell.getOrderId() + "     " + cell.getPrice());
			}
		} else {
			abnormalOrderStrList.add("不存在异常订单");
		}

		if (revokedList.size() != 0) {
			for (OrderVo cell : revokedList) {
				revokedOrderStrList.add(cell.getOrderId() + "     " + cell.getPrice());
			}
		} else {
			revokedOrderStrList.add("不存在撤回订单");
		}

		normalOrderList.setItems(normalOrderStrList);
		abnormalOrderList.setItems(abnormalOrderStrList);
		revokedOrderList.setItems(revokedOrderStrList);

	}

	@FXML
	public void click(MouseEvent e) {
		if (e.getClickCount() > 0) {
			setLabel(hotelLabel.getSelectionModel().getSelectedItem());
		}
	}

	private void setLabel(String hotelName) {

		HotelService hotelService = new HotelServiceImpl();
		HotelVo hotelVo = hotelService.getHotelInfo(hotelName);
		hotelNameLabel.setText(hotelName);
		hotelAddressLabel.setText(hotelVo.getAddress());
		remarkLabel.setText(String.valueOf(hotelService.getHotelRemark(hotelName)));

	}

}
