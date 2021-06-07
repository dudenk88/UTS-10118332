package com.example.catatanku10118332.Presenter;

//6 Juni 2021 - Nais Farid - IF8 - 10118332

import android.content.ContentValues;
import android.database.Cursor;

import com.example.catatanku10118332.IView.IListView;
import com.example.catatanku10118332.IView.IEditListView;
import com.example.catatanku10118332.Model.lListModel;
import com.example.catatanku10118332.Model.IModel;

public class lListPresenter implements IListPresenter {

    private IModel iModelModel;
    private IListView iListView;
    private IEditListView iEditListView;

    public lListPresenter(IListView iListView) {
        this.iListView = iListView;
        iModelModel = new lListModel(iListView);
    }

    public lListPresenter(IEditListView iEditListView) {
        this.iEditListView = iEditListView;
        iModelModel = new lListModel(iEditListView);
    }

    @Override
    public void getAllStudent() {
        Cursor cursor = iModelModel.getAllStudent();
        iListView.listStudent(cursor);
    }

    @Override
    public void createStudent(ContentValues values) {
        iModelModel.createStudent(values);
    }

    @Override
    public void getStudent(long id) {
        Cursor cursor = iModelModel.getStudent(id);
        iEditListView.getStudent(cursor);
    }

    @Override
    public void updateStudent(ContentValues values, long id) {
        iModelModel.updateStudent(values, id);
    }

    @Override
    public void deleteStudent(long id) {
        iModelModel.deleteStudent(id);
    }
}
