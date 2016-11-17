package EvaluateMock;

import java.util.ArrayList;

public class EvaluatePO {
    private String hotelName;
	private String memberId;
    private int orderid;
    private int score;
    private String s;
    public EvaluatePO(String hotelName,String memberId,int orderId,int score,String s){
    	this.hotelName=hotelName;
    	this.memberId=memberId;
    	this.orderid=orderId;
    	this.score=score;
    	this.s=s;
    }
    public String getHotelName() {
		return hotelName;
	}
	public String getMemberId() {
		return memberId;
	}
	public int getOrderid() {
		return orderid;
	}
	public int getScore() {
		return score;
	}
	public String getS() {
		return s;
	}
    
}
