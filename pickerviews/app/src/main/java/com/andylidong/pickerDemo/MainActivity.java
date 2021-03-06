package com.andylidong.pickerDemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andylidong.pickerview.TimePickerView;
import com.andylidong.pickerview.listener.OnTimeSelectListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TimePickerView tpPicker = null;

    private Context context = null;

    public final String ALL = "yyyy-MM-dd HH:mm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        final TextView tvShow = (TextView) this.findViewById(R.id.tvShow);
        Button btnShow = (Button) this.findViewById(R.id.btnPicker);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tpPicker = new TimePickerView(context, TimePickerView.Type.ALL);
                tpPicker.setRange(2015,2018);
                tpPicker.setTime(new Date(), ALL);
                tpPicker.setTitle("");
                tpPicker.setCyclic(false);
                tpPicker.setCancelable(true);
                if (tpPicker.isShowing()) {
                    tpPicker.dismiss();
                } else {
                    tpPicker.show();
                }
                tpPicker.setOnTimeSelectListener(new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        tvShow.setText(getTime(date));
                    }

                    @Override
                    public void onTimeSelect(String year, String month, String day, String hour, String minutes) {

                    }
                });
            }


        });
    }

    /**
     * 获取想要的时间格式
     *
     * @param date
     * @return
     */
    public String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(ALL);
        return format.format(date);
    }

}
