package com.kotlin.submission

object CryptoWalletData {
    private val nameToPhoto = mapOf(
        "Ledger" to R.drawable.ledger,
        "Trezor" to R.drawable.trezor,
        "MathWallet" to R.drawable.mathwallet
    )

    val listData: ArrayList<CryptoWallet>
        get() {
            val list = arrayListOf<CryptoWallet>()
            for ((walletName, walletPhoto) in nameToPhoto) {
                val wallet = CryptoWallet()
                wallet.name = walletName
                wallet.photo = walletPhoto
                list.add(wallet)
            }
            return list
        }
}