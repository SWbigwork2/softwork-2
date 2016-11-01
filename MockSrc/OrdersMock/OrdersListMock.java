package OrdersMock;

import java.util.ArrayList;

public class OrdersListMock {
	ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
	public void add(OrderItem item){
		orderList.add(item);
	}
	public OrderItem findOrder(int orderId){
		for(OrderItem item:orderList){
			if(item.orderId==orderId){
				return item;
			}
		}
		return null;
	}
	public ArrayList<OrderItem> getList(OrderType type){
		switch (type) {
		case normal:
			return findNormal();
		case error:
			return findError();
		case done:
			return findDone();
		case revoke:
			return findRevoke();
			
		default:
			return null;
		}
		
		
	}
	private ArrayList<OrderItem> findNormal(){
		ArrayList<OrderItem> temp = new ArrayList<OrderItem>();
		for(OrderItem item:orderList){
			if(item.orderType==OrderType.normal){
				temp.add(item);
			}
		}
		return temp;
	}
	private ArrayList<OrderItem> findError(){
		ArrayList<OrderItem> temp = new ArrayList<OrderItem>();
		for(OrderItem item:orderList){
			if(item.orderType==OrderType.error){
				temp.add(item);
			}
		}
		return temp;
	}
	private ArrayList<OrderItem> findRevoke(){
		ArrayList<OrderItem> temp = new ArrayList<OrderItem>();
		for(OrderItem item:orderList){
			if(item.orderType==OrderType.revoke){
				temp.add(item);
			}
		}
		return temp;
	}
	private ArrayList<OrderItem> findDone(){
		ArrayList<OrderItem> temp = new ArrayList<OrderItem>();
		for(OrderItem item:orderList){
			if(item.orderType==OrderType.done){
				temp.add(item);
			}
		}
		return temp;
	}

}
