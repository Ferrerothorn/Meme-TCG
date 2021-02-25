package extraData;

import game.Player;

public abstract class Card implements Cloneable, Comparable {

	protected String name;
	int counters;
	int priority;

	String type = "";
	String subtype = "";
	String color = "";

	public void onentry(Player self, Player opponent) {

	}

	public void afterResolving(Player self, Player opponent) {

	}

	public void graveAbility(Player self, Player opponent) {

	}

	public void whenDrawn(Player self) {
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public String getType() {
		return type;
	}

	public void setType(String s) {
		type = s;
	}
	
	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String s) {
		subtype = s;
	}
	
	public void setColor(String string) {
		color = string;
	}

	public String getColor() {
		return color;
	}

	public void addCounter() {
		counters++;
	}

	public void addCounters(int x) {
		while (x > 0) {
			counters++;
			x--;
		}
	}

	public void takeCounter() {
		if (counters > 0) {
			counters--;
		}
	}

	public void takeCounters(int x) {
		while (x > 0) {
			counters--;
			x--;
		}
	}

	public void setCounters(int x) {
		counters = x;
	}

	public int getCounters() {
		return counters;
	}

	public Card clone() throws CloneNotSupportedException {
		return (Card) super.clone();
	}
	

	public void shuffleBackIntoDeck(Player self) {
		if (self.grave.remove(this)) {
			self.getDeck().add(this);
		}
	}

	public void rfgThis(Player self) {
		if (self.grave.remove(this)) {
			self.rfg.add(this);
		}
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int compareTo(Object arg0) {
		if(this.getPriority() < ((Card) arg0).getPriority()) {
			return -1;
		}
		if(this.getPriority() > ((Card) arg0).getPriority()) {
			return 1;
		}
		return 0;
	}
}
