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

	private static void clearConsole(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	@Override
	public void startGame() {
		Scanner reader = new Scanner(System.in);
		clearConsole();
		System.out.println(":: :: SUPER TRUNFO :: ::\n");
		double biggestNumbers[] = new double[4];
		biggestNumbers = pack.biggestNumbers();

		System.out.println("1: 1 Jogador");
		System.out.println("2: 2 Jogadores\n");
		System.out.println("Selecione o numero do modo: ");

		String mode = reader.next();
		
		if(mode.equals("1")){
			System.out.println("Insira o seu nome: ");
		}
		else
			System.out.println("Insira o nome do jogador 1: ");

		p1 = new Jogador();
		p1.setName(reader.next());
		p1.setId(1);
		
		p2 = new Jogador();

		if(mode.equals("2")){
			System.out.println("Insira o nome do jogador 2: ");
			p2.setName(reader.next());
		}
		else{
			p2.setName("Bot");
		}
		p2.setId(2);
		
		splitPack();
		
		// --------------- FUNCAO DE EXECUTAR JOGADA
		
		int turn = 1;
		String auxAttribute = "";
		pack.shuffle();
		while(p1.getCards().getPackLength() != 0 && p2.getCards().getPackLength() != 0){
			if(turn == 1){
				Interface.refreshInterface(p1, true, p2, false, pack);
				System.out.println(p1.getName() + ", selecione um atributo: ");
				auxAttribute = reader.next();
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				Interface.refreshInterface(p1, true, p2, true, pack);
				pack.addCard(p1.getCards().getCard());
				pack.addCard(p2.getCards().getCard());
				pack.shuffle();
				if(auxCardP1.getCard().get("Trunfo").equals("1")){
					char type = auxCardP2.getCard().get("Id").charAt(1);
					if(type == 'A'){
						while(pack.getPackLength() != 0){
							p2.addCard(pack.getCard());
						}
						System.out.println(p1.getName() + " possui o SUPER TRUNFO! Porem " + p2.getName() + " possui uma carta do tipo A");
						System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 2;
					}
					else{
						while(pack.getPackLength() != 0){
							p1.addCard(pack.getCard());
						}
						System.out.println(p1.getName() + " possui o SUPER TRUNFO! " + p2.getName() + " nao possui uma carta do tipo A");
						System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 1;
					}
				}
				else if(auxCardP2.getCard().get("Trunfo").equals("1")){
					char type = auxCardP1.getCard().get("Id").charAt(1);
					if(type == 'A'){
						while(pack.getPackLength() != 0){
							p1.addCard(pack.getCard());
						}
						System.out.println(p2.getName() + " possui o SUPER TRUNFO! Porem " + p1.getName() + " possui uma carta do tipo A");
						System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 1;
					}
					else{
						while(pack.getPackLength() != 0){
							p2.addCard(pack.getCard());
						}
						System.out.println(p2.getName() + " possui o SUPER TRUNFO! " + p1.getName() + " nao possui uma carta do tipo A");
						System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 2;
					}
				} 
				else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
					while(pack.getPackLength() != 0){
						p1.addCard(pack.getCard());
					}
					System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
					turn = 1;
				}else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) < Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					while(pack.getPackLength() != 0){
						p2.addCard(pack.getCard());
					}
					System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
					// Jogador 2 ganha
					turn = 2;
				}else{ // empate
					System.out.println("Empate! Pressione enter para continuar");
					turn = 2;
				}
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(turn == 2){
				Interface.refreshInterface(p1, false, p2, true, pack);
				if(mode.equals("2")){
					System.out.println(p2.getName() + ", selecione um atributo: ");
					auxAttribute = reader.next();
				}
				else{
					System.out.println(p2.getName() + " esta selecionando um atributo.");
					auxAttribute = p2.getCards().botChoise(biggestNumbers, p2.getCards().showCard());
					System.out.println(p2.getName() + " selecionou o atributo " + auxAttribute + ". Pressione enter para continuar");
					try {
						System.in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Carta auxCardP1 = p1.getCards().showCard();
				Carta auxCardP2 = p2.getCards().showCard();
				Interface.refreshInterface(p1, true, p2, true, pack);
				pack.addCard(p1.getCards().getCard());
				pack.addCard(p2.getCards().getCard());
				pack.shuffle();
				if(auxCardP2.getCard().get("Trunfo").equals("1")){
					char type = auxCardP1.getCard().get("Id").charAt(1);
					if(type == 'A'){
						while(pack.getPackLength() != 0){
							p1.addCard(pack.getCard());
						}
						System.out.println(p2.getName() + " possui o SUPER TRUNFO! Porem " + p1.getName() + " possui uma carta do tipo A");
						System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 1;
					}
					else{
						while(pack.getPackLength() != 0){
							p2.addCard(pack.getCard());
						}
						System.out.println(p2.getName() + " possui o SUPER TRUNFO! " + p1.getName() + " nao possui uma carta do tipo A");
						System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 2;
					}
				}
				else if(auxCardP1.getCard().get("Trunfo").equals("1")){
					char type = auxCardP2.getCard().get("Id").charAt(1);
					if(type == 'A'){
						while(pack.getPackLength() != 0){
							p2.addCard(pack.getCard());
						}
						System.out.println(p1.getName() + " possui o SUPER TRUNFO! Porem " + p2.getName() + " possui uma carta do tipo A");
						System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 2;
					}
					else{
						while(pack.getPackLength() != 0){
							p1.addCard(pack.getCard());
						}
						System.out.println(p1.getName() + " possui o SUPER TRUNFO! " + p2.getName() + " nao possui uma carta do tipo A");
						System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
						turn = 1;
					}
				} 
				else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) > Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 1 ganha
					while(pack.getPackLength() != 0){
						p1.addCard(pack.getCard());
					}
					System.out.println(p1.getName() + " venceu a rodada! Pressione enter para continuar");
					turn = 1;
				}else if(Double.parseDouble(auxCardP1.getCard().get(auxAttribute)) < Double.parseDouble(auxCardP2.getCard().get(auxAttribute))){
					// Jogador 2 ganha
					while(pack.getPackLength() != 0){
						p2.addCard(pack.getCard());
					}
					System.out.println(p2.getName() + " venceu a rodada! Pressione enter para continuar");
					turn = 2;
				}else{ // empate
					System.out.println("Empate! Pressione enter para continuar");
					turn = 1;
				}
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
