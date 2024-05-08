import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk1, chk2, chk3, chk4;
    private ImageView output1, output2, output3, output4;
    private TextView showOrder;
    private StringBuilder orderBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);

        showOrder = findViewById(R.id.showOrder);

        orderBuilder = new StringBuilder();

        // 監聽 CheckBox 選取狀態變化
        chk1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                orderBuilder.append("漢堡, ");
                showOrder.setText(orderBuilder.toString());
                output1.setVisibility(View.VISIBLE);
            }
        });

        chk2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                orderBuilder.append("薯條, ");
                showOrder.setText(orderBuilder.toString());
                output2.setVisibility(View.VISIBLE);
            }
        });

        chk3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                orderBuilder.append("可樂, ");
                showOrder.setText(orderBuilder.toString());
                output3.setVisibility(View.VISIBLE);
            }
        });

        chk4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                orderBuilder.append("咖啡, ");
                showOrder.setText(orderBuilder.toString());
                output4.setVisibility(View.VISIBLE);
            }
        });
    }
}
