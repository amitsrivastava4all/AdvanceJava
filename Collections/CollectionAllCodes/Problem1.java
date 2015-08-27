import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Customer 5 Records
I want to Access Each Customer on Customer Name Basis.
Every Customer has Many Address
like Office Address , Office Address Can be Many 
and Res Address can be Many
Address Sorted by City 
 */
class Address implements Comparable<Address>
{
	private String city;
	private String state;
	private String pinCode;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public int compareTo(Address o) {
		// TODO Auto-generated method stub
		return this.city.compareTo(o.city);
	}
	
}
class CashCustomer
{
	private int id;
	private String name;
	private String phone;
	private Map<String,List<Address>> addressMap = new HashMap<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Map<String, List<Address>> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(Map<String, List<Address>> addressMap) {
		this.addressMap = addressMap;
	}
	
	
}
public class Problem1 {

	public static void main(String[] args) {
		Map<String,CashCustomer> customerMap = new HashMap<>();
		CashCustomer sunilObject = new CashCustomer();
		sunilObject.setId(1001);
		sunilObject.setName("sunil");
		sunilObject.setPhone("2222");
		ArrayList<Address> officeAddressList =new ArrayList<>();
		Address officeAddress1 = new Address();
		officeAddress1.setCity("Delhi");
		officeAddress1.setPinCode("110006");
		officeAddress1.setState("Delhi");
		officeAddressList.add(officeAddress1);  // 0th Index Add
		officeAddress1 = new Address();
		officeAddress1.setCity("Mumbai");
		officeAddress1.setPinCode("220006");
		officeAddress1.setState("M.H");
		officeAddressList.add(officeAddress1);  //1st Index Add
		Collections.sort(officeAddressList);
		Map<String,List<Address>> addressMap = new HashMap<>();
		addressMap.put("office", officeAddressList);
		
		ArrayList<Address> resAddressList =new ArrayList<>();
		Address resAddress1 = new Address();
		resAddress1.setCity("Kolkata");
		resAddress1.setPinCode("110006");
		resAddress1.setState("Kolkata");
		resAddressList.add(resAddress1);  // 0th Index Add
		resAddress1 = new Address();
		resAddress1.setCity("Bangalore");
		resAddress1.setPinCode("220006");
		resAddress1.setState("Bangalore");
		resAddressList.add(resAddress1);  //1st Index Add
		Collections.sort(resAddressList);
		addressMap.put("res", resAddressList);
		sunilObject.setAddressMap(addressMap);
		
		customerMap.put("sunil", sunilObject);
		
		System.out.println(customerMap.get("sunil").getAddressMap().get("office").get(1).getCity());
		
		CashCustomer sandeepObject = new CashCustomer();
		sandeepObject.setId(1000);
		sandeepObject.setName("sandeep");
		sandeepObject.setPhone("9834272");
		
		ArrayList<Address> sandeepOfficeAddressList =new ArrayList<>();
		Address sandeepOfficeAddress1  = new Address();
		sandeepOfficeAddress1 .setCity("Uttar Pardesh");
		sandeepOfficeAddress1 .setPinCode("110006");
		sandeepOfficeAddress1 .setState("Uttar Pardesh");
		sandeepOfficeAddressList.add(sandeepOfficeAddress1 );  // 0th Index Add
		sandeepOfficeAddress1  = new Address();
		sandeepOfficeAddress1 .setCity("Lucknow");
		sandeepOfficeAddress1 .setPinCode("220006");
		sandeepOfficeAddress1 .setState("Lucknow");
		sandeepOfficeAddressList.add(sandeepOfficeAddress1 );  //1st Index Add
		//Collections.sort(sandeepOfficeAddressList);
		Map<String,List<Address>> sandeepAddressMap = new HashMap<>();
		sandeepAddressMap.put("office", sandeepOfficeAddressList);
		
		ArrayList<Address> sandeepResAddressList =new ArrayList<>();
		Address sandeepResAddress1 = new Address();
		sandeepResAddress1.setCity("Goa");
		sandeepResAddress1.setPinCode("110006");
		sandeepResAddress1.setState("Goa");
		sandeepResAddressList.add(sandeepResAddress1);  // 0th Index Add
		sandeepResAddress1 = new Address();
		sandeepResAddress1.setCity("Bangalore");
		sandeepResAddress1.setPinCode("220006");
		sandeepResAddress1.setState("Bangalore");
		sandeepResAddressList.add(sandeepResAddress1);  //1st Index Add
		Collections.sort(sandeepResAddressList);
		sandeepAddressMap.put("res", sandeepResAddressList);
		sandeepObject.setAddressMap(sandeepAddressMap);
		
		customerMap.put("sandeep", sandeepObject);
		
		System.out.println(customerMap.get("sandeep").getAddressMap().get("office").get(1).getCity());		
		

	}

}
