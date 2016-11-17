package com.firstapp.fake.firstapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Fake on 12.11.2016.
 */

public class AddItemDialog extends DialogFragment {

    Note note;
    OnDialogCallback odc;

    void setCallback(OnDialogCallback odc) {
        this.odc = odc;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_additem, null);
        final EditText noteTitle = (EditText) view.findViewById(R.id.noteTitle);
        note = new Note();

        initCircles(view);
        Button bt_ok = (Button) view.findViewById(R.id.ok);
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setTitle(noteTitle.getText().toString());
                if (note.getTitle().equals("")) {
                    note.setTitle("Element " + (RecyclerAdapter.itemCount + 1));
                    RecyclerAdapter.itemCount++;
                }
                odc.onButtonClick(note);
                AddItemDialog.this.dismiss();
            }
        });
        return view;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    public void initCircles(View view) {

        ImageView imageRed = ((ImageView) view.findViewById(R.id.circleRed));
        ImageView imageOrange = ((ImageView) view.findViewById(R.id.circleOrange));
        ImageView imageYellow = ((ImageView) view.findViewById(R.id.circleYellow));
        ImageView imageGreen = ((ImageView) view.findViewById(R.id.circleGreen));
        ImageView imageBlue = ((ImageView) view.findViewById(R.id.circleBlue));
        ImageView imageDarkBlue = ((ImageView) view.findViewById(R.id.circleDarkBlue));
        ImageView imageViolet = ((ImageView) view.findViewById(R.id.circleViolet));
        final ImageView rectancle = (ImageView) view.findViewById(R.id.rectancle);

        imageRed.getDrawable().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
        imageOrange.getDrawable().setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
        imageYellow.getDrawable().setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        imageGreen.getDrawable().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.SRC_ATOP);
        imageBlue.getDrawable().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);
        imageDarkBlue.getDrawable().setColorFilter(getResources().getColor(R.color.dark_blue), PorterDuff.Mode.SRC_ATOP);
        imageViolet.getDrawable().setColorFilter(getResources().getColor(R.color.violet), PorterDuff.Mode.SRC_ATOP);

        imageRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.red);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.orange);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.yellow);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.green);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.blue);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.dark_blue);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.dark_blue), PorterDuff.Mode.SRC_ATOP);
            }
        });
        imageViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.violet);
                rectancle.getDrawable().setColorFilter(getResources().getColor(R.color.violet), PorterDuff.Mode.SRC_ATOP);
            }
        });
    }
}
