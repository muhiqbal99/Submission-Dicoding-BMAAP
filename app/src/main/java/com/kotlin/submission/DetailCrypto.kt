package com.kotlin.submission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailCrypto : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnShare : Button
    private lateinit var rvWallet: RecyclerView
    private var listWallet: ArrayList<CryptoWallet> = arrayListOf()

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
        const val EXTRA_CREATOR = "extra_creator"
        const val EXTRA_DOB = "extra_dob"
        const val EXTRA_LAUNCH = "extra_launch"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_crypto)

        rvWallet = findViewById(R.id.rv_wallet)
        rvWallet.setHasFixedSize(true)

        listWallet.addAll(CryptoWalletData.listData)
        showRecyclerCardView()
        showProductDetail()

        btnShare = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Hi ! This is my first apps")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }

    private fun showRecyclerCardView() {
        rvWallet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listWalletAdapter = CryptoWalletAdapter(listWallet)
        rvWallet.adapter = listWalletAdapter
    }

    private fun showProductDetail() {
        val CProfile: ImageView = findViewById(R.id.ivProfile)
        val CCreator: TextView = findViewById(R.id.tv_creator_name)
        val CDOB: TextView = findViewById(R.id.tv_creator_dob)
        val CLaunch: TextView = findViewById(R.id.tv_coin_launch)
        val CDetail: TextView = findViewById(R.id.tv_coin_overview)

        CCreator.setText(intent.getStringExtra(EXTRA_CREATOR))
        CDOB.setText(intent.getStringExtra(EXTRA_DOB))
        CLaunch.setText(intent.getStringExtra(EXTRA_LAUNCH))
        CDetail.setText(intent.getStringExtra(EXTRA_DETAIL))
        val img  = intent.getIntExtra(EXTRA_PROFILE, 0)

        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(CProfile)
    }
}