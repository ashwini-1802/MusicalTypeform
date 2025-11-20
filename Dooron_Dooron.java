package com.first;

import java.util.concurrent.TimeUnit;

public class Dooron_Dooron {

	public static void typeLine(String line, long charDelay) throws InterruptedException {
		for (char ch : line.toCharArray()) {
			System.out.print(ch);
			System.out.flush();
			TimeUnit.MILLISECONDS.sleep(charDelay);
		}
		System.out.println();
	}

	public static void printLyrics() throws InterruptedException {
		String[] lyrics = { "Sochu Ke Milni Te Bolanga Ki", "Teri Ta Gallaan Ch Shayari",
				"Vekhegi Mainu Te Sochegi Kya Tu?", "Mitti Da Banda Main, Tu Ta Pari",
				"Ishq De Galiyaan Ch, Khoya Ae Dil Ve", "Aas Lagaye ik jaaye Tu Mil Ve", "Kol Tere Mainu Aan De Soni",
				"Karaan Main Kitne Jatan O Soni", "Dooron Dooron Main" };

		double[] delays = { 1.8, 1.8, 1.8, 1.5, 2.3, 2.3, 1.8, 2.5, 3.0 };

		System.out.println("Dooron Dooron..\n");
		TimeUnit.MILLISECONDS.sleep(1500);

		for (int i = 0; i < lyrics.length; i++) {
			String line = lyrics[i];
			// Print the line character by character
			typeLine(line, 65);
			// Sleep after printing the full line
			long sleepMillis = (long) (delays[i] * 1000);
			try {
				TimeUnit.MILLISECONDS.sleep(sleepMillis);
			} catch (InterruptedException e) {
				// Restore interrupt status and exit if interrupted
				Thread.currentThread().interrupt(); // good practice to re-interrupt
				System.err.println("Printing interrupted");
				return;
			}
		}
	}

	public static void main(String[] args) {
		try {
			printLyrics();
		} catch (InterruptedException e) {
			// Restore the interrupt flag just in case
			Thread.currentThread().interrupt();
			System.err.println("Main thread interrupted, stopping.");
		}
	}
}
