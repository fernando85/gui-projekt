package model;

import command.HistoryCommand;

/**
 * Diese Klasse speichert die Information ueber die letzte
 * Aenderungen an den Graphen:
 * <li> {@code historyCommand} Welche Aktion wurde ausgefuehrt?
 * <li> {@code graphElement} Welches Graphelement ist betroffen?
 */
public class History {

	private HistoryCommand historyCommand;
	private Object graphElement;
	
	
	public History() {
		
	}
	
	public History(HistoryCommand historyCommand, Object graphElement) {
		this.historyCommand = historyCommand;
		this.graphElement = graphElement;
	}
	
	
	public HistoryCommand getHistoryCommand() {
		return historyCommand;
	}
	
	public void setHistoryCommand(HistoryCommand historyCommand) {
		this.historyCommand = historyCommand;
	}
	
	public Object getGraphElement() {
		return graphElement;
	}
	
	public void setGraphElement(Object graphElement) {
		this.graphElement = graphElement;
	}
	
	
}
