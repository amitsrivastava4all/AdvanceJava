import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


public class Demo1 {
static void disp(Set names ){
	System.out.println("***************************");
	names.add("ram");
	names.add("amit");
	names.add("amit");
	names.add("ram");
	names.add("shyam");
	System.out.println(names);
}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		disp(new TreeSet());
		
		disp(new HashSet());
		disp(new LinkedHashSet());
		
		ArrayList l3 = new ArrayList(1000);  //10 
		
		l3.add(100);
		System.out.println(l3.size());
		
		Vector v = new Vector();
		v.add(290);
		v.addElement(78);
		System.out.println("Vector Capacity "+v.capacity());
		System.out.println(v.size());
		LinkedList l2 = new LinkedList();
		l2.add(90);
		l2.addFirst(100);
		l2.addLast(33);
		System.out.println(l2.get(0));
		
		//Set names = new TreeSet(); //Upcasting
		//TreeSet names = new TreeSet();
		//LinkedHashSet names = new LinkedHashSet();
		//HashSet names = new HashSet();
		
	}

}
