package co.p.calenderdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    public void endBtnOnClick(View view) {
    }

    public void startBtnOnCLick(View view) {
        showDialog(true);
    }

    private void showDialog(boolean isFromStart){
        String endDate  = "2021/3/10";
        Date one = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            one = simpleDateFormat.parse(endDate);
        }catch (Exception e){
            Log.d("fasfa", "showDialog: "+e.getMessage());
        }


        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        String start = year + "/" + (monthOfYear+1) +"/"+dayOfMonth;
                        tv.setText(start);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());
        datePickerDialog.getDatePicker().setMaxDate(one.getTime());

    }
}