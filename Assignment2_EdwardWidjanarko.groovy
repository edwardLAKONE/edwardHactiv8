class Bank {
    def balance = 100000 // nilai awal simpanan atau inisialisasi saldo awal sebesar Rp 100.000,-
    // menampilkan grid Menu dengan pilihan informasi simpanan, penarikan, transfer, dan keluar
    def displayMenu() {
        println("=== Menu ===")
        println("1. Simpanan")
        println("2. Penarikan")
        println("3. Transfer")
        println("4. Exit")
    }
    // mendefinisikan proses input dari pengguna (mengelola input pengguna dan memanggil fungsi setiap pilihan)
    def processInputMenu(input) {
        switch (input.toInteger()) { // mengarahkan ke case sesuai inputan
            case 1:
                processSaving(askAmount()) // menanyakan jumlah amount untuk proses simpanan
                break //berhenti
            case 2:
                processWithdrawal(askAmount()) // menanyakan jumlah amount untuk proses penarikan
                break //berhenti
            case 3:
                processTransfer(askAmount(), new Bank()) //menanyakan jumlah amount untuk proses transfer dan membuat instance baru dari bank
                break
            case 4:
                println("Terima kasih!") // menampilkan kata terima kasih dan keluar dari program 
                break
            default:
                println("Input tidak valid") // menampilkan pesan klo diinput diluar case atau tidak sesuai opsi
        }
    }
// Meminta pengguna atau user memasukkan jumlah uang dengan validasi
    def askAmount() {
        def amount = 0 // mendefinikan amount awal sebagai nol
        boolean validInput = false // pilihan boolean untuk validasi input

        while (!validInput) { //loop while yang akan terus berjalan sampai pengguna memasukkan input yg valid
            print("Masukkan jumlah: Rp. ") // menampilkan informasi ke pengguna untuk memasukkan sejumlah uang  
            def userInput = System.console().readLine() // membaca input dari pengguna melalui konsol dan menyimpan dalam variabel userInput

            try { // ini blok try = operasi yang mungkin menghasilkan exception
                amount = userInput.toInteger() // Meng-konversi input pengguna ke tipe data integer dan menyimpannya dalam variabel
                validInput = true // Jika konversi berhasil , maka variabel validInput diubah menjadi True. dianggap valid dan keluar.
            } catch (NumberFormatException e) { // Menangkap exception yang mungkin terjadi selama operasi blok try. exception format number
                println("Error: Masukkan angka yang valid.") // Jika terjadi exception, kesalahan ditampilkan dan loop dilanjutkan minta input kembali.
            }
        }

        return amount
    }
// Memproses simpanan dan mengupdate saldo jika jumlahnya valid
    def processSaving(amount) {
        if (amount > 0) {
            balance += amount // proses kalkulasi dari variabel balance di tambah variabel amount
            println("Simpanan berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah simpanan harus lebih besar dari 0")
        }
    }
// Memproses penarikan dan mengupdate saldo juga jumlahnya valid
    def processWithdrawal(amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount // proses kalkulasi cek balance dan amount - variabel balance kurangi variabel amount
            println("Penarikan berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah penarikan tidak valid atau saldo tidak mencukupi")
        }
    }
// Memproses transfer dan mengupdate saldo kedua akun jika jumlahnya valid
    def processTransfer(amount, destinationAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount // operasi pengurangan dari variabel balance dikurangi variabel amount
            destinationAccount.processSaving(amount)
            println("Transfer berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah transfer tidak valid atau saldo tidak mencukupi")
        }
    }
}

def myBank = new Bank()
// Loop UTAMA program yang menampilkan menu dan memproses input pengguna atau user sampai pengguna memilih keluar
while (true) {
    myBank.displayMenu()
    def choice = System.console().readLine()
    
    // Validasi untuk memastikan input adalah angka yang valid
    try {
        Integer.parseInt(choice)
        myBank.processInputMenu(choice)
    } catch (NumberFormatException e) { // harapannya input format harus berupa angka
        println("Error: Pilihan harus berupa angka.")
    }

    // Jika pengguna memilih Exit(4), keluar dari loop.
    if (choice.toInteger() == 4) {
        break
    }
}
