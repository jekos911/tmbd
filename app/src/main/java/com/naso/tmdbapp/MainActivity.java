package com.naso.tmdbapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;

import com.naso.tmdbapp.ui.GenresFragment;





public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager = null;

    public static FragmentManager getFragmentManagerFromActivity() {
        return fragmentManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        GenresFragment genres = new GenresFragment();
        genres.setEnterTransition(new Fade());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.container) == null)
            fragmentManager.beginTransaction()
                    .add(R.id.container, new GenresFragment())
                    .commit();
    }

}
