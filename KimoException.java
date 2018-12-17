public class KimoException extends Exception{
	String errMsg = "SoS";
	
	public KimoException(){
		this.errMsg = "Messaggio di errore non impostato";
	}
	
	public KimoException(String errorMessage){
		this.errMsg = errorMessage;
	}
	
	public void message(){
		System.out.println(this.errMsg);
	}
}