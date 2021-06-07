package com.example.catatanku10118332.IView;

//5 Juni 2021 - Nais Farid - IF8 - 10118332

import android.database.Cursor;

public interface IListView {

    void listStudent(Cursor cursor);
    void createStudent(String name, String time, String catatan);

}
