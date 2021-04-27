package com.example.quizapp.quizquestionsfragment

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.model.QuestionModel
import com.example.quizapp.util.Constants
import com.squareup.picasso.Picasso

class QuizQuestionsViewModel : ViewModel(){

    // Call Question model
    private var question            = MutableLiveData<QuestionModel>()
    // Global variable Current position
    private var mCurrentPosition    = 1
    // Global List from Questions model
    private var mQuestionsList : ArrayList<QuestionModel>? = null
    // Global variable SelectedOptionPosition whit default value change value whene select user answer
    private var mSelectedOptionPosition = 0
    private var mCorrectAnswer          = 0
    private var mUserName : String?     = null

    // fun set question call getQuestion from Constants and show on layout after register user
    fun setQuestions( context           : Context ,
                    btn_submit          : Button,
                    progressBar         : ProgressBar ,
                    tv_progress_bar     : TextView ,
                    tv_question         : TextView ,
                    iv_flag_country     : ImageView ,
                    tv_option_one       : TextView ,
                    tv_option_tow       : TextView ,
                    tv_option_three     : TextView ,
                    tv_option_four      : TextView){



        mQuestionsList = Constants.getQuestions()
        question.value = mQuestionsList!![mCurrentPosition -1]

        defaultOptionView(context, tv_option_one, tv_option_tow, tv_option_three, tv_option_four)

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "Submit"
        }

        progressBar.progress    = mCurrentPosition
        tv_progress_bar.text    = "$mCurrentPosition" + "/" + progressBar.max
        tv_question.text        = question.value!!.question
        Picasso.get().load(question.value!!.image).into(iv_flag_country)

        tv_option_one.text      = question.value!!.optionOne
        tv_option_tow.text      = question.value!!.optionTow
        tv_option_three.text    = question.value!!.optionThree
        tv_option_four.text     = question.value!!.optionFour


    }

    private fun defaultOptionView(context           : Context,
                                  tv_option_one     : TextView,
                                  tv_option_tow     : TextView,
                                  tv_option_three   : TextView,
                                  tv_option_four    : TextView){

        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_tow)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){

            option.setTextColor(Color.parseColor("#E8E8E8"))
            option.typeface     = Typeface.DEFAULT
            option.background   = ContextCompat.getDrawable(context , R.drawable.default_option_border_bg)
        }
    }

    fun selectedOptionView( tv                  : TextView,
                            selectedOptionNum   : Int,
                            context             : Context,
                            tv_option_one       : TextView,
                            tv_option_tow       : TextView,
                            tv_option_three     : TextView,
                            tv_option_four      : TextView){

        defaultOptionView(context, tv_option_one, tv_option_tow, tv_option_three, tv_option_four)

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface , Typeface.BOLD )
        tv.background = ContextCompat.getDrawable(context , R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer           : Int,
                           drawableView     : Int,
                           context          : Context,
                           tv_option_one    : TextView,
                           tv_option_tow    : TextView,
                           tv_option_three  : TextView,
                           tv_option_four   : TextView ){
        when(answer){

            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(context , drawableView)
            }
            2 ->{
                tv_option_tow.background = ContextCompat.getDrawable(context , drawableView)
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(context , drawableView)
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(context , drawableView)
            }
        }

    }

    fun submitQuiz(questionsFragment   : QuizQuestionsFragment,
                   btn_submit          : Button,
                   context             : Context,
                   progressBar         : ProgressBar,
                   tv_progress_bar     : TextView,
                   tv_question         : TextView,
                   iv_flag_country     : ImageView,
                   tv_option_one       : TextView,
                   tv_option_tow       : TextView,
                   tv_option_three     : TextView,
                   tv_option_four      : TextView
    ){

        mUserName = questionsFragment.arguments?.getString(Constants.USER_NAME)

        if( mSelectedOptionPosition == 0 ){
            mCurrentPosition ++

            when{
                mCurrentPosition <= mQuestionsList!!.size ->{
                    setQuestions(context,
                            btn_submit,
                            progressBar,
                            tv_progress_bar,
                            tv_question,
                            iv_flag_country,
                            tv_option_one,
                            tv_option_tow,
                            tv_option_three,
                            tv_option_four)
                }else ->{

                    var bundle = bundleOf(Constants.USER_NAME to mUserName , Constants.CORRECT_ANSWER to mCorrectAnswer.toString() , Constants.TOTAL_QUESTIONS to mQuestionsList!!.size.toString())
                    questionsFragment.findNavController().navigate(R.id.action_quizQuestionsFragment_to_resultFragment , bundle)
                }
            }

        }else{

            val question = mQuestionsList!![mCurrentPosition -1]

            if(question!!.correctAnswer != mSelectedOptionPosition){

                // Call fun answerView whit wrong option
                answerView(mSelectedOptionPosition ,
                        R.drawable.wrong_option_border_bg ,
                        context,
                        tv_option_one,
                        tv_option_tow,
                        tv_option_three,
                        tv_option_four)
            }else{
                mCorrectAnswer ++
            }
            // Call fun answerView whit correct option
            answerView(question!!.correctAnswer ,
                    R.drawable.correct_option_border_bg ,
                    context,
                    tv_option_one,
                    tv_option_tow,
                    tv_option_three,
                    tv_option_four)

            if(mCurrentPosition == mQuestionsList!!.size){
                btn_submit.text = "FINISH"
            }else{
                btn_submit.text = "Go to next question"
            }
            mSelectedOptionPosition = 0
        }
    }
}