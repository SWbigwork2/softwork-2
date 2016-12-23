package view.manager;


import Hotelblimpl.HotelServiceImpl;
import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import blservice.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vo.HotelVo;

public class addHotelController {
	
    private Main main;
	
	@FXML
	private TextArea introductionBar; //酒店介绍
	@FXML
	private TextArea hotelServiceBar; //酒店服务
	@FXML
	private TextField hotelAddressBar;//酒店地址
	@FXML 
	private TextField hotelNameBar;//酒店名称
	@FXML
	private ComboBox<HotelTradeArea> hotelTradeAreaBar;//酒店商圈
	@FXML
	private ComboBox<HotelRanking> hotelRankingBar;//酒店等级
	@FXML
	private Button confirmButton;//按钮
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
	
	/**
	 * 确定添加酒店
	 */
	@FXML
	public void confirmHotelInfo(){
		
		HotelService hotelService = new HotelServiceImpl();
		//判断是否填写完整
		if(isEmpty()){
		    if(!hotelService.judgeHotelExists(hotelNameBar.getText())){
		        HotelVo hotelVo = new HotelVo(hotelNameBar.getText()
				, hotelAddressBar.getText(), hotelTradeAreaBar.getValue()
				,introductionBar.getText(), hotelServiceBar.getText(),hotelRankingBar.getValue());
		
		        hotelService.addHotel(hotelVo);
		        main.showWaningInformation(AlertType.INFORMATION,"成功", "已添加"+hotelNameBar.getText()+"的信息");
		        main.setHotel(hotelNameBar.getText());
		        main.moveToAddStaff();
		    }else{
		    	//提示用户酒店已存在
		    	main.showWaningInformation(AlertType.ERROR, "错误", "酒店已存在");
		    }
		}else{
			//提示用户输入完整
			main.showWaningInformation(AlertType.ERROR, "错误", "请输入完整");
		}
	}
	
	/**
	 * @return 判断是否填写完整
	 */
	private boolean  isEmpty(){
		if(hotelNameBar.getText().length()>=1&&hotelAddressBar.getText().length()>=1&&
				hotelRankingBar.getValue()!=null&&hotelServiceBar.getText().length()>=1&&
				hotelTradeAreaBar.getValue()!=null){
			return true;
		}
		return false;
	}

}
