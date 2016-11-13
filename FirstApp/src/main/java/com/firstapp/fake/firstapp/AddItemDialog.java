package com.firstapp.fake.firstapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Fake on 12.11.2016.
 */

public class AddItemDialog extends DialogFragment{

    Note note;
    OnDialogCallback odc;

    void setCallback(OnDialogCallback odc){
        this.odc = odc;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_additem,null);
        note = new Note();

        initCircles(view);

        Button bt_ok = (Button) view.findViewById(R.id.ok);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    public void initCircles(View view){
        ImageView imageRed = ((ImageView) view.findViewById(R.id.circleRed));
        ImageView imageOrange = ((ImageView) view.findViewById(R.id.circleOrange));
        ImageView imageYellow = ((ImageView) view.findViewById(R.id.circleYellow));
        ImageView imageGreen = ((ImageView) view.findViewById(R.id.circleGreen));
        ImageView imageBlue = ((ImageView) view.findViewById(R.id.circleBlue));
        ImageView imageDarkBlue = ((ImageView) view.findViewById(R.id.circleDarkBlue));
        ImageView imageViolet = ((ImageView) view.findViewById(R.id.circleViolet));

        int color = R.color.red;
        imageRed.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.orange;
        imageOrange.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.yellow;
        imageYellow.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.green;
        imageGreen.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.blue;
        imageBlue.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.dark_blue;
        imageDarkBlue.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
        color = R.color.violet;
        imageViolet.getDrawable().setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);

        imageRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.red);
            }
        });

        imageOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.orange);
            }
        });

        imageYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.yellow);
            }
        });

        imageGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.green);
            }
        });

        imageBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.blue);
            }
        });

        imageDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.dark_blue);
            }
        });

        imageViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setColor(R.color.violet);
            }
        });
    }

    public interface OnDialogCallback{
        public void onButtonClick(Note note);
    }
}
