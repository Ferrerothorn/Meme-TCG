package extraData;

public class ErrorMessage extends Card {

	String error = "";

	public ErrorMessage(String string) {
		this.name = "Error Message";
		error = string;
		System.out.println("The config for " + error + " in the card pool index is spelled wrongly. Check it out!");
		System.exit(0);
	}
}
