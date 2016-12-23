package blservice;

import java.util.ArrayList;

import Evaluateblimpl.EvaluateVO;
import Evaluateblimpl.ResultMessage;
import vo.OrderVo;

public interface EvaluateService {
	 
	/** 
     * @return 返回评价的结果，一般不会失败
     * @param evaluatePO 需要保存的值
     * 
     */
	 public ResultMessage evaluate(EvaluateVO evaluateVO,OrderVo orderVo);
	 
	 /**
	 * @param hotelName 酒店的名称
	 * @return 得到酒店的所有评价用ArrayList保存，格式为：memberName：comments
	 */
	public ArrayList<String> getComments(String hotelName);
	 
	
	/**
	 * @param hotelName
	 * @return 得到酒店的分数
	 */
	public double getScore(String hotelName);
}
