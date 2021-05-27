package com.kotlin.submission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailCrypto : AppCompatActivity() {

    private lateinit var walletName : String
    private lateinit var rvWallet: RecyclerView
    private var listWallet: ArrayList<CryptoWallet> = arrayListOf()

    companion object {
        const val EXTRA_CREATOR = "extra_creator"
        const val EXTRA_DOB = "extra_dob"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_LAUNCH = "extra_launch"
        const val EXTRA_WALLET = "extra_wallet"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_crypto)

        walletName = intent.getStringExtra(EXTRA_WALLET).toString()

        rvWallet = findViewById(R.id.rv_wallet)
        rvWallet.setHasFixedSize(true)

        listWallet.addAll(CryptoWalletData.listData)
        showRecyclerCardView(walletName)
        showProductDetail()
    }


    private fun showProductDetail() {
        var CProfile: ImageView = findViewById(R.id.ivProfile)
        var CCreator: TextView = findViewById(R.id.tv_creator_name)
        var CDOB: TextView = findViewById(R.id.tv_creator_dob)
        var CLaunch: TextView = findViewById(R.id.tv_coin_launch)
        var CDetail: TextView = findViewById(R.id.tv_coin_overview)

        CCreator.setText(intent.getStringExtra(EXTRA_CREATOR))
        CDOB.setText(intent.getStringExtra(EXTRA_DOB))
        CLaunch.setText(intent.getStringExtra(EXTRA_LAUNCH))
        CDetail.setText(intent.getStringExtra(EXTRA_DETAIL))
        val img  = intent.getIntExtra(EXTRA_PHOTO, 0)

        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(CProfile)
    }

    private fun showRecyclerCardView(walletName : String) {
        rvWallet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        val listWalletAdapter = CryptoWalletAdapter(listWallet)
        rvWallet.adapter = listWalletAdapter
    }
}