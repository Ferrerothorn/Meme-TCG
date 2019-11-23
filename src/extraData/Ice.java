package extraData;

import game.Player;

public class Ice extends Card {

	public Ice() {
		this.name = "Ice";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.rfg.add(this);
		self.grave.remove(this);
		self.getDeck().add(new Water());
		self.shuffle();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
