package exception;

@SuppressWarnings("serial")
public class EdgeAlreadyExistException extends Exception {

	public EdgeAlreadyExistException() {
		super("Es existiert schon eine Kante zwischen diesen beiden Knoten!");
	}
}
