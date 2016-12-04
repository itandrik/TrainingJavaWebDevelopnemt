package com.javaweb;

import java.util.Scanner;

/**
 * Adapter for {@link Scanner} for mock testing
 *
 * @author      Andrii Chernysh
 * @version     1.0, 02 Dec 2016
 */
public class ScannerAdapter {
    private Scanner scanner;

    public ScannerAdapter(Scanner scanner) {
        this.scanner = scanner;
    }
    public ScannerAdapter(){
        scanner = new Scanner(System.in);
    }

    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    public String next() {
        return scanner.next();
    }

    public boolean hasNext(String string) {
        return scanner.hasNext(string);
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
