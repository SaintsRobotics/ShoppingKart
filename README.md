# ShoppingKart
[![Build Status](https://travis-ci.com/delaynieym/ShoppingKart.svg?branch=master)](https://travis-ci.com/delaynieym/ShoppingKart)

**Presented by the Boering Company**

### About
This project is meant to be a framework for FRC teams to use the AndyMark Swerve and Steer module easily without having to set a lot of code everytime.

### How to use use
This project provides a subsystem for driving that can be instanciated in Robot.java. Before doing that, create a Swerve Wheel object for each swerve and steer module. Some important things to know is, the location of each wheel relative to the location that the Robot pivots around. Typically this will be the center but it will not always be that. After instanciating the Swerve wheels, you can pass them in as an array to the swerve subsystem.

To interact with and use the swerve subsystem, you set the translation and rotation vector using the corresponding methods. Then to drive them you will call either the dynamic or static drive methods. 

### Using this project

Currently the only way to use this project is to download it and copy necessary files into your project. In the future, we plan to make it so you can add this library as a maven/gradle dependency. 

### Why is it here?

This repository is currently hosting a school project.
When complete, this repository will be reunited with the original repo.
Then that will be turned into a dependency.
If the project is not dependency-ready before its due, the project will still be merged with the original repo.
Development and production will continue from Saints Robotics.

**tl;dr this repo will be gone after the project is turned in, It will be at [Saints Robotics]( https://github.com/saintsrobotics/shoppingkart.git)**


