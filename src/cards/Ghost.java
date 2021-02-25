package cards;

import extraData.Card;
import game.Player;

public class Ghost extends Card {

	public Ghost() {
		this.name = "Ghost";
		this.setColor("Black");
		this.setType("Creature");
		this.setPriority(5);
	}

	@Override
	public void onentry(Player self, Player opponent){
		this.addCounter();
		opponent.lifeTotal-=2*this.getCounters();
		
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		this.shuffleBackIntoDeck(self);
	}
}