import java.util.*;
public class OccupancyVO {
	public OccupancyType type;
	public String roomId;
	public Date inDate;
	public Date predictDate;
	
	public OccupancyVO(OccupancyType t,String r, Date i,Date p){
		this.type=t;
		this.roomId=r;
		this.inDate=i;
		this.predictDate=p;
	}

}
