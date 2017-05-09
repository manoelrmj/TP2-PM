import java.util.ArrayList;

public class Jogador {

	private int id;
	private String name;
	private ArrayList<Carta> cards;

	/**
	 * @return the cards
	 */
	public ArrayList<Carta> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<Carta> cards) {
		this.cards = cards;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
