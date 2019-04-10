package cards;

import game.Player;

public class Heal extends Card {

	
	public Heal() {
		this.name = "Heal";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal+=4;
	//	System.out.println(self.getName() + " casts Heal for 4 lifegain! (" + self.getLife() + ")-(" + opponent.getLife() + ")");
	}
	
	
}
