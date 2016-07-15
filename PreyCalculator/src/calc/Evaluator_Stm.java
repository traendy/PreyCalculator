package calc;


import java.util.HashMap;

import CPP.Absyn.*;

/**
 * This class handles all kinds of statements mentioned in the grammar 
 * @author soenke
 *
 */
public class Evaluator_Stm implements Stm.Visitor<Stm, Stm>{

	@Override
	public Stm visit(SExp p, Stm arg) {
	
		SExp s= new SExp(Acceptor.eval(p.exp_));
		return s;
	}

	
	/**
	 * Todo Special case
	 */
	@Override
	public Stm visit(SDecls p, Stm arg) {
		
		
		for(int i =0; i< p.listid_.size(); i++){
			//do nothing right now
		}
		
		return p;
	}
	/**
	 * Here the new initialized value is saved in the ConstList
	 */
	@Override
	public Stm visit(SInit p, Stm arg) {
		System.out.println("Einit");
		Exp e1=Acceptor.eval(p.exp_);
		
		
		HashMap< String, String> h = new HashMap<>();
		String s1 = p.id_.trim();
		if(e1 instanceof EInt || e1 instanceof EDouble || e1 instanceof ETrue || e1 instanceof EFalse){
			String s2 = ValueHandler.eval(e1).trim();
			h.put(s1, s2);
			ConstantsManager.constList.add(h);
		}
		 
		return new SInit(p.type_, p.id_, e1);
	}

	@Override
	public Stm visit(SReturn p, Stm arg) {
	
		return new SReturn(Acceptor.eval(p.exp_));
	}

	@Override
	public Stm visit(SReturnVoid p, Stm arg) {
	return p;
	}

	@Override
	public Stm visit(SWhile p, Stm arg) {
	
		return  new SWhile(Acceptor.eval(p.exp_), Acceptor.eval(p.stm_));
	}

	@Override
	public Stm visit(SBlock p, Stm arg) {
		ListStm ls = new ListStm();
		for(int i=0; i<p.liststm_.size(); i++){
			ls.add(Acceptor.eval(p.liststm_.get(i)));		
		}
		return new SBlock(ls);
	}
	
	@Override
	public Stm visit(SIfElse p, Stm arg) {
		return new SIfElse(Acceptor.eval(p.exp_), Acceptor.eval(p.stm_1),Acceptor.eval(p.stm_2));
	}
	


}
