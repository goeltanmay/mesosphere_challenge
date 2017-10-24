# Coding challenge 

The challenge was to make a Elevator control system, as close to the real life as possible.

### Approach & Implementation

First I defined an Elevator class, its members and its responsibilities. The elevator class should know its ID, its current level, its current direction, and the requests it has to furnish (levels it has to go to).

Then I defined a Elevator Manager class, which manages all the elevators in the system. Its job is to know how many, and which elevators are in the system. Since this is a time stepped simulation, the manager class manages the time step for all elevators that belong to it. Elevator class also decides the strategy which the elevators will take to decide their routes.

After these classes, I defined the ControlPanel class, which gives a basic command line interface to add elevators to the system, check the status of these elevators, give a request to one of these elevators to go to a floor, and to increment the time step.

Finally, I used the strategy pattern to make 2 distinct strategies of choosing next stop. One was the FIFO strategy, which as the write-up suggested, is not a good solution in real life. The second strategy that I implemented is called Inertial Strategy. In this strategy, if the elevator is going up, it will keep going up until it does not have any requests for floors above it. Similarly, if the elevator is going down, it will keep going down until it has no requests for floors below it. This is how I feel that real-world elevators are usually implemented. 

### Build instructions

Run the class ControlPanel.java
pr_test
..
