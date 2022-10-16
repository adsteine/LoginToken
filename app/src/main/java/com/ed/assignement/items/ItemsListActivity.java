package com.ed.assignement.items;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.ed.assignement.R;
import java.util.List;

public class ItemsListActivity extends AppCompatActivity {
    private String informationJson;
    private List<ItemsObject> objectList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        fillListWithItems();
    }


    private void fillListWithItems() {

        this.listView = findViewById(R.id.list_view_elements);
        // get the bundle data from the login activity
        final Bundle b = getIntent().getExtras();
        this.informationJson = b.getString("data");
        this.objectList = getItemsObjects();
        final ItemsElementsAdapter adapter = new ItemsElementsAdapter(this, R.layout.row_item, this.objectList);
        this.listView.setAdapter(adapter);
    }

    private List<ItemsObject> getItemsObjects() {
        final ItemsJsonParser mep = new ItemsJsonParser(this.informationJson);
        return mep.getItemsObjects();
    }
}
