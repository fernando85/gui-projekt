package command;

/**
 * Diese enum speichert die Befehle, die hinter einem Button steckt.
 * Diese Befehle werden erst relevant, wenn ein Benutzer auf einem 
 * Button klickt.
 */
public enum GraphActionCommand {

	/** Kommando zum Fordern einer neuen Seite. */
	EMPTY,
	
	/** Kommando zum Fordern einer Undo-Aktion. */
	UNDO,
	
	/** Kommando zum Fordern einer Redo-Aktion. */
	REDO,
	
	/** Kommando zum An-/Ausschalten des ToggleButton zum Erstellen von Knoten. */
	NODE,
	
	/** Kommando zum An-/Ausschalten des ToggleButton zum Erstellen von Kanten. */
	EDGE,
	
	/** Kommando zum Überprüfen eines Graphen auf Existenz eines Eulerwegs/-kreises. */
	CHECK, 
	
	/** Kommando zum Entfernen eines Knotens oder einer Kante. */
	DELETE;
	
}
