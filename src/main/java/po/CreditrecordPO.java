package po;

import java.io.Serializable;

public class CreditrecordPO implements Serializable{
  String memberid;
  String time;
  int recordid;
  String action;
  double creditchange;
  double creditresult;
  public String getMemberid(){
	  return memberid;
  }
  public String getTime(){
	  return time;
  }
  public int getRecordid(){
	  return  recordid;
  }
  public String getAction(){
	  return action;
  }
  public double getCreditchange(){
	  return creditchange;
  }
  public double getCreditresult(){
	  return creditresult;
  }
  public CreditrecordPO(String memberid,String time,int recordid,String action,double creditchange,double creditresult){
	  this.memberid=memberid;
	  this.time=time;
	  this.recordid=recordid;
	  this.action=action;
	  this.creditchange=creditchange;
	  this.creditresult=creditresult;
			 
  }
}
