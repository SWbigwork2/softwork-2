public class HotelBLService_Driver {

	// Ϊ�˴���һ��HotelVO����������ԣ������Ƶ�Ļ�����Ϣ
	HotelTradeArea tradeArea;
	HotelRanking ranking;
	
	public void drive(HotelBLService hotelBLService) {
		//���Է������۾Ƶ�
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

		//���Է������¾Ƶ���Ϣ
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

		//���Է�����ӾƵ�
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
