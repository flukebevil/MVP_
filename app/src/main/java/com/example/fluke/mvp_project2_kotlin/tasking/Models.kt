package com.example.fluke.mvp_project2_kotlin.tasking

import com.example.fluke.mvp_project2_kotlin.base.BaseModel

/**
 * Created by Fluke on 12/1/2561.
 */
data class Models(val name: String?, val isCream: String, val isChoco: String
                  , val Quantity: String) : Contacter.Model , BaseModel {

    override fun Receiver():String {
        return  "$name,$isCream,$isChoco,$Quantity"
    }

}