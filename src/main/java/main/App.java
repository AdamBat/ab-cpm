package main;

import java.util.Scanner;

import main.Service.ParkService;

public class App {
    public static void main(String[] args) {
        ParkService parkService = new ParkService();
        System.out.println("Please provide car park instructions separated by coma");
        Scanner sc = new Scanner(System.in);
        String instr = sc.nextLine();
        parkService.processInstructions(instr);
    }
}
