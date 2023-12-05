package com.london.vistasul1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.london.vistasul1.adapters.PokerAdapter
import com.london.vistasul1.databinding.ActivityListViewPokeBinding
import com.london.vistasul1.models.Parameters


class ListViewPoke : AppCompatActivity(),  View.OnClickListener {
    private lateinit var binding: ActivityListViewPokeBinding
    private  lateinit var adapter: PokerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewPokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAgrepo.setOnClickListener(this)
    }


    override fun onStart() {
        super.onStart()
        adapter= PokerAdapter(this, Parameters.getPokerList())
        adapter.notifyDataSetChanged()
        binding.lstPoke.adapter = adapter
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_agrepo -> {
                val intent = Intent(this, RegistPoke::class.java)
                startActivity(intent)
            }
        }
    }
}