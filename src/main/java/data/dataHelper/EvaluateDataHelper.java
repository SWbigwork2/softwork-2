package data.dataHelper;

import java.util.ArrayList;

import EvaluateMock.ResultMessage;

public interface EvaluateDataHelper {
    public ResultMessage addEvaluate(String hotelName,double score,String comment,String memberId);
    public ArrayList getEvaluate(String hotelName);
}