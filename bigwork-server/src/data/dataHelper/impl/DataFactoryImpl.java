package data.dataHelper.impl;

import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.HotelsDataHelper;
import data.dataHelper.MembersDataHelper;
import data.dataHelper.OrdersDataHelper;
import data.dataHelper.PromotionsDataHelper;

import data.dataHelper.RoomsDataHelper;


import data.dataHelper.UserDataHelper;

public class DataFactoryImpl implements DataFactory{

	public OrdersDataHelper getOrdersDataHelper() {
		OrdersDataHelper order = new OrdersDataSqlHelper();
		return order;
	}
	
	public UserDataHelper getUserDataHelper(){
        UserDataHelper userDataHelper= new UserDataSqlHelper();
        return userDataHelper;
	}

	public EvaluateDataHelper getEvaluateDataHelper() {
		EvaluateDataHelper evaluateDataHelper=new EvaluateDataSqlHelper();
		return evaluateDataHelper;
	}
        public MembersDataHelper getMembersDataHelper() {
		MembersDataHelper member=new MembersDataSqlHelper();
		return member;
	}
        public PromotionsDataHelper getPromtionsDataHelper() {
		PromotionsDataHelper promotion =new PromotionsDataSqlHelper();
		return promotion;
        }


		public HotelsDataHelper getHotelsDataHelper(){
			HotelsDataHelper hotelsDataHelper = new HotelsDataSqlHelper();
			return hotelsDataHelper;
		}
		
		public RoomsDataHelper getRoomsDataHelper(){
			RoomsDataHelper roomsDataHelper = new RoomsDataSqlHelper();
			return roomsDataHelper;
		}
}
