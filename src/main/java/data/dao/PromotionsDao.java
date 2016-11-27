package data.dao;

import java.util.Date;

public interface PromotionsDao {
   public boolean addStrategeisI(int type,String hotel,String introduction,double discount);
   public boolean addStrategiesII(int type,String hotel,Date startdate,Date enddate,String introduction,double discount);
   public boolean addStrategiesIII(int type,String hotel,int num,String introduction,double discount);
   public boolean addStrategiesIV(int type,String hotel,String introduction,double discount);
   public boolean addStrategiesV(int type,String hotel,int viplevel,String area,String introduction,double discount);
   public boolean addStrategiesVI(int type,String hotel,int viplevel,String introduction,double discount);
   public boolean deleteStrategeisI(int type,String hotel,String introduction,double discount);
   public boolean deleteStrategiesII(int type,String hotel,Date startdate,Date enddate,String introduction,double discount);
   public boolean deleteStrategiesIII(int type,String hotel,int num,String introduction,double discount);
   public boolean deleteStrategiesIV(int type,String hotel,String introduction,double discount);
   public boolean deleteStrategiesV(int type,String hotel,int viplevel,String area,String introduction,double discount);
   public boolean deleteStrategiesVI(int type,String hotel,int viplevel,String introduction,double discount);
}
