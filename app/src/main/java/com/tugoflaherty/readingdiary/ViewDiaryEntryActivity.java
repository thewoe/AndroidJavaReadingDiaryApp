package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewDiaryEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diary_entry);

        Button edit = (Button) findViewById(R.id.view_diary_entry_button_edit);
        Button delete = (Button) findViewById(R.id.view_diary_entry_button_delete);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.view_diary_entry_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.view_diary_entry_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.view_diary_entry_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.view_diary_entry_navigation_button_settings);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EditDiaryEntryMenuScreen = new Intent(getApplicationContext(), EditDiaryEntryMenuActivity.class);
                startActivity(EditDiaryEntryMenuScreen);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomeScreen);
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