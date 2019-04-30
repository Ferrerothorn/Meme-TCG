package cards;

import extraData.Card;
import game.Player;

public class IncreasingHeal extends Card {

	public IncreasingHeal() {
		this.name = "Increasing Heal";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int count = self.cardCount(self.grave, "Increasing Heal");
		self.lifeTotal += (count + 1) * count;
		if(count == 1) {
			self.draw();
		}
	}
}
