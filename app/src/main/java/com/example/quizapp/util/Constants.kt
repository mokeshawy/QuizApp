package com.example.quizapp.util

import com.example.quizapp.R
import com.example.quizapp.model.QuestionModel

object Constants {

    const val USER_NAME         : String ="user_name"
    const val TOTAL_QUESTIONS   : String = "total_questions"
    const val CORRECT_ANSWER    : String = "correct_answer"
    fun getQuestions() : ArrayList<QuestionModel>{

        val questionsList = ArrayList<QuestionModel>()

        // Question1
        val quest1 = QuestionModel( 1 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_argentina ,
                "Argentina",
            "Australia" ,
            "Armenia" ,
            "Austria" ,
            1)
        questionsList.add(quest1)

        // Question2
        val quest2 = QuestionModel( 2 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_finland ,
                "Norway",
            "Russia" ,
            "Finland" ,
            "Italy" ,
            3)
        questionsList.add(quest2)

        // Question3
        val quest3 = QuestionModel( 3 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_brazil ,
                "Argentina",
            "Australia" ,
            "Armenia" ,
            "Brazil" ,
            4)
        questionsList.add(quest3)

        // Question4
        val quest4 = QuestionModel( 4 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_belgium ,
            "Bahamas",
            "Belgium" ,
            "Barbados" ,
            "Belize" ,
            2)
        questionsList.add(quest4)

        // Question5
        val quest5 = QuestionModel( 5 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_of_fiji ,
            "Gabon",
            "France" ,
            "Fiji" ,
            "Finland" ,
            3)
        questionsList.add(quest5)

        // Question6
        val quest6 = QuestionModel( 6,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_deutschland ,
            "Germany",
            "Georgia" ,
            "Greece" ,
            "non of this" ,
            1)
        questionsList.add(quest6)

        // Question7
        val quest7 = QuestionModel( 7 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_denemark ,
            "Dominica",
            "Egypt" ,
            "Denmark" ,
            "Ethiopia" ,
            3)
        questionsList.add(quest7)

        // Question8
        val quest8 = QuestionModel( 8 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_india ,
            "Ireland",
            "Iran" ,
            "Hungary" ,
            "India" ,
            4)
        questionsList.add(quest8)

        // Question9
        val quest9 = QuestionModel( 9 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_newzealand ,
            "Australia",
            "New Zealand" ,
            "Tuvalu" ,
            "United States of America" ,
            2)
        questionsList.add(quest9)

        // Question10
        val quest10 = QuestionModel( 10 ,
            "What country dos this flag belong to ?",
            R.drawable.ic_flag_kuwait ,
            "Kuwait",
            "Jordan" ,
            "Sudan" ,
            "Palestine" ,
            1)
        questionsList.add(quest10)

        return questionsList
    }
}