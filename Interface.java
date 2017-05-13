import java.util.Map;

public class Interface {

	private static void clearConsole(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void printBoard(Jogador j1, boolean b1, Jogador j2, boolean b2, Pack monte){
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
					if(i == 1){
						if(j == 5)
							printName(j1.getName());
						else if(j == 52)
							printName(j2.getName());
						else
							System.out.print("                       ");
					}
					else if(i >1 && i <18){

						if(j == 5)
							printCard(j1.getPack().showCard(), b1, i-2);
						else if(j == 52)
							printCard(j2.getPack().showCard(), b2, i-2);
						else
							System.out.print("                       ");
					}
					else if(i>19 && i <25){
						if(j == 5)
							printPack(j1.getPack(), i-20); // Jogador 1
						else if(j == 52)
							printPack(j2.getPack(),i-20); // Jogador 2
						else
							System.out.print("                       ");
					}
					else
						System.out.print("                       ");
				}
				else if(j > 29 && j < 47){
					if(j == 30){
						if(i > 17 && i < 21){
							printStack(monte, i-18);
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
	
	
	private static void printStack(Pack deck, int num){
		int stack = deck.getPackLength();
		
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
	
	
	private static void printPack(Pack deck, int num){ // Pack deck
		int num_cards = deck.getPackLength();
		
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
		
	
	private static void printCard(Carta card, boolean bool, int num){ // card carta		
		if(bool == false)
			System.out.print("                       ");
		else{

			String attributes[] = new String[7];
			String attributes2[] = new String[7];

			int j = 0;
			for (Map.Entry<String, String> entry : card.getCard().entrySet()) {
			    attributes[j] = entry.getKey().toString(); // key
			    attributes2[j] = entry.getValue(); 
			    j++;
			}
			
			//String id = "A1"; // = carta.getId();
			//String name = "Urso Polar"; // = carta.getName();
			// Tamanho da carta = 23              Altura da carta = 24
			
			String[] name_array = card.getCard().get("Nome").split(" ");

			switch(num){
				case 0:
					System.out.print(" --------------------- ");
					break;
				case 1:
					System.out.print("/          " + card.getCard().get("Id") + "         \\");
					break;
				case 2:
					System.out.print("|---------------------|");
					break;
			}
					
			if(card.getCard().get("Trunfo").equals("1")){ // Se é super trunfo
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
					if(Integer.parseInt(card.getCard().get("Peso(kg)")) < 10)
						System.out.print("| Peso(kg):         " + card.getCard().get("Peso(kg)") +" |");
					else if(Integer.parseInt(card.getCard().get("Peso(kg)")) < 100)
						System.out.print("| Peso(kg):        " + card.getCard().get("Peso(kg)") +" |");
					else if(Integer.parseInt(card.getCard().get("Peso(kg)")) < 1000)
						System.out.print("| Peso(kg):       " + card.getCard().get("Peso(kg)") +" |");
					else if(Integer.parseInt(card.getCard().get("Peso(kg)")) < 10000)
						System.out.print("| Peso(kg):      " + card.getCard().get("Peso(kg)") +" |");
					else
						System.out.print("| Peso(kg):     " + card.getCard().get("Peso(kg)") +" |");
					break;
	
				case 11:
					if(Integer.parseInt(card.getCard().get("Altura(cm)")) < 10)
						System.out.print("| Altura(cm):       " + card.getCard().get("Altura(cm)") + " |");
					else if (Integer.parseInt(card.getCard().get("Altura(cm)")) < 100)
						System.out.print("| Altura(cm):      " + card.getCard().get("Altura(cm)") + " |");
					else
						System.out.print("| Altura(cm):     " + card.getCard().get("Altura(cm)") + " |");
					break;
	
				case 12:
					if(Integer.parseInt(card.getCard().get("Idade(anos)"))  < 10)
						System.out.print("| Idade(anos):      " + card.getCard().get("Idade(anos)") + " |");
					else if(Integer.parseInt(card.getCard().get("Idade(anos)")) < 100)
						System.out.print("| Idade(anos):     " + card.getCard().get("Idade(anos)") + " |");
					else
						System.out.print("| Idade(anos):    " + card.getCard().get("Idade(anos)") + " |");
					break;
	
				case 13:
					if(Integer.parseInt(card.getCard().get("Num filhotes"))  < 10)
						System.out.print("| Num filhotes:     " + card.getCard().get("Num filhotes") + " |");
					else if(Integer.parseInt(card.getCard().get("Num filhotes"))  < 100)
						System.out.print("| Num filhotes:    " + card.getCard().get("Num filhotes") + " |");
					else
						System.out.print("| Num filhotes:   " + card.getCard().get("Num filhotes") + " |");
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
	
	public static void refreshInterface(Jogador j1, boolean b1, Jogador j2, boolean b2, Pack monte){ // Atualiza a interface
		clearConsole();
		printBoard(j1, b1, j2, b2, monte);
	}
}
