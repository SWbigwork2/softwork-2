package view.manager;

import java.util.ArrayList;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.StaffVO;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FindMemberController {
	 private ArrayList<MemberInformationVO> memberInfoList;
	    private ObservableList<String> temp ;
	    
		@FXML private TextField memberIdFindField;
		@FXML private TableView< String> memberList;
		
		
		public FindMemberController() {
	        memberIdFindField=new TextField();
	        memberList=new TableView<String>();
	        memberInfoList=new ArrayList<MemberInformationVO>();
		    
	        temp = FXCollections.observableArrayList();
			for(MemberInformationVO info:memberInfoList){
				temp.add(standardFormat(info));
			}
			memberList.setItems(temp);
		}
		
		/**
		 * 搜索按钮
		 */
		@FXML
		public void findmember(){
	        MemberInformationVO memberVo =null;
			if(memberIdFindField.getText()!=null){
				String  memberId=memberIdFindField.getText();
				UserControllerblimpl userControllerMock=new UserControllerblimpl();
				memberVo=(MemberInformationVO)userControllerMock.find(memberId, UserType.member);
		    }
			
			if(memberVo!=null){
				
			}
		}
		
		@FXML
		public void showDetails(MouseEvent event){
		    if(event.getClickCount()>=2){
		    	showmember();
		    }
			
		}
		
		
		private String standardFormat(MemberInformationVO memberVO){
			String memberId  = memberVO.getUserId()+"";
			String memberName= memberVO.getName();
            String vipType="个人会员";
            if(memberVO.getVipType().equals(VipType.CompanyVip)){
            	vipType="企业会员";
            }
			
            String credit=Double.toString(memberVO.getCredit());
            String level=Integer.toString(memberVO.getLevel());
			return memberId+" "+memberName+" "+vipType+" "+level+" "+credit;
		}
		
		private void showmember(){
	        String selectedStr =memberList.getSelectionModel().getSelectedItem();
			
			String memberId = selectedStr.split(" ")[0];
			MemberInformationVO resultInfo =null;
			for(MemberInformationVO voInfo:memberInfoList){
				if(voInfo.getUserId().equals(memberId)){
					resultInfo = voInfo;
					break;
				}
			}
			//调用main方法
		}
	}

