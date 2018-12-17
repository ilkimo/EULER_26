import java.lang.Double;
import java.math.BigDecimal;

public class Prova{
	public static void prova1(){
		double x = 0.123456789987654321235;
		String str = Double.toString(x);
		
		System.out.println(str);
	}
	
	public static void prova2(){
		//BigDecimal n = new BigDecimal(); //imparare ad usarlo (magari usare BigDecimalStringConverter
	}
	
	public static void prova3(){
		System.out.println("QUESTA E' UNA PROVA: ");
		System.out.println("Cycle found: " + ReciprocalCycles.recognise_Cycle("8449832870493781088997658899765"));
	}
	
	public static void prova4(){
		try{
			ScritturaSuFile.pulisciFile("prova.txt");
			ScritturaSuFile.scriviSuFile("prova.txt", "Questa e' una stringa di prova");
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova5(){
		try{
			ScritturaSuFile.sovrascriviSuFile("prova.txt", "jolooooo questa si che e' una prova!");
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova6(){
		String[] str = new String[]{"zero",
									"uno",
									"due",
									"tre",
									"quattro",
									"cinque"};
		
		try{
			ScritturaSuFile.scriviSuFile("prova.txt", str, false, false); //false per non andare a capo fra una stringa e l'altra
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova7(){
		String[] testo = new String[]{"Vai",
									"a",
									"quel",
									"paese",
									"hahahaha",
									"che",
									"ridere",
									"JOOOOOL"};
		
		try{
			ScritturaSuFile.sovrascriviSuFile("prova.txt", testo, true, false); //false per non andare a capo fra una stringa e l'altra
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova8(){
		try{
			ScritturaSuFile.mettiSpazio("prova.txt");
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova9(){
		try{
			ScritturaSuFile.vaiACapo("prova.txt");
			ScritturaSuFile.scriviSuFile("prova.txt", "sono un coso!");
			ScritturaSuFile.vaiACapo("prova.txt");
		}
		catch(KimoException e){
			e.message();
		}
	}
	
	public static void prova10(){
		System.out.println("Prova, risultato: " + UnitFractions.generate_Unit_Fraction(10, 3)); //secondo numero indica il numero di cifre del risultato della divisione - 1
	}
	
	public static void main(String[] args){
		//prova1();
		//prova2();
		//prova3();
		//prova4();
		//prova5();
		//prova6();
		//prova7();
		//prova8();
		//prova9();
		prova10();
	}
}