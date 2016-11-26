package data.dataHelper;

import java.sql.SQLException;
import java.util.ArrayList;

import po.MemberPO;

public interface MembersDataHelper {
	public MemberPO getMember(String id) throws SQLException;
    public boolean updateMemberCredit(String id,double changecredit);
}
