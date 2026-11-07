public class Main {
    public static void main(String[] args) {
        Info info = new Info();
        info.loadCharactersFromFile();
        info.tampilkanInfoCharacter();

        String searchName = "Elysia"; // Ganti dengan nama karakter yang ingin dicari
        Char foundCharacter = info.cariCharacter(searchName);
        if (foundCharacter != null) {
            System.out.println("Informasi karakter ditemukan:");
            System.out.println(foundCharacter.getInfo());
        } else {
            System.out.println("Karakter dengan nama '" + searchName + "' tidak ditemukan.");
        }
    }
}