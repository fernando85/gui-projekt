package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import exception.EdgeAlreadyExistException;
import exception.NotEulerschException;
import exception.UnConnectedException;

enum HistoryCommand {
	ADD_NODE,
	DELETE_NODE,
	MOVE_NODE,
	ADD_EDGE,
	DELETE_EDGE
}

public class Graph {

	/** Diese Variable speichert eine Menge von Knoten. */
	private Set<Node> nodes;
	
	/** Diese Variable speichert eine Menge von Kanten. */
	private Set<Edge> edges;
	
	/** Diese Variable speichert eine Liste zuletzt ausgefuehrte Nutzeraktionen von Knoten. */
	private List<History> lastActions;
	
	public Graph() {
		nodes = new HashSet<Node>();
		edges = new HashSet<Edge>();
		
		lastActions = new ArrayList<History>();
	}


	public Set<Node> getNodes() {
		return nodes;
	}


	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}


	public Set<Edge> getEdges() {
		return edges;
	}


	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * Diese Methode fuegt den eingegebenen Knoten in den
	 * Graphen ein.
	 * @param node Knoten, der in den Graphen eingefuegt wird.
	 */
	public void addNode(Node node) {
		if (nodes.add(node)) {
			lastActions.clear();
			
			History lastAction = new History(HistoryCommand.ADD_NODE, node);
			lastActions.add(lastAction);
		}
	}
	
	/**
	 * Diese Methode loescht den eingegebenen Knoten.
	 * Vorher werden alle Kanten geloescht, die den Knoten
	 * mit einem anderen Knoten verbindet.
	 * @param node Der Knoten, der geloescht wird.
	 */
	public void removeNode(Node node) {
		Set<Edge> edgesToRemove = new HashSet<Edge>();
		
		for (Edge edge : edges) {
			if (node.equals(edge.getNode1()) || node.equals(edge.getNode2())) {
				edgesToRemove.add(edge);
			}
		}
		
		lastActions.clear();
		
		// Kanten loeschen
		for (Edge edge : edgesToRemove) {
			edges.remove(edge);
			
			History removeEdgeAction = new History(HistoryCommand.DELETE_EDGE, edge);
			lastActions.add(0, removeEdgeAction);
		}
		
		// Knoten loeschen
		if (nodes.remove(node)) {
			History removeNodeAction = new History(HistoryCommand.DELETE_NODE, node);
			lastActions.add(0, removeNodeAction);
		}
	}
	
	
	public void addEdge(Edge edge) throws EdgeAlreadyExistException {
		if (edges.contains(edge)) {
			throw new EdgeAlreadyExistException();
		}
		
		if (edges.add(edge)) {
			lastActions.clear();
			
			History lastAction = new History(HistoryCommand.ADD_EDGE, edge);
			lastActions.add(lastAction);
		}
	}
	
	public void removeEdge(Edge edge) {
		if (edges.remove(edge)) {
			lastActions.clear();
			
			History lastAction = new History(HistoryCommand.DELETE_EDGE, edge);
			lastActions.add(lastAction);
		}
	}
	
	
	/**
	 * Diese Methode ueberprueft, ob ein Knoten in der Position (x,y) existiert
	 * und gibt diesen gegebenenfalls zurueck. Wenn kein Knoten in der Position
	 * (x,y) existiert, wird {@code null} zurueckgegeben.
	 * 
	 * @param x   x-Position, die ueberprueft werden muss.
	 * @param y   y-Position, die ueberprueft werden muss.
	 * @return Der Knoten in der Position (x,y) wird zurueckgegeben oder
	 *         {@code null} fuer den Fall, dass kein Knoten in der eingegebenen
	 *         Position (x,y) existiert.
	 */
	public Node getNodeAtPosition(int x, int y) {
		for (Node node : nodes) {
			if (x >= node.getX() - Node.RADIUS && x <= node.getX() + Node.RADIUS
					&& y >= node.getY() - Node.RADIUS && y <= node.getY() + Node.RADIUS) {
				return node;
			}
		}

		return null;
	}
	
	
	public void restore() {
		if (lastActions == null || lastActions.isEmpty()) {
			return;
		}
		
		for (History lastAction : lastActions) {
			Object graphElement = lastAction.getGraphElement();
			
			switch (lastAction.getHistoryCommand()) {
			case ADD_NODE:
				if (graphElement instanceof Node) {
					Node node = (Node) graphElement;
					if (nodes.remove(node)) {
						lastAction.setHistoryCommand(HistoryCommand.DELETE_NODE);
						lastAction.setGraphElement(node);						
					}
				}
				break;
			case DELETE_NODE:
				if (graphElement instanceof Node) {
					Node node = (Node) graphElement;
					if (nodes.add(node)) {
						lastAction.setHistoryCommand(HistoryCommand.ADD_NODE);
						lastAction.setGraphElement(node);						
					}
				}
				break;
			case ADD_EDGE:
				if (graphElement instanceof Edge) {
					Edge edge = (Edge) graphElement;
					if (edges.remove(edge)) {
						lastAction.setHistoryCommand(HistoryCommand.DELETE_EDGE);
						lastAction.setGraphElement(edge);						
					}
				}
				break;
			case DELETE_EDGE:
				if (graphElement instanceof Edge) {
					Edge edge = (Edge) graphElement;
					if (edges.add(edge)) {
						lastAction.setHistoryCommand(HistoryCommand.ADD_EDGE);
						lastAction.setGraphElement(edge);						
					}
				}
				break;
			case MOVE_NODE:
				// TODO
				break;
			default:
				break;
			}
		}
		
	}
	
	public void checkConnected(Graph  g) throws  UnConnectedException{
		if(!g.dfs())
			throw new UnConnectedException();
	}
	
	public void findNaigbours(Node n, ArrayList<Node> l1, ArrayList<Node> l2) {
		
		int zaehler = 0;
		for(Edge edge : this.getEdges()) {
			if(n == edge.getNode1()){
				if(!l2.contains(edge.getNode2())){
					l1.add(edge.getNode2());
					l2.add(edge.getNode2());
					zaehler++;
				}
				
			}
			if(n == edge.getNode2()){
				if(!l2.contains(edge.getNode1())){
					l1.add(edge.getNode1());
					l2.add(edge.getNode1());
					zaehler++;
				}
			}
		}
		if(zaehler == 0)
			l1.remove(n);
			
	}
	
	public boolean dfs() {
		Iterator<Node> e = nodes.iterator();
		Node n = e.next();
		
		ArrayList<Node> visited1 = new ArrayList<Node>();
		ArrayList<Node> visited2 = new ArrayList<Node>();
		visited1.add(n);
		visited2.add(n);
		while(!visited1.isEmpty()){
			Node n1 = visited1.get(visited1.size()-1);
			this.findNaigbours(n1, visited1, visited2);
		}
		if(visited2.size() == this.edges.size())
			return true;
		else
			return false;
		
	}
	
	
	public void Fleury()  {
		
		try{
			checkConnected(this);
			for (Node node : this.getNodes() ) {
				
				node.checkGrad();
			}

			
		
		
		}
		catch (UnConnectedException e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage());
		
		} catch (NotEulerschException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
		
			
	}
	
	
	
}
