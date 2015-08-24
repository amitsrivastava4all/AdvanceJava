import java.util.HashSet;
import java.util.TreeSet;

class Person  implements Comparable<Person>//extends Object
{
	int age;
	String name;
	Person(int age, String name){
		this.age = age;
		this.name = name;
		
	}
	
	
	
	/*@Override
	public boolean equals(Object o){
		Person p = (Person)o;
		if(this.name.equals(p.name) && this.age==p.age){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return name.length();
	}*/
	
	// toString is used to print the object in a meaningful manner, by default it will call object class toString
	// and object class toString will print the classname and the hashCode
	@Override
	public String toString(){
		return "Age "+age+" Name "+name;
	}



	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(o.name);
	}
}

public class HashSetBasicExample {

	public static void main(String[] args) {
		//HashSet<Person> personSet = new HashSet<>();
		TreeSet<Person> personSet = new TreeSet<>();
		Person ram = new Person(21,"ram");
		personSet.add(ram);
		
		Person shyam = new Person(22,"Shyam");
		personSet.add(shyam);
		
		Person ram2 = new Person(21,"ram");
		personSet.add(ram2);
		
		Person shyam2 = new Person(22,"Shyam");
		personSet.add(shyam2);
		
		Person mike = new Person(21,"mike");
		personSet.add(mike);
		System.out.println(" HashCode No "+ ram.hashCode());
		System.out.println(" HashCode No "+ ram2.hashCode());
		System.out.println(" HashCode No "+ shyam.hashCode());
		System.out.println(" HashCode No "+ shyam2.hashCode());
		System.out.println("Person Set **************************************");
		System.out.println(personSet);
		
		System.out.println("*************************************************");
		
		
		HashSet<String> set = new HashSet<>();
		set.add("amit");  // this add is first search the element is already in the set or not
		// if it is not then it will add the new element
		
		// 1. When add is called , internally it will call 
		// hashcode - search the right bucket
		// equals - Search the Right Value
		
		// If hashcode not found , so it will add it direcly
		// If HashCode is there, so it will compare the Value in Bucket (equals)
		// HashSet - 
		set.add("ram");
		set.add("ram");
		set.add("shyam");
		set.add("amit");
		System.out.println(set);
		
	}

}
