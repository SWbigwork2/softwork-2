package Evaluateblimpl;

import java.util.ArrayList;

import blservice.EvaluateService;
import blservice.OrdersService;
import data.dao.EvaluateDao;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import vo.OrderVo;

public class Evaluateblimpl implements EvaluateService {
	private RemoteHelper remoteHelper;
	private EvaluateDao evaluateDao;
	
    public Evaluateblimpl(){
    	remoteHelper = RemoteHelper.getInstance();
    	evaluateDao = remoteHelper.getEvaluateDao();
    	
    }
    
    /** 
     * @return 返回评价的结果，一般不会失败
     * @param evaluatePO 需要保存的值
     * 
     */
    public ResultMessage evaluate(EvaluateVO evaluateVO,OrderVo orderVo){
    	OrdersService ordersService=new OrderServiceImpl();
    	ordersService.setType(orderVo.getOrderId(), OrderType.evaluation);
    	return evaluateDao.addEvaluate(EvaluatePOVOTran.VoToPo(evaluateVO));
        
    }
    

	/**
	 * @return 得到酒店的所有评价用ArrayList保存，格式为：memberName：comments
	 * @param hotelName 酒店的名称
	 */
	public ArrayList<String> getComments(String hotelName){
    	ArrayList<String> commentList=new ArrayList<String>();
    	
    	commentList=evaluateDao.getEvaluatetion(hotelName);
    	return commentList;
    }

	/**
	 * @return 得到酒店的分数
	 */
	public double getScore(String hotelName)  {
		// TODO Auto-generated method stub
		return evaluateDao.getScore(hotelName);
	}
    
    
    
}
