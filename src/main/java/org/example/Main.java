package org.example;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        while (true) {
            userInterface.init();
            userInterface.display();
        }
    }
}