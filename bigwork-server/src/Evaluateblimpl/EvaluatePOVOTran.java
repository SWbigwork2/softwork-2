package Evaluateblimpl;

import po.EvaluatePO;

public class EvaluatePOVOTran {
    
	public static EvaluatePO VoToPo(EvaluateVO vo){
		return new EvaluatePO(vo.getHotelName(), vo.getScore(), vo.getS(), vo.getName());
	}
	
	public static EvaluateVO PoToVo(EvaluatePO po){
		return new EvaluateVO(po.getHotelName(), po.getScore(),po.getS(), po.getName());
	}
}
