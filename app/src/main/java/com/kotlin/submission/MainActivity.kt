package com.kotlin.submission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCrypto: RecyclerView
    private var list: ArrayList<Crypto> = arrayListOf()
    private var title: String = "Cryptocurrency"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)
        rvCrypto = findViewById(R.id.rv_crypto)
        rvCrypto.setHasFixedSize(true)

        list.addAll(CryptoData.listData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        rvCrypto.layoutManager = LinearLayoutManager(this)
        val listCryptoAdapter = ListCryptoAdapter(list)
        rvCrypto.adapter = listCryptoAdapter
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
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
            R.id.action_aboutme -> {
                startActivity(Intent(this@MainActivity, AboutMe::class.java))
            }
        }
        setActionBarTitle(title)
    }

}