The Traffic Simulation applies object-oriented software development skills to a significant but moderately-sized application. 
The following sections describe the general behavior of the application, the simulation, and the deliverable requirements for the project. 

The O-O paradigm was founded in simulation and is an excellent means for exercising its strengths. The Simula programming language, 
followed by the Smalltalk environment, together pioneered the development and dissemination of O-O languages, and were first and foremost 
designed as simulation languages. 

We are modeling a traffic grid with a variable number of rows and columns. For example, a 2x3 grid would look something like this:

       |     |     |
       |     |     |
  -----#-----#-----#-----
       |     |     |     
       |     |     |
  -----#-----#-----#-----
       |     |     |     
       |     |     |     

The # represent intersections, and the lines represent roads (or road segments).

We will assume that each car goes in a consistent direction (north to south, east to west, etc). Cars do not turn. All roads are one-way and 
have only a single lane of traffic.

We will consider two kinds of traffic patterns: simple and alternating.

In the simple traffic pattern, all traffic goes in the same direction. In the following picture, + represent a car source and @ represents
a car sink. Cars flow from sources to sinks. Here is a 2x4 simple grid:

       +     +     +     +
       |     |     |     |
       |     |     |     |
 +-----#-----#-----#-----#-----@
       |     |     |     |     
       |     |     |     |
 +-----#-----#-----#-----#-----@
       |     |     |     |     
       |     |     |     |     
       @     @     @     @
       
In the alternating traffic pattern, roads alternate direction. Here is a 3x5 alternating grid:

       +     @     +     @     +
       |     |     |     |     |
       |     |     |     |     |
 +-----#-----#-----#-----#-----#-----@
       |     |     |     |     |     
       |     |     |     |     |      
 @-----#-----#-----#-----#-----#-----+
       |     |     |     |     |     
       |     |     |     |     |     
 +-----#-----#-----#-----#-----#-----@
       |     |     |     |     |      
       |     |     |     |     |      
       @     +     @     +     @
       
Sources generate cars and place them on a road. Sinks delete cars from the simulation.
