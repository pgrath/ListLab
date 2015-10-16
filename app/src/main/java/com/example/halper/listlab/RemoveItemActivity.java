package com.example.halper.listlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remove_item, menu);
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

    public void removeItem (View view){
        EditText et1;
        int pos;
        StringList the_list;

        the_list = StringList.getInstance();

        et1 = (EditText) findViewById(R.id.removeItemNumber);
        pos = Integer.parseInt(et1.getText().toString());

        try{
            the_list.remove(pos);
            Toast.makeText(RemoveItemActivity.this,
                    "Item successfully removed",
                    Toast.LENGTH_SHORT).show();

        }
        catch (IndexOutOfBoundsException e){
            Toast.makeText(RemoveItemActivity.this,
                    "Remove item failed. Check position selected",
                    Toast.LENGTH_SHORT).show();

        }

    }
}
