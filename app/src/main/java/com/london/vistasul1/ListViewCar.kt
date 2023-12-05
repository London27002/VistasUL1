package com.london.vistasul1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.london.vistasul1.adapters.CarAdapter
import com.london.vistasul1.databinding.ActivityListViewCarBinding
import com.london.vistasul1.models.Parameters


class ListViewCar : AppCompatActivity(),  View.OnClickListener  {
    private lateinit var binding: ActivityListViewCarBinding
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgrev.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        adapter= CarAdapter(this,Parameters.getCarsList())
        adapter.notifyDataSetChanged()
        binding.lstCar.adapter=adapter
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_agrev -> {
                val intent = Intent(this, RegistCars::class.java)
                startActivity(intent)
            }
        }
    }
}