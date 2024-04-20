National College of Ireland - NCI 
HDip in Computing - International 

Due Date: 19th April 2024
Lecturer: Mark Cudden

Distributed System 
      gRPC 

Implementation: Command-line / GUI

This project provides a basic Java programmer’s introduction  gRPC.

By walking through we will see:
  A service in a .proto file.
  Server and client code using the protocol buffer compiler.
  Java gRPC API - Simple client and server 

References: 
https://grpc.io/docs/languages/java/basics/
https://moodle2023.ncirl.ie/course/view.php?id=1201


Project - Smart Home 
=========================
Client Side
---
Smart Thermostats
  Allows the user to send a request to the server to set a room temperature
  
You Connections
  Allows the user to send information to the server as a ping or connection test

Smart Devices
  Allows the user to request to switch off or switch on a few components.
  

Server Side
---
Smart Thermostats
  Send to the user the weather forecast

Your Connection
  Receive from the client some information

Smart Devices
  Respond to the user that the component has switched on/off.

Version 1.0 - Command-Line
Version 1.1 - GUI by Java Swing
---



Version 2.0 - GUI by JavaFX
--
Once I finished my project. To improve my learning, I will develop a new version that reinforces gRPC concepts
and learn about a new topic JavaFX.

This version includes the following services:
Proto -> Utilities 
      * Service: DomesticUtilitiesServices
            # Method: Energy Monitor ->  Approach: Service-Side Streaming RPC
            # Method: Disable Energy Monitor -> Approach: Unary RPC
      
Proto -> Environment
      * Service: Environment Mgmt Services
            # Method: Switch On -> Approach: Service-Side Streaming RPC
            # Method: SwitchOff -> Approach: Unary RPC
            # Method: Forecast -> Approach: Unary RPC
            
Proto -> Security
      * Service: SmartDoorServices
            # Method: OpenDoor -> Approach: Unary RPC
            # Method: Close Door -> Approach: Unary RPC
            .
      * Service: SmartAlarmServices
            # Method: TurnOnAlarm -> Approach: Service-Side Streaming RPC
            # Method: TurnOffAlarm -> Approach: Unary RPC
      

by Sergio Oliveira 

