package Evaluateblimpl;

import java.util.ArrayList;

import blservice.EvaluateService;
import data.dao.EvaluateDao;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

/**
 * @author lenovo
 *
 */
public class Evaluateblimpl implements EvaluateService {

    
    public Evaluateblimpl(){

    }
    
    
    
    public ResultMessage evaluate(EvaluatePO evaluatePO){
        EvaluateDao evaluateDao=new EvaluateDaoImpl();

        return evaluateDao.addEvaluate(evaluatePO);
    }
    

	
	public ArrayList<String> getComments(String hotelName){
    	ArrayList<String> commentList=new ArrayList<String>();
    	EvaluateDao evaluateDao=new EvaluateDaoImpl();
    	commentList=evaluateDao.getEvaluatetion(hotelName);
    	return commentList;
    }
	
	public ArrayList<Double> getScore(String hotelName){
		ArrayList<Double> ScoreList=new ArrayList<Double>();
    	EvaluateDao evaluateDao=new EvaluateDaoImpl();
    	ScoreList=evaluateDao.getScore(hotelName);
    	return ScoreList;
		
	}
}
