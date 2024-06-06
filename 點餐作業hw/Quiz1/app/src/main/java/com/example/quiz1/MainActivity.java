package com.example.quiz1;

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

        // Set onClickListener for each CheckBox
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
        // Update the visibility of ImageView corresponding to the clicked CheckBox
        CheckBox checkBox = checkBoxes.get(index);
        ImageView imageView = imageViews.get(index);
        imageView.setVisibility(checkBox.isChecked() ? View.VISIBLE : View.INVISIBLE);

        // Update the visibility of remaining ImageViews to maintain order
        for (int i = index + 1; i < checkBoxes.size(); i++) {
            ImageView nextImageView = imageViews.get(i);
            CheckBox nextCheckBox = checkBoxes.get(i);

            if (nextCheckBox.isChecked()) {
                // If the next CheckBox is checked, set the corresponding ImageView to visible
                nextImageView.setVisibility(View.VISIBLE);
            } else {
                // If the next CheckBox is unchecked, set the corresponding ImageView to invisible
                nextImageView.setVisibility(View.INVISIBLE);
            }
        }
    }
}
