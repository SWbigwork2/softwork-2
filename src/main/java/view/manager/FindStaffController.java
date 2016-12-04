package view.manager;

import java.util.ArrayList;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FindStaffController {
	
    private ArrayList<StaffVO> staffInfoList;
    private ObservableList<String> temp ;
    
	@FXML private TextField staffIdFindField;
	@FXML private TableView< String> staffList;
	
	
	public FindStaffController() {
        staffIdFindField=new TextField();
        staffList=new TableView<String>();
        staffInfoList=new ArrayList<StaffVO>();
	    
        temp = FXCollections.observableArrayList();
		for(StaffVO info:staffInfoList){
			temp.add(standardFormat(info));
		}
		staffList.setItems(temp);
	}
	
	/**
	 * 搜索按钮
	 */
	@FXML
	public void findStaff(){
        StaffVO staffVo =null;
		if(staffIdFindField.getText()!=null){
			String  staffId=staffIdFindField.getText();
			UserControllerblimpl userControllerMock=new UserControllerblimpl();
			staffVo=(StaffVO)userControllerMock.find(staffId, UserType.staff);
	    }
		
		if(staffVo!=null){
			
		}
	}
	
	@FXML
	public void showDetails(MouseEvent event){
	    if(event.getClickCount()>=2){
	    	showStaff();
	    }
		
	}
	
	
	private String standardFormat(StaffVO staffVO){
		String staffId  = staffVO.getUserId()+"";
		String staffName= staffVO.getName();
		String hotelName= staffVO.getHotelName();
		
		return staffId+" "+staffName+" "+hotelName;
	}
	
	private void showStaff(){
        String selectedStr =staffList.getSelectionModel().getSelectedItem();
		
		String staffId = selectedStr.split(" ")[0];
		StaffVO resultInfo =null;
		for(StaffVO voInfo:staffInfoList){
			if(voInfo.getUserId().equals(staffId)){
				resultInfo = voInfo;
				break;
			}
		}
		//调用main方法
	}
}
