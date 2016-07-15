package calc;

import CPP.Absyn.*;
/**
 * This is class is the entrance for the visitor pattern
 * @author soenke
 *
 */
public class Acceptor {
	public static Exp eval(Exp e){
		
		return  e.accept(new Evaluator_Exp(), null);
	}
	
	public static Stm eval(Stm s){
		
		return s.accept(new Evaluator_Stm(), null);
	}
	
	public static Arg eval(Arg a){
		
		return  a.accept(new Evaluator_Arg(), null);
	}
	
	public static Def eval(Def d){
		
		return d.accept(new Evaluator_Def(), null);
	}
	
	public static Program eval(Program p){
	
		return p.accept(new Evaluator_Program(),null);
	}
	
	
	
}
