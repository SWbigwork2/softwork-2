package Evaluateblimpl;

public class EvaluateVO {
	
    private String hotelName;
    private double score;
    private String s;
    private String memberName;
    
    public EvaluateVO(String hotelName,double score,String s,String memberName){
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