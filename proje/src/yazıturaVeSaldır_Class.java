import java.util.Scanner;
import java.util.Random;
public class yazıturaVeSaldır_Class {
	
	 public static int yazıturaVeSaldır(Scanner entry, Random random, String tahminci, String rakip, int rakipCan) {
		 
		    System.out.println("\n" + tahminci + ", Yazı Tura tahmininizi girin (YAZI/TURA):");
	        String tahmin = entry.next();
	        String yazituraSonucu = random.nextBoolean() ? "YAZI" : "TURA";
	        System.out.println("Yazı Tura sonucu: " + yazituraSonucu+"\n");

	        if (tahmin.equalsIgnoreCase(yazituraSonucu)) {
	            System.out.println(tahminci + " doğru tahmin etti!");

	            System.out.println(tahminci + ", iki kat hasar için ikinci bir Yazı Tura tahmini yapmak ister misiniz? (Evet/Hayır)");
	            String cevap = entry.next();
	            if (cevap.equalsIgnoreCase("Evet")) {
	                System.out.println("İkinci tahmininizi yapın (YAZI/TURA):");
	                tahmin = entry.next();
	                yazituraSonucu = random.nextBoolean() ? "YAZI" : "TURA";
	                System.out.println("İkinci Yazı Tura sonucu: " + yazituraSonucu);

	                if (tahmin.equalsIgnoreCase(yazituraSonucu)) {
	                    System.out.println(tahminci + " ikinci tahminde de başarılı! Zar atılacak.");
	                    int zarSonucu = zarAt_Class.zarAt(entry, random);
	                    System.out.println("Atılan zar: " + zarSonucu);
	                    rakipCan -= zarSonucu * 2; // İki kat hasar
	                } else {
	                    System.out.println(tahminci + " ikinci tahminde başarısız oldu. Hasar uygulanmadı.");
	                }
	            } else {
	                System.out.println(tahminci + " zar atıyor.");
	                int zarSonucu = zarAt_Class.zarAt(entry, random);
	                System.out.println("Atılan zar: " + zarSonucu);
	                rakipCan -= zarSonucu; // Normal hasar
	            }
	        } else {
	            System.out.println(tahminci + " yanlış tahmin etti. Saldırı yapılamadı.");
	        }
	        return rakipCan;
	    }
}
