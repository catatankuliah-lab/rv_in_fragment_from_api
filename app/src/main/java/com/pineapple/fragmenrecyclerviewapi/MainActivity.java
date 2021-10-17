package com.pineapple.fragmenrecyclerviewapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO : langkah 1, deklarasi dan assignment frame layout
        FrameLayout frameLayout = new FrameLayout(this);

        // TODO : langkah 2, set layout parameter dari frame layout todo 1
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // TODO : langkah 3, set id dari frame layout pada fragment.xml
        frameLayout.setId(R.id.layout_frame);

        // TODO : langkah 4, set content view dengan frame layout hasil todo 1
        setContentView(frameLayout);

        getSupportFragmentManager().beginTransaction().add(R.id.layout_frame, new RecyclerFragment()).commit();
    }
}