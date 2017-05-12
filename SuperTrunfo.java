import java.io.IOException;
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
		
		// --------------- FUNCAO DE EXECUTAR JOGADA
		
		int turn = 1;
		String auxAttribute = "";
		pack.shuffle();
		while(p1.getCards().getPackLength() != 0 || p2.getCards().getPackLength() != 0){
			if(turn == 1){
				Interface.refreshInterface(p1, true, p2, false, pack);
				System.out.println(p1.getName() + ", selecione um atributo: ");
				auxAttribute = reader.next();
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					pack.shuffle();
					while(pack.getPackLength() != 0){
						p1.addCard(pack.getCard());
					}
					System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					turn = 1;
				}else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) < Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					pack.shuffle();
					while(pack.getPackLength() != 0){
						p2.addCard(pack.getCard());
					}
					System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Jogador 2 ganha
					turn = 2;
				}else{ // empate
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					System.out.println("Empate! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					turn = 2;
				}
			}else if(turn == 2){
				Interface.refreshInterface(p1, false, p2, true, pack);
				System.out.println(p2.getName() + ", selecione um atributo: ");
				auxAttribute = reader.next();
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				//Interface.refreshInterface(p1, true, p2, true, pack);
				if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					pack.shuffle();
					while(pack.getPackLength() != 0){
						p1.addCard(pack.getCard());
					}
					System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					turn = 1;
				}else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) < Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 2 ganha
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					pack.shuffle();
					while(pack.getPackLength() != 0){
						p2.addCard(pack.getCard());
					}
					System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					turn = 2;
				}else{ // empate
					Interface.refreshInterface(p1, true, p2, true, pack);
					pack.addCard(p1.getCards().getCard());
					pack.addCard(p2.getCards().getCard());
					System.out.println("Empate! Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					turn = 1;
				}
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
