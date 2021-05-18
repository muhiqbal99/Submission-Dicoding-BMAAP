package com.kotlin.submission

object CryptoData {
    private val cryptoNames = arrayOf("Bitcoin",
        "Ethereum",
        "Binance Coin",
        "Cardano",
        "Dogecoin",
        "TheterUs",
        "XRP",
        "Polkadot",
        "Bitcoin Cash",
        "Litcoin")

    private val cryptoDetails = arrayOf("Bitcoin is a peer-to-peer online currency, meaning that all transactions happen directly between equal, independent network participants, without the need for any intermediary to permit or facilitate them. Bitcoin was created, according to Nakamoto’s own words, to allow \"online payments to be sent directly from one party to another without going through a financial institution.\"",
        "Ethereum is a decentralized open-source blockchain system that features its own cryptocurrency, Ether. ETH works as a platform for numerous other cryptocurrencies, as well as for the execution of decentralized smart contracts. Ethereum’s own purported goal is to become a global platform for decentralized applications, allowing users from all over the world to write and run software that is resistant to censorship, downtime and fraud.",
        "Launched in July 2017, Binance is one of the biggest cryptocurrency exchanges globally. By aiming to bring cryptocurrency exchanges to the forefront of financial activity globally. The idea behind Binance’s name is to show this new paradigm in global finance — Binary Finance, or Binance.",
        "Cardano is a proof-of-stake blockchain platform that says its goal is to allow “changemakers, innovators and visionaries” to bring about positive global change.",
        "Dogecoin (DOGE) is based on the popular \"doge\" Internet meme and features a Shiba Inu on its logo. The open-source digital currency was created by Billy Markus from Portland, Oregon and Jackson Palmer from Sydney, Australia, and was forked from Litecoin in December 2013.",
        "USDT is a stablecoin (stable-value cryptocurrency) that mirrors the price of the U.S. dollar, issued by a Hong Kong-based company Tether. The token’s peg to the USD is achieved via maintaining a sum of dollars in reserves that is equal to the number of USDT in circulation.",
        "XRP is the currency that runs on a digital payment platform called RippleNet, which is on top of a distributed ledger database called XRP Ledger.",
        "Polkadot is an open-source sharding multi chain protocol that facilitates the cross-chain transfer of any data or asset types, not just tokens, thereby making a wide range of blockchains interoperable with each other.",
        "Bitcoin Cash is a peer-to-peer electronic cash system that aims to become sound global money with fast payments, micro fees, privacy, and high transaction capacity (big blocks). In the same way that physical money, such as a dollar bill, is handed directly to the person being paid, Bitcoin Cash payments are sent directly from one person to another.",
        "Litecoin (LTC) is a cryptocurrency that was designed to provide fast, secure and low-cost payments by leveraging the unique properties of blockchain technology.")

    private val cryptoATH = arrayOf("64,863.10",
    "4,362.35",
    "690.93",
    "2.46",
    "0.7376",
    "1.06",
    "1.96",
    "49.69",
    "1,635.15",
    "412.96")

    private val cryptoPrice24Hours = arrayOf("45,812.46",
    "3,562.47",
    "534.18",
    "2.15",
    "0.5156",
    "1.00",
    "1.70",
    "41.63",
    "1,167.23",
    "318.05")

    private val cryptoWallet = arrayOf("Ledger, Trezor, MathWallet, TrustWallet, BTCWallet, Electrum, Coinbase, Cobo, Safepal, Edge",
    "Ledger, Trezor, MathWallet, TrustWallet, Metamask, MyCrypto, Coinbase, Cobo, imToken, SafePal, Binance Chain Wallet, Argent",
    "Ledger, Trezor, MathWallet, TrustWallet, SafePal, Binance Chain Wallet",
    "Ledger, Trezor, MathWallet, TrustWallet, Exodus, SafePal",
    "Ledger, Trezor, MathWallet, TrustWallet, Metamask, DogeCoin Core",
    "Ledger, Trezor, MathWallet, TrustWallet, Metamask, Coinbase, Cobo, SafePal, Tronlink, Binance Chain Wallet, Sollet",
    "Ledger, Trezor, MathWallet, TrustWallet, Coinbase, Cobo, HyperPay, SafePal, Atomic Wallet",
    "Ledger, Trezor, MathWallet, TrustWallet, Metamask, Fairy-wallet, Parity Signer, SafePal, Ownbit, Dharma, Binance Chain Wallet",
    "Ledger, Trezor, MathWallet, TrustWallet, BTC Wallet, Metamask, Coinbase, Cobo, SafePal",
    "Ledger, Trezor, MathWallet, TrustWallet, Coinbase, Cobo, SafePal, Luno")

    private val cryptoImages = intArrayOf(R.drawable.logo_btc,
        R.drawable.logo_eth,
        R.drawable.logo_bnb,
        R.drawable.logo_ada,
        R.drawable.logo_doge,
        R.drawable.logo_usdt,
        R.drawable.logo_xrp,
        R.drawable.logo_pol,
        R.drawable.logo_bch,
        R.drawable.logo_ltc)

    val listData: ArrayList<Crypto>
        get() {
            val list = arrayListOf<Crypto>()
            for (position in cryptoNames.indices) {
                val crypto = Crypto()
                crypto.name = cryptoNames[position]
                crypto.detail = cryptoDetails[position]
                crypto.photo = cryptoImages[position]
                list.add(crypto)
            }
            return list
        }
}