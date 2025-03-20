import java.util.Scanner;

public class SwalayanTiny {
    private static Scanner scanner = new Scanner(System.in);
    private static Pelanggan[] pelangganList = {
        new Pelanggan("3812345678", 500000, "1234"),
        new Pelanggan("5612345678", 1200000, "5678"),
        new Pelanggan("7412345678", 2500000, "4321")
    };

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Pembelian\n2. Top-Up\n3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 3) break;

            System.out.print("Masukkan nomor pelanggan: ");
            String nomor = scanner.nextLine();
            Pelanggan pelanggan = cariPelanggan(nomor);

            if (pelanggan == null) {
                System.out.println("Nomor tidak ditemukan.");
                continue;
            }

            System.out.print("Masukkan PIN: ");
            String pin = scanner.nextLine();

            if (!pelanggan.autentikasi(pin)) continue;

            System.out.print("Masukkan jumlah: Rp");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();

            if (pilihan == 1) pelanggan.beli(jumlah);
            else pelanggan.topUp(jumlah);
        }
    }

    private static Pelanggan cariPelanggan(String nomor) {
        for (Pelanggan p : pelangganList) {
            if (p != null && nomor.equals(p.getNomorPelanggan())) {
                return p;
            }
        }
        return null;
    }
}
