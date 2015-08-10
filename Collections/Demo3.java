import java.util.ArrayList;


public class Demo3 {

	public static void main(String[] args) {
		ArrayList numList = new ArrayList();
		//numList.add(100);
		numList.add(new Integer(100));  // Boxing
		numList.add(new Integer(200));
		Integer x = (Integer)numList.get(0);
		Integer y = (Integer)numList.get(1);
		int a = x.intValue(); //UnBoxing
		int b = y.intValue();
		int c = a + b;
		numList.add(new Integer(c)); // Boxing
		//Integer z = x + y;
		
		// 1.5 Style
		ArrayList<Integer> numList2 = new ArrayList<Integer>();
		numList2.add(100);
		numList2.add(200);
		// 1. Integer , UnBoxing , Boxing , add
		numList2.add(numList2.get(0)+ numList2.get(1));
	}	

}
