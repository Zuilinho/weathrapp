package br.com.luizhbfilho.weathr.ui.fragment

import androidx.fragment.app.Fragment
import br.com.luizhbfilho.weathr.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInFragment: Fragment() {

    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth


}