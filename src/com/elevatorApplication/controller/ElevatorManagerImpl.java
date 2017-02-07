package com.elevatorApplication.controller;

import java.util.HashMap;
import java.util.Map;

import com.elevatorApplication.model.Elevator;

public class ElevatorManagerImpl implements ElevatorManager{
	private int nextId;
	private  Map<Integer, Elevator> elevators;
	@Override
	public void addElevator(int elevatorId) {
		Elevator e = new Elevator(nextId);
		elevators.put(nextId,e);
		nextId ++;
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

}
