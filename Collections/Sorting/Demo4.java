import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Sorting in ArrayList
class SortByName implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
	
}

class SortById implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.id.compareTo(o2.id);
	}
	
}

class Customer implements Comparable<Customer>{
	Integer id;
	String name;
	Customer(Integer id, String name){
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
	/*@Override
	public int compareTo(Object o){
		Customer that  = (Customer)o;
		return this.name.compareTo(that.name);
	}*/
	@Override
	public int compareTo(Customer that) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(that.name); // Not using the Ascii Order
		//return this.name.compareTo(that.name);  // Ascending or Natural order (Ascii Order)
		//return that.name.compareTo(this.name); // Descending Order
	}
	
	
}
class CRUDOperation{
	private static ArrayList<Customer> customerList = new ArrayList<>();
	
	static void anotherWayOfSortingForComparator(){
		Collections.sort(customerList,new Comparator<Customer>() {
		public int compare(Customer o1, Customer o2){
			return o1.name.compareTo(o2.name);
		}
		});
		Comparator<Customer> idWiseSort = (o1,o2)->o1.id.compareTo(o2.id);
		Collections.sort(customerList,idWiseSort);
	}
	
	static void sortAscending(){
		Collections.sort(customerList, new SortById());
		Collections.sort(customerList);
		System.out.println("After Sort "+customerList);
	}
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
