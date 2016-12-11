package view.member;

import Evaluateblimpl.Evaluateblimpl;
import Hotelblimpl.HotelRanking;
import blservice.EvaluateService;
import blservice.OrdersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import po.EvaluatePO;
import vo.OrderVo;

public class EvaluateController {
	
    @FXML private Label hotelNameLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label inTimeLable;
    @FXML private ComboBox<Integer> scoreComboBox;
    @FXML private TextArea evaluationArea;
    
	private OrderVo order;
	private Main main;
	public EvaluateController() {
		main = main.getMain();
		scoreComboBox=new ComboBox<Integer>();
		hotelNameLabel=new Label();
		roomTypeLabel=new Label();
		inTimeLable=new Label();
		evaluationArea=new TextArea();
	}
	
	@FXML
	public void initialize(){
		ObservableList<Integer> scoreList= FXCollections.observableArrayList();
		for(int i=1;i<=5;i++){
			scoreList.add(i);
		}
		System.out.println("test");
		scoreComboBox.setValue(1);
		scoreComboBox.setItems(scoreList);
	}
	
	@FXML
	private void cancel(){
		main.backPane();
	}
	
	@FXML
	private void confirm(){
		int score=scoreComboBox.getValue();
	    String evaluate=evaluationArea.getText();
	    EvaluateService service=new Evaluateblimpl();
	    EvaluatePO  po=new EvaluatePO(this.order.getHotel(), score, evaluate, this.order.getName());
	    service.evaluate(po);
	    OrdersService ordersService=new OrderServiceImpl();
	    ordersService.setType(order.getOrderId(), OrderType.evaluation);
	    
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("提示");
	    alert.setHeaderText("评价成功");
	    alert.setContentText("");

	    alert.showAndWait();
	    
	    cancel();
	}
	
	public void setOrderVo(OrderVo orderVo){
		this.order=orderVo;
		
		hotelNameLabel.setText(this.order.getHotel());
		roomTypeLabel.setText(this.order.getRoomType());
		inTimeLable.setText(this.order.getInDate().toLocaleString());
	}
}
