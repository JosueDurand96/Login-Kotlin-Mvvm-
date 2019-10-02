package com.example.kotlinmvvmlogin.Interface


interface LoginResultCallBacks {
    fun onSuccess(message:String)
    fun onError(message: String)
}