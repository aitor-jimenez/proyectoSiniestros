package com.babelgroup.helloworld.practicaSiniestros.iomanager;

import java.util.Scanner;

public class ConsoleIOManager implements IOManager {

    private Scanner scanner;

    public void write(String message) {
        System.out.println(message);
    }

    public String read() {
        return this.scanner.nextLine();
    }

}
