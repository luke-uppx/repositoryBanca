package it.begear.Banca.util;

import java.util.Scanner;

@SuppressWarnings({"unused","resource"})
public class ScannerClass {
	
	public static int readInt() {
		int intgr = 0;
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			intgr = scanner.nextInt();
			return intgr;
		}
		String flush = scanner.nextLine();
		return readInt();
	}
	
	public static double readDouble() {
		double doubl = 0;
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextDouble()) {
			doubl = scanner.nextDouble();
			return doubl;
		}
		String flush = scanner.nextLine();
		return readDouble();
	}
	
	public static String readString() {
		String str = new String();
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			str = scanner.nextLine();
			return str;
		}
		String flush = scanner.nextLine();
		return readString();
	}
	
}
