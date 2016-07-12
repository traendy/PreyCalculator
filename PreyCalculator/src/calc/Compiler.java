package calc;

import CPP.Absyn.*;

public class Compiler {
	public static String eval(Exp e){
		System.out.println("Eval Expression:");
		 e.accept(new CompileExp(), null);
		
		return "" ;
	}
	
	public static void eval(Stm s){
		System.out.println("Eval Statement");
		s.accept(new CompileStm(), null);
		
		return ;
	}
	
	public static String eval(Arg a){
		System.out.println("Eval Argument");
		  a.accept(new CompileArg(), null);
		return "";
	}
	
	public static void eval(Def d){
		System.out.println("Eval Definition");
		d.accept(new CompileDef(), null);
		return ;
	}
	
	public static void eval(Program p){
		System.out.println("Eval Programm");
		
		 p.accept(new CompileProgram(),null);
		return;
	}
	
	
	
}
