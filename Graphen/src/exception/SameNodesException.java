package exception;

@SuppressWarnings("serial")
public class SameNodesException extends Exception {

	public SameNodesException() {
		super("Die Knoten muessen verschieden sein!");
	}

}
