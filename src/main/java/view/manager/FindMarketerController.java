package view.manager;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialogs;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class FindMarketerController {
    
	@FXML private TextField marketerIdField;
	@FXML private TableColumn<MarketerModel, String> idColumn;
	@FXML private TableColumn<MarketerModel, String> nameColumn;
	@FXML private TableView<MarketerModel> marketerList;
    
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
        ArrayList<UserVO> marketerVOs=userService.getAllUsers(UserType.marketer);
		
		for(UserVO marketerVO:marketerVOs){
			MarketerModel marketerModel=new 
					MarketerModel(marketerVO.getUserId(), marketerVO.getName());
			marketerItems.add(marketerModel);
		}
		
       
		idColumn.setCellValueFactory(new PropertyValueFactory("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		
		marketerList.setItems(marketerItems);
        	
		
	}
	
	@FXML
	private void selectMarketer(){
		
		MarketerModel marketer=marketerList.getSelectionModel().getSelectedItem();
		UserService userService=new UserControllerblimpl();
		MarketerVO marketerVO=(MarketerVO)userService.find(marketer.getId(), UserType.marketer);

		if(marketerVO!=null){
		    main.showMarketerDetais(marketerVO);
		}else{
		    
		}
	}
	
	@FXML
	private void findMarketer(){
	    String id=marketerIdField.getText();
	    if(id!=null){
	        UserService userService=new UserControllerblimpl();
	        MarketerVO marketerVO=(MarketerVO)userService.find(id, UserType.marketer);
	        main.showMarketerDetais(marketerVO);
	    }
	}
}
