package com.example.authmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.authmvvm.models.auth.AuthViewModel
import com.example.authmvvm.databinding.FragmentLoginBinding
import com.example.authmvvm.util.Response
import com.example.authmvvm.util.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class login : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var authViewModel : AuthViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


        override fun onViewCreated(view: View, savedInstanceState : Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

            binding.btnLogin.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()
            authViewModel.login(email, password)
            }

            binding.btnToRegisterScreen.setOnClickListener {
                findNavController().navigate(R.id.action_login_to_register)
            }


            viewLifecycleOwner.lifecycleScope.launch{
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                    authViewModel.authState.collectLatest { response ->
                        when(response){
                            is Response.Success ->{
                                findNavController().navigate(R.id.action_login_to_dashboard2)
                            }
                            is Response.Error ->{
                                snackbar("Error")
                            }
                            is Response.Loading ->{

                            }
                        }

                    }
                }
            }



    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}
