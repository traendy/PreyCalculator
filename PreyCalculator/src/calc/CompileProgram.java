package calc;

import CPP.Absyn.PDefs;
import CPP.Absyn.Program.Visitor;


/**
 * the R and A aastuff has to be evaluatet
 * @author soenke
 *
 */
public class CompileProgram implements Visitor<String, String>{

	@Override
	public String visit(PDefs p, String arg) {
		System.out.println("Visit PDefs");
		
		for(int i =0 ; i< p.listdef_.size(); i++){
			Compiler.eval(p.listdef_.get(i));
			
		}
		
		return null;
	}

}
