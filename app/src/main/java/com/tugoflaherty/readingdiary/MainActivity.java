package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new myDbAdapter(this);

        Button viewReadingHistory = (Button) findViewById(R.id.home_view_reading_history);
        Button addNewDiaryEntry = (Button) findViewById(R.id.home_add_new_diary_entry);
        Button manageUsers = (Button) findViewById(R.id.home_manage_users);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.home_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.home_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.home_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.home_navigation_button_settings);

        if (helper.getUserData().equals(null) || helper.getUserData().equals("")) {
            AlertDialog.Builder noUsersFoundDialogBuilder = new AlertDialog.Builder(this);
            noUsersFoundDialogBuilder.setMessage("Welcome to the Reading Diary app. No users have been created yet, but are required to use the app and identify users with school records. Set up users now to use the app?").setTitle("No users found")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Intent ManageUsersScreen = new Intent(getApplicationContext(), EditUsersActivity.class);
                            startActivity(ManageUsersScreen);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            System.exit(0);
                        }
                    });
            AlertDialog noUsersFoundDialog = noUsersFoundDialogBuilder.create();
            noUsersFoundDialog.show();
        }

        viewReadingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewReadingHistoryScreen = new Intent(getApplicationContext(), ViewReadingHistoryActivity.class);
                startActivity(ViewReadingHistoryScreen);
                finish();
            }
        });

        addNewDiaryEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddNewDiaryEntryScreen = new Intent(getApplicationContext(), AddDiaryEntryInformationActivity.class);
                startActivity(AddNewDiaryEntryScreen);
                finish();
            }
        });

        manageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ManageUsersScreen = new Intent(getApplicationContext(), EditUsersActivity.class);
                startActivity(ManageUsersScreen);
                finish();
            }
        });

        homepageNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomeScreen);
                finish();
            }
        });

        viewReadingHistoryNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewReadingHistoryScreen = new Intent(getApplicationContext(), ViewReadingHistoryActivity.class);
                startActivity(ViewReadingHistoryScreen);
                finish();
            }
        });

        addDiaryEntryNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddDiaryEntryScreen = new Intent(getApplicationContext(), AddDiaryEntryInformationActivity.class);
                startActivity(AddDiaryEntryScreen);
                finish();
            }
        });

        settingsNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SettingsScreen = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(SettingsScreen);
                finish();
            }
        });
    }
}