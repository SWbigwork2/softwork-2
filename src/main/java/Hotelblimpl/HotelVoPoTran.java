package Hotelblimpl;


import po.HotelPO;
import vo.HotelVo;

public class HotelVoPoTran {
    
    
	//将HotelPO转化为HotelVo
	public HotelVo PoToVo(HotelPO hotelPo){
		String hotelName = hotelPo.getName();
		String hotelAddress = hotelPo.getAddress();
		String hotelIntroduction = hotelPo.getIntroduction();
		HotelTradeArea hotelTradeArea = hotelPo.getTradeArea();
		String serviceAndFacility = hotelPo.getServiceAndFacility();
		HotelRanking hotelRanking = hotelPo.getRanking();
		
		return new HotelVo(hotelName, hotelAddress, hotelTradeArea, hotelIntroduction, serviceAndFacility, hotelRanking);
		
	}
	
    //将HotelVo转化为HotelPO
	public HotelPO VoToPo(HotelVo hotelVo){
		String hotelName = hotelVo.getName();
		String hotelAddress = hotelVo.getAddress();
		String hotelIntroduction = hotelVo.getIntroduction();
		HotelTradeArea hotelTradeArea = hotelVo.getTradeArea();
		String hotelServiceAndFacility = hotelVo.getServiceAndFacility();
		HotelRanking hotelRanking = hotelVo.getRanking();
		
		return new HotelPO(hotelName, hotelAddress, hotelTradeArea, hotelIntroduction, hotelServiceAndFacility, hotelRanking);
	}

}
