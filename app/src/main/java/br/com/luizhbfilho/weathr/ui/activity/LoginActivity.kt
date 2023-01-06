package br.com.luizhbfilho.weathr.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.luizhbfilho.weathr.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            loginAuth()
        }
        binding.signInButton.setOnClickListener {
            signInAuth()
        }
    }

    private fun loginAuth() {
        val email = binding.emailTextInputEditText.text.toString()
        val password = binding.passwordTextInputEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter the fields correctly", Toast.LENGTH_SHORT)
                .show()
            return
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                } else {
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    private fun signInAuth() {
    }

//    private fun registerUserWithEmail(email: String) {
//        val firebaseTask = firebaseAuth.createUserWithEmailAndPassword()
//    }
}