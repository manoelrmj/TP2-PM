public class Interface {

	private static void clearConsole(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void printBoard(){
		System.out.println("");
		for(int i=0; i<54;i++)
			System.out.print(" ");
		System.out.println("SUPER TRUNFO");
		for(int i=0;i<84;i++){
			if(i == 0)
				System.out.print("                  -");
			else
				System.out.print("-");
		}
		System.out.println("");
		

		for(int i=0;i<27;i++){
			System.out.print("                 |");
			for(int j=0;j<80;j++){
				if(j == 5 || j == 52){
					if(i == 1)
						if(j == 5)
							printName("Danilo");
						else if(j == 52)
							printName("Manoel");
						else
							System.out.print("                       ");
					else if(i >1 && i <18)
						// ij j == 5, printa a carta do jogador 1, se j == 52, carta do jogador 2
						printCard("non", i-2); // Tem 2 parametros, serão 3, o 3o será o objeto. o 1o se for = none, não printa cartas
					else if(i>19 && i <25)
						// ij j == 5, printa o deck do jogador 1, se j == 52, deck do jogador 2
						printPack("aa", i-20);
					else
						System.out.print("                       ");
				}
				else if(j > 29 && j < 47){
					if(j == 30){
						if(i > 17 && i < 21){
							printStack(i-18);
						}
						else
							System.out.print("                  ");
					}
				}
				else if(j<5 || (j>23 && j < 52) || j>75)
					System.out.print(" ");
			}
			System.out.println("|");
		}
		
		
		for(int i=0;i<84;i++){
			if(i == 0)
				System.out.print("                  -");
			else
				System.out.print("-");
		}
		System.out.println("");
	}
	
	
	private static void printName(String name){
		
		int folga1 = (23-name.length())/2;
		int folga2 = folga1;
		if((23-name.length())%2 == 1){
			folga2++;
		}
		
		for(int i =0; i<folga1; i++ )
			System.out.print(" ");
		System.out.print(name);
		for(int i =0; i<folga2; i++ )
			System.out.print(" ");
		
			
	}
	
	
	private static void printStack(int num){
		int stack = 10;
		
		switch(num){
			case 0:
				System.out.print(" ---------------- ");
				break;
			case 1:
				if(stack < 10)
					System.out.print("|   Monte:   " + stack + "   |");
				else if (stack < 100)
					System.out.print("|   Monte:  " + stack + "   |");
				else
					System.out.print("|   Monte: " + stack + "   |");
				break;
			case 2:
				System.out.print(" ---------------- ");
				break;
		}	
		
	}
	
	
	private static void printPack(String jogador, int num){ // Pack deck
		int num_cards = 10; // deck.queue.size() (? kkk)
		
		switch(num){
			case 0:
				System.out.print(" --------------------- ");
				break;
			case 1:
				System.out.print("|                     |");
				break;
			case 2:
				if(num_cards < 10)
					System.out.print("|       Deck:     " + num_cards + "   |");
				else if (num_cards < 100)
					System.out.print("|       Deck:    " + num_cards + "   |");
				else
					System.out.print("|       Deck:   " + num_cards + "   |");
				break;
			case 3:
				System.out.print("|                     |");
				break;
			case 4:
				System.out.print(" --------------------- ");
				break;
		}	
	}
		
	
	private static void printCard(String card, int num){ // card carta
		String id = "A1"; // = carta.getId();
		String name = "Urso Polar"; // = carta.getName();
		int taxa = 20;
		int importancia = 10;
		int dific = 50;
		int terror = 10;
		int trunfo = 0;
		// Tamanho da carta = 23              Altura da carta = 24
		
		String[] name_array = name.split(" ");
		
		if(card == "none")
			System.out.print("                       ");
		else{
			switch(num){
				case 0:
					System.out.print(" --------------------- ");
					break;
				case 1:
					System.out.print("/          " + id + "         \\");
					break;
				case 2:
					System.out.print("|---------------------|");
					break;
			}
					
			if(trunfo == 1){ // Se é super trunfo
				switch(num){
					case 3:
						System.out.print("|    SUPER TRUNFO     |");
						break;
					case 4:
						System.out.print("|---------------------|");
						break;
				}
			}
			else{
				switch(num){ // Se não é super trunfo
					case 3:
						System.out.print("|                     |");
						break;
					case 4:
						System.out.print("|                     |");
						break;
				}
			}
			switch(num){
				case 5:
					System.out.print("|                     |");
					break;
				case 6:
					
					int folga1 = (23-name_array[0].length())/2;
					int folga2 = folga1;
					if((23-name_array[0].length())%2 == 1){
						folga2++;
					}
					
					System.out.print("|");
					for(int i =1; i<folga1; i++ )
						System.out.print(" ");
					System.out.print(name_array[0]);
					for(int i =0; i<folga2-1; i++ )
						System.out.print(" ");
					System.out.print("|");
					break;
			}
			if (name_array.length == 1){
				switch(num){
					case 7:
						System.out.print("|                     |");
						break;
				}
			}
			if (name_array.length == 2){
				switch(num){
					case 7:
						int folga1 = (23-name_array[1].length())/2;
						int folga2 = folga1;
						if((23-name_array[1].length())%2 == 1){
							folga2++;
						}
						
						System.out.print("|");
						for(int i =1; i<folga1; i++ )
							System.out.print(" ");
						System.out.print(name_array[1]);
						for(int i =0; i<folga2-1; i++ )
							System.out.print(" ");
						System.out.print("|");
						break;
				}
			}
			switch(num){
				case 8:
					System.out.print("|                     |");
					break;
				case 9:
					System.out.print("|                     |");
					break;
				case 10:
					if(taxa < 10)
						System.out.print("| % de reprovacao:  " + taxa +" |");
					else if(taxa < 100)
						System.out.print("| % de reprovacao: " + taxa +" |");
					else
						System.out.print("| % de reprovacao:" + taxa +" |");
					break;
	
				case 11:
					if(importancia < 10)
						System.out.print("| Importancia:      " + importancia + " |");
					else if (importancia < 100)
						System.out.print("| Importancia:     " + importancia + " |");
					else
						System.out.print("| Importancia:    " + importancia + " |");
					break;
	
				case 12:
					if(dific < 10)
						System.out.print("| Dificuldade:      " + dific + " |");
					else if(dific < 100)
						System.out.print("| Dificuldade:     " + dific + " |");
					else
						System.out.print("| Dificuldade:    " + dific + " |");
					break;
	
				case 13:
					if(terror < 10)
						System.out.print("| Terror:           " + terror + " |");
					else if(terror < 100)
						System.out.print("| Terror:          " + terror + " |");
					else
						System.out.print("| Terror:         " + terror + " |");
					break;
	
				case 14:
					System.out.print("\\                     /");
					break;
				case 15:
					System.out.print(" --------------------- ");
					break;
			}
		}
	}
	
	public static void refreshInterface(){ // Atualiza a interface
		clearConsole();
		printBoard();
	}
	
	public static void main(String[] args){
		refreshInterface();
	}
}
