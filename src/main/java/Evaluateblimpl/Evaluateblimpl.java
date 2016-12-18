package Evaluateblimpl;

import java.util.ArrayList;

import Hotelblimpl.HotelServiceImpl;
import blservice.EvaluateService;
import blservice.HotelService;
import data.dao.EvaluateDao;
import data.rmi.RemoteHelper;
import po.EvaluatePO;

public class Evaluateblimpl implements EvaluateService {
	private RemoteHelper remoteHelper;
	private EvaluateDao evaluateDao;
    
    public Evaluateblimpl(){
    	remoteHelper = RemoteHelper.getInstance();
    	evaluateDao = remoteHelper.getEvaluateDao();
//        this.hotelName=hotelName;
//        this.memberId=memberId;
    }
    
    public ResultMessage evaluate(EvaluatePO evaluatePO){
 
        return evaluateDao.addEvaluate(evaluatePO);
    }
    

	@SuppressWarnings("unchecked")
	public ArrayList<String> getComments(String hotelName){
    	ArrayList<String> commentList=new ArrayList<String>();
    	
    	commentList=evaluateDao.getEvaluatetion(hotelName);
    	return commentList;
    }

	@Override
	public double getScore(String hotelName) {
		// TODO Auto-generated method stub
		return evaluateDao.getScore(hotelName);
	}
    
    
    
}
