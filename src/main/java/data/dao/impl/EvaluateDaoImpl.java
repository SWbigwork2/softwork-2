package data.dao.impl;

import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;
import data.dao.EvaluateDataService;
import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataservice.EvaluateDao;
import data.rmi.RemoteHelper;

public class EvaluateDaoImpl implements EvaluateDataService {
    
	 private static EvaluateDaoImpl evaluateDaoImpl;
	 private EvaluateDataHelper evaluateDataHelper;
	 private DataFactory dataFactory;
	 private  RemoteHelper remoteHelper;
	 private EvaluateDao evaluateDao;
	 public EvaluateDaoImpl(){
		 remoteHelper = RemoteHelper.getInstance();
		 evaluateDao = remoteHelper.getEvaluateDao();
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
		return evaluateDao.addEvaluate(evaluatePO);
		//return evaluateDataHelper.addEvaluate(evaluatePO.getHotelName(), evaluatePO.getScore(), evaluatePO.getS(),evaluatePO.getName());
	}

	public ArrayList getEvaluatetion(String hotelName) {
		
		//return evaluateDataHelper.getEvaluate(hotelName);
		return evaluateDao.getEvaluatetion(hotelName);
	}

	
    
}
