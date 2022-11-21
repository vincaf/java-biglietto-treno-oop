package org.buyticket.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserire i km da percorrere: ");
		int userKm = sc.nextInt();
		
		System.out.print("Inserire età passeggero: ");
		int userAge = sc.nextInt();
		
		System.out.print("Biglietto flessibile (true/false): ");
		boolean flexible = sc.nextBoolean();
		
		sc.close();
		
		System.out.println("\n----------\n");
		
		Biglietto b1 = null;
		try {
			b1 = new Biglietto(userKm, userAge, flexible);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(b1);
		}
	}

}
