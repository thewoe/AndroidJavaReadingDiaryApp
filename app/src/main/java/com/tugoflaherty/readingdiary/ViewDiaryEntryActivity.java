package com.tugoflaherty.readingdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewDiaryEntryActivity extends AppCompatActivity {
    TextView readingStartView, readingEndView, bookTitleView, bookAuthorView, pagesReadView, pupilCommentsView, parentCommentsView, teacherCommentsView;
    ProgressBar readingProgressBar;
    RatingBar enjoymentRatingView, readingAbilityRatingView, readingProgressRatingView;
    myDbAdapter helper;
    String diaryEntryId, uid,readingStart,readingEnd,bookTitle,bookAuthor,pageCount,startPage,endPage,enjoymentRating,pupilComments,readingAbility,parentComments,readingProgress,teacherComments, pupilName, parentName, teacherName;
    int readingProgressPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diary_entry);

        diaryEntryId = getIntent().getStringExtra("diaryEntryId");
        helper = new myDbAdapter(this);

        readingStartView = (TextView) findViewById(R.id.view_diary_entry_information_reading_information_start_date_time);
        readingEndView = (TextView) findViewById(R.id.view_diary_entry_information_reading_information_end_date_time);
        bookTitleView = (TextView) findViewById(R.id.view_diary_entry_information_book_information_book_title);
        bookAuthorView = (TextView) findViewById(R.id.view_diary_entry_information_book_information_author_name);
        readingProgressBar = (ProgressBar) findViewById(R.id.view_diary_entry_information_book_information_pages_read_progress_bar);
        pagesReadView = (TextView) findViewById(R.id.view_diary_entry_information_book_information_pages_read);
        enjoymentRatingView = (RatingBar) findViewById(R.id.view_diary_entry_pupil_comments_enjoyment_rating_bar);
        pupilCommentsView = (TextView) findViewById(R.id.view_diary_entry_pupil_comments_additional_comments);
        readingAbilityRatingView = (RatingBar) findViewById(R.id.view_diary_entry_parent_comments_reading_ability_rating_bar);
        parentCommentsView = (TextView) findViewById(R.id.view_diary_entry_parent_comments_additional_comments);
        readingProgressRatingView = (RatingBar) findViewById(R.id.view_diary_entry_teacher_comments_reading_progress_rating_bar);
        teacherCommentsView = (TextView) findViewById(R.id.view_diary_entry_teacher_comments_additional_comments);

        ImageButton sendEmail = (ImageButton) findViewById(R.id.view_diary_entry_button_email_diary);
        Button edit = (Button) findViewById(R.id.view_diary_entry_button_edit);
        Button delete = (Button) findViewById(R.id.view_diary_entry_button_delete);

        if ((!helper.getDiaryEntryDataById(diaryEntryId).equals(null)) && (!helper.getDiaryEntryDataById(diaryEntryId).equals(""))) {
            String returnedData = helper.getDiaryEntryDataById(diaryEntryId);
            String[] diaryEntryData = returnedData.split("¬");

            uid = diaryEntryData[0];
            readingStart = diaryEntryData[1];
            readingEnd = diaryEntryData[2];
            bookTitle = diaryEntryData[3];
            bookAuthor = diaryEntryData[4];
            pageCount = diaryEntryData[5];
            startPage = diaryEntryData[6];
            endPage = diaryEntryData[7];
            enjoymentRating = diaryEntryData[8];
            pupilComments = diaryEntryData[9];
            readingAbility = diaryEntryData[10];
            parentComments = diaryEntryData[11];
            readingProgress = diaryEntryData[12];
            teacherComments = diaryEntryData[13];
            pupilName = diaryEntryData[14];
            parentName = diaryEntryData[15];
            teacherName = diaryEntryData[16];
            readingProgressPercentage = (Integer.valueOf(Math.round((Float.valueOf(endPage)/Float.valueOf(pageCount))*100)));
            readingStartView.setText(readingStart);
            readingEndView.setText(readingEnd);
            bookTitleView.setText(bookTitle);
            bookAuthorView.setText(bookAuthor);
            readingProgressBar.setProgress(readingProgressPercentage);
            pagesReadView.setText("Read "+(Integer.parseInt(endPage)-Integer.parseInt(startPage)) +" pages. Read from page "+startPage+" to page "+endPage+" out of a total of "+pageCount+" pages");
            enjoymentRatingView.setRating(Float.parseFloat(enjoymentRating));
            pupilCommentsView.setText(pupilComments+" - "+pupilName);
            readingAbilityRatingView.setRating(Float.parseFloat(readingAbility));
            parentCommentsView.setText(parentComments+" - "+parentName);
            readingProgressRatingView.setRating(Float.parseFloat(readingProgress));
            teacherCommentsView.setText(teacherComments+" - "+teacherName);
        }

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mailUri = Uri.parse("mailto:readingprogress@kingstonprimary.sch.uk");
                String subject = pupilName+ "\'s Reading Entry";
                String body = "Dear Reading Progress Team,\n\n";
                body += pupilName+" in "+teacherName+"\'s class has recorded a new reading diary entry.\n\n";
                body += "Reading Information:\n\n";
                body += "Reading Start Date: "+readingStart+"\n\n";
                body += "Reading End Date: "+readingEnd+"\n\n";
                body += "Book Information:\n\n";
                body += "Book Title: "+bookTitle+"\n\n";
                body += "Book Author :"+bookAuthor+"\n\n";
                body += "Book Page Count: "+pageCount+"\n\n";
                body += "Page Information:\n\n";
                body += "Start Page: "+startPage+"\n\n";
                body += "End Page: "+endPage+"\n\n";
                body += "Pages Read: "+(Integer.parseInt(endPage)-Integer.parseInt(startPage))+"\n\n";
                body += "Pupil Feedback ("+pupilName+"):\n\n";
                body += "Pupil Enjoyment Rating: "+enjoymentRating+"/5\n\n";
                body += "Pupil Additional Comments: "+pupilComments+"\n\n";
                body += "Parent Feedback ("+parentName+"):\n\n";
                body += "Parent Reading Ability Rating: "+readingAbility+"/5\n\n";
                body += "Parent Additional Comments: "+parentComments+"\n\n";
                body += "Teacher Feedback ("+teacherName+"):\n\n";
                body += "Teacher Reading Ability Rating: "+readingProgress+"/5\n\n";
                body += "Teacher Additional Comments: "+teacherComments+"\n\n";
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                body += "Information correct as of: "+dateFormat.format(new Date())+"\n\n";
                body += "Regards,\n\n";
                body += "Kingston Primary School Reading Diary App";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,mailUri);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);

                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
                else {
                    Message.message(getApplicationContext(), "No Email Client Apps Available");
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EditDiaryEntryMenuScreen = new Intent(getApplicationContext(), EditDiaryEntryMenuActivity.class);
                EditDiaryEntryMenuScreen.putExtra("diaryEntryId",diaryEntryId);
                startActivity(EditDiaryEntryMenuScreen);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmDeleteDialogBuilder = new AlertDialog.Builder(ViewDiaryEntryActivity.this);
                confirmDeleteDialogBuilder.setMessage(R.string.reading_diary_dialog_delete_record_message).setTitle(R.string.reading_diary_dialog_delete_record_title)
                    .setPositiveButton(R.string.button_confirm, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            deleteDiaryEntry(v);
                        }
                    })
                    .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                });
                AlertDialog confirmDeleteDialog = confirmDeleteDialogBuilder.create();
                confirmDeleteDialog.show();
            }
        });
    }

    public void deleteDiaryEntry(View view) {
        int count = helper.deleteDiaryEntry(diaryEntryId);

        if (count <= 0) {
            Message.message(getApplicationContext(), "Delete Unsuccessful - Please Try Again");
        }
        else {
            Message.message(getApplicationContext(), "Delete Successful");
            Intent ViewReadingHistoryScreen = new Intent(getApplicationContext(), ViewReadingHistoryActivity.class);
            startActivity(ViewReadingHistoryScreen);
        }
    }
}