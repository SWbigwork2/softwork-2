package view.staff;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import Roomblimpl.RoomType;
import blservice.HotelService;
import blservice.PromotionsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class PromotionsiiController {
	
	@FXML
	private AnchorPane PromotionsiiPane;
	@FXML
	private TextField hotelnameTextField;
	@FXML
	private TextField discountTextField;
	@FXML	
	private DatePicker startdateDatePicker;
	@FXML
	private DatePicker enddateDatePicker;
	@FXML
	private TextField introductionTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Main main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	HotelService hotelService=new HotelServiceImpl();
	public PromotionsiiController(){
		main=Main.getMain();
		hotelnameTextField=new TextField();
		discountTextField=new TextField();
		enddateDatePicker=new DatePicker();
		enddateDatePicker=new DatePicker();
		introductionTextField=new TextField();
		
	}
	@FXML
	public void initialize() {
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                            if (item.isBefore(
	                            		startdateDatePicker.getValue().plusDays(1))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }
	                            long p = ChronoUnit.DAYS.between(
	                            		startdateDatePicker.getValue(), item
	                            );
	                           
	                    }
	                };
	            }
	        };
	    enddateDatePicker.setDayCellFactory(dayCellFactory);
	}
	public void addPromotionsII(){
		String hotel=hotelnameTextField.getText();
		String discountstr=discountTextField.getText();
		String startdate=startdateDatePicker.getValue().toString();
		String enddate=enddateDatePicker.getValue().toString();
		String introduction=introductionTextField.getText();
		
		
		
		
		
		
		if(hotel.length()==0||startdate.length()==0||enddate.length()==0||discountstr.length()==0||introduction.length()==0){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("策略信息填写不完整");
			alert.showAndWait();
		}else if(hotelService.judgeHotelExists(hotel)){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("不存在该酒店");
			alert.showAndWait();
		}
		
		else{
			
			double discount=Double.parseDouble(discountstr);
			if(discount>0.99||discount<0.1){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("折扣只能在0.1~0.99之间");
				alert.showAndWait();
			}else {
				
			
			PromotionsIIVO promotionsIIVO=new PromotionsIIVO(2, hotel, introduction, startdate, enddate, discount);
			boolean result=promotionsService.addPromotionsII(promotionsIIVO);
			if(result){
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略添加成功");
				alert.showAndWait();
				clearPromotionsII();
			}else{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("策略已存在");
				alert.showAndWait();
			}
		}
		}
	}
	public void clearPromotionsII(){
		hotelnameTextField.setText("");
		discountTextField.setText("");
		startdateDatePicker.setValue(null);
		enddateDatePicker.setValue(null);
		introductionTextField.setText("");
	}
	

}
