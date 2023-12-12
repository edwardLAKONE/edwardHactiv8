//Program sederhana untuk menghitung rata-rata dari sejumlah bilangan yg dimasukkan user/pengguna
def scanner = new Scanner(System.in)
    print "Masukkan jumlah data : "
def jumlahData = scanner.nextInt()
def total = 0
    for (int i = 1; i <= jumlahData; i++) {
        println "Masukkan bilangan ke- $i:   "
    def bilangan = scanner.nextInt()
    total += bilangan
    }
    
def ratarata = total / jumlahData 
println "Rata-rata: $ratarata"