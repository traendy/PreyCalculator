package calc;

import CPP.Absyn.*;

import java.util.LinkedList;


/**
 * Find the R, and A attributes I dont know them now
 * @author soenke
 *
 */
public class CompileExp implements Exp.Visitor<String, String>{
/**
 * Most of the functions are her always return the appended string that schould be it
 */
	
	
	@Override
	public String visit(ETrue p, String arg) {
		// TODO Auto-generated method stub		
		System.out.println("Visit ETrue");		
		return "1 ";
	}

	@Override
	public String visit(EFalse p, String arg) {		
		System.out.println("Visit EFalse");		
		return "0 ";
	}

	@Override
	public String visit(EInt p, String arg) {
		System.out.println("Visit EInt");	
		return p.integer_.toString()+ " ";
	}

	@Override
	public String visit(EDouble p, String arg) {
		System.out.println("Visit Double");
		return (p.double_.toString()+" ");
	}

	@Override
	public String visit(EString p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EString");
		
		return p.string_ +" ";
	}

	@Override
	public String visit(EId p, String arg) {
		System.out.println("Visit EId");
		checkID();
		
		return "%"+p.id_+ " ";
	}

	
	private void checkID() {
	/*
	 * case is known and has a value change id in code with this value	
	 */
	}

	@Override
	public String visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		if(p.listexp_.size()==0){
			return "call "+p.id_+"()";
		
		}else{
			LinkedList<String> k= new LinkedList<>();
			String s="";
			for(int index = 0; index < p.listexp_.size(); index++){
				 k.add( Compiler.eval(p.listexp_.get(index)));
			}
			for(int i = 0; i<k.size()-1; i++){
				s+=" i32 "+ k.get(i)+",";
			}
			s+= "i32 "+ k.getLast();
			String s2 ="call "+ p.id_+"( " + s + " )";
			return s2;
		}
		
	}

	@Override
	public String visit(EPIncr p, String arg) {
		
		System.out.println("Visit EPIncr");
		
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EPDecr p, String arg) {
		
		System.out.println("Visit EPDecr");
		return "";
	}

	@Override
	public String visit(EIncr p, String arg) {
		System.out.println("Visit EIncr");
	
		//return "%"+ (Module.level-1);
		return "";
	}

	@Override
	public String visit(EDecr p, String arg) {
		System.out.println("Visit EDecr");
	
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ETimes p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETimes");
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		if(isNumber(e1)&& isNumber(e2)){
			double d1 = Double.parseDouble(e1);
			double d2 = Double.parseDouble(e2);
			if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
			    outInt=(int) (d1*d2);
			    changeAST();
			}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
				outDouble= d1*d2;
				changeAST();
			}
		}
		
		return "";
		//return "%"+ (Module.level-1);
		
	}

	

	@Override
	public String visit(EDiv p, String arg) {
		// TODO Auto-generated method stub
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		if(isNumber(e1)&& isNumber(e2)){
			double d1 = Double.parseDouble(e1);
			double d2 = Double.parseDouble(e2);
			if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
			    outInt=(int) (d1/d2);
			    changeAST();
			}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
				outDouble= d1/d2;
				changeAST();
			}
		}
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EPlus p, String arg) {
		
		System.out.println("Visit EPlus");
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		if(isNumber(e1)&& isNumber(e2)){
			double d1 = Double.parseDouble(e1);
			double d2 = Double.parseDouble(e2);
			if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
			    outInt=(int) (d1+d2);
			    changeAST();
			}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
				outDouble= d1+d2;
				changeAST();
			}
		}
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EMinus p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EMinus");
		
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		if(isNumber(e1)&& isNumber(e2)){
			double d1 = Double.parseDouble(e1);
			double d2 = Double.parseDouble(e2);
			if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
			    outInt=(int) (d1-d2);
			    changeAST();
			    
			}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
				outDouble= d1-d2;
				changeAST();
			}
		}
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ELt p, String arg) {
		
		System.out.println("Visit ELt");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EGt p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGt");
		
		return "";
		//return "%"+ (Module.level-1);
	
	}

	@Override
	public String visit(ELtEq p, String arg) {
		
		System.out.println("Visit ELtEq");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EGtEq p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGtEq");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EEq p, String arg) {
		System.out.println("Visit EEq");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ENEq p, String arg) {
		System.out.println("Visit ENEq");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EAnd p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EAnd");
	
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EOr p, String arg) {
		System.out.println("Visit EOr");
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EAss p, String arg) {
		
		System.out.println("Visit EAss");
		/*
		 * If value known set value not id
		 */
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ETyped p, String arg) {
		
		System.out.println("Visit ETyped");
		return null;
	}
	
	public static boolean isNumber(String s){
		for(char c: s.trim().toCharArray()) {
			
			if(!Character.isDigit(c))return false;
			
		}return true;
		
	}
	public void changeAST() {
		// TODO Auto-generated method stub
		
	}

}
