package game.tree;

/**
 * A possible operation at each second of the game.
 * Only one operation is executed per second.
 */
public class Operation {

	private String verb;
	private String noun;
	
	public Operation(String verb, String noun) {
		this.verb = verb;
		this.noun = noun;
	}
	
	public String getVerb(){
		return verb;
	}
	
	public String getNoun(){
		return noun;
	}
	
}
