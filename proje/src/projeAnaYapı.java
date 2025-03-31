import java.util.Scanner;
import java.util.Random;
public class projeAnaYapı {
	public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        Random random = new Random();
        zarAt_Class Zarİşlemleri = new zarAt_Class();
        yazıturaVeSaldır_Class YazıTuraİşlemleri = new yazıturaVeSaldır_Class ();
        girdi_Class girdiİşlemleri = new girdi_Class();
        
        int oyuncu1can = 20;
        int oyuncu2can = 20;
        // Oyuncu adlarının alınması
        System.out.println("                                                            '1 Liralık Arkadaş' Oyununa Hoşgeldiniz\nDevam etmek için oyuncu isimlerini giriniz--->");
        entry.nextLine();// Boşluğu temizlemek için eklenen satır
        String oyuncu1isim = girdiİşlemleri.girdi(entry, "Birinci oyuncunun adı:");
        String oyuncu2isim = girdiİşlemleri.girdi(entry, "İkinci oyuncunun adı:");
        
        System.out.println("\n" + oyuncu1isim + " ve " + oyuncu2isim + " karşı karşıya. Oyun başlıyor!\n");
        System.out.println("İlk oyuncuyu seçmek için zar atacağız. Büyük atan başlar.\n");

        // İlk oyuncuyu belirlemek için zar atma işlemi
        int oyuncu1Zar = Zarİşlemleri.zarAt(entry, random);
        System.out.println("Oyuncu 1'in zarı: " + oyuncu1Zar);
        int oyuncu2Zar = Zarİşlemleri.zarAt(entry, random);
        System.out.println("Oyuncu 2'nin zarı: " + oyuncu2Zar);

      //sıranın belirlenmesi
        boolean oyuncu1Basliyor = oyuncu1Zar > oyuncu2Zar;
        System.out.println((oyuncu1Basliyor ? oyuncu1isim : oyuncu2isim) + " oyuna başlıyor!\n");
        
        // Oyun döngüsü
        while (oyuncu1can > 0 && oyuncu2can > 0) {
            System.out.println(oyuncu1isim + " CAN: " + oyuncu1can);
            System.out.println(oyuncu2isim + " CAN: " + oyuncu2can);

            if (oyuncu1Basliyor) {
            oyuncu2can = YazıTuraİşlemleri.yazıturaVeSaldır (entry, random, oyuncu1isim, oyuncu2isim, oyuncu2can);
            if (oyuncu2can <= 0) break;
            oyuncu1can = YazıTuraİşlemleri.yazıturaVeSaldır(entry, random, oyuncu2isim, oyuncu1isim, oyuncu1can);
            }else {
                oyuncu1can = YazıTuraİşlemleri.yazıturaVeSaldır(entry, random, oyuncu2isim, oyuncu1isim, oyuncu1can);
            if (oyuncu1can <= 0) break;
                oyuncu2can = YazıTuraİşlemleri.yazıturaVeSaldır(entry, random, oyuncu1isim, oyuncu2isim, oyuncu2can);
            }
        }
        
        // Kazanan belirlem
        if (oyuncu1can <= 0) {
            System.out.println(oyuncu2isim + " oyunu kazandı!");
        } else {
            System.out.println(oyuncu1isim + " oyunu kazandı!");
        }

        entry.close();
    }
   
}
	