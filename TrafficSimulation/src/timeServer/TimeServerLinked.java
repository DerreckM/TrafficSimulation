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

	/*
	 * Invariant: _head != null
	 * Invariant: _head.agent == null
	 * Invariant: (_size == 0) iff (_head.next == null)
	 */
	public TimeServerLinked() {
		size = 0;
		head = new Node(0, null, null);
	}

	@Override
	public double currentTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enqueue(double wake, Agent agent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(double duration) {
		// TODO Auto-generated method stub
		
	}
}