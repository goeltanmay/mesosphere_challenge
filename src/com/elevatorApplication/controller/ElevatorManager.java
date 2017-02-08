package com.elevatorApplication.controller;

public interface ElevatorManager {

	public int addElevator();
	
	public void addRequestToElevator(int elevatorId, int floor);
	
	public void step();
	
	public int request(int floor);
	
	public void getStatusOfAllElevators();
}
