package extraData;

import game.Player;

public class ErrorMessage extends Card {

	public ErrorMessage() {
		this.name = "Error Message";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		System.out.println("One of the cards in the card pool index is spelled wrongly. Check them all!");
	}

}
