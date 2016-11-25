package MembersMock;

import java.util.ArrayList;

import OrdersMock.OrderItem;
import OrdersMock.OrderVO;
import po.HotelPO;

public abstract class Member {
     public abstract ResultMessage addmember(String memberIid,String memberPassword,String memberName,String memberTelephone);
     public abstract ArrayList<OrderVO>  getOrder(String id);
     public abstract ArrayList<String> getHotel(String id);
}
