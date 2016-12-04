package Evaluateblimpl;

public class EvaluateItem {
	String hotelName;
	String memberId;
    int orderid;
    int score;
    String s;
    
    public EvaluateItem(String hotelName,String memberId,int orderId,int score,String s){
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
