package com.london.vistasul1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.london.vistasul1.adapters.PersonAdapter
import com.london.vistasul1.databinding.ActivityListViewPersonBinding
import com.london.vistasul1.models.Parameters

class ListViewPerson : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityListViewPersonBinding
    private lateinit var adapter: PersonAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAgrepe.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        adapter= PersonAdapter(this,Parameters.getPersonsList())
        adapter.notifyDataSetChanged()
        binding.listPerson.adapter = adapter

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_agrepe -> {
                val intent = Intent(this, RegistPerson::class.java)
                startActivity(intent)
            }
        }
    }
}