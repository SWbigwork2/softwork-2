package data.dao;

import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;

public interface EvaluateDao {
    public ResultMessage addEvaluate(EvaluatePO evaluatePO);
    public ArrayList<String> getEvaluatetion(String hotelName);
    public ArrayList<Double> getScore(String hotelName);
}
