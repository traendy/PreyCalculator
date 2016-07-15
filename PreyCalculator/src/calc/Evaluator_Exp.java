package calc;

import CPP.parser;
import CPP.Absyn.*;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * The evaluator for expressions
 * @author soenke
 *
 */
public class Evaluator_Exp implements Exp.Visitor<Exp, Exp>{

	
	
	@Override
	public Exp visit(ETrue p, Exp arg) {
		
		
		return p;
	}

	@Override
	public Exp visit(EFalse p, Exp arg) {		
			
		return p;
	}

	@Override
	public Exp visit(EInt p, Exp arg) {
			
		return p;
	}

	@Override
	public Exp visit(EDouble p, Exp arg) {
		
		return p;
	}

	@Override
	public Exp visit(EString p, Exp arg) {
		
		
		return p;
	}

	@Override
	public Exp visit(EId p, Exp arg) {

		return p;
	}

	
	

	@Override
	public Exp visit(EApp p, Exp arg) {
		
		return p;
		
	}
	/**
	 * If there is a increment or decrement in one way or another
	 * This removes the variable from the list. because it may
	 * cause bad output in loops
	 * @param p
	 * @param arg
	 * @return
	 */
	@Override
	public Exp visit(EPIncr p, Exp arg) {
		Exp e1= Acceptor.eval(p.exp_);
		if(e1 instanceof EId){
			String s1 = ValueHandler.eval(e1);
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				
				for(int i =ConstantsManager.constList.size()-1; i>=0; i--){
					if(ConstantsManager.constList.get(i).containsKey(s1)){
						ConstantsManager.constList.remove(i);
						return p;
					}
				}
			}
		}
		
		
		
