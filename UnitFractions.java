import java.math.BigInteger;
import java.lang.Integer;

public class UnitFractions{
	public static double generate_Unit_Fraction(int n){
		return (double)1 / (double)n;
	}
	
	public static String generate_Unit_Fraction(int n, int dimPrecisione){
		String dividendo = "1";
		BigInteger num = new BigInteger(new Integer(n).toString());
		
		for(int i = 0; i < dimPrecisione; ++i){ //aumenta la dimensione del numero, in modo che poi dividendo ci saranno piu' cifre decimali
			dividendo += "0";
		}
		
		//System.out.println(dividendo);
		
		BigInteger risultato = new BigInteger("0");
		
		//RIPRENDI DA QUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
		
		return "SeS"; //cancellami
	}
}