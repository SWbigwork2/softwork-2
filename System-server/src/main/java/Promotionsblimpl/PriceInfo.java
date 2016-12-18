package Promotionsblimpl;

/**
 * @author Administrator
 *传递订单价格以及所使用的策略的类
 */
public class PriceInfo {
	
	private String introduction;
	private double price;
	public PriceInfo(String introduction, double price) {
		this.introduction = introduction;
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
