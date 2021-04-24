package com.example.quizapp.resultfragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.util.Constants

class ResultFragment : Fragment() {

    lateinit var binding        : FragmentResultBinding
    private val resultViewModel : ResultViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.resultVarModel = resultViewModel



        val userName        = arguments?.getString(Constants.USER_NAME)
        val correctAnswer   = arguments?.getString(Constants.CORRECT_ANSWER)
        val totalQuestions  = arguments?.getString(Constants.TOTAL_QUESTIONS)

        binding.tvName.text = userName

       binding.tvScore.text = "Your score is $correctAnswer out of $totalQuestions"


        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
        }


    }
}