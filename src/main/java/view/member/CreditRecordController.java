package view.member;

import java.util.ArrayList;

import Membersblimpl.MemberServiceImpl;
import blservice.MembersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import po.CreditrecordPO;
import po.PromotionsPO;

public class CreditRecordController {
     @FXML
     private ListView<String> creditRecordListView;
     @FXML
	  private ObservableList<String> temp ;
     @FXML
     private Main main;
     public CreditRecordController(){
    	 main=main.getMain();
    	 creditRecordListView=new ListView<String>();
    	 
     }
     @FXML
     public void initialize(){
    	 System.out.println("test");
    	 temp = FXCollections.observableArrayList();
    	 MembersService membersService=new MemberServiceImpl();
    	String member=main.getMembervo().getUserId();
    	ArrayList<CreditrecordPO>  list=new ArrayList<CreditrecordPO>();
    	list=membersService.getMemberCreditRecord(member);
        ArrayList<String> creditlist=new ArrayList<String>();
        for(CreditrecordPO po:list){
			creditlist.add(po.getTime()+" "+po.getRecordid()+" "+po.getAction()+" "+po.getCreditchange()+" "+po.getCreditresult());
			
		}
        for(String cre:creditlist){
        	temp.add(cre);
        }
        creditRecordListView.setItems(temp);
        
     }
}
