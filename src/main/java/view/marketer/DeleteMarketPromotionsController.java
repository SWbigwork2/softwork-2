package view.marketer;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import view.staff.DeletePromotionsController;
import view.staff.PromotionsVO;

public class DeleteMarketPromotionsController {
        @FXML
        private TextField hotelnameTextField;
        @FXML
        private TextField typeTextField;
        @FXML
        private TextField introductionTextField;
        @FXML
        private Button okButton;
        @FXML
        private Button cancelButton;
        @FXML
        private MarketerMain main;
        PromotionsService promotionsService=new PromotionsServiceImpl();
        
        public DeleteMarketPromotionsController(){
        	main=MarketerMain.getMain();
        	hotelnameTextField=new TextField();
        	typeTextField=new TextField();
        	introductionTextField=new TextField();
        	okButton=new Button();
        	cancelButton=new Button();
        }
        @FXML 
        public void  DeletePromotions(){
        	String hotel=hotelnameTextField.getText();
        	String typestr=typeTextField.getText();
        	String introduction=introductionTextField.getText();
        	if(hotel==null||typestr==null||introduction==null){
        		Alert alert=new Alert(AlertType.INFORMATION);
    			alert.setTitle("提示");
    			alert.setHeaderText(null);
    			alert.setContentText("删除策略信息填写不完整");
    			alert.showAndWait();
        		
        	}else{
        		int type=Integer.parseInt(typestr);
        		PromotionsVO promotionsVO=new PromotionsVO();
         		promotionsVO.setHotel(hotel);
         		promotionsVO.setDiscount(1);
         		promotionsVO.setIntroduction(introduction);
         		promotionsVO.setType(type);
        		boolean result=promotionsService.deletePromotions(promotionsVO);
        		if(result){
        			Alert alert=new Alert(AlertType.INFORMATION);
    				alert.setTitle("提示");
    				alert.setHeaderText(null);
    				alert.setContentText("策略删除成功");
    				alert.showAndWait();
        		}else{
        			Alert alert=new Alert(AlertType.INFORMATION);
    				alert.setTitle("提示");
    				alert.setHeaderText(null);
    				alert.setContentText("不存在该策略");
    				alert.showAndWait();
        		}
        	}
        	
        }
}
