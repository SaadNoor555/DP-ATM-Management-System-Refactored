package atm;
import java.util.*;

public class Admin
{
    private ArrayList customerlist;
	private static boolean isCreated = false;
	private static Admin admin = Admin.getAdmin();
    private Admin() {
		this.isCreated = true;
        customerlist=new ArrayList();
    }
	public static Admin getAdmin(){
		if(isCreated!=true)
			admin = new Admin();
		return admin;
	}
	public void setCustomerlist(ArrayList customerlist) {
		this.customerlist = customerlist;
	}

	public ArrayList getCustomerlist() {
		return customerlist;
	}

    public void addPersonToCustomerlist(AccountData account)
	{
		customerlist.add(account);
	}

    public void deleteFromCustomerList(int i)
	{
		customerlist.remove(i);
	}

}
