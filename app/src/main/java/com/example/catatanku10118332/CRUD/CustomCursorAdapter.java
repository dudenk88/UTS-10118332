package com.example.catatanku10118332.CRUD;

//5 Juni 2021 - Nais Farid - IF8 - 10118332

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.catatanku10118332.BD.DBHelper;
import com.example.catatanku10118332.R;

public class CustomCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        View view = layoutInflater.inflate(R.layout.row_data, viewGroup, false);
        MyHolder holder = new MyHolder();

        holder.listId = (TextView) view.findViewById(R.id.listId);
        holder.listName = (TextView) view.findViewById(R.id.listName);
        holder.listTime = (TextView) view.findViewById(R.id.listTime);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        MyHolder holder = (MyHolder) view.getTag();
        holder.listId.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_id)));
        holder.listName.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_name)));
        holder.listTime.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_time)));


    }

    class MyHolder {
        TextView listId;
        TextView listName;
        TextView listTime;
        TextView listCatatan;
    }

}
