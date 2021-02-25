package cards;

import extraData.Card;
import game.Player;

public class DarkKnight extends Card {

	public DarkKnight() {
		this.name = "Dark Knight";
		this.setType("Hero");
		this.setColor("Black");
		this.setPriority(10);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damage = (20 - self.lifeTotal);
		int damageModifier = 3;
		if (self.containsClass(self.grave, "Hero")) {
			damageModifier = 2;
		}
		damage /= damageModifier;
		if (damage == 0) {
			self.draw();
		} else {
			opponent.lifeTotal -= damage;
		}
	}
}
