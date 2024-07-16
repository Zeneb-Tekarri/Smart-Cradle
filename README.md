# Smart-Cradle
PFA 2022
## Project Description: Intelligent Cradle Prototype

**Project Title: Design and Implementation of an Intelligent Cradle Prototype

**Presented by: Zeineb Tekarri and Ahlem Ben Hassen

**Institution: National School of Electronics and Telecommunications of Sfax, University of Sfax

**Supervisors: 
- Mr. Ghozzi Fahmi (Examiner)
- Mr. Gassara Bilel (Supervisor)

**Academic Year: 2021-2022

## Overview ##
The project aims to design and develop a prototype of an intelligent cradle system using Internet of Things (IoT) technology. This system is intended to help parents monitor their baby's status remotely and ensure their safety and comfort. 

## Problem Statement ##
Modern parents often struggle to balance their professional and personal lives, particularly when it comes to continuously monitoring their babies. Existing baby monitoring systems have limitations in terms of comprehensiveness and real-time updates, leading to the need for a more integrated and automated solution.

## Project Objectives ##
1. Continuous Monitoring: Provide parents with a system that allows them to monitor their baby continuously.
2. Automated Response: Develop a cradle that responds to the baby's cries by automatically initiating a gentle rocking motion and playing soothing music.
3. Remote Access: Enable parents to access live video streaming of their baby and receive real-time alerts through a mobile application.

## System Description ##
- **Components:**
  - NodeMCU ESP8266: For Wi-Fi connectivity and cloud communication.
  - Arduino Mega 2560: For controlling various sensors and actuators.
  - ESP32 CAM: For capturing and streaming live video.
  - Servo Motor: For automated rocking of the cradle.
  - Sound Sensor (GT1146): For detecting baby cries.
  - FTDI USB Adapter: For serial communication.
  - LED Indicators: For visual notifications.
  
- **Functionality:**
  - The sound sensor detects the baby's cries and triggers the rocking mechanism.
  - The ESP32 CAM provides live video streaming accessible through the mobile app.
  - The system sends alerts to parents via the mobile application, notifying them of the baby's status and any detected activity.

## Implementation ##
1. **Hardware Integration:** Connecting and configuring the sensors, actuators, and microcontrollers.
2. **Software Development:** Writing the firmware for the Arduino and NodeMCU, and developing the mobile application using Android Studio.
3. **Testing:** Conducting extensive tests to ensure the system's reliability and responsiveness.

## Results and Conclusion ##
The intelligent cradle system successfully integrates IoT technology to provide a comprehensive baby monitoring solution. It offers continuous surveillance, automated responses to the baby's needs, and remote accessibility for parents, significantly improving the ease and effectiveness of baby care.


This project demonstrates the potential of IoT in developing practical and innovative solutions for everyday challenges, offering significant benefits for parents and caregivers.