		return p;
		
	}

	@Override
	public Exp visit(EPDecr p, Exp arg) {
		Exp e1= Acceptor.eval(p.exp_);
		if(e1 instanceof EId){
			String s1 = ValueHandler.eval(e1);
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				
				for(int i =ConstantsManager.constList.size()-1; i>=0; i--){
					if(ConstantsManager.constList.get(i).containsKey(s1)){
						ConstantsManager.constList.remove(i);
						return p;
					}
				}
			}
		}
		
		
		
		return p;
	}

	@Override
	public Exp visit(EIncr p, Exp arg) {
		Exp e1= Acceptor.eval(p.exp_);
		if(e1 instanceof EId){
			String s1 = ValueHandler.eval(e1);
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				
				for(int i =ConstantsManager.constList.size()-1; i>=0; i--){
					if(ConstantsManager.constList.get(i).containsKey(s1)){
						ConstantsManager.constList.remove(i);
						return p;
					}
				}
			}
		}
		
		
		
		return p;
	}

	@Override
	public Exp visit(EDecr p, Exp arg) {
		Exp e1= Acceptor.eval(p.exp_);
		if(e1 instanceof EId){
			String s1 = ValueHandler.eval(e1);
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				
				for(int i =ConstantsManager.constList.size()-1; i>=0; i--){
					if(ConstantsManager.constList.get(i).containsKey(s1)){
						ConstantsManager.constList.remove(i);
						return p;
					}
				}
			}
		}
		
		
		
		return p;
		
	}

	/*
	 * In case the expression contains known values it will replace
	 * variables with their respecting known values and return the
	 * corresponding expression type
	 * @see CPP.Absyn.Exp.Visitor#visit(CPP.Absyn.ETimes, java.lang.Object)
	 */
	@Override
	public Exp visit(ETimes p, Exp arg) {
		
		
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof EId){
			double d1 =0;
			d1 = ConstantsManager.findValue((ValueHandler.eval(e1).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e2 instanceof EDouble || e2 instanceof EInt){
					return new EDouble(d1* Double.parseDouble(ValueHandler.eval(e2)));
				}
				if(e2 instanceof EId){
					double d2 = 0;
					d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1*d2);
					}
				}
			}
		}
		
		if(e2 instanceof EId){
			double d2 =0;
			d2 = ConstantsManager.findValue((ValueHandler.eval(e2).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e1 instanceof EDouble || e1 instanceof EInt){
					return new EDouble(d2* Double.parseDouble(ValueHandler.eval(e1)));
				}
				if(e2 instanceof EId){
					double d1 = 0;
					d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1*d2);
					}
				}
			}
		}
		
		if(e1 instanceof EDouble || e2 instanceof EDouble){
			double out = Double.parseDouble(ValueHandler.eval(e1)) *
					 Double.parseDouble(ValueHandler.eval(e2));
			return new EDouble(out);
		}else if (e1 instanceof EInt || e2 instanceof EInt){
			int out = Integer.parseInt(ValueHandler.eval(e1)) *
					 Integer.parseInt(ValueHandler.eval(e2));
			return new EInt(out);
		}else return p;
	}

	
	/*
	 * See ETimes comment
	 * 
	 * @see CPP.Absyn.Exp.Visitor#visit(CPP.Absyn.EDiv, java.lang.Object)
	 */
	@Override
	public Exp visit(EDiv p, Exp arg) {
		
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof EId){
			
			double d1 =0;
			d1 = ConstantsManager.findValue((ValueHandler.eval(e1).trim()));
			if(ConstantsManager.isInTable){
				
				ConstantsManager.isInTable=false;
				if(e2 instanceof EDouble || e2 instanceof EInt){
					
					return new EDouble(d1 / Double.parseDouble(ValueHandler.eval(e2)));
				}
				if(e2 instanceof EId){
					
					double d2 = 0;
					d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
					ConstantsManager.printList();
					System.out.println("d2:" +d2 +"   is in tabel: " + ConstantsManager.isInTable);
					if(ConstantsManager.isInTable){
						System.out.println("reached 5");
						ConstantsManager.isInTable= false;
						double tmp = d1/d2;
						return new EDouble(tmp);
					}
				}
			}
		}
		
		if(e2 instanceof EId){
			double d2 =0;
			d2 = ConstantsManager.findValue((ValueHandler.eval(e2).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e1 instanceof EDouble || e1 instanceof EInt){
					return new EDouble(d2/ Double.parseDouble(ValueHandler.eval(e1)));
				}
				if(e1 instanceof EId){
					double d1 = 0;
					d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						
						return new EDouble(d1/d2);
					}
				}
			}
		}
		
		if(e1 instanceof EDouble || e1 instanceof EInt){
			if (e2 instanceof EDouble || e2 instanceof EInt){
				double out = Double.parseDouble(ValueHandler.eval(e1)) /
						 Double.parseDouble(ValueHandler.eval(e2));
				
				return new EDouble(out);
			}
		}
		return p;
		
	}
	/*
	 * See ETimes comment
	 * @see CPP.Absyn.Exp.Visitor#visit(CPP.Absyn.EPlus, java.lang.Object)
	 */
	@Override
	public Exp visit(EPlus p, Exp arg) {
		
		
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof EId){
			double d1 =0;
			d1 = ConstantsManager.findValue((ValueHandler.eval(e1).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e2 instanceof EDouble || e2 instanceof EInt){
					return new EDouble(d1 + Double.parseDouble(ValueHandler.eval(e2)));
				}
				if(e2 instanceof EId){
					double d2 = 0;
					d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1 + d2);
					}
				}
			}
		}
		
		if(e2 instanceof EId){
			double d2 =0;
			d2 = ConstantsManager.findValue((ValueHandler.eval(e2).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e1 instanceof EDouble || e1 instanceof EInt){
					return new EDouble(d2 + Double.parseDouble(ValueHandler.eval(e1)));
				}
				if(e2 instanceof EId){
					double d1 = 0;
					d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1 + d2);
					}
				}
			}
		}
		
		if(e1 instanceof EDouble || e2 instanceof EDouble){
			double out = Double.parseDouble(ValueHandler.eval(e1)) +
					 Double.parseDouble(ValueHandler.eval(e2));
			return new EDouble(out);
		}else if (e1 instanceof EInt || e2 instanceof EInt){
			int out = Integer.parseInt(ValueHandler.eval(e1)) +
					 Integer.parseInt(ValueHandler.eval(e2));
			
			return new EInt(out);
		}else return p;
		
		
	}
	/*
	 * See ETimes comment
	 * @see CPP.Absyn.Exp.Visitor#visit(CPP.Absyn.EMinus, java.lang.Object)
	 */
	@Override
	public Exp visit(EMinus p, Exp arg) {
		
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof EId){
			double d1 =0;
			d1 = ConstantsManager.findValue((ValueHandler.eval(e1).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e2 instanceof EDouble || e2 instanceof EInt){
					return new EDouble(d1 - Double.parseDouble(ValueHandler.eval(e2)));
				}
				if(e2 instanceof EId){
					double d2 = 0;
					d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1 - d2);
					}
				}
			}
		}
		
		if(e2 instanceof EId){
			double d2 =0;
			d2 = ConstantsManager.findValue((ValueHandler.eval(e2).trim()));
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable=false;
				if(e1 instanceof EDouble || e1 instanceof EInt){
					return new EDouble(d2 - Double.parseDouble(ValueHandler.eval(e1)));
				}
				if(e2 instanceof EId){
					double d1 = 0;
					d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
					if(ConstantsManager.isInTable){
						ConstantsManager.isInTable= false;
						return new EDouble(d1 - d2);
					}
				}
			}
		}
		if(e1 instanceof EDouble || e2 instanceof EDouble){
			double out = Double.parseDouble(ValueHandler.eval(e1)) -
					 Double.parseDouble(ValueHandler.eval(e2));
			return new EDouble(out);
		}else if (e1 instanceof EInt || e2 instanceof EInt){
			int out = Integer.parseInt(ValueHandler.eval(e1)) -
					 Integer.parseInt(ValueHandler.eval(e2));
			return new EInt(out);
		}else return p;
		
	}

	@Override
	public Exp visit(ELt p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 < d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 < d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 < d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
				if(ConstantsManager.isInTable){
					ConstantsManager.isInTable = false;
					if(d1 < d2){
						return new ETrue();
					}else 
						return new EFalse();
				
				}
			}
		}
		return p;
		
	}

	@Override
	public Exp visit(EGt p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 > d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 > d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 > d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
				if(ConstantsManager.isInTable){
					ConstantsManager.isInTable = false;
					if(d1 > d2){
						return new ETrue();
					}else 
						return new EFalse();
				
				}
			}
		}
		return p;
		
		
		
	
	}

	@Override
	public Exp visit(ELtEq p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 <= d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 <= d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 <= d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
				if(ConstantsManager.isInTable){
					ConstantsManager.isInTable = false;
					if(d1 <= d2){
						return new ETrue();
					}else 
						return new EFalse();
				
				}
			}
		}
		return p;
		
	}

	@Override
	public Exp visit(EGtEq p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 >= d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 >= d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 >= d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
				if(ConstantsManager.isInTable){
					ConstantsManager.isInTable = false;
					if(d1 >= d2){
						return new ETrue();
					}else 
						return new EFalse();
				
				}
			}
		}
		return p;
		
		
	}

	@Override
	public Exp visit(EEq p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 == d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 == d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 == d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			String s1 = ValueHandler.eval(e1).trim();
			String s2 = ValueHandler.eval(e2).trim();
			if(s1.equals(s2)){
				return new ETrue();
			}else 
				return new EFalse();
		}
		return p;
		
		
	}

	@Override
	public Exp visit(ENEq p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		if((e1 instanceof EInt || e1 instanceof EDouble) && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
			double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
			if(d1 != d2){
				return new ETrue();
			}else 
				return new EFalse();
		}
		if(e1 instanceof EId && (e2 instanceof EInt || e2 instanceof EDouble)){
			double d1 = ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d2 = Double.parseDouble(ValueHandler.eval(e2).trim());
				if(d1 != d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e2 instanceof EId && (e1 instanceof EInt || e1 instanceof EDouble)){
			double d2 = ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				double d1 = Double.parseDouble(ValueHandler.eval(e1).trim());
				if(d1 != d2){
					return new ETrue();
				}else 
					return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			String s1 = ValueHandler.eval(e1).trim();
			String s2 = ValueHandler.eval(e2).trim();
			if(!s1.equals(s2)){
				return new ETrue();
			}else 
				return new EFalse();
		}
		return p;
		
	}

	@Override
	public Exp visit(EAnd p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof ETrue && e2 instanceof ETrue){
			return new ETrue();
		}
		if(e1 instanceof EId && e2 instanceof ETrue){
			int v = (int)ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				if(v==1){
					return new ETrue();
				}else return new EFalse();
			}
			
		}
		if(e2 instanceof EId && e1 instanceof ETrue){
			int v = (int)ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				if(v==1){
					return new ETrue();
				}else return new EFalse();
			}
		}
		if(e1 instanceof EId && e2 instanceof EId){
			int v1 = (int)ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				int v2 = (int)ConstantsManager.findValue(ValueHandler.eval(e2).trim());
				if(ConstantsManager.isInTable){
					ConstantsManager.isInTable = false;
					if(v1 == 1 && v2 == 1) return new ETrue();
					else return new EFalse();
				}
			}
			
		}
		
		
		return p;
		
	}

	@Override
	public Exp visit(EOr p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		Exp e2 = Acceptor.eval(p.exp_2);
		
		if(e1 instanceof ETrue || e2 instanceof ETrue){
			return new ETrue();
		}
		if(e1 instanceof EId ){
			int v = (int)ConstantsManager.findValue(ValueHandler.eval(e1).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				if(v==1){
					return new ETrue();
				}else return new EFalse();
			}
			
		}
		if(e2 instanceof EId ){
			int v = (int)ConstantsManager.findValue(ValueHandler.eval(e2).trim());
			if(ConstantsManager.isInTable){
				ConstantsManager.isInTable = false;
				if(v==1){
					return new ETrue();
				}else return new EFalse();
			}
		}
		
		
		
		return p;
		
	}
	/**
	 * If a new Value is assigned to a variable it will be replaced in the
	 * ConstManager.constList
	 * 
	 * @param p
	 * @param arg
	 * @return
	 */
	@Override
	public Exp visit(EAss p, Exp arg) {
		Exp e1 = Acceptor.eval(p.exp_1);
		System.out.println(e1.getClass().getName());
		
		System.out.println(Acceptor.eval(p.exp_2).getClass().getName());
		Exp e2 = Acceptor.eval(p.exp_2);
		
		String s1 = ValueHandler.eval(e1).trim();
		
		if(ConstantsManager.isInTable && !(e2 instanceof EApp )){
			ConstantsManager.isInTable= false;
			int id=0;
			
			for(int i =ConstantsManager.constList.size()-1; i>=0 ; i--){
				if(ConstantsManager.constList.get(i).keySet().contains(s1)){
					id = i;
					
					ConstantsManager.isInTable = false;
				}
			}
			String s2 = ValueHandler.eval(e2).trim();
			HashMap<String, String> h = new HashMap<>();
			h.put(s1, s2);
			ConstantsManager.constList.remove(id);
			ConstantsManager.constList.add(h);
			
		}
		return p;
		
	}

	@Override
	public Exp visit(ETyped p, Exp arg) {
		
		
		return p;
	}
	
	

}
