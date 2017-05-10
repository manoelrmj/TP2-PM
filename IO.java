import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO {
	private static IO IOinstance; // Instancia unica
	
	private String filePath = "cards.txt";
	private static FileReader arq;
	private static BufferedReader readArq;
	
	private IO() {} // Construtor privado
	
	public static IO getInstance(){
		if (IOinstance == null)
			IOinstance = new IO();
		return IOinstance;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Pack buildPack(){
		
		Pack cards = new Pack();
		String[] attributesName;
		String[] attributesValues;
		String line = null;
		int numCards = 0;
		
		try {
			arq = new FileReader(filePath);
			readArq = new BufferedReader(arq);
			// Le a qtde de cartas
			numCards = Integer.parseInt(readArq.readLine());
			// Le os atributos
			line = readArq.readLine();
			attributesName = line.split(",");
			while(line != null){
				line = readArq.readLine();
				// gambs
				if(line==null)
					break;
				//System.out.println(line);
				attributesValues = line.split(",");
				Carta auxCard = new Carta();
				for(int i=0; i<attributesName.length; i++)
					auxCard.addAttribute(attributesName[i], attributesValues[i]);
				cards.addCard(auxCard);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo de cartas...");
		} finally { // Garantia de que sempre será feita a tentativa de fechar o arquivo
			try {
				arq.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar o arquivo.");
			}
		}
		
		return cards;
	}
}
