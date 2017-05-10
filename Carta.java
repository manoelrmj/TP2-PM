import java.util.HashMap;
import java.util.Map;

public class Carta {
	
	private Map<String, String> cardInfo = new HashMap<String, String>();
	
	public Carta() {
		// TODO Auto-generated constructor stub
	}

	public void addAttribute(String attribute, String value){
		this.cardInfo.put(attribute, value);
	}
	
	public Map<String, String> getCard(){
		return cardInfo;
	}
	
	public void printCard(){
		for (Map.Entry<String, String> entry : cardInfo.entrySet()) {
		    String key = entry.getKey().toString();
		    String value = entry.getValue();
		    System.out.print(key + ":" + value + " | ");
		}
		System.out.println();
	}
}
