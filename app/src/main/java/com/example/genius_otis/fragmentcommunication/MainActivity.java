package com.example.genius_otis.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragmentListener,FragmentListener2 {

    private BlankFragment firstFragment = new BlankFragment();
    private BlankFragment2 secondFragment = new BlankFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            addFragment(firstFragment, R.id.frameLayout1);
            addFragment(secondFragment, R.id.frameLayout2);
        }else{
            firstFragment = (BlankFragment) getFragmentById(R.id.frameLayout1);
            secondFragment = (BlankFragment2)getFragmentById(R.id.frameLayout2);
        }
    }

    private void addFragment(Fragment fragment, int layoutId){
        getSupportFragmentManager().beginTransaction().add(layoutId, fragment).commit();
    }

    private Fragment getFragmentById(int layoutId){
        return getSupportFragmentManager().findFragmentById(layoutId);
    }

    @Override
    public void getMessage(String message) {
        secondFragment.setText(message);
    }

    @Override
    public void setMessage(String message){
        firstFragment.setText(message);
    }

}