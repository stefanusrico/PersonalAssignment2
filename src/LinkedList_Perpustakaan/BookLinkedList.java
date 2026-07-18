package LinkedList_Perpustakaan;


public class BookLinkedList {
    private Node head; // penunjuk ke elemen pertama dalam list
    private int jumlahBuku;

    public BookLinkedList() {
        head = null;
        jumlahBuku = 0;
    }

    /**
     * Tambah Buku (Push) - menambahkan data buku baru di akhir list.
     * Validasi: kodeBuku maksimal 5 karakter.
     */
    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Gagal menambahkan! Kode Buku maksimal 5 karakter.");
            return false;
        }
        if (kodeBuku.isEmpty() || judul.isEmpty() || penulis.isEmpty()) {
            System.out.println("Gagal menambahkan! Semua data (kode, judul, penulis) wajib diisi.");
            return false;
        }

        Node bukuBaru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            // Jika list masih kosong, buku baru menjadi head
            head = bukuBaru;
        } else {
            // Telusuri sampai Node terakhir, lalu sambungkan buku baru di akhir
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = bukuBaru;
        }

        jumlahBuku++;
        System.out.println("Data berhasil ditambahkan!");
        return true;
    }

    /**
     * Hapus Buku (Pop) - menghapus data buku TERAKHIR dari daftar.
     */
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            // Hanya ada satu buku dalam list
            System.out.println("Buku \"" + head.judul + "\" berhasil dihapus.");
            head = null;
        } else {
            // Telusuri sampai satu Node sebelum Node terakhir
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku \"" + current.next.judul + "\" berhasil dihapus.");
            current.next = null; // putuskan hubungan ke Node terakhir
        }
        jumlahBuku--;
    }

    /**
     * Cari Buku - mencari buku berdasarkan kodeBuku.
     */
    public void cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan:");
                System.out.println("Kode: " + current.kodeBuku +
                        " | Judul: " + current.judul +
                        " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    /**
     * Tampilkan Semua Buku - menampilkan seluruh data sesuai urutan input.
     */
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Belum ada data buku.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku +
                    " | Judul: " + current.judul +
                    " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + jumlahBuku);
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }
}
