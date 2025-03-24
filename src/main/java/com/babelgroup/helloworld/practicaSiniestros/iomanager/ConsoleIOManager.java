package com.babelgroup.helloworld.practicaSiniestros.iomanager;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleIOManager implements IOManager {

    private Scanner scanner;

    public ConsoleIOManager() {
        this.scanner = new Scanner(System.in);
    }

    public void write(String message) {
        System.out.println(message);
    }

    public String read() {
        return this.scanner.nextLine();
    }

}
