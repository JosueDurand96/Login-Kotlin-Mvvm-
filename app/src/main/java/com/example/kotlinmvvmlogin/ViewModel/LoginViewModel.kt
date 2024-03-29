package com.example.kotlinmvvmlogin.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.kotlinmvvmlogin.Interface.LoginResultCallBacks
import com.example.kotlinmvvmlogin.Model.User
import java.util.*

class LoginViewModel (private val listener:LoginResultCallBacks):ViewModel(){
    private val user:User

    init {
        this.user = User("","")
    }


    //create function to set Email after user finish enter text
    val emailTextWatcher:TextWatcher
        get()= object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user .setEmail(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }


    //create function to set Password after user finish enter text
    val passwordTextWatcher:TextWatcher
        get()= object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                user .setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }


    //create function to process Login Button clicked
    fun onLoginClicked(v: View){
        var loginCode:Int = user.isDataValid()
        if (loginCode == 0)
            listener.onError("el correo electrónico no debe estar vacío")
        else if (loginCode == 1)
            listener.onError("No es un patrón correcto de email")
        else if (loginCode == 2)
            listener.onError("La longitud de la contraseña debe ser mayor que 6")
        else
            listener.onSuccess("Acceso exitoso")
    }


}