package com.london.vistasul1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.london.vistasul1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  View.OnClickListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPersons.setOnClickListener(this)
        binding.btnVehic.setOnClickListener(this)
        binding.btnPoke.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_persons->{
                val intent = Intent(this,ListViewPerson::class.java)
                startActivity(intent)
            }
            R.id.btn_vehic->{
                val intent = Intent(this,ListViewCar::class.java)
                startActivity(intent)
            }
            R.id.btn_poke->{
                val intent = Intent(this,ListViewPoke::class.java)
                startActivity(intent)
            }
        }
    }
}