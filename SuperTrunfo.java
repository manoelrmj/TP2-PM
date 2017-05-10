import java.util.ArrayList;
import java.util.Scanner;

public class SuperTrunfo implements Game {
	
	private String cardsFilePath;
	private Pack pack;
	Jogador p1, p2;
	
	public SuperTrunfo(String cardsFilePath) {
		this.cardsFilePath = cardsFilePath;
	}

	@Override
	public void initialize() {
		IO IOHandler = IO.getInstance();
		IOHandler.setFilePath(cardsFilePath);
		pack = IOHandler.buildPack();
		//pack.printCards();
	}

	@Override
	public void startGame() {
		Scanner reader = new Scanner(System.in);
		System.out.println(":: :: SUPER TRUNFO :: ::");
		
		System.out.println("Insira o nome do jogador 1: ");
		p1 = new Jogador();
		p1.setName(reader.next());
		p1.setId(1);
		
		System.out.println("Insira o nome do jogador 2: ");
		p2 = new Jogador();
		p2.setName(reader.next());
		p2.setId(2);
		
		splitPack();
		
		System.out.println("Cartas do jogador 1:");
		p1.getCards().printCards();
		System.out.println("-------------------------------");
		System.out.println("Cartas do jogador 2:");
		p2.getCards().printCards();
		System.out.println("-------------------------------");
	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the cardsFilePath
	 */
	public String getCardsFilePath() {
		return cardsFilePath;
	}

	/**
	 * @param cardsFilePath the cardsFilePath to set
	 */
	public void setCardsFilePath(String cardsFilePath) {
		this.cardsFilePath = cardsFilePath;
	}
	
	private void splitPack(){
		int packLength = pack.getPackLength();
		
		for(int i=0; i<packLength/2; i++)
			p1.addCard(pack.getCard());
		
		
		for(int j=0; j<packLength/2; j++)
			p2.addCard(pack.getCard());
		
	}

}
