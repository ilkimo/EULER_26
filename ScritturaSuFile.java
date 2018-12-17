import java.io.*;

public class ScritturaSuFile{
	//costruttore FileWriter: FileWriter​(fileName)
	//BufferedWriter.write​(String s, int off, int len)
	
	public static void sovrascriviSuFile(String fileName, String str)throws KimoException{ //tested
		pulisciFile(fileName);
		scriviSuFile(fileName, str);
	}
	
	public static void pulisciFile(String fileName)throws KimoException{ //tested
		BufferedWriter b = null;
		
		try{
			b = new BufferedWriter(new FileWriter(fileName, false));
			b.write("");
		}
		catch(IOException e){
			throw new KimoException("ScritturaSuFile.pulisciFile: Problemi con il file: " + fileName);
		}
		finally{
			try{
				b.close();
			}
			catch(IOException e){
				throw new KimoException("ScritturaSuFile.pulisciFile: Problemi con il file: " + fileName);
			}
		}
	}
	
	public static void scriviSuFile(String fileName, String str)throws KimoException{ //tested
		BufferedWriter b = null;
		
		try{
			b = new BufferedWriter(new FileWriter(fileName, true));
			b.write(str);
		}
		catch(IOException e){
			System.out.println("ScritturaSuFile.scriviSuFile: Exception handling ancora da sistemare");
		}
		finally{
			try{
				b.close();
			}
			catch(IOException e){
				throw new KimoException("ScritturaSuFile.scriviSuFile(String fileName, String str): Problemi con la chiusura del file: " + fileName);
			}
		}
		
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static void sovrascriviSuFile(String fileName, String[] str, boolean andareACapo, boolean mettiSpazi)throws KimoException{ //dovrebbe essere finita
		//andareACapo == true implica che al termine di ogni stringa nel file si andra' a capo, altrimenti le concatena tutte
		//mettiSpazi == true mette uno spazio fra una riga e l'altra (se vai a capo non serve zio)
		pulisciFile(fileName);
		scriviSuFile(fileName, str, andareACapo, mettiSpazi); //la firma sara' con String[] str
	}
	
	public static  void scriviSuFile(String fileName, String[] str, boolean andareACapo, boolean mettiSpazi)throws KimoException{
		BufferedWriter b = null;
		
		try{
			b = new BufferedWriter(new FileWriter(fileName, true));
			
			for(int i = 0; i < str.length; ++i){
				b.write(str[i]);
				
				if(andareACapo){
					b.newLine();
				}
				
				if(mettiSpazi){
					b.write(" ");
				}
			}
		}
		catch(IOException e){
			throw new KimoException("ScritturaSuFile.scriviSuFile: problemi con il file: " + fileName);
		}
		finally{
			try{
				b.close();
			}
			catch(IOException e){
				throw new KimoException("ScritturaSuFile.scriviSuFile: problemi con il file: " + fileName);
			}
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static void mettiSpazio(String fileName)throws KimoException{
		BufferedWriter b = null;
		
		try{
			b = new BufferedWriter(new FileWriter(fileName, true)); //true per appendere e non sovrascrivere
			b.write(" ");
		}
		catch(IOException e){
			throw new KimoException("ScritturaSuFile.mettiSpazio: Problemi con il file " + fileName);
		}
		finally{
			try{
				b.close();
			}
			catch(IOException e){
				throw new KimoException("ScritturaSuFile.mettiSpazio: Problemi (nel finally) con il file " + fileName);
			}
		}
	}
	
	public static void vaiACapo(String fileName)throws KimoException{ //MALFUNZIONAMENTO: non va a capo 2 volte, e lo fa solo a fine robe (insomma fa schifo)
		if(fileName != ""){
			throw new KimoException("ScritturaSuFile.vaiACapo: METODO NON FUNZIONANTE, NON USARE!");
		}
	
		BufferedWriter b = null;
		
		try{
			b = new BufferedWriter(new FileWriter(fileName, true)); //true per appendere e non sovrascrivere
			b.newLine();
		}
		catch(IOException e){
			throw new KimoException("ScritturaSuFile.vaiACapo: Problemi con il file: " + fileName);
		}
		finally{
			try{
				b.close();
			}
			catch(IOException e){
				throw new KimoException("ScritturaSuFile.vaiACapo: Problemi (nel finally) con il file: " + fileName);
			}
		}
	}
}