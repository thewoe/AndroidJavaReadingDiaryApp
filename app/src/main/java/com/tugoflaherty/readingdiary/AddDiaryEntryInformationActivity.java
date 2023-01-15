package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddDiaryEntryInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary_entry_information);

        EditText readingStartInputField = (EditText) findViewById(R.id.new_reading_start_datetime_input);
        EditText readingEndInputField = (EditText) findViewById(R.id.new_reading_end_datetime_input);
        EditText bookTitleInputField = (EditText) findViewById(R.id.new_book_title_input);
        EditText bookAuthorInputField = (EditText) findViewById(R.id.new_book_author_input);
        EditText pageCountInputField = (EditText) findViewById(R.id.new_page_count_input);
        EditText startPageInputField = (EditText) findViewById(R.id.new_start_page_input);
        EditText endPageInputField = (EditText) findViewById(R.id.new_end_page_input);
        Button cancel = (Button) findViewById(R.id.new_diary_entry_information_button_cancel);
        Button next = (Button) findViewById(R.id.new_diary_entry_information_button_next);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.add_diary_entry_information_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.add_diary_entry_information_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.add_diary_entry_information_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.add_diary_entry_information_navigation_button_settings);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readingStartInputField.setText("");
                readingEndInputField.setText("");
                bookTitleInputField.setText("");
                bookAuthorInputField.setText("");
                pageCountInputField.setText("");
                startPageInputField.setText("");
                endPageInputField.setText("");
                Intent HomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fieldsCompleted = true;
                String readingStart = readingStartInputField.getText().toString();
                String readingEnd = readingEndInputField.getText().toString();
                String bookTitle = bookTitleInputField.getText().toString();
                String bookAuthor = bookAuthorInputField.getText().toString();
                String pageCountString = pageCountInputField.getText().toString();
                String startPageString = startPageInputField.getText().toString();
                String endPageString = endPageInputField.getText().toString();
                Integer pageCount = 0, startPage = 0, endPage = 0;
                if ((readingStart.equals(null)) || (readingStart.equals(""))) {
                    readingStartInputField.setHintTextColor(getResources().getColor(R.color.red));
                    Log.i("reading start date","Rejected");
                    fieldsCompleted = false;
                }
                if ((readingEnd.equals(null)) || (readingEnd.equals(""))) {
                    readingEndInputField.setHintTextColor(getResources().getColor(R.color.red));
                    fieldsCompleted = false;
                    Log.i("reading end date","Rejected");
                }
                if ((bookTitle.equals(null)) || (bookTitle.equals(""))) {
                    bookTitleInputField.setHintTextColor(getResources().getColor(R.color.red));
                    fieldsCompleted = false;
                    Log.i("book title","Rejected");
                }
                if ((bookAuthor.equals(null)) || (bookAuthor.equals(""))) {
                    bookAuthorInputField.setHintTextColor(getResources().getColor(R.color.red));
                    fieldsCompleted = false;
                    Log.i("author","Rejected");
                }
                if ((!pageCountString.equals(null)) && (!pageCountString.equals(""))) {
                    try {
                        pageCount = Integer.parseInt(pageCountString);
                        if (pageCount < 1) {
                            endPageInputField.setTextColor(getResources().getColor(R.color.red));
                            pageCountInputField.setHintTextColor(getResources().getColor(R.color.red));
                            fieldsCompleted = false;
                            Log.i("page count less than 1","Rejected");
                        }
                    }
                    catch (Exception e) {
                        endPageInputField.setTextColor(getResources().getColor(R.color.red));
                        pageCountInputField.setHintTextColor(getResources().getColor(R.color.red));
                        fieldsCompleted = false;
                        Log.i("page count parse error","Rejected");
                    }
                }
                if ((!startPageString.equals(null)) && (!startPageString.equals(""))) {
                    try {
                        startPage = Integer.parseInt(startPageString);
                        if ((startPage < 1) || (startPage > pageCount)) {
                            endPageInputField.setTextColor(getResources().getColor(R.color.red));
                            startPageInputField.setHintTextColor(getResources().getColor(R.color.red));
                            fieldsCompleted = false;
                            Log.i("startpage<|>pagecount","Rejected");
                        }
                    }
                    catch (Exception e) {
                        endPageInputField.setTextColor(getResources().getColor(R.color.red));
                        startPageInputField.setHintTextColor(getResources().getColor(R.color.red));
                        fieldsCompleted = false;
                        Log.i("start page parse error","Rejected");
                    }
                }
                if ((!endPageString.equals(null)) && (!endPageString.equals(""))) {
                    try {
                        endPage = Integer.parseInt(endPageString);
                        if ((endPage < 1) || (endPage > pageCount) || (endPage < startPage)) {
                            endPageInputField.setTextColor(getResources().getColor(R.color.red));
                            endPageInputField.setHintTextColor(getResources().getColor(R.color.red));
                            fieldsCompleted = false;
                            Log.i("Endpage issue","Rejected");
                        }
                    }
                    catch (Exception e) {
                        endPageInputField.setTextColor(getResources().getColor(R.color.red));
                        endPageInputField.setHintTextColor(getResources().getColor(R.color.red));
                        fieldsCompleted = false;
                        Log.i("Endpage parse error","Rejected");
                    }
                }
                if (fieldsCompleted == true) {
                    Log.i("NEXT - ACCEPTED","Reading Start Time: "+readingStart+" Reading End Time: "+readingEnd+" Book Title: "+bookTitle+" Book Author: "+bookAuthor+" Page Count: "+pageCount+" Start Page: "+startPage+" End Page: "+endPage);
                    Intent AddDiaryEntryPupilCommentsScreen = new Intent(getApplicationContext(), AddDiaryEntryPupilCommentsActivity.class);
                    startActivity(AddDiaryEntryPupilCommentsScreen);
                }
                else {
                    Log.i("NEXT - REJECTED", "Rejected: "+fieldsCompleted);
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