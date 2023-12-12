//Program sederhana untuk menghitung rata-rata dari sejumlah bilangan yg dimasukkan user/pengguna
//menangani kesalahan jika user/pengguna memasukkan input yang bukan angka

def scanner = new Scanner(System.in)
print "Masukkan jumlah data: "

def jumlahData = 0
try {
    jumlahData = scanner.nextInt()
} catch (InputMismatchException e) {
    println "Error: Masukkan harus berupa angka."
    System.exit(1) // Keluar dari program jika terjadi kesalahan
}

def total = 0

for (int i = 1; i <= jumlahData; i++) {
    print "Masukkan bilangan ke-$i: "

    def bilangan = 0
    try {
        bilangan = scanner.nextInt()
    } catch (InputMismatchException e) {
        println "Error: Masukkan harus berupa angka."
        System.exit(1) // Keluar dari program jika terjadi kesalahan
    }
        total += bilangan
}

def ratarata = total / jumlahData
println "Rata-rata: $ratarata"