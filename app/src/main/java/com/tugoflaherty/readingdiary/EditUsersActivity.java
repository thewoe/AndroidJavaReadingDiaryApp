package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_users);

        EditText pupilNameInputField = (EditText) findViewById(R.id.edit_users_pupils_input);
        EditText parentNameInputField = (EditText) findViewById(R.id.edit_users_parents_input);
        EditText teacherNameInputField = (EditText) findViewById(R.id.edit_users_teachers_input);
        Button cancel = (Button) findViewById(R.id.edit_users_button_cancel);
        Button save = (Button) findViewById(R.id.edit_users_button_save);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.edit_users_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.edit_users_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.edit_users_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.edit_users_navigation_button_settings);
        myDbAdapter helper = new myDbAdapter(this);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SettingsScreen = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(SettingsScreen);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fieldsCompleted = true;
                String pupilName = "";
                String parentName = "";
                String teacherName = "";
                pupilName = pupilNameInputField.getText().toString();
                parentName = parentNameInputField.getText().toString();
                teacherName = teacherNameInputField.getText().toString();
                if ((pupilName.equals(null)) || (pupilName.equals(""))) {
                    pupilNameInputField.setHintTextColor(getResources().getColor(R.color.red));
                    Log.i("reading start date","Rejected");
                    fieldsCompleted = false;
                }
                if ((parentName.equals(null)) || (parentName.equals(""))) {
                    parentNameInputField.setHintTextColor(getResources().getColor(R.color.red));
                    Log.i("reading start date","Rejected");
                    fieldsCompleted = false;
                }
                if ((teacherName.equals(null)) || (teacherName.equals(""))) {
                    teacherNameInputField.setHintTextColor(getResources().getColor(R.color.red));
                    Log.i("reading start date","Rejected");
                    fieldsCompleted = false;
                }
                if (fieldsCompleted == true) {
                    Intent SettingsScreen = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(SettingsScreen);
                }
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
    public void addUser(View view) {

    }
}