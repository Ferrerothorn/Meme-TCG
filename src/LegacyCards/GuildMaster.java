package LegacyCards;

import extraData.Card;
import game.Player;

public class GuildMaster extends Card {

	public GuildMaster() {
		this.name = "Guild Master";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		if (self.handContainsCardsWithType("Hero")) {
			self.playsPerTurn++;
		}
	}
}
