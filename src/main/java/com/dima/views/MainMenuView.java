package com.dima.views;

import com.dima.utils.Constants;
import com.dima.utils.Printer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuView {
    private Scanner scanner = new Scanner(System.in);
    public int getData() {
        printHeader();
        System.out.println("1 - Login\n2 - Signup\n0 - Exit");
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            System.out.println(Constants.INPUT_ERR_MSG);
        } finally {
            scanner.nextLine();
        }
        return -1;
    }

    public void printHeader() {
        Printer.printHeader(Constants.APP_NAME);
    }
}
