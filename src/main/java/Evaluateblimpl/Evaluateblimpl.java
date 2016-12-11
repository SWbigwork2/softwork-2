package Evaluateblimpl;

import java.util.ArrayList;

import Hotelblimpl.HotelMock;
import Hotelblimpl.HotelServiceImpl;
import blservice.EvaluateService;
import blservice.HotelService;
import data.dao.EvaluateDao;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class Evaluateblimpl implements EvaluateService {

    
    public Evaluateblimpl(){
//        this.hotelName=hotelName;
//        this.memberId=memberId;
    }
    
    public ResultMessage evaluate(EvaluatePO evaluatePO){
        EvaluateDao evaluateDao=new EvaluateDaoImpl();
//      hotel加评分
        HotelService hotelService=new HotelServiceImpl();
        hotelService.setHotelRemark(evaluatePO.getHotelName(),(int)evaluatePO.getScore()) ;

        return evaluateDao.addEvaluate(evaluatePO);
    }
    

	@SuppressWarnings("unchecked")
	public ArrayList<String> getComments(String hotelName){
    	ArrayList<String> commentList=new ArrayList<String>();
    	EvaluateDao evaluateDao=new EvaluateDaoImpl();
    	commentList=evaluateDao.getEvaluatetion(hotelName);
    	return commentList;
    }
    
    
    
}
