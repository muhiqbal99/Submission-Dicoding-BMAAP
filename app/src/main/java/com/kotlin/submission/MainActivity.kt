package com.kotlin.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCrypto: RecyclerView
    private var list: ArrayList<Crypto> = arrayListOf()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCrypto = findViewById(R.id.rv_crypto)
        rvCrypto.setHasFixedSize(true)

        list.addAll(CryptoData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCrypto.layoutManager = LinearLayoutManager(this)
        val listCryptoAdapter = ListCryptoAdapter(list)
        rvCrypto.adapter = listCryptoAdapter
    }

    private fun showRecyclerGrid() {
        rvCrypto.layoutManager = GridLayoutManager(this, 2)
        val gridCryptoAdapter = GridCryptoAdapter(list)
        rvCrypto.adapter = gridCryptoAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
            }
        }
    }
}