
public class RoomVO {
	public String roomId;
	public String hotelBelongTo;
	public RoomType roomtype;
	public String introdution;
	public double price;
	//status��Ҫ�洢�����õ�ʱ��Σ���Ӧ����int���飬����ʵ�ִ�����
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
