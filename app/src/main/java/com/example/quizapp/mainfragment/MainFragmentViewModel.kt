package com.example.quizapp.mainfragment

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.quizapp.R
import com.example.quizapp.util.Constants

class MainFragmentViewModel : ViewModel() {

    var etEnterYourName = MutableLiveData<String>("")

    // fun register user name
    fun register( context : Context , view : View ){

        // check input user name is not empty
        if(etEnterYourName.value!!.trim().isEmpty()){

            Toast.makeText(context , "Please enter your name", Toast.LENGTH_SHORT).show()
        }else{
            // pass name for register using bundle
            var bundle = bundleOf(Constants.USER_NAME to etEnterYourName.value)
           Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_quizQuestionsFragment , bundle)
            Toast.makeText(context , "Welcome ${etEnterYourName.value}" , Toast.LENGTH_SHORT).show()
        }
    }
}