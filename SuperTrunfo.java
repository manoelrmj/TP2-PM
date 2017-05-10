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
		
		System.exit(0);
		
		// --------------- FUNCAO DE EXECUTAR JOGADA
		
		int turn = 1;
		String auxAttribute = "";
		while(p1.getCards().getPackLength() != 0 || p2.getCards().getPackLength() != 0){
			if(turn == 1){
				//refreshInterface(p1, true, p2, false);
				System.out.println("Jogador 1, selecionar atributo: ");
				auxAttribute = reader.next();
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
				}else{
					// Jogador 2 ganha
				}
				//refreshInterface(p1, true, p2, true);
				turn = 2;
			}else if(turn == 2){
				//refreshInterface(p1, true, p2, false);
				System.out.println("Jogador 2, selecionar atributo: ");
				auxAttribute = reader.next();
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
				}else{
					// Jogador 2 ganha
				}
				//refreshInterface(p1, true, p2, true);
				turn = 1;
			}
		}
		
		if(p1.getCards().getPackLength() != 0)
			System.out.println(p1.getName() + " venceu!");
		
		if(p2.getCards().getPackLength() != 0)
			System.out.println(p2.getName() + " venceu!");
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
