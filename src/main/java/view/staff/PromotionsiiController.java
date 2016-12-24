package view.staff;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Hotelblimpl.HotelServiceImpl;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.HotelService;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class PromotionsiiController {
	
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
	private Main main;
	PromotionsService promotionsService=new PromotionsServiceImpl();
	HotelService hotelService=new HotelServiceImpl();
	public PromotionsiiController(){
		main=Main.getMain();
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
	/**
	 * 添加策略
	 */
	public void addPromotionsII(){
		String hotel=main.getHotelname();
		String discountstr=discountTextField.getText();
		String startdate=startdateDatePicker.getValue().toString();
		String enddate=enddateDatePicker.getValue().toString();
		String introduction=introductionTextField.getText();
		if(startdate.length()==0||enddate.length()==0||discountstr.length()==0||introduction.length()==0){
		  main.showWaningInformation(AlertType.INFORMATION, "策略信息填写不完整");
		}	
		else{
			
			double discount=Double.parseDouble(discountstr);
			if(discount>0.99||discount<0.1){
				main.showWaningInformation(AlertType.INFORMATION, "折扣只能在0.1~0.99之间");
			}else {
				
			
			PromotionsIIVO promotionsIIVO=new PromotionsIIVO(2, hotel, introduction, startdate, enddate, discount);
			boolean result=promotionsService.addPromotionsII(promotionsIIVO);
			if(result){
				main.showWaningInformation(AlertType.INFORMATION, "策略添加成功");
				clearPromotionsII();
			}else{
				main.showWaningInformation(AlertType.INFORMATION, "策略已存在");
			}
		}
		}
	}
	/**
	 * 清空制定策略的信息
	 */
	public void clearPromotionsII(){
		discountTextField.setText("");
		startdateDatePicker.setValue(LocalDate.now());
		enddateDatePicker.setValue(null);
		introductionTextField.setText("");
	}
	

}
