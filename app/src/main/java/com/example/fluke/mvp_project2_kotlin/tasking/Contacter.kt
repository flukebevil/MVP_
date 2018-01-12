package com.example.fluke.mvp_project2_kotlin.tasking

import android.content.Context

interface Contacter{

    interface View{

        fun SendIntents(data : String)

    }

    interface Present{

        fun OnClicked(model : Contacter.Model, context : Context, view : Contacter.View)

        fun OnDataReady(name : String , isIce : String , isChoco : String , qunn:String):String

        fun CheckButNegative(quans: Int):Int

    }

    interface Model{

        fun Receiver():String

    }
}