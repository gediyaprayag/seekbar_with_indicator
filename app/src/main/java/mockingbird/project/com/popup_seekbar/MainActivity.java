package mockingbird.project.com.popup_seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Indicator tvIndicator, tvIndicator1;
    SeekBar seekBar, seekBar1;
    int posX;
    int scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvIndicator = this.findViewById(R.id.tvIndicator);
        seekBar = this.findViewById(R.id.seekBar);

        tvIndicator1 = this.findViewById(R.id.tvIndicator1);
        seekBar1 = this.findViewById(R.id.seekBar1);

        scale = 527 / 10;
        seekBar.setProgress(seekBar.getMax()/2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                posX = seekBar.getThumb().getBounds().centerX();
                tvIndicator.moveIndicator(seekBar, posX);
                setThumbText(String.valueOf(seekBar.getProgress() * scale), tvIndicator);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                posX = seekBar.getThumb().getBounds().centerX();
                tvIndicator1.moveIndicator(seekBar, posX);
                setThumbText(String.valueOf(seekBar1.getProgress()), tvIndicator1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void setThumbText(String text, Indicator indicator) {
        indicator.setText(text);
    }
}
