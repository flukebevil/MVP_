package com.example.fluke.mvp_project2_kotlin.tasking

import android.content.Context
import android.util.Log
import android.view.Display
import android.widget.Toast


/**
 * Created by Fluke on 12/1/2561.
 */

class Presenter : Contacter.Present {
    override fun OnClicked(model: Models, context: Context, view: Contacter.View) {
        if (model.name.isNullOrEmpty() || model.name.equals(" ") || model.Quantity== "0"
                || model.name.equals("")) {

            Toast.makeText(context, "กรุณากรอกข้อมูลให้ครบด้วยครับ", Toast.LENGTH_SHORT).show()

        } else {

            view.SendIntents(OnDataReady(model.name.toString(), model.isCream.toString(),
                    model.isChoco.toString(), model.Quantity.toString()))
            Log.e("finalText", OnDataReady(model.name.toString(), model.isCream.toString()
                    , model.isChoco.toString(), model.Quantity.toString()))

        }
    }


     fun OnDataReady(name: String , isIce: String , isChoco: String, qunn: String): String {
        var resuld: String = "คุณ $name \nได้ทำการสั่งกาแฟ"
        if (isIce == "true") {
            resuld += "\nเพิ่ม Whipping cream"
        }
        if (isChoco == "true") {
            resuld += "\nเพิ่ม Chocolate"
        }
        resuld += "\n จำนวน $qunn แก้ว"
        return resuld

    }

    override fun CheckButNegative(quans: Int): Int {
        var quan: Int = quans - 1
        return if (quans < 1) {
            0
        } else {
            quan
        }
    }
}