package com.kotlin.submission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListCryptoAdapter(val listCrypto: ArrayList<Crypto>) : RecyclerView.Adapter<ListCryptoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_crypto, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val crypto = listCrypto[position]
        Glide.with(holder.itemView.context)
            .load(crypto.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvCName.text = crypto.name
        holder.tvCDesc.text = crypto.detail
        holder.btnReadmore.setOnClickListener {
            val context= holder.btnReadmore.context
            val cryptoDetailActivity = Intent(context, DetailCrypto::class.java)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_CREATOR, crypto.name)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_DOB, crypto.dob)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_PHOTO, crypto.photo)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_LAUNCH, crypto.launch)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_WALLET, crypto.wallet)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_WALLET_IMG, crypto.walletimg)
            cryptoDetailActivity.putExtra(DetailCrypto.EXTRA_DETAIL, crypto.detail)
            context.startActivity(cryptoDetailActivity)
        }
    }

    override fun getItemCount(): Int {
        return listCrypto.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.ivLogo)
        var tvCName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCDesc: TextView = itemView.findViewById(R.id.tv_item_description)
        var btnReadmore: Button = itemView.findViewById(R.id.btn_readmore)
    }
}