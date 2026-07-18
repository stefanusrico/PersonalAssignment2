package StackQueue_Kasir;

public class Node {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    Node next; // referensi ke Node selanjutnya

    public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
