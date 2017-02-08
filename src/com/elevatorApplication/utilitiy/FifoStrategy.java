package com.elevatorApplication.utilitiy;

import java.util.Queue;

public class FifoStrategy implements StepStrategy {

	@Override
	public int getNextStop(int currentLocation, int currentDirection, Queue<Integer> requestQueue) {
		// TODO Auto-generated method stub
		return requestQueue.peek();
	}

	@Override
	public int getDirection(int currentLocation, int currentDirection, Queue<Integer> requestQueue) {
		// TODO Auto-generated method stub
		if (currentLocation < getNextStop(currentLocation, currentDirection, requestQueue))
			return +1;
		else if(currentLocation == getNextStop(currentLocation, currentDirection, requestQueue))
			return 0;
		else return -1;
	}

}
