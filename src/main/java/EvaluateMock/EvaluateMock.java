package EvaluateMock;

import java.util.ArrayList;

import HotelsMock.HotelMock;
import data.dao.EvaluateDao;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class EvaluateMock {
    HotelInfo hotel;
    MemberInfo member;
    OrdersInfo order;
    String s;
    int score;
    
    public EvaluateMock(HotelInfo hotel,MemberInfo member,OrdersInfo order){
    	this.hotel= hotel;
    	this.member=member;
    	this.order=order;
    }
    
    public ResultMessage evaluate(String hotelName,String memberId,int orderId,double score,String s){
        EvaluatePO evaluatePO=new EvaluatePO(hotelName, memberId, score, s);
        EvaluateDao evaluateDao=new EvaluateDaoImpl();
//        HotelMock hotelMock=new HotelMock().
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
