package com.example.lazy_engineer.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lazy_engineer.data.UserPreferences
import com.example.lazy_engineer.data.network.AuthApi
import com.example.lazy_engineer.data.network.RemoteDataSource
import com.example.lazy_engineer.databinding.FragmentLoginBinding
import com.example.lazy_engineer.data.repository.AuthRepository
import com.example.lazy_engineer.ui.base.ViewModelFactory

class LoginFragment : Fragment(){

    private lateinit var viewModel:LoginViewModel
    private lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = RemoteDataSource().buildApi(AuthApi::class.java)
        val preferences = UserPreferences(requireContext())
        val repository = AuthRepository(api,preferences)
        viewModel = ViewModelProvider(this,ViewModelFactory(repository)).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        viewModel.navigateToSignUp.observe(viewLifecycleOwner,{
            if(it){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
                viewModel.navigationComplete()
            }
        })
    }
}