package com.example.quizapp.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.quizapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding                : FragmentMainBinding
    private val mainFragmentViewModel   : MainFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Connect whit view model
        binding.lifecycleOwner          = this
        binding.mainFragmentVarModel    = mainFragmentViewModel

        // btn start
        binding.btnStart.setOnClickListener {
            mainFragmentViewModel.register(requireActivity() , view)
        }
    }
}