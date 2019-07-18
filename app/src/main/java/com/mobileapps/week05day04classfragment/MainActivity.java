package com.mobileapps.week05day04classfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
            implements PurpleFragment.OnFragmentInteractionListener,
                        RedFragment.OnFragmentInteractionListener{

    private FragmentManager fragmentManager;
    private PurpleFragment purpleFragment;
    private RedFragment redFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setupAndAddPurpleFragment();
        setupAndAddRedFragment();

    }

    private void setupAndAddPurpleFragment()
    {
        purpleFragment = PurpleFragment.newInstance("Please Enter user Name");
        fragmentManager.beginTransaction()
                .add(R.id.frmPurple, purpleFragment)
                .addToBackStack("PURPLE_FRAGMENT")
                .commit();
    }

    private void setupAndAddRedFragment()
    {
        redFragment = new RedFragment();
        fragmentManager.beginTransaction()
                .add(R.id.frmRed, redFragment)
                .addToBackStack("RED_FRAGMENT")
                .commit();
    }

    @Override
    public void onFragmentInteraction(String passedString)
    {
        //Toast.makeText(this, passedString, Toast.LENGTH_SHORT).show();
        redFragment.setTextForTextView(passedString);
    }

    @Override
    public void popFragment()
    {
       // fragmentManager.popBackStack();  //1 fragment at the time
       // fragmentManager.popBackStack("PURPLE_FRAGMENT", FragmentManager.POP_BACK_STACK_INCLUSIVE); // eliminate all even the one in the top
        //fragmentManager.popBackStack("PURPLE_FRAGMENT", 0);   //Eliminate just in the top of this but no this one
        //fragmentManager.beginTransaction().remove(purpleFragment).commit(); //Just Remove this one

        //Replace fragment in stack
        //RedFragment redFragment1 = new RedFragment();
        //fragmentManager.beginTransaction().add(R.id.frmPurple,redFragment1).commit();
    }
}
