import java.lang.Double;

public class ReciprocalCycles{
	/* Problema principale:
	 *     Non so se usare variabili double basti, in quanto potrebbero generarsi numeri con parte decimale molto molto lunga,
	 *     a quel punto non saprei distinguere se il numero finisce con l'ultima cifra, o se ha una parte irrazionale che continua,
	 *     ma non posso accorgermene perche' ho raggiunto il limite di cifre del double
	 * Cominciamo a saper riconoscere da una stringa un eventuale ciclo dopo la virgola, poi possiamo evidenziare tutti i numeri
	 *     che raggiungono una lunghezza eccessiva (in cui non e' stato riconosciuto alcun ciclo) e capire se bisogna usare BigDecimal o altro
	 */
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean findCycle(String str, String sub){ //tested (sembra fungere!)
		boolean gotAnswer = false, answer = false;
		int iStr = str.length() - sub.length() - 1, iSub = sub.length() - 1;
		
		if(sub.length() == 1){
			for(int i = str.length() - 1; i > str.length() - 4 && !gotAnswer; --i){
				if(sub.charAt(iSub) != str.charAt(iStr)){
					gotAnswer = true;
					answer = false; //just to be safe
				}
			}
			if(!gotAnswer) answer = true;
		} else{
			while(!gotAnswer && iStr >= 0){
				if(sub.charAt(iSub) != str.charAt(iStr)){
					gotAnswer = true;
					answer = false; //just to be safe
				}
				
				--iSub;
				if(iSub < 0){ //fine giro di controllo
					gotAnswer = true;
					answer = true;
				}
				--iStr;
			}
		}
		//if(iStr == -1 && nGiriCompletati == 2) answer = true;
		
		return answer;
	}
	
	//PORCA PUTTNA MA BASTA CONTROLLARE DALL'ULTIMA CIFRA INVECE CHE DALLA PRIMA, IN QUESTO MODO SI EVITA LA RICORSIONE
	public static String recognise_Cycle(String str){
		String res = "";
		
		if(str.length() >= 2){
			boolean cycleFound = false;
			
			for(int i = str.length() - 1; i >= (str.length() - 1) / 2 && !cycleFound; --i){
				//controlla se c'e' un cycle (non deve ripetersi per forza fino alla cifra indice 0, basta che un pattern si ripeti almeno 2 volte)
					//se c'e', prende il numero con tante cifre decimali quante sono 1 (o un tot) giro in piu' e verifica se anche li si ripete il ciclo
						//se si, abbiamo il nostro ciclo e non serve continuare il for
				cycleFound = findCycle(str, str.substring(i));
				if(cycleFound){
					res = str.substring(i);
				}
			}
		}
		//se non e' stato trovato un ciclo, puo' ancora essere che il numero non sia abbastanza sviluppato (ci penso dopo)
		return res; //returns the cycle that is found, otherwise returns ""
	}
	
	public static String decimal_Part(String str){ //tested
		String res = "";
		boolean puntoTrovato = false;
		
		for(int i = 0; i < str.length(); ++i){
			if(puntoTrovato){
				res += str.charAt(i);
			} else{
				if(str.charAt(i) == '.'){
					puntoTrovato = true;
				}
			}
		}
		return res;
	}
	
	public static int recurring_Cycle_UnitFraction_Length(int n)throws KimoException{
		if(n == 0) throw new KimoException("Non si puo' dividere per zero");
		
		double num = UnitFractions.generate_Unit_Fraction(n);
		
		String decimalCyfers = decimal_Part(Double.toString(num)); //tested
		if(decimalCyfers.length() == 0) throw new KimoException("Number with no decimal part");
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
		//funzione che ci schiaffo una stringa e mi ritorna il ciclo che trova (in ogni caso torna qualcosa, a costo di ritornare la stringa stessa)
		//se facendo la divisione in modo piu' (con piu' cifre decimali), il ciclo che ho trovato si ripete, ho trovato un ciclo e ne so la lunghezza
		//altrimenti, o ci sono degli zeri (e boh il numero non e' irrazionale) oppure il numero continua (e allora bisogna capire se e' irrazionale)
		//capire dove mettere il limite di questi ultimi controlli
		
		String s = recognise_Cycle(decimalCyfers);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
		if(s != ""){
			System.out.println("1/" + n + " = " + num + ". Parte periodica: " + s); //NON FUNGE ANCORA, funzione riconosci ciclo probabilmente errata in qualche modo
		}
		
		return s.length();
	}
}