package calc;

import java.util.HashMap;
import java.util.LinkedList;

import CPP.parser;

public class ConstantsManager {
	/**
	 * List of all initialized variables in Order of their implementation
	 * e.g. int a = 8 -> <a:8>
	 */
	public static CPP.Absyn.Program parse_tree;
	public static CPP.Absyn.Program parse_tree_copy;
	
	public static parser p;
	public static boolean isInTable=true;
	public static LinkedList<HashMap<String, String>> constList = new LinkedList<>();
	
	
	
	public static void addORChange(String name, String value){
		int id=-1;
		for(int i = 0; i< constList.size(); i++){
			if(constList.get(i).containsKey(name)){
				id = i;
				addV(name, value, id);
			}
		}
		if(id==-1){
			addV(name, value, id);
		}
	}
	
	private static void addV(String name, String value, int id){
		
		HashMap<String, String> tmp = new HashMap<>();
		tmp.put(name, value);
		if(id ==-1){
		constList.add(tmp);
		}else{
			try{
			constList.get(id).replace(name, value);
			}catch(Exception e){
				System.out.println("Failed to replace value at " +id);
			}
			
		}
		
	}
	
	public static double findValue(String id){
		int size = constList.size();
		
		double tmp=0.0f;
		
		for(int i=size-1; i>=0; i--){
			if(constList.get(i).containsKey(id)){
				tmp = Double.parseDouble(constList.get(i).get(id).trim());
				System.out.println("---------------test output "+ tmp);
				i=0;
				isInTable =true;
			}
		}
		if(isInTable){
			return tmp;
		}else{
			System.out.println("This is not the variable you are looking for.");
			isInTable =false;
			return 0;
		}
	}
	public static void printList(){
		System.out.println("List:");
		for(int i = 0; i< constList.size(); i++){
			System.out.println(constList.get(i).toString());
		}
	}
}
