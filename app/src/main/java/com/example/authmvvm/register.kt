package com.example.authmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.authmvvm.models.auth.AuthViewModel
import com.example.authmvvm.databinding.FragmentRegisterBinding
import com.example.authmvvm.util.Response
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class register : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var  authViewModel : AuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

//        when(val authResponse = authViewModel.authState){
//            is Response<Response.Success> ->{
//
//            }
//        }
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                authViewModel.authState.collectLatest { response ->
                    when(response){
                        is Response.Success ->{

                        }
                        is Response.Error ->{

                        }
                        is Response.Loading ->{

                        }
                    }

                }
            }
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.registerEmail.text.toString()
            val number = binding.registerNumber.text.toString()
            val password = binding.registerPassword.text.toString()
            authViewModel.register(number, email, password)
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}