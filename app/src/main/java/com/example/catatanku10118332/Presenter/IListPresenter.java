package com.example.catatanku10118332.Presenter;

//6 Juni 2021 - Nais Farid - IF8 - 10118332

import android.content.ContentValues;

public interface IListPresenter {
    void getAllStudent();
    void createStudent(ContentValues values);
    void getStudent(long id);
    void updateStudent(ContentValues values, long id);
    void deleteStudent(long id);
}
