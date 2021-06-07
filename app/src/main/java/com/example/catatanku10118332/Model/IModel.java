package com.example.catatanku10118332.Model;

//5 Juni 2021 - Nais Farid - IF8 - 10118332

import android.content.ContentValues;
import android.database.Cursor;

public interface IModel {
    Cursor getAllStudent();
    void createStudent(ContentValues values);
    Cursor getStudent(Long id);
    void updateStudent(ContentValues values, long id);
    void deleteStudent(long id);
}
