package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;
import data.dao.EvaluateDao;
import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.impl.DataFactoryImpl;

public class EvaluateDaoImpl implements EvaluateDao {
    
	 private static EvaluateDaoImpl evaluateDaoImpl;
	 private EvaluateDataHelper evaluateDataHelper;
	 private DataFactory dataFactory;
	    
	 public EvaluateDaoImpl(){
	    dataFactory=new DataFactoryImpl();
		evaluateDataHelper=dataFactory.getEvaluateDataHelper();
	 }
	 
	 public static EvaluateDaoImpl getInstance(){
	    	if(evaluateDaoImpl ==null){
	    		evaluateDaoImpl=new EvaluateDaoImpl();
	    		return evaluateDaoImpl;
	    	}else{
	    		return evaluateDaoImpl;
	    	}
	    }
	    
	/** (non-Javadoc)
	 * @see data.dao.EvaluateDao#addEvaluate(po.EvaluatePO)
	 * 添加评论
	 */
	public ResultMessage addEvaluate(EvaluatePO evaluatePO) {
		// TODO Auto-generated method stub
		return evaluateDataHelper.addEvaluate(evaluatePO.getHotelName(), evaluatePO.getScore(), evaluatePO.getS(),evaluatePO.getName());
	}

	/** (non-Javadoc)
	 * @see data.dao.EvaluateDao#getEvaluatetion(java.lang.String)
	 * 得到评论
	 */
	public ArrayList<String> getEvaluatetion(String hotelName) {
		
		return evaluateDataHelper.getEvaluate(hotelName);
	}

	/*** (non-Javadoc)
	 * @see data.dao.EvaluateDao#getScore(java.lang.String)
	 * 得到评分
	 */
	@Override
	public double getScore(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return evaluateDataHelper.getScore(hotelName);
	}

	
    
}
