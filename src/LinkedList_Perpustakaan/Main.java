package LinkedList_Perpustakaan;

import java.util.Scanner;

/**
 * Program pengelolaan daftar buku perpustakaan menggunakan Single Linked List.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookLinkedList daftarBuku = new BookLinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka menu.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan Kode Buku: ");
                    String kode = scanner.nextLine().trim();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine().trim();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;

                case 2:
                    daftarBuku.hapusBuku();
                    break;

                case 3:
                    System.out.print("\nMasukkan Kode Buku: ");
                    String kodeCari = scanner.nextLine().trim();
                    daftarBuku.cariBuku(kodeCari);
                    break;

                case 4:
                    System.out.println();
                    daftarBuku.tampilkanSemua();
                    break;

                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan pilih menu 1-5.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
