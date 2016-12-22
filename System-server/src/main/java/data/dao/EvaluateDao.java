package data.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Evaluateblimpl.ResultMessage;
import po.EvaluatePO;

public interface EvaluateDao extends Remote{
	
    /**
     * @param evaluatePO
     * @return
     * @throws RemoteException
     * 添加评论
     */
    public ResultMessage addEvaluate(EvaluatePO evaluatePO) throws RemoteException;
    
    
    /**
     * @param hotelName
     * @return
     * @throws RemoteException
     * 得到所有的评价
     */
    public ArrayList<String> getEvaluatetion(String hotelName) throws RemoteException;
    
    
    /**
     * @param hotelName
     * @return
     * @throws RemoteException
     * 得到酒店评分
     */
    public double getScore(String hotelName) throws RemoteException;
}
