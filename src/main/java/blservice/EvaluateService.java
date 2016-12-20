package blservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;

public interface EvaluateService {
	 public ResultMessage evaluate(EvaluatePO evaluatePO);
	 public ArrayList<String> getComments(String hotelName);
	 public double getScore(String hotelName);
}
