package com.example.quiz0605;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CheckBox> checkBoxes;
    private List<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxes = new ArrayList<>();
        checkBoxes.add((CheckBox) findViewById(R.id.chk1));
        checkBoxes.add((CheckBox) findViewById(R.id.chk2));
        checkBoxes.add((CheckBox) findViewById(R.id.chk3));
        checkBoxes.add((CheckBox) findViewById(R.id.chk4));

        imageViews = new ArrayList<>();
        imageViews.add((ImageView) findViewById(R.id.output1));
        imageViews.add((ImageView) findViewById(R.id.output2));
        imageViews.add((ImageView) findViewById(R.id.output3));
        imageViews.add((ImageView) findViewById(R.id.output4));

        // Set all imageViews initially invisible
        for (ImageView imageView : imageViews) {
            imageView.setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < checkBoxes.size(); i++) {
            final int index = i;
            checkBoxes.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateOutput(index);
                }
            });
        }
    }

    private void updateOutput(int index) {
        CheckBox checkBox = checkBoxes.get(index);
        ImageView imageView = imageViews.get(index);

        if (checkBox.isChecked()) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }
    }
}
