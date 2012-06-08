package control;

public enum GraphActionCommand {

	EMPTY,
	UNDO,
	REDO,
	NODE,
	EDGE,
	CHECK,
	SELECT;
	
//	public static GraphActionCommand valueOf(String command) {
//		if (command.equals(EMPTY.name())) {
//			return EMPTY;
//		}
//		if (command.equals(UNDO.name())) {
//			return UNDO;
//		}
//		if (command.equals(REDO.name())) {
//			return REDO;
//		}
//		if (command.equals(NODE.name())) {
//			return NODE;
//		}
//		if (command.equals(EDGE.name())) {
//			return EDGE;
//		}
//		if (command.equals(CHECK.name())) {
//			return CHECK;
//		}
//		if (command.equals(SELECT.name())) {
//			return SELECT;
//		}
//		
//		return null;
//	}
}
