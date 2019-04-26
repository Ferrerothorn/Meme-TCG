package extraData;

import java.util.ArrayList;
import java.util.Collections;

import game.Player;

public class Pigeon extends Card {

	public Pigeon() {
		this.name = "Pigeon";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> temp = new ArrayList<>();
		int i = 0;
		while (i < 5 && i < self.getDeck().size()) {
			Card c = self.getDeck().get(i);
			if (c.getName().equals("Pigeon")) {
				temp.add(c);
			}
			i++;
		}
		self.grave.remove(this);
		opponent.lifeTotal--;
		opponent.lifeTotal -= temp.size()*2;
		self.getDeck().removeAll(temp);
		temp.clear();
		Collections.shuffle(self.getDeck());
	}
}
