package calc;


import CPP.Absyn.*;
/**
 * evalute the R and A
 * @author soenke
 *
 */


public class CompileStm implements Stm.Visitor<String, String>{
/**
 * a lot of functions which are mostly similar to themselfs and compileExp funtctions
 * String work 
 */
	@Override
	public String visit(SExp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SExp");
		
		return null;
	}

	
	/**
	 * Todo Special case
	 */
	@Override
	public String visit(SDecls p, String arg) {
		System.out.println("Visit SDecls");
		for(int i =0; i< p.listid_.size(); i++){
			//6Compiler.eval(p.listid_);
		}
		
		return null;
	}

	@Override
	public String visit(SInit p, String arg) {
		System.out.println("Visit SInit");
		Compiler.eval(p.exp_);
		
		return null;
	}

	@Override
	public String visit(SReturn p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SReturn");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public String visit(SReturnVoid p, String arg) {
		
		System.out.println("Visit SReturnVoid");
		
		
		return null;
	}

	@Override
	public String visit(SWhile p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit SWhile");
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_);
		return null;
	}

	@Override
	public String visit(SBlock p, String arg) {
		System.out.println("Visit SBlock");
		
		for(int i=0; i<p.liststm_.size(); i++){
			Compiler.eval(p.liststm_.get(i));
			
		}
		
		return null;
	}

	@Override
	public String visit(SIfElse p, String arg) {
		
		System.out.println("Visit SIfElse");
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_1);
		Compiler.eval(p.stm_2);
		return null;
	}
	
	public static boolean isNumber(String s){
		for(char c: s.trim().toCharArray()) {
			
			if(!Character.isDigit(c))return false;
			
		}return true;
		
	}

}
