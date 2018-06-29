package com.codisats.journalapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.codisats.journalapp.database.AppDatabase;



// COMPLETED (1) Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddEntryViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // COMPLETED (2) Add two member variables. One for the database and one for the taskId
    private final AppDatabase mDb;
    private final int mEntryId;

    // COMPLETED (3) Initialize the member variables in the constructor with the parameters received
    public AddEntryViewModelFactory(AppDatabase database, int entryId) {
        mDb = database;
        mEntryId = entryId;
    }

    // COMPLETED (4) Uncomment the following method
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddEntryViewModel(mDb, mEntryId);
    }
}
