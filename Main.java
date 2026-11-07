import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Info info = new Info();
        info.loadCharactersFromFile();

        boolean looping = true;

        while (looping) {
            displayMenuMain();
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                continue;
            }

            switch (pilihan) {
                case 1:
                    displayMenuStory();
                    try {
                        pilihan = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                        continue;
                    }

                    boolean loopingStory = true;
                    while (loopingStory) {
                        switch (pilihan) {
                            case 1:
                                System.out.println("Story Astral Express");
                                break;
                            case 2:
                                System.out.println("Story Jarilo-VI");
                                break;
                            case 3:
                                System.out.println("Story Xianzhou");
                                break;
                            case 4:
                                System.out.println("Story Penacony");
                                break;
                            case 5:
                                System.out.println("Story Amphoreus");
                                break;
                            case 6:
                                System.out.println("Story Planarcadia");
                                break;
                            case 7:
                                loopingStory = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan masukkan angka menu yang benar.");
                        } if (loopingStory) {
                            displayMenuStory();
                            try {
                                pilihan = Integer.parseInt(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                                continue;
                            }
                        }

                    }
                    break;
                case 2:
                    displayMenuChar();
                    try {
                        pilihan = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                        continue;
                    }

                    boolean loopingChar = true;
                    while (loopingChar) {
                        switch (pilihan) {
                            case 1:
                                searchCharacter(scanner, info);
                                break;
                            case 2:
                                System.out.println("Daftar Karakter:");
                                info.charList();
                                break;
                            case 3:
                                loopingChar = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan masukkan angka menu yang benar.");
                        } if (loopingChar) {
                            displayMenuChar();
                            try {
                                pilihan = Integer.parseInt(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid, masukkan angka menu yang benar.\n");
                                continue;
                            }
                        }
                    }
                    break;
                case 3:
                    looping = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka menu yang benar.");
            }
        }

    }

    private static void searchCharacter(Scanner scanner, Info info) {
        System.out.print("Masukkan nama karakter yang ingin dicari: ");
        String searchName = scanner.nextLine();
        Char foundCharacter = info.cariCharacter(searchName);
        if (foundCharacter != null) {
            System.out.println("Karakter ditemukan:");
            System.out.println(foundCharacter.getInfo());
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }
    }

    private static void displayMenuChar() {
        System.out.println("=============================");
        System.out.println("Menu:");
        System.out.println("1. Cari karakter");
        System.out.println("2. Tampilkan semua karakter");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void displayMenuMain() {
        System.out.println("=============================");
        System.out.println("Menu Utama:");
        System.out.println("1. Rekap Story");
        System.out.println("2. Character");
        System.out.println("3. Exit");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void displayMenuStory() {
        System.out.println("=============================");
        System.out.println("Menu Rekap Story:");
        System.out.println("1. Story Astral Express");
        System.out.println("2. Story Jarilo-VI");
        System.out.println("3. Story Xianzhou");
        System.out.println("4. Story Penacony");
        System.out.println("5. Story Amphoreus");
        System.out.println("6. Story Planarcadia");
        System.out.println("7. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");
    }
}