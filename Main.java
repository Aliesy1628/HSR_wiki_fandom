import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Info info = new Info();
        info.loadCharactersFromFile();
        
        boolean looping = true;

        while (looping) {
            displayMenu();
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                continue;
            }

            switch (pilihan) {
                case 1 :
                    searchCharacter(scanner, info);
                    break;
                case 2 :
                    info.tampilkanInfoCharacter();
                    break;
                case 3 :
                    looping = false;
                    break;
                default :
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka menu yang benar.");
            }
        }
        
    }

    private static void searchCharacter(Scanner scanner, Info info) {
            System.out.print("Masukkan nama karakter yang ingin dicari: ");
            String searchName = scanner.nextLine();
            info.cariCharacter(searchName);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Cari karakter");
        System.out.println("2. Tampilkan semua karakter");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }
}