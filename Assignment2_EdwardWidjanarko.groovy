class Bank {
    def balance = 100000 // nilai awal simpanan

    def displayMenu() {
        println("=== Menu ===")
        println("1. Simpanan")
        println("2. Penarikan")
        println("3. Transfer")
        println("4. Exit")
    }

    def processInputMenu(input) {
        switch (input.toInteger()) {
            case 1:
                processSaving(askAmount())
                break
            case 2:
                processWithdrawal(askAmount())
                break
            case 3:
                processTransfer(askAmount(), new Bank())
                break
            case 4:
                println("Terima kasih!")
                break
            default:
                println("Input tidak valid")
        }
    }

    def askAmount() {
        def amount = 0
        boolean validInput = false

        while (!validInput) {
            print("Masukkan jumlah: Rp. ")
            def userInput = System.console().readLine()

            try {
                amount = userInput.toInteger()
                validInput = true
            } catch (NumberFormatException e) {
                println("Error: Masukkan angka yang valid.")
            }
        }

        return amount
    }

    def processSaving(amount) {
        if (amount > 0) {
            balance += amount
            println("Simpanan berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah simpanan harus lebih besar dari 0")
        }
    }

    def processWithdrawal(amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Penarikan berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah penarikan tidak valid atau saldo tidak mencukupi")
        }
    }

    def processTransfer(amount, destinationAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            destinationAccount.processSaving(amount)
            println("Transfer berhasil. Saldo sekarang: Rp. ${balance}")
        } else {
            println("Error: Jumlah transfer tidak valid atau saldo tidak mencukupi")
        }
    }
}

def myBank = new Bank()

while (true) {
    myBank.displayMenu()
    def choice = System.console().readLine()
    
    // Validasi untuk memastikan input adalah angka yang valid
    try {
        Integer.parseInt(choice)
        myBank.processInputMenu(choice)
    } catch (NumberFormatException e) {
        println("Error: Pilihan harus berupa angka.")
    }

    // Jika pengguna memilih Exit, keluar dari loop
    if (choice.toInteger() == 4) {
        break
    }
}
