package cards;

import game.Player;

public class Heal extends Card {

	
	public Heal() {
		this.name = "Heal";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal+=4;
	}	
}
