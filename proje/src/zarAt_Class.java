import java.util.Scanner;
import java.util.Random;
public class zarAt_Class {
	public static int zarAt(Scanner entry,Random random) {
		 while (true) {
 System.out.println("Zar atmak için 'ZARLA' komutunu girin:");
 String komut = entry.next();	
	 if (komut.equalsIgnoreCase("ZARLA")) {
              return random.nextInt(6) + 1;
	            } else {
	        System.out.println("Geçersiz komut. Lütfen tekrar deneyin.");
	          }
		 }
	}
	
}
