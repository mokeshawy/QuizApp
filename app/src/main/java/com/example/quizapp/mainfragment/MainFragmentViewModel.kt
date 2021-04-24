package com.example.quizapp.mainfragment

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.quizapp.R

class MainFragmentViewModel : ViewModel() {

    var etEnterYourName = MutableLiveData<String>("")


    fun register( context : Context , view : View ){

        if(etEnterYourName.value!!.trim().isEmpty()){
            Toast.makeText(context , "Please enter your name", Toast.LENGTH_SHORT).show()
        }else{
           Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_quizQuestionsFragment)
            Toast.makeText(context , "Welcome ${etEnterYourName.value}" , Toast.LENGTH_SHORT).show()
        }
    }
}