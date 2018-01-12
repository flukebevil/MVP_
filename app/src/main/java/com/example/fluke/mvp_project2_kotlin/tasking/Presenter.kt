package com.example.fluke.mvp_project2_kotlin.tasking

import android.content.Context
import android.util.Log
import android.widget.Toast


/**
 * Created by Fluke on 12/1/2561.
 */

class Presenter : Contacter.Present {

    override fun OnClicked(model: Contacter.Model, context: Context, view: Contacter.View) {

        var data: List<String> = model.Receiver().split(",")
        var name: String = data.get(0)
        var cream: String = data.get(1)
        var choco: String = data.get(2)
        var quan: String = data.get(3)

        if (name.isEmpty() || name.isNullOrEmpty() || name.equals(" ") || quan == "0"
                || name.equals("")) {

            Toast.makeText(context, "กรุณากรอกข้อมูลให้ครบด้วยครับ", Toast.LENGTH_SHORT).show()

        } else {

            view.SendIntents(OnDataReady(name, cream, choco, quan))
            Log.e("finalText", OnDataReady(name, cream, choco, quan))

        }
    }


    override fun OnDataReady(name: String, isIce: String, isChoco: String, qunn: String): String {

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