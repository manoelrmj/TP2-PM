import java.util.LinkedList;
import java.util.Map;

public class Pack {
	
	private LinkedList<Carta> cards = new LinkedList<Carta>();
	
	public Pack() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCard(Carta card){
		//card.printCard();
		cards.addLast(card);
	}
	
	public Carta getCard(){
		Carta auxCard = cards.poll();
		return auxCard;
	}
	
	public Carta showCard(){
		Carta auxCard = cards.getFirst();
		return auxCard;
	}
	
	public int getPackLength(){
		return cards.size();
	}
	
	public void printCards(){
		for(int i=0; i<cards.size(); i++){
			Carta auxCard = cards.get(i);
			for (Map.Entry<String, String> entry : auxCard.getCard().entrySet()) {
			    String key = entry.getKey().toString();
			    String value = entry.getValue();
			    System.out.print(key + ":" + value + " | ");
			}
			System.out.println();
		}
	}
}
