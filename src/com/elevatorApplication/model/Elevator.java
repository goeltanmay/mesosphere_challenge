package com.elevatorApplication.model;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.elevatorApplication.utilitiy.StepStrategy;

public class Elevator {
	private int elevatorId;
	private int currentLevel;
	private int direction;
	private boolean doorOpen;
	private Queue<Integer> requestQueue;
	private StepStrategy stepStrategy;
	
	public int getElevatorId() {
		return elevatorId;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public Elevator(int elevatorId, StepStrategy strategy) {
		super();
		this.elevatorId = elevatorId;
		this.currentLevel = 0;
		this.direction = 0;
		this.doorOpen = false;
		this.stepStrategy = strategy;
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
		// if the door is open, we first close the door. This action needs one time step.
		if (doorOpen){
			doorOpen = false;
			return;
		}
		// check if there is any stop in queue, and go to that stop. else stay where you are.
		if(requestQueue.peek() != null)
			// if reaching the next stop, stop at the next stop and open the door
			if (currentLevel + direction == stepStrategy.getNextStop(currentLevel, direction, requestQueue)){
				// get to the stop
				currentLevel += direction;
				// stop moving
				direction = 0;
				// remove the stop from queue
				requestQueue.remove(currentLevel);
				// open the door
				doorOpen=true;
			}
			else {
				// if target is up, direction is 1
				// if target is down, direction is -1
				direction = stepStrategy.getDirection(currentLevel, direction, requestQueue);
				currentLevel += direction;
			}
		else direction = 0;
	}
	
	public void getStatus(){
		// print the status here
		System.out.println(String.format("Status of Elevator %d : Level : %d, Direction : %d, Next Floor : %d", elevatorId, currentLevel, direction, requestQueue.peek()));
	}
}
