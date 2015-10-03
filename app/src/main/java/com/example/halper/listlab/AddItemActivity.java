package com.example.halper.listlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // add the item to the list

    public void addItem(View view) {

        EditText editText1;
        EditText editText2;
        String new_item;
        int pos;
        StringList the_list;

        editText1 = (EditText) findViewById(R.id.edit_item);
        new_item = editText1.getText().toString();

        editText2 = (EditText) findViewById(R.id.edit_position);
        pos = Integer.parseInt(editText2.getText().toString());

        // Get the string list instance

        the_list = StringList.getInstance();

        // try to put the new item on the list

        try
        {
            the_list.add(pos, new_item);

            Toast.makeText(AddItemActivity.this,
                    new_item + " added to the list",
                    Toast.LENGTH_SHORT).show();
        }
        catch(IndexOutOfBoundsException e)
        {
            Toast.makeText(AddItemActivity.this,
                    "Failed to add item to the list",
                    Toast.LENGTH_SHORT).show();

        }

    } // end addItem

} // end AddItemActivity
