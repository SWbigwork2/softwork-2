
public class RoomVO {
	public String roomId;
	public String hotelBelongTo;
	public RoomType roomtype;
	public String introdution;
	public double price;
	//status需要存储不可用的时间段，不应采用int数组，具体实现待讨论
	public int[] unavailablePeriod;
	
	
	public RoomVO(String r, String h, RoomType t,String i,double p, int[] s){
		this.roomId= r;
		this.hotelBelongTo =h;
		this.roomtype =t;
		this.introdution=i;
		this.price =p;
		this.unavailablePeriod =s;
	}

}
