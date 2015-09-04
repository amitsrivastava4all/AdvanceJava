package com.brainmentors.registerapp;

import java.util.Arrays;

public class StringPrograms {

	public static void main(String[] args) {
		String r = "Hello How are You How are";
		String w [] = r.split(" ");
		System.out.println(w.length);
		//r.replace("How","");
		//int i = 3;
		/*while(i>=3){
			System.out.println(i);
			i++;
		}*/
		int highestOccurance= 0;
		String data  = "abcdaberopjfhmamj9876kmnbtyumampfghtmnbcxsaqyhgktz";
		String find = "mam";
		//if(data.contains(find))
		if(data.indexOf(find)>=0)
		{
			System.out.println("Found...");
		}
		else{
			System.out.println("Not Found");
		}
		
		char charArray [] = data.toCharArray();
		Arrays.sort(charArray);
		String sortedData  = new String(charArray);
		System.out.println("UnSorted      "+data);
		System.out.println("Sorted String "+sortedData);
		for(int i = 0; i<sortedData.length(); ){
			char singleChar = sortedData.charAt(i);
			int startIndex = sortedData.indexOf(singleChar);
			int lastIndex = sortedData.lastIndexOf(singleChar);
			int count = lastIndex - startIndex;
			if(count>highestOccurance){
				highestOccurance = count;
			}
			/*if(count==0){
				System.out.print(singleChar);
			}*/
			//System.out.print(singleChar);
			i = lastIndex + 1;
			
		}
		System.out.println(highestOccurance);

	}

}
