package po;

import java.util.ArrayList;

public class EvaluatePO {
    private String hotelName;
	private String memberId;
    private double score;
    private String s;
    
    public EvaluatePO(String hotelName,String memberId,double score,String s){
    	this.hotelName=hotelName;
    	this.memberId=memberId;
    	this.score=score;
    	this.s=s;
    }
    public String getHotelName() {
		return hotelName;
	}
	public String getMemberId() {
		return memberId;
	}
	
	public double getScore() {
		return score;
	}
	public String getS() {
		return s;
	}
    
}
