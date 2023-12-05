package com.london.vistasul1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.london.vistasul1.databinding.ActivityRegistPersonBinding
import com.london.vistasul1.models.Parameters
import com.london.vistasul1.models.Person

class RegistPerson : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityRegistPersonBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnGuardper.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_guardper) {
                if (validateFields()) {
                val Persons = Person(
                    binding.txtName.text.toString(),
                    binding.txtEmail.text.toString(),
                    binding.txtPassword.text.toString(),
                    binding.txtUrlImage.text.toString()
                )

                Parameters.setPersonsList(Persons)

                binding.txtName.text.clear()
                binding.txtEmail.text.clear()
                binding.txtPassword.text.clear()
                binding.txtUrlImage.text.clear()

                finish()

            }
        }
    }

    private fun validateFields(): Boolean {
        val name = binding.txtName.text.toString()
        val email = binding.txtEmail.text.toString()
        val password = binding.txtPassword.text.toString()
        val urlImage = binding.txtUrlImage.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || urlImage.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

}