package calc;



import CPP.Absyn.*;

//The R and a has to be evaluated

public class Evaluator_Def implements Def.Visitor<DFun, DFun> {
	/**
	 * create a string for that definition and write it in the text file
	 * go through all stuff that p has nad do the same 
	 */
	@Override
	public DFun visit(DFun p, DFun arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit DFun");
		
		for(int i =0; i<p.listarg_.size(); i++){
			Acceptor.eval(p.listarg_.get(i));	
			
		}
		ListStm stmList = new ListStm();
		
		
		for(int i =0; i<p.liststm_.size(); i++){
			stmList.add(Acceptor.eval(p.liststm_.get(i)));	
		}
		
		return  new DFun(p.type_, p.id_, p.listarg_, stmList );
	}
	
	
	
}
