package cards;

import extraData.Card;
import game.Player;

public class ChannelTheDepths extends Card {

	public ChannelTheDepths() {
		this.name = "Channel the Depths";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.grave.size() >= 7 || opponent.grave.size() >= 7) {
			opponent.lifeTotal -= 5;
		}
		else {
			opponent.lifeTotal -= 2;
		}
	}
}
