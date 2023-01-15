package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

public class EditDiaryEntryParentCommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary_entry_parent_comments);
        int diaryEntryId = getIntent().getIntExtra("diaryEntryId",-1);

        RatingBar readingAbilityRatingInputField = (RatingBar) findViewById(R.id.edit_diary_entry_parent_comments_reading_ability_rating_bar);
        EditText parentCommentsInputField = (EditText) findViewById(R.id.edit_parent_comments_input);
        Button cancel = (Button) findViewById(R.id.edit_diary_entry_parent_comments_button_cancel);
        Button save = (Button) findViewById(R.id.edit_diary_entry_parent_comments_button_save);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.edit_diary_entry_parent_comments_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.edit_diary_entry_parent_comments_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.edit_diary_entry_parent_comments_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.edit_diary_entry_parent_comments_navigation_button_settings);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EditDiaryEntryMenuScreen = new Intent(getApplicationContext(), EditDiaryEntryMenuActivity.class);
                EditDiaryEntryMenuScreen.putExtra("diaryEntryId",diaryEntryId);
                startActivity(EditDiaryEntryMenuScreen);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fieldsCompleted = true;
                Float readingAbilityRating = 0.0F;
                String parentComments = "";
                readingAbilityRating = readingAbilityRatingInputField.getRating();
                parentComments = parentCommentsInputField.getText().toString();
                if ((parentComments.equals(null)) || (parentComments.equals(""))) {
                    parentCommentsInputField.setHintTextColor(getResources().getColor(R.color.red));
                    Log.i("reading start date","Rejected");
                    fieldsCompleted = false;
                }
                if (fieldsCompleted == true) {
                    Log.i("NEXT - ACCEPTED","Reading Ability Rating: "+readingAbilityRating+" Parent Comments: "+parentComments);
                    Intent ViewDiaryEntryScreen = new Intent(getApplicationContext(), ViewDiaryEntryActivity.class);
                    ViewDiaryEntryScreen.putExtra("diaryEntryId",diaryEntryId);
                    startActivity(ViewDiaryEntryScreen);
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
}