package calc;

import CPP.Absyn.*;

//The R and a has to be evaluated

public class CompileDef implements Def.Visitor<String, String> {
	/**
	 * create a string for that definition and write it in the text file
	 * go through all stuff that p has nad do the same 
	 */
	@Override
	public String visit(DFun p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit DFun");
		
		for(int i =0; i<p.listarg_.size(); i++){
			Compiler.eval(p.listarg_.get(i));	
			
		}
		
		for(int i =0; i<p.liststm_.size(); i++){
			Compiler.eval(p.liststm_.get(i));	
		}
		
		return null;
	}
	
	
	
}
