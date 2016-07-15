package calc;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import CPP.PrettyPrinter;
import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;


public class Main {

	static  String filename;
	
	public static void main(String[] args) {
		/*if(args.length==0){
			System.out.println("No Input argument!");
			return;
		}*/
		try {
			
			
			File f = new File("files/good11.cc");
			//File f = new File(args[0]);
			
			f.createNewFile();
			filename = f.getName();
			if(!f.exists()){
			System.out.println("File does not exist");
			}
			Yylex l = new Yylex(new FileReader(f));
			
			@SuppressWarnings("deprecation")
			parser p = new parser(l);
		
				ConstantsManager.p = p;
				
				try {
					ConstantsManager.parse_tree = ConstantsManager.p.pProgram();
					ConstantsManager.parse_tree_copy = ConstantsManager.p.pProgram();
					 System.out.println();
				      System.out.println("Parse Succesful!");
				      System.out.println();
				      System.out.println("[Abstract Syntax]");
				      System.out.println();
				      System.out.println(PrettyPrinter.show(ConstantsManager.parse_tree));
				      System.out.println();
				      System.out.println("[Linearized Tree]");
				      System.out.println();
				      System.out.println(PrettyPrinter.print(ConstantsManager.parse_tree));
				      
				     // generate(parse_tree);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				generate(ConstantsManager.parse_tree);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
	
	

	/*
	 * This Funktion generates the new parse_tree and prints it to the standard output
	 */
	private static void generate(Program parse_tree) {
		
		
		
		
		parse_tree = Acceptor.eval(parse_tree);
		System.out.println();
	      System.out.println("[Abstract Syntax]");
	      System.out.println();
	      System.out.println(PrettyPrinter.show(parse_tree));
	      System.out.println();
	      System.out.println("[Linearized Tree]");
	      System.out.println();
	      System.out.println(PrettyPrinter.print(parse_tree));
		
	}
	
	

}
