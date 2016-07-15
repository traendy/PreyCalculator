package calc;

import CPP.Absyn.ListDef;
import CPP.Absyn.PDefs;
import CPP.Absyn.Program.Visitor;


/**
 * The evaluator for PDefs
 * @author soenke
 *
 */
public class Evaluator_Program implements Visitor<PDefs, PDefs>{

	@Override
	public PDefs visit(PDefs p, PDefs arg) {
		System.out.println("Visit PDefs");
		ListDef ld = new ListDef();
		for(int i =0 ; i< p.listdef_.size(); i++){
			ld.add(Acceptor.eval(p.listdef_.get(i)));
			
		}
		
		return new PDefs(ld);
	}

}
