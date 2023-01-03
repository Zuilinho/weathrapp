package br.com.luizhbfilho.weathr.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.luizhbfilho.weathr.databinding.ActivityLoginBinding
import br.com.luizhbfilho.weathr.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    private fun registerUserWithEmail(email: String) {
//        val firebaseTask = firebaseAuth.createUserWithEmailAndPassword()
//    }
}