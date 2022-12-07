package dead.code.theplatform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dead.code.theplatform.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater)
        inputInfo()
        return binding.root
    }

    fun inputInfo() {
        binding.apply {
            btnCreateAccount.setOnClickListener {
                val name = etName.text.toString()
                val email = etMail.text.toString()
                val password = etPasswordRegister.text.toString()

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || password.length > 8) {
                    etName.error = "Enter Your name"
                    etMail.error = "Enter real mail"
                    etPasswordRegister.error = "must more 8 character "

                } else {
                    Toast.makeText(activity, "Account Created", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}