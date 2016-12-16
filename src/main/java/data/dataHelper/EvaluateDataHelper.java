package data.dataHelper;

import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;

public interface EvaluateDataHelper {
    public ResultMessage addEvaluate(String hotelName,double score,String comment,String memberName);
    public ArrayList<String> getEvaluate(String hotelName);
    public ArrayList<Double> getScore(String hotelName);
}
