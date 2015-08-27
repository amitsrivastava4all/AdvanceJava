class A
{
	A(){
		System.out.println("A Class Cons call");
	}
	void show(){
		System.out.println("A Show");
	}
	void show2(){
		System.out.println("A Show");
	}
}
public class Demo23 {

	public static void main(String[] args) {
		
		
		
		new A().show();
		//new A().show2();
		A obj = new A();
		obj.show();
		obj.show();
		obj.show2();

	}

}
