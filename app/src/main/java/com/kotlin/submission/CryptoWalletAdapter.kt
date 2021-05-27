package com.kotlin.submission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CryptoWalletAdapter(val listWallet: ArrayList<CryptoWallet>) : RecyclerView.Adapter<CryptoWalletAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_crypto_wallet, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wallet = listWallet[position]
        Glide.with(holder.itemView.context)
            .load(wallet.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvWName.text = wallet.name
    }

    override fun getItemCount(): Int {
        return listWallet.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.ivLogo)
        var tvWName: TextView = itemView.findViewById(R.id.tv_item_name)
    }
}
