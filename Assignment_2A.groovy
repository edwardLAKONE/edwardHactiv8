class Barang {
    def id
    def nama
    def harga
    def stok

    Barang(def id, def nama, def harga, def stok) {
        this.id = id
        this.nama = nama
        this.harga = harga
        this.stok = stok
    }

    def getTotalValue() {
        return harga * stok
    }
}

class Toko {
    def daftarBarang = []

    def tambahBarang() {
        print "Masukkan jumlah barang yang akan ditambahkan (0 untuk keluar): "
        def jumlahBarang = System.in.newReader().readLine().toInteger()

        if (jumlahBarang == 0) {
            println "Keluar dari program."
            System.exit(0)
        }

        for (int i = 0; i < jumlahBarang; i++) {
            print "Masukkan ID barang ke-${i + 1}: "
            def id = System.in.newReader().readLine()

            print "Masukkan nama barang: "
            def nama = System.in.newReader().readLine()

            def harga
            while (true) {
                print "Masukkan harga barang: "
                try {
                    harga = System.in.newReader().readLine().toDouble()
                    break
                } catch (NumberFormatException e) {
                    println "Error: Masukkan harga harus berupa angka. Silakan coba lagi."
                }
            }

            print "Masukkan stok barang: "
            def stok = System.in.newReader().readLine().toInteger()

            def barangBaru = new Barang(id, nama, harga, stok)
            daftarBarang << barangBaru
        }
        println "Stok barang ditambahkan."
    }

    def tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            println "Daftar Barang kosong."
        } else {
            println "Daftar Barang:"
            daftarBarang.each { barang ->
                println "ID: ${barang.id}, Nama: ${barang.nama}, Harga: ${barang.harga}, Stok: ${barang.stok}"
            }
        }
    }

    def hitungTotalStok() {
        def totalStok = daftarBarang.collect { it.stok }.sum()
        println "Total stok barang: $totalStok"
    }
}

def toko = new Toko()

while (true) {
    toko.tambahBarang()
    toko.tampilkanDaftarBarang()
    toko.hitungTotalStok()
}
