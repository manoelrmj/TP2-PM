import java.util.ArrayList;
import java.util.Map;

public class Pack {
	
	private ArrayList<Carta> cards = new ArrayList<Carta>();
	
	public Pack() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCard(Carta card){
		cards.add(card);
	}
	
	public int getPackLength(){
		return cards.size();
	}
	
	public void printCards(){
		for(int i=0; i<cards.size(); i++){
			Carta auxCard = cards.get(i);
			auxCard.printCarta();
		}
	}
}
