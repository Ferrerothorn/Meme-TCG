package cards;

import extraData.Card;
import game.Player;

public class DoomsdayDevice extends Card {

	public DoomsdayDevice() {
		this.name = "Doomsday Device";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		setCounters(10);
		self.draw();
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.lifeTotal--;
		takeCounter();
		if(getCounters()<=0) {
			opponent.lifeTotal = 0;
		}
	}
}
