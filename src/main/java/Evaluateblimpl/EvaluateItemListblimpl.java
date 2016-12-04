package Evaluateblimpl;

import java.util.ArrayList;


public class EvaluateItemListblimpl {
    ArrayList<EvaluateItem> evaluatelist=new ArrayList<EvaluateItem>();
    
    public ArrayList<EvaluateItem> getEvaluateList(String hotelName){
    	
    	ArrayList<EvaluateItem> temp=new ArrayList<EvaluateItem>();
    	for(EvaluateItem evaluateItem:evaluatelist){
    		if(evaluateItem.getHotelName().equals(hotelName)){
    			temp.add(evaluateItem);
    		}
    	}
    	return temp;
    }
}
