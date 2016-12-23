package view.marketer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.HotelService;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class Promotionsii2Controller {
	@FXML
	private AnchorPane PromotionsiiPane;
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
	private MarketerMain main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	HotelService hotelService=new HotelServiceImpl();
	public Promotionsii2Controller(){
		main=MarketerMain.getMain();
		discountTextField=new TextField();
		startdateDatePicker=new DatePicker();
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
	@FXML
	public void addPromotionsII2(){
		String hotel="网站";
		String discountstr=discountTextField.getText();
		String startdate=startdateDatePicker.getValue().toString();
		String enddate=enddateDatePicker.getValue().toString();
		String introduction=introductionTextField.getText();		
		if(startdate.length()==0||enddate.length()==0||discountstr.length()==0||introduction.length()==0){
			main.showWaningInformation(AlertType.INFORMATION, null, "策略信息填写不完整");
		}else{
			double discount=Double.parseDouble(discountstr);
			if(discount>0.99||discount<0.1){
				main.showWaningInformation(AlertType.INFORMATION, null, "折扣只能在0.1~0.99之间");
				
			}
			else {
			PromotionsII2VO promotionsII2VO=new PromotionsII2VO(2, hotel, introduction, startdate, enddate, discount);
			boolean result=promotionsService.addPromotionsII2(promotionsII2VO);
			if(result){
				main.showWaningInformation(AlertType.INFORMATION, null, "策略添加成功");
				clearPromotionsII2();
			}else{
				main.showWaningInformation(AlertType.INFORMATION, null,"策略已存在");
				
			}
		}
		}
	}
	@FXML
	public void clearPromotionsII2(){
		discountTextField.setText("");
		startdateDatePicker.setValue(LocalDate.now());
		
		introductionTextField.setText("");
	}
	
}
