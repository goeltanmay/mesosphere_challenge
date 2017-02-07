package com.elevatorApplication.controller;

public interface ElevatorManager {

	public void addElevator(int elevatorId);
	
	public void addRequestToElevator(int elevatorId, int floor);
	
	public void step();
	
	public int request(int floor);
}
