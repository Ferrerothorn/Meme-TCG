package cards;

import java.util.Random;

import extraData.Card;
import extraData.RoadCone;
import game.Player;

public class Ghoul extends Card {

	public Ghoul() {
		this.name = "Ghoul";
		this.setType("Monster");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Random r = new Random();
		this.setCounters(r.nextInt(4));
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		this.setCounters((this.getCounters() + 1) % 4);
		switch (this.getCounters()) {
		case 0:
			opponent.getDeck().add(0, new RoadCone());
		}
	}
}
