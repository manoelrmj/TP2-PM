public class Main{
	public static void main(String[] args) {
		SuperTrunfo game = new SuperTrunfo("cards.txt");
		game.initialize();
		game.startGame();
		game.endGame();
	}
}