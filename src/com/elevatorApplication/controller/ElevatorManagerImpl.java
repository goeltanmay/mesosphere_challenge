package com.elevatorApplication.controller;

import java.util.HashMap;
import java.util.Map;

import com.elevatorApplication.model.Elevator;
import com.elevatorApplication.utilitiy.FifoStrategy;

public class ElevatorManagerImpl implements ElevatorManager{
	private int nextId;
	private  Map<Integer, Elevator> elevators;
	@Override
	public int addElevator() {
		Elevator e = new Elevator(nextId, new FifoStrategy());
		elevators.put(nextId,e);
		nextId ++;
		return elevators.size();
	}

	@Override
	public void addRequestToElevator(int elevatorId, int floor) {
		elevators.get(elevatorId).requestElevatorToGoToFloor(floor);
	}

	@Override
	public void step() {
		for(Elevator e : elevators.values()) e.step();
	}

	@Override
	public int request(int floor) {
		return 0;
	}
	
	public ElevatorManagerImpl(){
		nextId = 1;
		this.elevators = new HashMap<>();
	}

	@Override
	public void getStatusOfAllElevators() {
		for(Elevator e : elevators.values()) e.getStatus();
	}

}
