package com.pechenkin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ilya on 15.06.2016.
 */
public class Triangle {
    public static void main(String[] args) throws IOException {
        //getcounter
        FileInputStream fileInputStream = new FileInputStream("C:\\Autodesk\\Triangle.txt");
        int counter = 1;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == 10) counter++;
        }
        fileInputStream.close();
        System.out.println(counter);
        //initialize array
        Scanner scanner = new Scanner(new File("C:\\Autodesk\\Triangle.txt"));
        int[][] triangle = new int[counter][counter];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < i+1; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }
        //triangle[0][0] i an answer
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle.length - 1; j++) {
                if (triangle[i][j] > triangle[i][j + 1]) {
                    triangle[i - 1][j] += triangle[i][j];
                } else {
                    triangle[i - 1][j] += triangle[i][j+1];
                }
            }
        }
        System.out.println(triangle[0][0]);
    }
}
