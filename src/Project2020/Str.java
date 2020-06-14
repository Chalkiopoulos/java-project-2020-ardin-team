package Project2020;

import java.util.Formatter;
import java.util.Scanner;


public class Str {
	
	private static Scanner scanner0=new Scanner(System.in);
	
	public static <Typos> void  print(Typos ektypvsh) {System.out.println(ektypvsh); }
	
	public static String keepChars(String source, String letters) {
		//Από το κείμενο που έχεις ορίσει μέσα στο source κρατά μόνο τα γράμματα που αναφέρω στο letters
		int i, s=source.length();
		char c, n='\0';
		StringBuilder ss=new StringBuilder(source);
		for(i=0; i<s; i++) {
			c=ss.charAt(i);
			if (letters.indexOf(c)==-1) ss.setCharAt(i, n);
		}
		return new String(ss).replaceAll("\0", "");
	}
	
	public static String noSpecialChars(String source) {
		String s="\n\r\t\b\f";
		for(int i=0; i<s.length(); i++) source=source.replaceAll(s.substring(i,i+1), " ");
		return source;
	}
	
	public static String left(String source, int len) {
		if(len<=0) return "";
		if(len>source.length()) return source;
		return source.substring(0, len);
	}
	
		
	public static String input(String mhnyma) {
		//import java.util.Scanner;
		//private static Scanner scanner0=new Scanner(System.in);
		//Αν κάθε φορά δημιουργείς ξανά τον Scanner ΔΕΝ δουλεύει σωστά
		System.out.print(mhnyma + " ");
		String r="";
		scanner0.useDelimiter("(\\b|\\B)");
		r=scanner0.nextLine();
		if (r.equalsIgnoreCase("\n")) r=""; 
		return r;
	}
	
	public static int inputInt(String prompt, int min, int max) {
		 //Διαβάζει έναν ακέραιο αριθμό μεταξύ των ορίων που ορίζεις
		 String sVal = "";
		 int val;
		 if (min>max) { val=min; min=max; max=val; }
			do {
				sVal = input(prompt);
				try {val = Integer.parseInt(sVal); }
				catch (NumberFormatException e) {	val = min - 1; }
			} while (val < min || val > max);
			return val;
		}
	
	public static long longOf(String ariumos) {
		ariumos=ariumos.trim().replaceAll(" ", "");
		if (ariumos.isEmpty()) return 0;
		long r;
		try {
			r=Long.parseLong(ariumos);
		} catch(NumberFormatException e) {
			r=longOf(ariumos.substring(0, ariumos.length()-1));
		}
		return r;
	}
	
	public static int intOf(String ariumos) {
		ariumos=ariumos.trim().replaceAll(" ", "");
		if (ariumos.isEmpty()) return 0;
		int r;
		try {
			r=Integer.parseInt(ariumos);
		} catch(NumberFormatException e) {
			r=intOf(ariumos.substring(0, ariumos.length()-1));
		}
		return r;
	}
	
	public static double doubleOf(String ariumos) {
		ariumos=ariumos.trim().replaceAll(" ", "");
		if (ariumos.isEmpty()) return 0;
		double r;
		try {
			r=Double.parseDouble(ariumos);
		} catch(NumberFormatException e) {
			r=val(ariumos.substring(0, ariumos.length()-1));
		}
		return r;
	}
	public static double val(String ariumos) {return doubleOf(ariumos); }
	
	public static double euro(double poso) {
		return 0.01*Math.floor(poso*100+0.5);
	}
	
	public static String euroStr(double poso) {
		Formatter ff=new Formatter();
		ff.format("%.2f", poso);
		String s=ff.toString()+"Eur";
		ff.close();
		return s;
	}
	

}
