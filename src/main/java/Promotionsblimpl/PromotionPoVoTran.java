package Promotionsblimpl;

import org.omg.PortableServer.POA;

import javafx.geometry.VPos;
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

public class PromotionPoVoTran {
	 
	/**
	 * @param vo
	 * @return 策略父类VO转PO
	 */
	public PromotionsPO VoToPo(PromotionsVO vo){
     	 PromotionsPO po=new PromotionsPO();
     	 po.setType(vo.getType());
     	 po.setHotel(vo.getHotel());
     	 po.setDiscount(vo.getDiscount());
     	 po.setIntroduction(vo.getIntroduction());
//     	 =new PromotionsPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getDiscount());
     	 return po;
     	
        }
           /**
         * @param vo
         * @return 策略一VO转化为PO
         */
        public PromotionsIPO VoToPoI(PromotionsIVO vo){
        	 PromotionsIPO po=new PromotionsIPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getDiscount());
        	 return po;
        	
           }
           /**
         * @param po
         * @return 策略一PO转为VO
         */
        public PromotionsIVO PoToVoI(PromotionsIPO po){
        	   PromotionsIVO vo=new PromotionsIVO(po.getType(), po.getHotel(), po.getIntroduction(), po.getDiscount());
        	   return vo;
           }
           /**
         * @param vo
         * @return 策略二VO转PO
         */
        public PromotionsIIPO VoToPoII(PromotionsIIVO vo){
        	
        	   PromotionsIIPO po=new PromotionsIIPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getStartdate(), vo.getEnddate(), vo.getDiscount());
        	   return po;
           }
           /**
         * @param po
         * @return 策略二PO转VO
         */
        public PromotionsIIVO PoToVoII(PromotionsIIPO po){
        	   PromotionsIIVO vo=new PromotionsIIVO(po.getType(), po.getHotel(), po.getIntroduction(), po.getStartdate(), po.getEnddate(), po.getDiscount());
        	   return vo;
           }
           /**
         * @param vo
         * @return 策略三VO转PO
         */
        public PromotionsIIIPO VoToPoIII(PromotionsIIIVO vo){
        	   PromotionsIIIPO po=new PromotionsIIIPO(vo.getType(), vo.getHotel(), vo.getIntroduction(),vo.getNum(), vo.getDiscount());
        	   return po;
           }
        /**
         * @param po
         * @return 策略三PO转VO
         */
        public PromotionsIIIVO PoToVoIII(PromotionsIIIPO po){
        	PromotionsIIIVO vo=new PromotionsIIIVO(po.getType(), po.getHotel(), po.getIntroduction(),po.getNum(), po.getDiscount());
            return vo;
        }
        /**
         * @param vo
         * @return 策略四VO转PO
         */
        public PromotionsIVPO VoToPoIV(PromotionsIVVO vo){
      	   PromotionsIVPO po=new PromotionsIVPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getCompanyname(),vo.getDiscount());
      	   return po;
         }
        /**
         * @param po
         * @return 策略四PO转VO
         */
        public PromotionsIVVO PoToVoIV(PromotionsIVPO po){
        	   PromotionsIVVO vo=new PromotionsIVVO(po.getType(), po.getHotel(), po.getIntroduction(), po.getcompanyname(),po.getDiscount());
        	   return vo;
           }
       
        /**
         * @param vo
         * @return 策略五VO转PO
         */
        public PromotionsVPO VoToPoV(PromotionsVVO vo){
        	   PromotionsVPO po=new PromotionsVPO(vo.getType(), vo.getHotel(), vo.getIntroduction(),vo.getViplevel(),vo.getArea(), vo.getDiscount());
        	   return po;
           }
          
        /**
         * @param po
         * @return 策略五PO转VO
         */
        public PromotionsVVO PoToVoV(PromotionsVPO po){
        	   PromotionsVVO vo=new PromotionsVVO(po.getType(), po.getHotel(), po.getIntroduction(),po.getViplevel(),po.getArea(),po.getDiscount());
        	   return vo;
           }
        
        /**
         * @param vo
         * @return 策略六VO转PO
         */
        public PromotionsVIPO VoToPoVI(PromotionsVIVO vo){
        	   PromotionsVIPO po=new PromotionsVIPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getViplevel(), vo.getDiscount());
        	   return po;
        	   
           }
           /**
         * @param po
         * @return 策略六PO转VO
         */
        public PromotionsVIVO PoToVoVI(PromotionsVIPO po){
        	   PromotionsVIVO vo =new PromotionsVIVO(po.getType(), po.getHotel(),po.getIntroduction(), po.getViplevel(), po.getDiscount());
        	   return vo;
            }
           /**
         * @param vo
         * @return 策略二VO2转PO2
         */
        public PromotionsIIPO VoToPoII2(PromotionsII2VO vo){
        	   PromotionsIIPO po=new PromotionsIIPO(vo.getType(), vo.getHotel(), vo.getIntroduction(), vo.getStartdate(), vo.getEnddate(), vo.getDiscount());
        	   return po;
           }
           /**
         * @param po
         * @return 策略二PO2转VO2
         */
        public PromotionsII2VO PoToVoII2(PromotionsIIPO po){
        	   PromotionsII2VO vo=new PromotionsII2VO(po.getType(), po.getHotel(), po.getIntroduction(),po.getStartdate() ,po.getEnddate(), po.getDiscount());
               return vo;       
           }
           
           
}
