package com.humBug;
import java.util.Scanner;
public class humBug {
	public static void main(String[] args) {
			for (int i = 0; i <= 100; i++)
			{
				
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println("HumBug");
					continue;
				}
				else if (i % 3 == 0) {
					System.out.println("Hum");
				}
				else if (i % 5 == 0) {
					System.out.println("Bug");
				}
				else {
					System.out.println(i);
				}
			}
		
	}
}
