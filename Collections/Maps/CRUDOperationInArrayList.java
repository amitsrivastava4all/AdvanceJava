import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Consumer;

class MyLogic implements Consumer<String>{

	@Override
	public void accept(String t) {
		t  = t.toUpperCase();
		System.out.println(t);
		
	}
	
}
class ArrayListOperations{
	static ArrayList<String> list = new ArrayList<>();
	
	static void addOperation(String value){
		list.add(value);
	}
	
	static int find(String value){
		return list.indexOf(value);
	}
	
	static void removeOperation(String value){
		//list.remove(value);
		int index = find(value);
		if(index!=-1){
		list.remove(index);
		}
		else
		{
			System.out.println("Not Found so Can't Remove");
		}
	}
	
	static void sort(){
		Collections.sort(list);
		System.out.println("After Sort "+list);
	}
	
	static void traverseFirstWay(){
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	static void traverseSecondWay(){
		Iterator<String> i = list.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			
			//i.remove();
		}
	}
	
	static void traverseThirdWay(){
		ListIterator<String> i = list.listIterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			
			//i.remove();
		}
		while(i.hasPrevious())
		{
			System.out.println(i.previous());
			
			//i.remove();
		}
	}
	
	static void traverseFourthWay(){
		for(String z: list){
			System.out.println(z);
		}
	}
	
	static void traverseFifthWay(){
		Consumer<String> c = (x)->System.out.println(x.toUpperCase()); 
		list.forEach(c);
	}
	
	static void updateOperation(String oldValue, String newValue){
		int index = find(oldValue);
		if(index!=-1){
		list.set(index, newValue);
		}
		else
		{
			System.out.println("Not Found so Can't Update");
		}
	}
}

public class CRUDOperationInArrayList {

	public static void main(String[] args) {
		
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Search");
		System.out.println("4. Iterate First Way");
		System.out.println("5. Iterate Second Way");
		System.out.println("6. Iterate Third Way");
		System.out.println("7. Iterate Fourth Way");
		System.out.println("8. Iterate Fifth Way");
		System.out.println("9. Sort");
		System.out.println("10. Update");
		
		while(true){
			System.out.println("Enter Your Choice ");
			Scanner scanner =new Scanner(System.in);
			int choice = scanner.nextInt();
			switch(choice){
		case 1:
			System.out.println("Enter the New Value");
			String value = scanner.next();
			ArrayListOperations.addOperation(value);
			break;
		case 2:
			ArrayListOperations.removeOperation("Hello");
			break;
		case 3:
			ArrayListOperations.find("Hello");
			break;
		case 4:
			ArrayListOperations.traverseFirstWay();
			break;
		case 5:
			ArrayListOperations.traverseSecondWay();
			break;
		case 6:
			ArrayListOperations.traverseThirdWay();
			break;	
		case 7:
			ArrayListOperations.traverseFourthWay();
			break;
		case 8:
			ArrayListOperations.traverseFifthWay();
			break;	
		case 9:
			ArrayListOperations.sort();
			break;
		case 10:
			ArrayListOperations.updateOperation("Hello","Bye");
			break;
		default:
			System.exit(0);
		}
		}
		/*ArrayList<String> l = new ArrayList<>();
		l.add("hello");
		l.add("bye");
		
		// Java 8 Way
		//Consumer logic = new MyLogic();
		Consumer<String> logic = (x)->{
			System.out.println(x.toUpperCase());
			System.out.println(x.toLowerCase());
		};
		l.forEach(logic);
		*//*int j = 0;
		int x[] = new int[10];
		for(int i = 0 ; i<=9 ; i++){
			j = j + x[i];
			j = j * 2;
			j = j + 3;
			*/
		//}
		

	}

}
