package com.example.fluke.mvp_project2_kotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fluke.mvp_project2_kotlin.base.BaseView
import com.example.fluke.mvp_project2_kotlin.tasking.Contacter
import com.example.fluke.mvp_project2_kotlin.tasking.Models
import com.example.fluke.mvp_project2_kotlin.tasking.Presenter
import kotlinx.android.synthetic.main.activity_runner_app.*
import android.widget.Toast




class RunnerApp : AppCompatActivity(), BaseView , Contacter.View{

    lateinit var presenter: Contacter.Present
    lateinit var res_model : Models

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runner_app)
        presenter = Presenter()
        OnEvents()
    }

    override fun OnEvents() {
        btn_minus.setOnClickListener(View.OnClickListener {
          edt_quan.setText((presenter.CheckButNegative(edt_quan.text.toString().toInt())).toString())
        })
        btn_plus.setOnClickListener(View.OnClickListener {

            edt_quan.setText((edt_quan.text.toString().toInt() + 1).toString())
        })
        btn_submit.setOnClickListener(View.OnClickListener {
            res_model = Models(edt_name.text.toString(),cb_cream.isChecked.toString(),cb_chocolate.isChecked.toString()
                    ,edt_quan.text.toString())
            presenter.OnClicked(res_model, this , this)
        })
    }

    override fun SendIntents(data: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("message/rfc822")
        intent.putExtra(Intent.EXTRA_EMAIL  , "example@example.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "รายการสั่งกาแฟ")
        intent.putExtra(Intent.EXTRA_TEXT , data)
        try {
            startActivity(Intent.createChooser(intent , "Sened"))
        } catch (ex: android.content.ActivityNotFoundException) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show()
        }
    }
}
