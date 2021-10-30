package com.example.lazy_engineer.ui

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lazy_engineer.data.network.Resource
import com.example.lazy_engineer.ui.auth.LoginFragment
import com.example.lazy_engineer.ui.base.BaseFragment
import com.google.android.material.snackbar.Snackbar

fun<A : Activity> Activity.startNewActivity(activity: Class<A>){
    Intent(this,activity).also{ intent ->
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
    }
}

fun View.visible(isVisible: Boolean){
    visibility = if(isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean){
    isEnabled = enabled
}

fun View.snackbar(message:String, action:(()-> Unit)? = null){
    val snackbar = Snackbar.make(this,message,Snackbar.LENGTH_LONG)
    action?.let { retry->
        snackbar.setAction("Retry"){
            retry()
        }
    }
    snackbar.show()
}

fun Fragment.handleAppError(
    failure: Resource.Failure,
    retry: (()->Unit)? = null
) {
    when (failure.error.temp) {
        "0" -> requireView().snackbar("Please check your internet connection",retry)
        "401" -> {
            if(this is LoginFragment)
                requireView().snackbar("You've entered incorrect email or password")
            else {
                (this as BaseFragment<*,*,*>).logout()
            }
        }

    }

}