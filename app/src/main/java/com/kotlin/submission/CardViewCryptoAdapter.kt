package com.kotlin.submission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewCryptoAdapter(private val listCrypto: ArrayList<Crypto>) :
    RecyclerView.Adapter<CardViewCryptoAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewCryptoAdapter.CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewCryptoAdapter.CardViewViewHolder, position: Int) {
        val crypto = listCrypto[position]
        Glide.with(holder.itemView.context)
            .load(crypto.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvCName.text = crypto.creator
        holder.tvCDob.text = crypto.dob
        holder.tvCLaunch.text = crypto.launch
        holder.tvCWallet.text = crypto.wallet
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listCrypto[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return listCrypto.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.ivProfile)
        var tvCName: TextView = itemView.findViewById(R.id.tv_creator_name)
        var tvCDob: TextView = itemView.findViewById(R.id.tv_creator_dob)
        var tvCLaunch: TextView = itemView.findViewById(R.id.tv_launch_coin)
        var tvCWallet: TextView = itemView.findViewById(R.id.tv_support_wallet)
    }
}