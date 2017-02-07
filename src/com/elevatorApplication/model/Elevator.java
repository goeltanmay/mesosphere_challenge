package com.elevatorApplication.model;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Elevator {
	private int elevatorId;
	private int currentLevel;
	private int direction;
	private Queue<Integer> requestQueue;
	
	public int getElevatorId() {
		return elevatorId;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public Elevator(int elevatorId) {
		super();
		this.elevatorId = elevatorId;
		this.currentLevel = 0;
		this.requestQueue = new LinkedBlockingQueue<>();
	}
	
	public int requestElevatorToGoToFloor(int floor){
		if(!requestQueue.contains(floor))
			requestQueue.add(floor);
		return 1;
	}
	
	public int peekNextFloor(){
		if(requestQueue.isEmpty()) return -1;
		else 
			return requestQueue.peek();
	}
	
	public int getNextFloor(){
		return requestQueue.poll();
	}
	
	public void step(){
		if(requestQueue.peek() != null)
			this.currentLevel = getNextFloor();
	}
}
