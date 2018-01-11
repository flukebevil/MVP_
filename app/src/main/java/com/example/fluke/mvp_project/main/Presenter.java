package com.example.fluke.mvp_project.main;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Fluke on 11/1/2561.
 */

public class Presenter implements InterMainActivity.Presenter {

    private InterMainActivity.View view;
    private  Context context;

    public Presenter(InterMainActivity.View view , Context context) {
        this.view = view;
    }

    @Override
    public void viewOncreate() {

    }

    @Override
    public void viewOnStart() {

    }

    @Override
    public void viewOnResume() {

    }

    @Override
    public void viewOnPause() {

    }

    @Override
    public void viewOnStop() {

    }

    @Override
    public void viewOnDestroy() {

    }

    @Override
    public void viewOnCreateView() {

    }

    @Override
    public void onButtonClick() {
        String name ="ไม่ได้ระบุชื่อ";
        String choco="";
        String qunn="ไม่ได้ระบุจำนวน";
        String cream="";

        if (view.getName() != null){
            name = view.getName();
        }

        if (view.getQunn()+"" != null){
            qunn   = view.getQunn()+"";
        }

        if (view.getChoco() != null){
           choco = view.getChoco();
        }
        if (view.getCream() != null){
            cream = view.getCream();
        }

        ArrayList<String> itemList= new ArrayList<>();
        if (!name.equals("")){
            itemList.add(name);
        }
        if (!choco.equals("")){
            itemList.add(choco);
        }
        if (!cream.equals("")){
            itemList.add(cream);
        }
        if (!qunn.equals("")){
            itemList.add(qunn);
        }

        String resultList="";
        for (int i = 0 ; i< itemList.size() ; i++){
            if (i==0){
                resultList+=itemList.get(i)+" สั่งกาแฟ\n\n";
            }else
            if (i==itemList.size()-1){
                resultList+="จำนวน "+itemList.get(i)+" แก้ว";
            }else{
                resultList+="เพิ่ม "+itemList.get(i)+"\n\n";
            }
        }
{
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"example@example.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "D JAAAA EIEI");
            i.putExtra(Intent.EXTRA_TEXT   ,"คุณ "+resultList);
            try {
                view.getContextx().startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            Log.e("apwefawef",view.getName());
        }

    }
}
