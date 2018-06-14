package kz.qazlingo.www.qazlingo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {
    ViewPager viewPager;
    AlippeSlideAdapter slideAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        viewPager = findViewById(R.id.viewpager);
        slideAdapter = new AlippeSlideAdapter(getApplicationContext());
        viewPager.setAdapter(slideAdapter);
    }
}
