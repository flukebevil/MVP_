package com.example.fluke.mvp_project.base;

/**
 * Created by Fluke on 11/1/2561.
 */

public interface BasePresenter {

    void viewOncreate();
    void viewOnStart();
    void viewOnResume();
    void viewOnPause();
    void viewOnStop();
    void viewOnDestroy();
    void viewOnCreateView();



}
