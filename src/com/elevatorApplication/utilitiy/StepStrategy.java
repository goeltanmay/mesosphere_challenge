package com.elevatorApplication.utilitiy;

import java.util.Queue;

public interface StepStrategy {
	public int getNextStop(int currentLocation, int currentDirection, Queue<Integer> requestQueue);
	
	public int getDirection(int currentLocation, int currentDirection, Queue<Integer> requestQueue);
}
