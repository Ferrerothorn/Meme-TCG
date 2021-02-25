package cards;

import extraData.Card;
import game.Player;

public class Ignite extends Card {

	
	public Ignite() {
		this.name = "Ignite";
		this.setType("Spell");
		this.setColor("Red");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 2;
		self.lifeTotal -= 1;
		self.draw();
	}
}
