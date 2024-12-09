package eu.smoothcloud.node.console;

import eu.smoothcloud.node.console.modes.DefaultMode;
import eu.smoothcloud.node.console.modes.Mode;

import java.util.Scanner;

public class Console {

    private boolean isRunning;
    private boolean isPaused;
    private Mode currentMode;

    public Console() {
        this.isRunning = true;
        this.isPaused = false;
        this.currentMode = new DefaultMode(this);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(isRunning) {
            if(isPaused) {
                String input = scanner.nextLine().trim();
                if(input.equalsIgnoreCase("resume")) {
                    isPaused = false;
                }
                continue;
            }

            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "exit" -> {
                    isRunning = false;
                }
                case "pause" -> {
                    isPaused = true;
                }
                case "switch" -> {
                    String modeName = input.substring(7).trim();
                    switchMode(modeName);
                }
                default -> {
                    currentMode.handleCommand(input);
                }
            }
        }
        scanner.close();
    }

    private void switchMode(String modeName) {
        switch (modeName.toLowerCase()) {
            case "setup" -> {

            }
            case "default" -> {

            }
            default -> {

            }
        }
    }

    private void print(String message) {
        print(message, true);
    }

    private void print(String message, boolean newLine) {
        String coloredMessage = ConsoleColor.apply(message);
        if(newLine) {
            System.out.println(coloredMessage);
            return;
        }
        System.out.print(coloredMessage);
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }

}