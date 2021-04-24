package com.example.quizapp.model

data class QuestionModel (

    var id              : Int,
    var question        : String,
    var image           : Int,
    var optionOne       : String,
    var optionTow       : String,
    var optionThree     : String,
    var optionFour      : String,
    var correctAnswer   : Int
)