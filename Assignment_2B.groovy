//Error = Masukkan harga harus berupa Angka
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
        print "Masukkan jumlah barang yang ingin ditambahkan: "
        def jumlahBarang = System.in.newReader().readLine().toInteger()

        for (int i = 0; i < jumlahBarang; i++) {
            print "Masukkan ID barang (angka atau string) untuk barang ke-${i+1}: "
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
                    println "Harga harus berupa angka. Silakan coba lagi."
                }
            }

            print "Masukkan stok barang: "
            def stok = System.in.newReader().readLine().toInteger()

            def barangBaru = new Barang(id, nama, harga, stok)
            daftarBarang << barangBaru
            println "Stok."
        }
    }


    def tampilkanDaftarBarang() {
        println "Daftar Barang:"
        daftarBarang.each { barang ->
            println "ID: ${barang.id}, Nama: ${barang.nama}, Harga: ${barang.harga}, Stok: ${barang.stok}"
        }
    }

    def hitungTotalInventaris() {
        def total = daftarBarang.collect { it.getTotalValue() }.sum()
        println "Total nilai inventaris toko: $total"
    }
}

def toko = new Toko()

while (true) {
    println("Menu:")
    println("1. Jumlah Barang ditambahkan")
    println("2. Daftar Barang")
    println("3. Stok Barang")
    println("4. Keluar")
    print("Pilih menu (1-4): ")

    def pilihan = System.in.newReader().readLine().toInteger()

    switch (pilihan) {
        case 1:
            toko.tambahBarang()
            break
        case 2:
            toko.tampilkanDaftarBarang()
            break
        case 3:
            toko.hitungTotalInventaris()
            break
        case 4:
            println("Keluar dari program.")
            System.exit(0)
            break
        default:
            println("Pilihan tidak valid. Silakan pilih lagi.")
    }
}
