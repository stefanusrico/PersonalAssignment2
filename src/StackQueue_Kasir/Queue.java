package StackQueue_Kasir;


public class Queue {
    private Node front; // pelanggan paling depan (akan dilayani lebih dulu)
    private Node rear;  // pelanggan paling belakang (baru masuk antrian)
    private int jumlah;

    public Queue() {
        front = null;
        rear = null;
        jumlah = 0;
    }

    /**
     * Enqueue - menambahkan pelanggan baru ke akhir (belakang) antrian.
     */
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node baru = new Node(nomorAntrian, namaPelanggan, totalBelanja);
        if (rear == null) {
            // antrian masih kosong
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlah++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    /**
     * Dequeue - mengeluarkan pelanggan paling depan untuk dilayani.
     * Mengembalikan Node pelanggan yang dilayani, atau null jika antrian kosong.
     */
    public Node dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada pelanggan untuk dilayani.");
            return null;
        }
        Node dilayani = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian menjadi kosong
        }
        jumlah--;
        // Putuskan referensi next agar Node ini "bersih" saat nanti di-push ke Stack
        dilayani.next = null;
        return dilayani;
    }

    /**
     * Menampilkan seluruh antrian pelanggan saat ini, dari depan ke belakang.
     */
    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian Pelanggan Saat Ini:");
        Node current = front;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: " + current.totalBelanja);
            current = current.next;
        }
        System.out.println("Jumlah pelanggan dalam antrian: " + jumlah);
    }

    public int getJumlah() {
        return jumlah;
    }
}
