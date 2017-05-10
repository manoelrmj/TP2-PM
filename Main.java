public class Main{
	public static void main(String[] args) {
		SuperTrunfo game = new SuperTrunfo("packs/Animais Silvestres.txt");
		game.initialize();
		game.startGame();
		game.endGame();
	}
}