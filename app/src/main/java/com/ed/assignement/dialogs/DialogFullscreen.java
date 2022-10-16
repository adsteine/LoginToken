package com.ed.assignement.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ed.assignement.R;
import com.squareup.picasso.Picasso;

/**
 * fullscreen dialog
 */
public class DialogFullscreen extends Dialog {
    private final Activity activity;
    private String icon;
    private String name;

    public DialogFullscreen(Activity activity, String name, String icon) {
        super(activity);
        this.activity = activity;
        this.icon = icon;
        this.name = name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // using a layout for the dialog, to have more control over the design
        setContentView(R.layout.dialog_fullscreen);

        TextView nameV = findViewById(R.id.name_item);
        nameV.setText(this.name);
        // set the metric for the dialog to be a full screen
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        ImageButton btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(view -> {
            dismiss();
        });

        ImageView iconV = findViewById(R.id.image_item);
        Picasso.get().load(this.icon).resize(getScreenWidth(),getScreenHeight())
                .placeholder(android.R.drawable.toast_frame)
                .error(android.R.drawable.stat_notify_error).into(iconV);

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


}
