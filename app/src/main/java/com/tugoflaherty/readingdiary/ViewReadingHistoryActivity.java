package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ViewReadingHistoryActivity extends AppCompatActivity {
    RecyclerView readingHistoryList;
    myDbAdapter helper;
    myHistoryAdapter readingHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reading_history);
        helper = new myDbAdapter(this);

        SearchView diaryEntriesSearch = (SearchView) findViewById(R.id.view_reading_history_search);
        Button viewDiaryEntry = (Button) findViewById(R.id.view_reading_history_button_view_entry);
        ImageButton homepageNav = (ImageButton) findViewById(R.id.view_reading_history_navigation_button_home);
        ImageButton viewReadingHistoryNav = (ImageButton) findViewById(R.id.view_reading_history_navigation_button_history);
        ImageButton addDiaryEntryNav = (ImageButton) findViewById(R.id.view_reading_history_navigation_button_add);
        ImageButton settingsNav = (ImageButton) findViewById(R.id.view_reading_history_navigation_button_settings);
        TextView noRecords = (TextView) findViewById(R.id.view_reading_history_no_records_available);

        if ((!helper.getDiaryEntryData().equals(null)) && (!helper.getDiaryEntryData().equals(""))) {
            String returnedData = helper.getDiaryEntryData();
            String[] readingHistoryDataArray = returnedData.split("`");
            List<String> readingHistoryData = new ArrayList<String>(Arrays.asList(readingHistoryDataArray));
            readingHistoryList = (RecyclerView) findViewById(R.id.view_reading_history_list);
            readingHistoryAdapter = new myHistoryAdapter(readingHistoryData);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            readingHistoryList.setLayoutManager(layoutManager);
            readingHistoryList.setAdapter(readingHistoryAdapter);
            diaryEntriesSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String searchField) {

                    List<String> filteredReadingHistoryData = new ArrayList<String>();
                    for (String diaryEntry : readingHistoryData ) {
                        if (diaryEntry.toLowerCase().contains(searchField.trim().toLowerCase())) {
                            filteredReadingHistoryData.add(diaryEntry);
                        }
                    }
                    readingHistoryAdapter.setDataSet(filteredReadingHistoryData);
                    readingHistoryAdapter.notifyDataSetChanged();
                    return true;
                }
            });
        }
        else {
            noRecords.setText("No Diary Entry Records To Display");
        }

        viewDiaryEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewDiaryEntryScreen = new Intent(getApplicationContext(), ViewDiaryEntryActivity.class);
                ViewDiaryEntryScreen.putExtra("diaryEntryId",1); //hardcoded temporarily - must be dynamic from db from clicked list item
                startActivity(ViewDiaryEntryScreen);
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