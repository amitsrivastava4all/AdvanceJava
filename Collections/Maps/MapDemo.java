import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapDemo {

	public static void main(String[] args) {
		// Key is always Unique
		HashMap<String,Integer> phoneMap = new HashMap<>();
		phoneMap.put("amit",2222);
		phoneMap.put("ram",3333);
		phoneMap.put("amit",1111);
		System.out.println(phoneMap.get("amit"));
		/*System.out.println(phoneMap.remove("amit"));
		System.out.println(phoneMap.remove("amit", 1111));*/
		System.out.println(phoneMap.isEmpty());
		System.out.println(phoneMap.containsKey("ram"));
		System.out.println(phoneMap.containsValue(1111));
		System.out.println(phoneMap.size());
		System.out.println(phoneMap.replace("ram", 3333, 5555));
		// 1st Way - Oldest Way
		// Convert Map Keys into Set Keys
		Set<String> keys = phoneMap.keySet();
		// Get Iterator from the Set
		Iterator<String> i  = keys.iterator();
		System.out.println("***************** First Way of Traversing Map ******************");
		while(i.hasNext()){
			String key = i.next();
			System.out.println("Key is "+key+" Value is "+phoneMap.get(key));		
			//System.out.println(i.next());
		}
		
		// 2nd Way to Traverse the Map
		// 1.5
		System.out.println("***************** Second Way of Traversing Map ******************");
		for(Map.Entry<String, Integer> keyValue:phoneMap.entrySet()){
			System.out.println(keyValue.getKey()+" "+keyValue.getValue());
		}
		
		
		
		

	}

}
