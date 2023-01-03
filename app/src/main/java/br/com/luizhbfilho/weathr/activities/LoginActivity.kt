package br.com.luizhbfilho.weathr.activities

import androidx.appcompat.app.AppCompatActivity
import br.com.luizhbfilho.weathr.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val firebaseAuth = Firebase.auth

    private fun registerUserWithEmail(email: String) {
        val firebaseTask = firebaseAuth.createUserWithEmailAndPassword()
    }
}