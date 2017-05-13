public class Jogador {

	private int id;
	private String name;
	//private LinkedList<Carta> cards;
	private Pack playerPack = new Pack();

	public Jogador(){
		
	}
	
	public Jogador(int id, String name){
		this.name = name;
		this.id = id;
		//this.playerPack = new Pack();
	}
	
	/**
	 * @return the cards
	 */
	public Pack getPack() {
		return playerPack;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(Pack cards) {
		this.playerPack = cards;
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
	
	public void addCard(Carta card){
		playerPack.addCard(card);
	}
	
	public Carta getCard(){
		return this.playerPack.getCard();
	}

}
