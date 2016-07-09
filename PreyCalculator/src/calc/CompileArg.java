package calc;


import CPP.Absyn.*;


/**
 * 
 * Check r,a
 * @author soenke
 *
 */
public class CompileArg implements Arg.Visitor<String, String>{
	/**
	 * append the string with that arg llvm stuff
	 */
	@Override
	public String visit(ADecl p, String arg) {
		System.out.println("Visit ADecl");
		
		// TODO Auto-generated method stub
		return null;
	}

}
