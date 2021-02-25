package cards;

import java.util.Collections;

import extraData.Card;
import extraData.Ice;
import game.Player;

public class IceWizard extends Card {

	public IceWizard() {
		this.name = "Ice Wizard";
		this.setType("Hero");
		this.setColor("Blue");
		this.setPriority(6);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
		for (Card c : self.getHand()) {
			if (c.getType().equals("Hero")) {
				opponent.getDeck().add(new Ice());
			}
		}
		Collections.shuffle(opponent.getDeck());
	}
}
