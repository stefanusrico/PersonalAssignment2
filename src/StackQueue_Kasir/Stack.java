package StackQueue_Kasir;

public class Stack {
    private Node top; // transaksi paling atas (paling baru)
    private int jumlah;

    public Stack() {
        top = null;
        jumlah = 0;
    }

    /**
     * Push - menyimpan data transaksi pelanggan yang baru selesai dilayani ke atas stack.
     */
    public void push(Node data) {
        data.next = top;
        top = data;
        jumlah++;
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    /**
     * Menampilkan riwayat transaksi dari yang terbaru ke yang paling lama.
     */
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (Terbaru ke Lama):");
        Node current = top;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: " + current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total transaksi: " + jumlah);
    }
}
