package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;

public interface EvaluateDao extends Remote{
    public ResultMessage addEvaluate(EvaluatePO evaluatePO) throws RemoteException;
    public ArrayList getEvaluatetion(String hotelName) throws RemoteException;
}
