import java.util.LinkedList;
import java.util.Map;
import java.util.Collections;
import java.util.Random;

public class Pack {
	
	private LinkedList<Carta> cards = new LinkedList<Carta>();
	private double array[] = new double[4];
	
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

	public LinkedList<Carta> getCards(){
		return cards;
	}

	public void shuffle(){
		Random random = new Random(55);
		Collections.shuffle(cards, random);		
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

	public double[] biggestNumbers(){
		for(int i=0; i<4; i++){
			array[i] = 0;
		}	
		for(int i=0; i<cards.size(); i++){
			int j = 0;
			Carta auxCard = cards.get(i);
			for (Map.Entry<String, String> entry : auxCard.getCard().entrySet()) {
				if(j != 6){
				    String key = entry.getKey().toString();
				    String value = entry.getValue();

				    if(!key.equals("Id") && !key.equals("Nome") && !key.equals("Trunfo")){
					    if(Double.parseDouble(value) > array[j])
					    	array[j] = Double.parseDouble(value);
					}
					else
						j--;
				}
				else
					j--;
				j++;
			}
		}
		return array;
	}


	public String botChoise(double[] array, Carta card){
		int j = 0;
		int i = 0;
		double porcent = 0;
		String best = "";
		for (Map.Entry<String, String> entry : card.getCard().entrySet()) {
			if(j != 6){
			    String key = entry.getKey().toString();
			    String value = entry.getValue();
			    if(!key.equals("Id") && !key.equals("Nome") && !key.equals("Trunfo")){

					if(Double.parseDouble(value)/array[i] > porcent){
						porcent = Double.parseDouble(value)/array[i];
						best = key;
					}
				    i++;
				}
				else
					j--;
			}
			else
				j--;
			j++;
		}
		return best;
	}

}
