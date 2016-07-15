package calc;


import CPP.Absyn.*;


/**
 * 
 * Check r,a
 * @author soenke
 *
 */
public class Evaluator_Arg implements Arg.Visitor<ADecl, String>{
	/**
	 * append the string with that arg llvm stuff
	 */
	@Override
	public ADecl visit(ADecl p, String s ) {
		System.out.println("Visit ADecl");
		if(ConstantsManager.findValue(p.id_)==0){
			// abfrage ob der wert in der ddingens liste ist
		}
		// TODO Auto-generated method stub
		return p;
	}

}
