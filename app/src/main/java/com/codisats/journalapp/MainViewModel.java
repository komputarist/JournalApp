package com.codisats.journalapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.codisats.journalapp.database.AppDatabase;
import com.codisats.journalapp.database.JournalEntry;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<JournalEntry>> entries;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the entries from the DataBase");
        entries = database.journalDao().loadAllTasks();
    }

    public LiveData<List<JournalEntry>> getEntries() {
        return entries;
    }
}
