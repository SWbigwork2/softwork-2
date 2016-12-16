package data.dao;

import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;

public interface EvaluateDataService {
    public ResultMessage addEvaluate(EvaluatePO evaluatePO);
    public ArrayList getEvaluatetion(String hotelName);
}
