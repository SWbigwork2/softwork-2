package MembersImpl;

import java.util.ArrayList;

import OrdersMock.OrderItem;
import OrdersMock.OrderVO;

public abstract class Member {
     public abstract ArrayList<OrderVO>  getOrder(String id);
     public abstract ArrayList<String> getHotel(String id);
}
