package cards;

import extraData.Card;
import game.Player;

public class DoomsdayDevice extends Card {

	public DoomsdayDevice() {
		this.name = "Doomsday Device";
		this.setType("Creature");
		this.setColor("Red");
		this.setPriority(2);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		setCounters(10);
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters() > 0) {
			takeCounter();
			if (getCounters() <= 0) {
				opponent.lifeTotal = 0;
			}
		}
	}
}
