package atm;
import javax.swing.*;

public class AccountData 
{
 	private String pincode;
	private String customername;
	private String accounttype;
	private String accountnumber;
	private String startbalance;
	
	public AccountData(String pin,String customer_name,String acc_type,String acc_num,String startbalance)
	{
		this.pincode=pin;
		this.customername=customer_name;
		this.accounttype=acc_type;
		this.accountnumber=acc_num;
		this.startbalance=startbalance;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getStartbalance() {
		return startbalance;
	}

	public void setStartbalance(String startbalance) {
		this.startbalance = startbalance;
	}

	public void printAccountDetails()
	{
		JOptionPane.showMessageDialog(null,"PINCODE : "+pincode+"\n\tCustomer Name : "+customername+"\n\tAccount Type : "+accounttype+
		"Account Number : "+accountnumber+"\nStarting Balance : "+startbalance,"Account Information ",JOptionPane.INFORMATION_MESSAGE);
	}
   
}
