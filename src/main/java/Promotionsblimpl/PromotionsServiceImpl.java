package Promotionsblimpl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import Hotelblimpl.HotelServiceImpl;
import Membersblimpl.MemberServiceImpl;
import blservice.HotelService;
import blservice.MembersService;
import blservice.PromotionsService;
import data.dao.PromotionsDao;
import data.rmi.RemoteHelper;
import po.HotelPO;
import po.MemberPO;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;
import view.marketer.PromotionsII2VO;
import view.marketer.PromotionsVIVO;
import view.marketer.PromotionsVVO;
import view.staff.PromotionsIIIVO;
import view.staff.PromotionsIIVO;
import view.staff.PromotionsIVO;
import view.staff.PromotionsIVVO;
import view.staff.PromotionsVO;

public class PromotionsServiceImpl implements PromotionsService,PromotionGetPrice{
	PromotionsDao dao;
	RemoteHelper remoteHelper;
//	MembersService membersService=new MemberServiceImpl();
//	HotelService  hotelService=new HotelServiceImpl();
	DateFormat df = DateFormat.getDateInstance();
	
	
	
	ArrayList<PromotionsPO> strategieslist=new ArrayList<PromotionsPO>();	
	public PromotionsServiceImpl(){
		remoteHelper = RemoteHelper.getInstance();
		dao=remoteHelper.getPromotionsDao();
		
	}
	/**
	 * @param hotel
	 * @return  返回酒店拥有的促销策略
	 */
	public ArrayList<String> getHotelPromotion(String hotel){
       		ArrayList<String> list=new ArrayList<String>();
		strategieslist=dao.getHotelPromotions(hotel);
		for(PromotionsPO po:strategieslist){
			list.add("策略"+po.getType()+po.getIntroduction());
		}
		
		
		return list;
	
	}
	/**
	 * @param hotel
	 * @param price
	 * @param roomNum
	 * @param userId
	 * @param days
	 * @return  计算订单最优价格返回Priceinfo
	 */
	public PriceInfo getPrice(String hotel, double price, int roomNum, String userId, int days)  {
		// TODO Auto-generated method stub
		DateFormat df = DateFormat.getDateInstance();
		strategieslist=dao.getHotelPromotions(hotel);
		String introduction="";
		double discount=1.0;
		double totalprice=1000000;	
		for(PromotionsPO po:strategieslist){
			if(po.getType()==1){				
			Date now=new Date();
			String nowday=df.format(now);
			MembersService membersService=new MemberServiceImpl();
			MemberPO member=membersService.getMember(userId);
			if(member.getType()==0){
				String birth=member.getSpecial();
			    String date[]=birth.split("-");
			    String today[]=nowday.split("-");
			    if(date[1].equals(today[1])&&date[2].equals(today[2])){
			    	if(po.getDiscount()<=discount){
			    		discount=po.getDiscount();
			    		introduction=po.getIntroduction();
			    		
			    	}
			    }
			}
			
		}else if(po.getType()==2){
			PromotionsIIPO newpo=(PromotionsIIPO)po;
			Date now=new Date();
			String nowday=df.format(now);
			String startdate=newpo.getStartdate();
			String enddate=newpo.getEnddate();
			if(indays(nowday, startdate, enddate)){
				if(newpo.getDiscount()<=discount){
					discount=newpo.getDiscount();
					introduction=newpo.getIntroduction();
				}
			}
		
		}else if(po.getType()==3){
			PromotionsIIIPO poIII=(PromotionsIIIPO)po;
			if(roomNum>=poIII.getNum()){
				if(poIII.getDiscount()<=discount){
					discount=poIII.getDiscount();
					introduction=poIII.getIntroduction();
				}
			}
		}else if(po.getType()==4){
			MembersService membersService=new MemberServiceImpl();
			MemberPO memberPO=membersService.getMember(userId);	
			PromotionsIVPO poIV=(PromotionsIVPO)po;
			if(memberPO.getType()==1){
				if(poIV.getcompanyname().equals(memberPO.getSpecial())){
					if(poIV.getDiscount()<=discount){
						discount=poIV.getDiscount();
						introduction=poIV.getIntroduction();
					}
				}
			}
			
		}else if(po.getType()==5){
			MembersService membersService=new MemberServiceImpl();
		    HotelService  hotelService=new HotelServiceImpl();
		   PromotionsVPO poV=(PromotionsVPO)po;
		   HotelPO hotelPO=hotelService.getHotelInformation(hotel);
		   MemberPO memberPO=membersService.getMember(userId);
		   String area=hotelPO.getTradeArea().toString();
		   if(memberPO.getLevel()==poV.getViplevel()&&area==poV.getArea()){
			   if(poV.getDiscount()<=discount){
				   discount=poV.getDiscount();
				   introduction=poV.getIntroduction();
			   }
			   
		   }
			
			
			
		}else if(po.getType()==6){
			MembersService membersService=new MemberServiceImpl();
			MemberPO memberPO =membersService.getMember(userId);
			PromotionsVIPO poVI=(PromotionsVIPO)po;
			if(poVI.getViplevel()==memberPO.getLevel()){
				if(poVI.getDiscount()<=discount){
					discount=poVI.getDiscount();
					introduction=poVI.getIntroduction();
				}
			}
		}
			totalprice=price*roomNum*discount;
			
			
		}
		PriceInfo priceInfo=new PriceInfo(introduction, totalprice);
		return priceInfo;
	}
	/**
	 * @param nowdate
	 * @param startdate
	 * @param enddate
	 * @return  判断当前时间是否在活动期间内
	 */
	public boolean indays(String nowdate,String startdate,String enddate){
		boolean result=false;
		String nowdatestr[]=nowdate.split("-");
		String startdatestr[]=startdate.split("-");
		String enddatestr[]=enddate.split("-");
		if((Integer.parseInt(nowdatestr[0])==Integer.parseInt(startdatestr[0])&&
				Integer.parseInt(nowdatestr[1])>=Integer.parseInt(startdatestr[1])&&
				Integer.parseInt(nowdatestr[1])<=Integer.parseInt(enddatestr[1])&&
				Integer.parseInt(startdatestr[1])!=Integer.parseInt(enddatestr[1]))||
				(Integer.parseInt(nowdatestr[0])==Integer.parseInt(startdatestr[0])&&
				Integer.parseInt(nowdatestr[1])==Integer.parseInt(startdatestr[1])&&
				Integer.parseInt(nowdatestr[1])==Integer.parseInt(enddatestr[1])&&
				Integer.parseInt(nowdatestr[2])>=Integer.parseInt(startdatestr[2])&&
				Integer.parseInt(nowdatestr[2])<=Integer.parseInt(enddatestr[2]))
				
				){
			result=true;
		}
		return result;
		
	}


	

	
	/**
	 * @param promotionsIVO
	 * @return  添加策略一生日特惠
	 */
	public boolean addPromotionsI(PromotionsIVO promotionsIVO){
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsIPO promotionsIPO=tran.VoToPoI(promotionsIVO);
		return dao.addPromotionsI(promotionsIPO);
		
	}
	/**
	 * @param promotionsIIVO
	 * @return  添加策略二节日特惠
	 */
	public boolean addPromotionsII(PromotionsIIVO promotionsIIVO) {
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsIIPO promotionsIIPO=tran.VoToPoII(promotionsIIVO);
		return dao.addPromotionsII(promotionsIIPO);
	}
	/**
	 * @param promotionsII2VO
	 * @return  添加策略二节日特惠
	 */
	public boolean addPromotionsII2(PromotionsII2VO promotionsII2VO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsIIPO promotionsII2PO=tran.VoToPoII2(promotionsII2VO);
		return dao.addPromotionsII(promotionsII2PO);
		
	}
	/**
	 * @param promotionsIIIVO
	 * @return  添加策略三多间特惠
	 */
	public boolean addPromotionsIII(PromotionsIIIVO promotionsIIIVO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsIIIPO promotionsIIIPO=tran.VoToPoIII(promotionsIIIVO);
		return dao.addPromotionsIII(promotionsIIIPO);
	}
	/**
	 * @param promotionsIVVO
	 * @return  添加策略四合作企业特惠
	 */
	public boolean addPromotionsIV(PromotionsIVVO promotionsIVVO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsIVPO promotionsIVPO=tran.VoToPoIV(promotionsIVVO);
		return dao.addPromotionsIV(promotionsIVPO);
	}
	/**
	 * @param promotionsVVO
	 * @return  添加策略五商圈特惠
	 */
	public boolean addPromotionsV(PromotionsVVO promotionsVVO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsVPO promotionsVPO=tran.VoToPoV(promotionsVVO);
		return dao.addPromotionsV(promotionsVPO);
	}
	/**
	 * @param promotionsVIVO
	 * @return  添加策略六等级特惠
	 */
	public boolean addPromotionsVI(PromotionsVIVO promotionsVIVO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsVIPO promotionsVIPO=tran.VoToPoVI(promotionsVIVO);
		return dao.addPromotionsVI(promotionsVIPO);
	}
	/**
	 * @param promotionsVO
	 * @return  删除促销策略
	 */
	public boolean deletePromotions(PromotionsVO promotionsVO) {
		// TODO Auto-generated method stub
		PromotionPoVoTran tran=new PromotionPoVoTran();
		PromotionsPO promotionsPO=tran.VoToPo(promotionsVO);
		return dao.deletePromotions(promotionsPO);
	
	}
	

	


}
