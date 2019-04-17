package extraData;

import game.Player;

public class ErrorMessage extends Card {

	String error = "";
	
	public ErrorMessage(String string) {
		this.name = "Error Message";
		error = string;
	}

	@Override
	public void onentry(Player self, Player opponent) {
		System.out.println("The config for " + error + " in the card pool index is spelled wrongly. Check it out!");
		System.exit(0);
	}

}
