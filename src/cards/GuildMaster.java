package cards;

import extraData.Card;
import game.Player;

public class GuildMaster extends Card {

	public GuildMaster() {
		this.name = "Guild Master";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw(2);
		self.playsPerTurn += self.containsXCardsFromClass(self.getHand(), "Hero");
	}
}
