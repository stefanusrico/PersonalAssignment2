package StackQueue_Kasir;


import java.util.Scanner;

/**
 * Program sistem kasir toko menggunakan struktur data Queue (antrian pelanggan)
 * dan Stack (riwayat transaksi).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
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
                    System.out.print("\nMasukkan Nomor Antrian: ");
                    String noAntrian = scanner.nextLine().trim();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    double total;
                    try {
                        total = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka.");
                        break;
                    }
                    antrian.enqueue(noAntrian, nama, total);
                    break;

                case 2:
                    Node dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian +
                                " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                    }
                    break;

                case 3:
                    System.out.println();
                    antrian.tampilkanAntrian();
                    break;

                case 4:
                    System.out.println();
                    riwayat.tampilkanRiwayat();
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
