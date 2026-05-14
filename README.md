# Shapes-Assignment
## Shapes Drawing Program (Java Swing)
A simple interactive drawing application built in Java using Swing.
Users can draw different shapes on the canvas using the mouse and toggle special drawing modes with keyboard shortcuts.

## Features
Draw multiple shape types

Line

Rectangle (Box)

Oval

Mouse‑based drawing

Click and drag to draw

Shapes appear on mouse release

Keyboard controls

C — Change color

E — Erase all shapes

T — Toggle Trails Mode (draws continuous shapes while dragging)

N — Toggle Nesting Mode (draws progressively smaller shapes)

Clean object‑oriented design

ShapeType enum

Individual shape classes

DrawingComponent handles rendering and input

Uses a list to store and repaint all shapes

## How It Works
The program listens for mouse press, drag, and release events to determine the start and end points of each shape.
Keyboard shortcuts modify how shapes are created, allowing for special effects like trails or nested shapes.

All shapes are stored in a list and redrawn on every repaint, ensuring smooth rendering.

## Technologies Used
Java

Java Swing

## How to Run
Open the project in your Java IDE (IntelliJ, Eclipse, VS Code with Java, etc.)

Compile and run the main class

Use the mouse and keyboard shortcuts to draw on the canvas

Object‑Oriented Programming

Event Handling (Mouse + Keyboard)
