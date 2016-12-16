package Usersblimpl;

import po.ManagerPO;
import po.MarketerPO;
import po.MemberInformationPO;
import po.StaffPO;
import po.UserPO;

public class UserPoVoTran {
    
	public static UserPO VoToPo(UserVO user){
		UserPO userPO=null;
		
		switch (user.getType()) {
		case "member":
			MemberInformationVO member=(MemberInformationVO)user;
		    userPO=memberVoToPo(member);
		    break;
		    
		case "staff" :
			StaffVO staff=(StaffVO)user;
		    userPO=staffVoToPo(staff);
		    break;
	
		case "marketer":
			MarketerVO marketer=(MarketerVO)user;
		    userPO=marketerVoToPo(marketer);
		    break;
		
		case "manager":
			ManagerVO manager=(ManagerVO)user;
		    userPO=managerVoToPo(manager);
		    break;
		    
		}

		return userPO;		
	}
	
	
	public static UserVO PoToVo(UserPO user){
		UserVO userVO=null;
		
		switch (user.getRole()) {
		case member:
			MemberInformationPO member=(MemberInformationPO)user;
		    userVO=memberPoToVo(member);
		    break;
		    
		case staff:
			StaffPO staff=(StaffPO)user;
		    userVO=staffPoToVo(staff);
		    break;
	
		case marketer:
			MarketerPO marketer=(MarketerPO)user;
		    userVO=marketerPoToVo(marketer);
		    break;
		
		case manager:
			ManagerPO manager=(ManagerPO)user;
		    userVO=managerPoToVo(manager);
		    break;
		    
		}

		return userVO;		
	}
    
	private static MemberInformationVO memberPoToVo(MemberInformationPO member){
		MemberInformationVO memberInformationVO=new MemberInformationVO(member.getId()
				,  member.getName(),member.getPassword(), member.getCredit()
				, member.getContactInformation(), Integer.toString(member.getLevel()),
				member.getSpecial(), member.getVipType().name());
		return memberInformationVO;
	}
	
	private static MemberInformationPO memberVoToPo(MemberInformationVO member){
		
		MemberInformationPO memberPO=new MemberInformationPO(member.getUserId(), member.getName(),
				member.getPassword(), member.getContactInformation(), 
				member.getCredit(), VipType.valueOf(member.getVipType()), member.getSpecial(), Integer.valueOf(member.getLevel()));
		return memberPO;
	}
	
	private static StaffVO staffPoToVo(StaffPO staff){
		StaffVO staffVO=new StaffVO(staff.getId(), staff.getPassword()
				, staff.getName(), staff.getHotelName());
	    return staffVO;
	}
	
	
	private static StaffPO staffVoToPo(StaffVO staff){
		StaffPO staffPO=new StaffPO(staff.getUserId(), staff.getName()
				, staff.getPassword(), staff.getHotelName());
	    return staffPO;
	}
	
	private static MarketerVO marketerPoToVo(MarketerPO markrter){
		MarketerVO markrterVO=new MarketerVO(markrter.getId(), markrter.getPassword(), markrter.getName());
		return markrterVO;
	}
	
	private static MarketerPO marketerVoToPo(MarketerVO markrter){
		MarketerPO markrterPO=new MarketerPO(markrter.getUserId(), markrter.getName(), markrter.getPassword());
	    return markrterPO;
	}
	
	
	private static ManagerVO managerPoToVo(ManagerPO manager){
		ManagerVO managerVO=new ManagerVO(manager.getId(), manager.getName(), manager.getPassword());
		return managerVO;
	}
	private static ManagerPO managerVoToPo(ManagerVO manager){
		ManagerPO managerPO=new ManagerPO(manager.getUserId(), manager.getName(), manager.getPassword());
		return managerPO;
	}
}
