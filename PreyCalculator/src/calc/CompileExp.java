package calc;

import CPP.parser;
import CPP.Absyn.*;

import java.util.LinkedList;


/**
 * Find the R, and A attributes I dont know them now
 * @author soenke
 *
 */
public class CompileExp implements Exp.Visitor<CPP.Absyn.Exp, String>{
/**
 * Most of the functions are her always return the appended string that schould be it
 */
	
	
	@Override
	public Exp visit(ETrue p, String arg) {
		// TODO Auto-generated method stub		
		System.out.println("Visit ETrue");	
		
		java_cup.runtime.Symbol res = parser.class.parse();
		return null;
	}

	@Override
	public Exp visit(EFalse p, String arg) {		
		System.out.println("Visit EFalse");		
		return null;
	}

	@Override
	public Exp visit(EInt p, String arg) {
		System.out.println("Visit EInt");	
		return null;
	}

	@Override
	public Exp visit(EDouble p, String arg) {
		System.out.println("Visit Double");
		return null;
	}

	@Override
	public Exp visit(EString p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EString");
		
		return null;
	}

	@Override
	public Exp visit(EId p, String arg) {
		System.out.println("Visit EId");
		
		
		return null;
	}

	
	

	@Override
	public Exp visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		if(p.listexp_.size()==0){
			return null;
		
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
			String s2 ="fun: "+ p.id_+"( " + s + " )";
			return null;
		}
		
	}

	@Override
	public Exp visit(EPIncr p, String arg) {
		
		System.out.println("Visit EPIncr");
		
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EPDecr p, String arg) {
		
		System.out.println("Visit EPDecr");
		return null;
	}

	@Override
	public Exp visit(EIncr p, String arg) {
		System.out.println("Visit EIncr");
	
		//return "%"+ (Module.level-1);
		return null;
	}

	@Override
	public Exp visit(EDecr p, String arg) {
		System.out.println("Visit EDecr");
	
		return null;
		//return "%"+ (Module.level-1);
	}

	/*
	 * Überarbeiten es soll der wert der varibalen aus dem constlist geholt werden 
	 * dafür gibt es bereits eine funktion
	 * es gibt also 4 fälle
	 * beides sind variablen
	 * eine ist variable eine ist const
	 * eine ist cont eine ist var
	 * und beide sind const
	 * 
	 * @see CPP.Absyn.Exp.Visitor#visit(CPP.Absyn.ETimes, java.lang.Object)
	 */
	@Override
	public Exp visit(ETimes p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETimes");
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		double d1=0.0f;
		double d2=0.0f;
		boolean isd1 = false;
		boolean isd2 = false;
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		//if(e1 instanceof EInt)
		if(e1.contains("fun")|| e2.contains("fun")){
			//dont change tree
			return null;
		}
		if(ConstantsManager.findValue(e1.split(":")[1])==0 || ConstantsManager.findValue(e2.split(":")[1])==0){
			if(!ConstantsManager.isInTable){
				ConstantsManager.isInTable = true;
				//dont change tree
				return null;
 			}
		}
		if(e1.contains("id")){
			String str []= e1.split(":");
			 d1= ConstantsManager.findValue(str[1]);
			 isd1=true;
		}
		if(e2.contains("id")){
			String str []= e2.split(":");
			 d2= ConstantsManager.findValue(str[1]);
			 isd2=true;
		}
		//if both are known constants
		if(isNumber(e1) && isNumber(e2)){
			d1 = Double.parseDouble(e1);
			d2 = Double.parseDouble(e2);
			
			// if the first is known constant the other is a number
		}else if(isd1 && isNumber(e2)){
			d2 = Double.parseDouble(e2);
			//if the first is number the second one is known constatn
		}else if(isd2 && isNumber(e1)){
			d1 = Double.parseDouble(e1);
		}
		
		if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
		    outInt=(int) (d1*d2);
		    changeAST();
		}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
			outDouble= d1*d2;
			changeAST();
		}
		return null;
		//return "%"+ (Module.level-1);
		
	}

	

	@Override
	public Exp visit(EDiv p, String arg) {
		// TODO Auto-generated method stub
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		double d1=0.0f;
		double d2=0.0f;
		boolean isd1 = false;
		boolean isd2 = false;
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		//if(e1 instanceof EInt)
		if(e1.contains("fun")|| e2.contains("fun")){
			//dont change tree
			return null;
		}
		if(ConstantsManager.findValue(e1.split(":")[1])==0 || ConstantsManager.findValue(e2.split(":")[1])==0){
			if(!ConstantsManager.isInTable){
				ConstantsManager.isInTable = true;
				//dont change tree
				return null;
 			}
		}
		if(e1.contains("id")){
			String str []= e1.split(":");
			 d1= ConstantsManager.findValue(str[1]);
			 isd1=true;
		}
		if(e2.contains("id")){
			String str []= e2.split(":");
			 d2= ConstantsManager.findValue(str[1]);
			 isd2=true;
		}
		//if both are known constants
		if(isNumber(e1) && isNumber(e2)){
			d1 = Double.parseDouble(e1);
			d2 = Double.parseDouble(e2);
			
			// if the first is known constant the other is a number
		}else if(isd1 && isNumber(e2)){
			d2 = Double.parseDouble(e2);
			//if the first is number the second one is known constatn
		}else if(isd2 && isNumber(e1)){
			d1 = Double.parseDouble(e1);
		}
		
		if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
		    outInt=(int) (d1*d2);
		    changeAST();
		}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
			outDouble= d1*d2;
			changeAST();
		}
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EPlus p, String arg) {
		
		System.out.println("Visit EPlus");
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		double d1=0.0f;
		double d2=0.0f;
		boolean isd1 = false;
		boolean isd2 = false;
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		//if(e1 instanceof EInt)
		if(e1.contains("fun")|| e2.contains("fun")){
			//dont change tree
			return null;
		}
		if(ConstantsManager.findValue(e1.split(":")[1])==0 || ConstantsManager.findValue(e2.split(":")[1])==0){
			if(!ConstantsManager.isInTable){
				ConstantsManager.isInTable = true;
				//dont change tree
				return null;
 			}
		}
		if(e1.contains("id")){
			String str []= e1.split(":");
			 d1= ConstantsManager.findValue(str[1]);
			 isd1=true;
		}
		if(e2.contains("id")){
			String str []= e2.split(":");
			 d2= ConstantsManager.findValue(str[1]);
			 isd2=true;
		}
		//if both are known constants
		if(isNumber(e1) && isNumber(e2)){
			d1 = Double.parseDouble(e1);
			d2 = Double.parseDouble(e2);
			
			// if the first is known constant the other is a number
		}else if(isd1 && isNumber(e2)){
			d2 = Double.parseDouble(e2);
			//if the first is number the second one is known constatn
		}else if(isd2 && isNumber(e1)){
			d1 = Double.parseDouble(e1);
		}
		
		if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
		    outInt=(int) (d1*d2);
		    changeAST();
		}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
			outDouble= d1*d2;
			changeAST();
		}
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EMinus p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EMinus");
		
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		double d1=0.0f;
		double d2=0.0f;
		boolean isd1 = false;
		boolean isd2 = false;
		String out ="";
		int outInt =0;
		double outDouble= 0.0f;
		//if(e1 instanceof EInt)
		if(e1.contains("fun")|| e2.contains("fun")){
			//dont change tree
			return null;
		}
		if(ConstantsManager.findValue(e1.split(":")[1])==0 || ConstantsManager.findValue(e2.split(":")[1])==0){
			if(!ConstantsManager.isInTable){
				ConstantsManager.isInTable = true;
				//dont change tree
				return null;
 			}
		}
		if(e1.contains("id")){
			String str []= e1.split(":");
			 d1= ConstantsManager.findValue(str[1]);
			 isd1=true;
		}
		if(e2.contains("id")){
			String str []= e2.split(":");
			 d2= ConstantsManager.findValue(str[1]);
			 isd2=true;
		}
		//if both are known constants
		if(isNumber(e1) && isNumber(e2)){
			d1 = Double.parseDouble(e1);
			d2 = Double.parseDouble(e2);
			
			// if the first is known constant the other is a number
		}else if(isd1 && isNumber(e2)){
			d2 = Double.parseDouble(e2);
			//if the first is number the second one is known constatn
		}else if(isd2 && isNumber(e1)){
			d1 = Double.parseDouble(e1);
		}
		
		if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) && ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))) {
		    outInt=(int) (d1*d2);
		    changeAST();
		}else if (((d1 == Math.floor(d1)) && !Double.isInfinite(d1)) || ((d2 == Math.floor(d2)) && !Double.isInfinite(d2))){
			outDouble= d1*d2;
			changeAST();
		}
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(ELt p, String arg) {
		
		System.out.println("Visit ELt");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EGt p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGt");
		
		return null;
		//return "%"+ (Module.level-1);
	
	}

	@Override
	public Exp visit(ELtEq p, String arg) {
		
		System.out.println("Visit ELtEq");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EGtEq p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGtEq");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EEq p, String arg) {
		System.out.println("Visit EEq");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(ENEq p, String arg) {
		System.out.println("Visit ENEq");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EAnd p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EAnd");
	
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EOr p, String arg) {
		System.out.println("Visit EOr");
		
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(EAss p, String arg) {
		
		System.out.println("Visit EAss");
		/*
		 * If value known set value not id
		 */
		return null;
		//return "%"+ (Module.level-1);
	}

	@Override
	public Exp visit(ETyped p, String arg) {
		
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
