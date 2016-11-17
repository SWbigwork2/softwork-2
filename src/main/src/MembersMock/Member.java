package MembersMock;

import java.util.ArrayList;

import HotelsMock.HotelPO;
import OrdersMock.OrderItem;
import OrdersMock.OrderVO;

public abstract class Member {
     public abstract ResultMessage addmember(String memberIid,String memberPassword,String memberName,String memberTelephone);
     public abstract ArrayList<OrderVO>  getOrder(String id);
     public abstract ArrayList<String> getHotel(String id);
}
