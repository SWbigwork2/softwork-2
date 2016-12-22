package data.dataHelper;

import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;

public interface EvaluateDataHelper {
	
    /**
     * @param hotelName
     * @param score
     * @param comment
     * @param memberId
     * @return 添加评价
     */
    public ResultMessage addEvaluate(String hotelName,double score,String comment,String memberId);
    
    /**
     * @param hotelName
     * @return 得到评价信息
     */
    public ArrayList<String> getEvaluate(String hotelName);
    
    /**
     * @param hotelName
     * @return 得到评分
     */
    public double getScore(String hotelName);
}
