package com.elevatorApplication.utilitiy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

public class InertialStrategy implements StepStrategy{

	@Override
	public int getNextStop(int currentLocation, int currentDirection, Queue<Integer> requestQueue) {
		if( requestQueue.peek()== null)
			return requestQueue.peek();
		
		if (currentDirection == 0) return requestQueue.peek();
		// if i am going up, i should look at all the stops above me, sorted in an ascending order.
		// if i am going down, i should look at all the stops below me in a sorted descending order.
		ArrayList<Integer> nextStops = new ArrayList<>();
		ArrayList<Integer> laterStops = new ArrayList<>();
		Iterator<Integer> queueIterator = requestQueue.iterator();
		while(queueIterator.hasNext()){
			int nextEl = queueIterator.next();
			if(currentDirection > 0)
				if(nextEl > currentLocation)
					nextStops.add(nextEl);
				else
					laterStops.add(nextEl);
			else
				if(nextEl < currentLocation)
					nextStops.add(nextEl);
				else
					laterStops.add(nextEl);
		}
		Collections.sort(nextStops);
		if (currentDirection > 0) {
			nextStops.addAll(laterStops);
			return nextStops.get(0);
		}
		laterStops.addAll(nextStops);
		return laterStops.get(laterStops.size()-1);
	}

	@Override
	public int getDirection(int currentLocation, int currentDirection, Queue<Integer> requestQueue) {
		if (currentLocation < getNextStop(currentLocation, currentDirection, requestQueue))
			return +1;
		else if(currentLocation == getNextStop(currentLocation, currentDirection, requestQueue))
			return 0;
		else return -1;
	}

}
