package extraData;

import java.util.ArrayList;

import game.Player;

public class WorkerBee extends Card {

	public WorkerBee() {
		this.name = "Worker Bee";
		this.setType("Junk");
		this.setPriority(99);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> hives = new ArrayList<Card>();
		for (Card c : self.grave) {
			if (!c.getName().contains("Hive") && !c.getName().contains("Bee")) {
				cards.add(c);
			}
			if (c.getName().equals("Onion")) {
				hives.add(c);
			}
		}
		self.getDeck().addAll(cards);
		self.grave.removeAll(cards);
		self.rfg.addAll(hives);
		self.grave.removeAll(hives);
		self.shuffle();
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
