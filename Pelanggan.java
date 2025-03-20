class Pelanggan {
    private String nomorPelanggan;
    private double saldo;
    private String pin;
    private int kesalahanLogin = 0;
    private boolean diblokir = false;

    public Pelanggan(String nomorPelanggan, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.saldo = saldo;
        this.pin = pin;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isDiblokir() {
        return diblokir;
    }

    public boolean autentikasi(String pin) {
        if (diblokir) {
            System.out.println("Akun diblokir.");
            return false;
        }
        if (this.pin.equals(pin)) {
            kesalahanLogin = 0;
            return true;
        } else {
            kesalahanLogin++;
            if (kesalahanLogin >= 3) {
                diblokir = true;
                System.out.println("Akun telah diblokir.");
            }
            return false;
        }
    }

    public void topUp(double jumlah) {
        saldo += jumlah;
        System.out.println("Top-up berhasil. Saldo: Rp" + saldo);
    }

    public boolean beli(double jumlah) {
        if (saldo - jumlah < 10000) {
            System.out.println("Transaksi gagal.");
            return false;
        }
        saldo -= jumlah;
        saldo += hitungCashback(jumlah);
        System.out.println("Pembelian berhasil. Saldo: Rp" + saldo);
        return true;
    }

    private double hitungCashback(double jumlah) {
        if (jumlah > 1000000) {
            return jumlah * 0.05;
        }
        return 0;
    }
}
