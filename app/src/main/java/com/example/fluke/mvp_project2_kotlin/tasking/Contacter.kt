package com.example.fluke.mvp_project2_kotlin.tasking

import android.content.Context

interface Contacter {

    interface View {
        fun SendIntents(data: String)
    }

    interface Present {
        fun OnClicked(model: Models, context: Context, view: Contacter.View)
        fun CheckButNegative(quans: Int): Int
    }
}