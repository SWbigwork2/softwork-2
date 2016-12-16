package data.dao.impl;

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
	    
	public ResultMessage addEvaluate(EvaluatePO evaluatePO) {
		// TODO Auto-generated method stub
		return evaluateDataHelper.addEvaluate(evaluatePO.getHotelName(), evaluatePO.getScore(), evaluatePO.getS(),evaluatePO.getName());
	}

	public ArrayList<String> getEvaluatetion(String hotelName) {
		
		return evaluateDataHelper.getEvaluate(hotelName);
	}

	@Override
	public ArrayList<Double> getScore(String hotelName) {
		
		return evaluateDataHelper.getScore(hotelName);
	}

	
    
}
