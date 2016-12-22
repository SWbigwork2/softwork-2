package view.manager;

import java.util.ArrayList;



import Usersblimpl.ManagerVO;
import Usersblimpl.MarketerVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.Userblimpl;
import Usersblimpl.Users;
import blservice.UserService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class FindMarketerController {
    
	@FXML 
	private TextField marketerIdField;//id区域
	
	@FXML 
	private TableColumn<MarketerModel, String> idColumn;//显示id的栏
	
	@FXML 
	private TableColumn<MarketerModel, String> nameColumn;//显示name的栏
	
	@FXML private TableView<MarketerModel> marketerList;//列表的框架
    
	//成员列表
	private ObservableList<MarketerModel> marketerItems
    = FXCollections.observableArrayList();
	
	private Main main;
	

	
	public FindMarketerController() {
		 marketerIdField=new TextField();
	     idColumn=new TableColumn<MarketerModel,String>();
	     nameColumn=new TableColumn<MarketerModel,String >();
	     marketerList=new TableView<MarketerModel>();
	     main=main.getMain();

	}
	
	@FXML
	private void initialize(){
		UserService userService=new UserControllerblimpl();
		
		//得到所有的marketer
        ArrayList<UserVO> marketerVOs=userService.getAllUsers(UserType.marketer);
		
        //把maeketers放到列表里
		for(UserVO marketerVO:marketerVOs){
			MarketerModel marketerModel=new 
					MarketerModel(marketerVO.getUserId(), marketerVO.getName());
			marketerItems.add(marketerModel);
		}
		
        
		idColumn.setCellValueFactory(new PropertyValueFactory("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		
		marketerList.setItems(marketerItems);
        	
		
	}
	
	/**
	 * 在列表中选择maeketer的响应
	 */
	@FXML
	private void selectMarketer(){
	    try{	
	    	MarketerModel marketer=marketerList.getSelectionModel().getSelectedItem();
	    	UserService userService=new UserControllerblimpl();
	    	MarketerVO marketerVO=(MarketerVO)userService.find(marketer.getId(), UserType.marketer);

		    main.showMarketerDetais(marketerVO);
	    } catch (NullPointerException e) {//捕获异常，防止不选择列表中的项
	    	// TODO: handle exception
	    	main.showWaningInformation(AlertType.ERROR, "", "请选择一项");
	    }
	}
	
	/**
	 * 在文本框中搜索
	 */
	@FXML
	private void findMarketer(){
		
	    String id=marketerIdField.getText();
	    
	    if(id.length()>=1){
	        UserService userService=new UserControllerblimpl();
	        MarketerVO marketerVO=(MarketerVO)userService.find(id, UserType.marketer);
	        main.showMarketerDetais(marketerVO);
	    }
	}
}
