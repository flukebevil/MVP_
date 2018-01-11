package com.example.fluke.mvp_project.main;

import android.content.Context;

import com.example.fluke.mvp_project.base.BasePresenter;
import com.example.fluke.mvp_project.base.BaseView;

/**
 * Created by Fluke on 11/1/2561.
 */

public interface InterMainActivity {

    interface View extends BaseView<Presenter>{
        void setTName(String s);
        void setQuan(int i);
        String getName();
        int getQunn();
        String getChoco();
        String getCream();
        Context getContextx();
    }

    interface Presenter extends BasePresenter{
        void onButtonClick();
    }

}
