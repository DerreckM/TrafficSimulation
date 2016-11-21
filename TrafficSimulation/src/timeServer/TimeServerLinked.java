package timeServer;

import java.util.Observable;

import model.Agent;

public final class TimeServerLinked extends Observable implements TimeServer {
	private static final class Node {
		final double wakeTime;
		final Agent agent;
		Node next;

		public Node(double waketime, Agent agent, Node next) {
			this.wakeTime = waketime;
			this.agent = agent;
			this.next = next;
		}
	}
	private double currentTime;
	private int size;
	private Node head;

	public TimeServerLinked() {
		size = 0;
		head = new Node(0, null, null);
	}

	@Override
	public double currentTime() {
		return currentTime;
	}
	
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder("[");
		Node node = head.next;
		String separate = "";
		while (node != null) {
			stringbuilder.append(separate).append("(").append(node.wakeTime).append(",")
			.append(node.agent).append(")");
			node = node.next;
			separate = ";";
		}
		stringbuilder.append("]");
		return (stringbuilder.toString());
	}

	@Override
	public void enqueue(double waketime, Agent agent) throws IllegalArgumentException {
		if (waketime < currentTime)
			throw new IllegalArgumentException();
		Node prevElement = head;
		while ((prevElement.next != null) && (prevElement.next.wakeTime <= waketime)) {
			prevElement = prevElement.next;
		}
		Node newElement = new Node(waketime, agent, prevElement.next);
		prevElement.next = newElement;
		size++;
	}

	Agent dequeue()
	{
		if (size < 1) 
			throw new java.util.NoSuchElementException();
		Agent rvAgent = head.next.agent;
		head.next = head.next.next;
		size--;
		return rvAgent;
	}

	int size() {
		return size;
	}

	boolean empty() {
		return size() == 0;
	}
	
	@Override
	public void run(double duration) {
		double endtime = currentTime + duration;
		while ((!empty()) && (head.next.wakeTime <= endtime)) {
			currentTime = head.next.wakeTime;
			dequeue().run(duration);
			super.setChanged();
			super.notifyObservers();
		}
		currentTime = endtime;
	}
}