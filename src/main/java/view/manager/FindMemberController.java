package view.manager;

import java.util.ArrayList;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import blservice.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindMemberController {
	
	private ObservableList<MemberModel> memberItems
    = FXCollections.observableArrayList();
	private Main main;
	
	@FXML private TextField memberIdFindField;
	
	@FXML 
	private TableView<MemberModel> memberList;
	
	@FXML 
	private TableColumn<MemberModel, String> memberIdColumn;
	
	@FXML 
	private TableColumn<MemberModel, String> memberNameColumn;
	
	@FXML 
	private TableColumn<MemberModel, String> memberLevelColumn;
	
	@FXML 
	private TableColumn<MemberModel, Double> memberCreditColumn;
	
		
	public FindMemberController() {
	    memberIdFindField=new TextField();
	    
	    memberList=new TableView<MemberModel>();
	    
	    memberIdColumn=new TableColumn<MemberModel, String>();
	    memberNameColumn=new TableColumn<MemberModel, String>();
	    memberLevelColumn=new TableColumn<MemberModel, String>();
	    memberCreditColumn=new TableColumn<MemberModel, Double>();
	    
//	    new ArrayList<MemberModel>();
	    main=main.getMain();
	}
		
	    
	
	@FXML
	private void initialize(){
		UserService userService=new UserControllerblimpl();
	    
		ArrayList<UserVO> list=userService.getAllUsers(UserType.member);
	    for(UserVO user:list){
	    	MemberInformationVO memberInformationVO=(MemberInformationVO)user;
	    	MemberModel memberModel=new MemberModel(memberInformationVO.getUserId()
	    			, memberInformationVO.getName(), memberInformationVO.getVipType()
	    			, memberInformationVO.getLevel(), memberInformationVO.getCredit()
	    			);
	    	memberItems.add(memberModel);
	    }
	    
	    memberIdColumn.setCellValueFactory(new PropertyValueFactory("id"));
		memberNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		
		memberLevelColumn.setCellValueFactory(new PropertyValueFactory("memberLevel"));
		memberCreditColumn.setCellValueFactory(new PropertyValueFactory("memberCredit"));
		
		memberList.setItems(memberItems);
	}
		
		/**
		 * 文本框搜索按钮，
		 */
		@FXML
		public void findMember(){
	        MemberInformationVO memberVo =null;
			if(memberIdFindField.getText().length()>=1){
				
				String  memberId=memberIdFindField.getText();
				UserControllerblimpl userControllerMock=new UserControllerblimpl();
				memberVo=(MemberInformationVO)userControllerMock.find(memberId, UserType.member);
				if(memberVo!=null){
					main.showMemberDetails(memberVo);
						
				}else{
					main.showWaningInformation(AlertType.WARNING, "提示", "账号不可用");
				}
				
			}
			
			
		}
		
		/**
		 * tableview选择，然后button的监听
		 */
		@FXML
		public void selectMember(){
			try{
			    MemberModel memberModel=memberList.getSelectionModel().getSelectedItem();
				
			    UserService userService=new UserControllerblimpl();
			    MemberInformationVO memberInformationVO=(MemberInformationVO)
					userService.find(memberModel.getId(), UserType.member);
			    main.showMemberDetails(memberInformationVO);			
			
			} catch (NullPointerException e) {
				// TODO: handle exception
				main.showWaningInformation(AlertType.ERROR, "", "请选择一项");
			}
		}
		
}

