package cards;

import extraData.Card;
import game.Player;

public class MightyWrench extends Card {

	public MightyWrench() {
		this.name = "Mighty Wrench";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int wrenches = 0;
		System.out.println("Entering Wronch");
		for (Card c : self.grave) {
			System.out.println(c.getName());
			if (c.getCounters() > 0) {
				wrenches++;
				System.out.println("+1");
			}
		}
		if (wrenches > 0) {
			System.out.println("Wrenches");
			while (opponent.getHand().size() > 0 && wrenches > 0) {
				wrenches--;
				opponent.randomDiscard();
			}
			while (wrenches > 0) {
				self.draw();
			}
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
