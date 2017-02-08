package com.elevatorApplication.main;

import java.util.Scanner;

import com.elevatorApplication.controller.ElevatorManager;
import com.elevatorApplication.controller.ElevatorManagerImpl;

public class ControlPanel {
	private static ElevatorManager elevatorManager;
	public static void main(String args[]){
		elevatorManager = new ElevatorManagerImpl();
		int input = -1;
		Scanner scanner = new Scanner(System.in);
		do {
			// print statements to show the main menu
			System.out.println("--- MAIN MENU ---");
			System.out.println("1. Add a new elevator");
			System.out.println("2. Get status of all the elevators");
			System.out.println("3. Take a time step");
			System.out.println("4. Request an elevator to open on the floor");
			System.out.println("5. Request some elevator to come to floor");
			input = scanner.nextInt();
			int elevatorId, floor;
			switch(input){
				case 1:
					elevatorManager.addElevator();
					break;
				case 2:
					elevatorManager.getStatusOfAllElevators();
					break;
				case 3:
					elevatorManager.step();
					break;
				case 4:
					System.out.println("Elevator Id : ");
					elevatorId = scanner.nextInt();
					System.out.println("Floor : ");
					floor = scanner.nextInt();
					elevatorManager.addRequestToElevator(elevatorId, floor);
					break;
				case 5:
					System.out.println("Floor : ");
					floor = scanner.nextInt();
					elevatorManager.request(floor);
					
				default:
					break;
			}
			
		} while(input != -1);
	}
}
