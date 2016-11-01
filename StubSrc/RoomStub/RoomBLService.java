package RoomStub;
public interface RoomBLService {
	public ResultMessage addRoom(RoomVO r);
	public ResultMessage recordOccupancy (OccupancyVO o);
	public ResultMessage recordCheckout (CheckoutVO c);
	

}
