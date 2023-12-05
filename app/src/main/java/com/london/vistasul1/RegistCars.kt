package com.london.vistasul1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.london.vistasul1.databinding.ActivityRegistCarrosBinding
import com.london.vistasul1.models.Car
import com.london.vistasul1.models.Parameters


class RegistCars : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistCarrosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistCarrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardcar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_guardcar) {
            if (validateFields()) {
                val Cars = Car(
                    binding.txtName.text.toString(),
                    binding.txtPlaq.text.toString(),
                    binding.txtColor.text.toString(),
                    binding.txtUrlImage.text.toString()
                )

                Parameters.setCarsList(Cars)



                binding.txtName.text.clear()
                binding.txtPlaq.text.clear()
                binding.txtColor.text.clear()
                binding.txtUrlImage.text.clear()

                finish()
            }
        }

    }

    private fun validateFields(): Boolean {
        val name = binding.txtName.text.toString()
        val plaque = binding.txtPlaq.text.toString()
        val colors = binding.txtColor.text.toString()
        val urlImage = binding.txtUrlImage.text.toString()

        if (name.isEmpty() || plaque.isEmpty() || colors.isEmpty() || urlImage.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false

        }
        return true
    }
}