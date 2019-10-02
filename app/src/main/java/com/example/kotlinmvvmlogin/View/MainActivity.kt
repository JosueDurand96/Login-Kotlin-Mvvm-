package com.example.kotlinmvvmlogin.View

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlinmvvmlogin.Interface.LoginResultCallBacks
import com.example.kotlinmvvmlogin.R
import com.example.kotlinmvvmlogin.ViewModel.LoginViewModel
import com.example.kotlinmvvmlogin.ViewModel.LoginViewModelFactory
import com.example.kotlinmvvmlogin.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(),LoginResultCallBacks {
    override fun onSuccess(message: String) {
        Toasty.success(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this,LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }
}
