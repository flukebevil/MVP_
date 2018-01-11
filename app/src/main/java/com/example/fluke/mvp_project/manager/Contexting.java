package com.example.fluke.mvp_project.manager;

import android.content.Context;

/**
 * Created by Fluke on 11/1/2561.
 */

public class Contexting {
    private  static Contexting instance;

    public  static Contexting getInstance(){
        if (instance == null ) {
            instance = new Contexting();
        }
        return instance;
    }
    private Context mcontext;

    private Contexting(){}

    public void init (Context context){
        mcontext = context;
    }
    public Context getContext() {return  mcontext;}
}
