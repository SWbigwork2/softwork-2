package data.dao;

import java.util.ArrayList;

import po.EvaluatePO;
import EvaluateMock.ResultMessage;

public interface EvaluateDao {
    public ResultMessage addEvaluate(EvaluatePO evaluatePO);
    public ArrayList getEvaluatetion(String hotelName);
}
