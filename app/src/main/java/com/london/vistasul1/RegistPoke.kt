package com.london.vistasul1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.london.vistasul1.databinding.ActivityRegistPokeBinding
import com.london.vistasul1.models.Parameters
import com.london.vistasul1.models.Poker


class RegistPoke : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistPokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistPokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardpoke.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_guardpoke){
            if(validateFields()){
                val Pokers = Poker(
                    binding.txtName.text.toString(),
                    binding.txtTip.text.toString(),
                    binding.txtPod.text.toString(),
                    binding.txtUrlImage.text.toString()
                )

                Parameters.setPokerList(Pokers)


                binding.txtName.text.clear()
                binding.txtTip.text.clear()
                binding.txtPod.text.clear()
                binding.txtUrlImage.text.clear()

                finish()

            }

        }
    }
    private fun validateFields(): Boolean {
        val name = binding.txtName.text.toString()
        val tip = binding.txtTip.text.toString()
        val power= binding.txtPod.text.toString()
        val urlImage = binding.txtUrlImage.text.toString()

        if(name.isEmpty() || tip.isEmpty() || power.isEmpty() || urlImage.isEmpty()){
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}