package com.example.user.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*2016/4/17/17:01*/

public class MainActivity extends Activity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //frist data
                values.put("name", "Compelete Code");
                values.put("author", "code");
                values.put("pages", 400);
                values.put("price", 26);
                db.insert("Book", null, values);
                //second data
                values.put("name", "Thinking in java");
                values.put("author", "manald");
                values.put("pages", 215);
                values.put("price", 23);
                db.insert("Book", null, values);
            }
        });
    }
}
