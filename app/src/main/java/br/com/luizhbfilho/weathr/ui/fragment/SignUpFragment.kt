package br.com.luizhbfilho.weathr.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.luizhbfilho.weathr.databinding.FragmentSignUpBinding
import br.com.luizhbfilho.weathr.ui.viewmodel.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val email = binding.enterEmailTextInputEditText.text.toString()
        val password = binding.createPasswordTextEditText.text.toString()
        val confirmPassword = binding.confirmPasswordTextEditText.text.toString()

        binding.signUpButton.setOnClickListener {
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(activity, "Please complete the fields correctly", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                Toast.makeText(activity, "The passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(activity, "Welcome, ${user?.email}!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(
                            activity,
                            "Sign Up error: ${task.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}