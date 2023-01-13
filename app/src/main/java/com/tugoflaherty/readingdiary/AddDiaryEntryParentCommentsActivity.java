package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddDiaryEntryParentCommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary_entry_parent_comments);

        Button cancel = (Button) findViewById(R.id.new_diary_entry_parent_comments_button_cancel);
        Button next = (Button) findViewById(R.id.new_diary_entry_parent_comments_button_next);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.add_diary_entry_parent_comments_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.add_diary_entry_parent_comments_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.add_diary_entry_parent_comments_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.add_diary_entry_parent_comments_navigation_button_settings);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddDiaryEntryTeacherCommentsScreen = new Intent(getApplicationContext(), AddDiaryEntryTeacherCommentsActivity.class);
                startActivity(AddDiaryEntryTeacherCommentsScreen);
            }
        });

        homepageNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });

        viewReadingHistoryNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewReadingHistoryScreen = new Intent(getApplicationContext(), ViewReadingHistoryActivity.class);
                startActivity(ViewReadingHistoryScreen);
            }
        });

        addDiaryEntryNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddDiaryEntryScreen = new Intent(getApplicationContext(), AddDiaryEntryInformationActivity.class);
                startActivity(AddDiaryEntryScreen);
            }
        });

        settingsNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SettingsScreen = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(SettingsScreen);
            }
        });
    }
}