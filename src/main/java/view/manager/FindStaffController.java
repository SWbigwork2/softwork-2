package view.manager;

import java.util.ArrayList;

import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import blservice.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FindStaffController {
	
	private Main main;
    private ObservableList<StaffModel> staffItems=
    		FXCollections.observableArrayList();
    
	@FXML private TextField staffIdFindField;
	@FXML private TableView<StaffModel> staffList;
	@FXML private TableColumn<StaffModel, String> staffId;
	@FXML private TableColumn<StaffModel, String> staffName;
	@FXML private TableColumn<StaffModel, String> hotelName;
	
	
	public FindStaffController() {
        staffIdFindField=new TextField();
        staffList=new TableView<StaffModel>();
        new ArrayList<StaffVO>();
        staffId=new TableColumn<StaffModel, String>();
        staffName=new TableColumn<StaffModel, String>();
        hotelName=new TableColumn<StaffModel, String>();
	    main =main.getMain(); 
	}
	
	@FXML
	private void initialize(){
 
        UserService userService=new UserControllerblimpl();
        ArrayList<UserVO> staffVOs=userService.getAllUsers(UserType.staff);
		
		for(UserVO userVO:staffVOs){
			StaffVO staff=(StaffVO)userVO;
			StaffModel staffModel=new 
					StaffModel(staff.getUserId(), staff.getName(),staff.getHotelName());
			staffItems.add(staffModel);
		}
		
		staffList.setItems(staffItems);

		staffId.setCellValueFactory(new PropertyValueFactory("id"));
		staffName.setCellValueFactory(new PropertyValueFactory("name"));
		hotelName.setCellValueFactory(new PropertyValueFactory("hotelName"));
	}
	
	/**
	 * 搜索按钮
	 */
	@FXML
	public void findStaff(){
		
        StaffVO staffVo =null;
		if(staffIdFindField.getText().length()>=1){
			String  staffId=staffIdFindField.getText();
			UserControllerblimpl userControllerMock=new UserControllerblimpl();
			staffVo=(StaffVO)userControllerMock.find(staffId, UserType.staff);
	        
		}
		
		if(staffVo!=null){
			main.showStaffDetails(staffVo);
		}else{
			main.showWaningInformation(AlertType.ERROR, "提示", "这个id不存在");
		}
	}
	
	@FXML
	public  void selectStaff(){
		try {
			
			StaffModel staffModel=staffList.getSelectionModel().getSelectedItem();

			
		    UserService userService=new UserControllerblimpl();
		    StaffVO staff=(StaffVO)userService.find(staffModel.getId(), UserType.staff);
	        
	    	main.showStaffDetails(staff);
	        
		
		} catch (NullPointerException e) {
			// TODO: handle exception
			main.showWaningInformation(AlertType.ERROR, "", "请选择一项");
		}
			
			
		}
	}
	
	

