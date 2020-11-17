package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.gujun.android.taggroup.TagGroup;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TagGroup mTagGroup =  findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Tag1", "Tag2", "Tag3"});
    }
}
