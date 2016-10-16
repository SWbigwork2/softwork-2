public class HotelBLService_Driver {

	// 为了创建一个HotelVO而引入的属性，包括酒店的基本信息
	HotelTradeArea tradeArea;
	HotelRanking ranking;
	
	public void drive(HotelBLService hotelBLService) {
		//测试方法评价酒店
		ResultMessage evaluationMessage = hotelBLService.evaluateHotel("0001", "qitian");
		switch (evaluationMessage) {
		case success:
			System.out.println("Evaluation success");
			break;
		case fail:
			System.out.println("Evaluation failed");
			break;
		default:
			break;
		}

		//测试方法更新酒店信息
		ResultMessage updateInfoMessage = hotelBLService
				.updateInfo(new HotelVO("0001", "No.111 ZhongshanRoad", tradeArea, "clean and convinent", "Wifi", ranking));
		switch (updateInfoMessage) {
		case success:
			System.out.println("updateIn success");
			break;
		case fail:
			System.out.println("updateIn failed");
			break;
		default:
			break;
		}

		//测试方法添加酒店
		ResultMessage addMessage = hotelBLService
				.addHotel(new HotelVO("0001", "No.111 ZhongshanRoad", tradeArea, "clean and convinent", "Wifi", ranking));
		switch (addMessage) {
		case hotelExist:
			System.out.println("add success");
			break;
		case hotelNotExist:
			System.out.println("add failed");
			break;
		default:
			break;
		}

	}

}
