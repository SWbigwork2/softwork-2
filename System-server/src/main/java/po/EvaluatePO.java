package po;

import java.io.Serializable;

public class EvaluatePO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8811457577381021855L;
	private String hotelName;
    private double score;
    private String s;
    private String memberName;
    
    public EvaluatePO(String hotelName,double score,String s,String memberName){
    	this.hotelName=hotelName;
    	this.score=score;
    	this.s=s;
    	this.memberName=memberName;
    }
    
    public String getHotelName() {
		return hotelName;
	}
    
    public String getName(){
    	return memberName;
    }
	
	public double getScore() {
		return score;
	}
	
	public String getS() {
		return s;
	}
    
}
