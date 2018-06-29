package com.codisats.journalapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.codisats.journalapp.database.AppDatabase;
import com.codisats.journalapp.database.JournalEntry;



// COMPLETED (5) Make this class extend ViewModel
public class AddEntryViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<JournalEntry> entry;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddEntryViewModel(AppDatabase database, int entryId) {
        entry = database.journalDao().loadEntryById(entryId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<JournalEntry> getEntry() {
        return entry;
    }
}
