package com.ed.assignement.items;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ed.assignement.R;
import com.ed.assignement.dialogs.DialogFullscreen;
import com.squareup.picasso.Picasso;

import java.util.List;

 /**
 * Addapter for each item
 * click on each item to open dialog
 */
public class ItemsElementsAdapter extends ArrayAdapter<ItemsObject> {
    private final Activity activity;
    private View v;
    private TextView id_text;
    private TextView name_text;
    private TextView date_text;
    private ImageView image_item;
    private RelativeLayout layout_item;

    public ItemsElementsAdapter(final Activity activity, final int resource, final List<ItemsObject> objects) {
        super(activity, resource, objects);
        this.activity = activity;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        this.v = convertView;
        if (this.v == null) {
            this.v = getView();
        }
        initViews();
        setViews(getRelatedObjectValue(position));
        return this.v;
    }

    private View getView() {
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        return inflater.inflate(R.layout.row_item, null);
    }

    private void initViews() {
        this.id_text = this.v.findViewById(R.id.id_item);
        this.name_text = this.v.findViewById(R.id.name_item);
        this.date_text = this.v.findViewById(R.id.date_item);
        this.image_item = this.v.findViewById(R.id.image_item);
        this.layout_item = this.v.findViewById(R.id.layout_item);
    }

    private void setViews(final ItemsObject object) {
        if (object == null) {
            return;
        }
        String name = object.getName();
        String icon = object.getIconUrl();
        String slug = object.getSlug();
        String updated = object.getUpdatedAt();
        String id = object.getId();
        this.id_text.setText(id);
        this.name_text.setText(name);
        this.date_text.setText(updated);
        // Download the icon and show it on the list using the picasso dependency
        Picasso.get().load(icon)
                .placeholder(android.R.drawable.toast_frame)
                .error(android.R.drawable.stat_notify_error).into(this.image_item);

        this.layout_item.setOnClickListener(v -> {
            // open the dialog with the full screen
            openImage(name,icon);
        });
    }
    private ItemsObject getRelatedObjectValue(final int position) {
        return getItem(position);
    }

    private void openImage(String name,String icon) {
        final DialogFullscreen dialog = new DialogFullscreen(this.activity,name,icon);

        dialog.setCancelable(false);

        dialog.show();
    }

}
