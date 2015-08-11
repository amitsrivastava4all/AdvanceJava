import java.util.ArrayList;

class Customer{
	int id;
	String name;
	Customer(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object o ){
		boolean isFound = false;
		if(o instanceof Customer){
			Customer c = (Customer)o;
			if(c.id == this.id || this.name.equals(c.name)){
				isFound = true;
			}
		}
		return isFound;
	}
	
	
	
}
class CRUDOperation{
	private static ArrayList<Customer> customerList = new ArrayList<>();
	static void addCustomer(Customer customerObject){
		customerList.add(customerObject);
	}
	static void printCustomer(){
		for(Customer cust : customerList){
			System.out.println(cust);
		}
	}
	
	static void search(Customer customerObject){
		if(customerList.contains(customerObject))
		{
			System.out.println("Found...");
		}
		else
		{
			System.out.println("Not Found...");
		}
	}
	
	static void find(Customer customerObject){
		int index = customerList.indexOf(customerObject);
		if(index!=-1){
			System.out.println("Found...");
		}
		else
		{
			System.out.println("Not Found...");
		}
	}
}

public class Demo4 {

	public static void main(String[] args) {
		Customer customer= new Customer(2001,"Ram");
		//Customer a = customer;
		CRUDOperation.addCustomer(customer);
		customer= new Customer(2002,"Shyam");
		CRUDOperation.addCustomer(customer);
		customer= new Customer(2003,"tim");
		CRUDOperation.addCustomer(customer);
		CRUDOperation.printCustomer();
		Customer searchCustomer = new Customer(2001,"Ram");
		CRUDOperation.find(searchCustomer);
		
		

	}

}
