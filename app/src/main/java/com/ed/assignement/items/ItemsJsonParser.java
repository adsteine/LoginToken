package com.ed.assignement.items;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Parse the json data we get from the API
 */
public class ItemsJsonParser {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PARENT_ID = "parent_id";
    private static final String SLUG = "slug";
    private static final String ICONURL = "icon_url";
    private static final String UPDATEDAT = "updated_at";
    private final String itemJson;

    public ItemsJsonParser(final String itemJson) {
        super();
        this.itemJson = itemJson;
    }

    public List<ItemsObject> getItemsObjects() {
        ArrayList mapObjects = new ArrayList<>();

        try {
            final JSONObject json = new JSONObject(this.itemJson);
            JSONArray data = json.getJSONArray("categories");
            for (int i = 0; i < data.length(); i++) {
                final ItemsObject mapObject = new ItemsObject();
                final JSONObject mapObjectJson = data.getJSONObject(i);
                mapObject.setId(mapObjectJson.get(ID).toString());
                mapObject.setIconUrl(mapObjectJson.get(ICONURL).toString());
                mapObject.setName(mapObjectJson.get(NAME).toString());
                mapObject.setParentId(mapObjectJson.get(PARENT_ID).toString());
                mapObject.setSlug(mapObjectJson.get(SLUG).toString());
                mapObject.setUpdatedAt(mapObjectJson.get(UPDATEDAT).toString());
                mapObjects.add(mapObject);
            }
        } catch (final JSONException e) {

        }
        return mapObjects;
    }
}
