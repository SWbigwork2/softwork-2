package Membersblimpl;

import java.util.ArrayList;

import ordersblimpl.OrderItem;
import view.member.OrderVo;


public abstract class Member {
     public abstract ArrayList<OrderVo>  getOrder(String id);
     public abstract ArrayList<String> getHotel(String id);
}
