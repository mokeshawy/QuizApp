package com.example.quizapp.quizquestionsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuizQuestionsBinding

class QuizQuestionsFragment : Fragment() {

    lateinit var binding : FragmentQuizQuestionsBinding
    private val quizQuestionsViewModel : QuizQuestionsViewModel by viewModels()
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizQuestionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner          = this
        binding.quizQuestionsVarModel   = quizQuestionsViewModel
    }
}