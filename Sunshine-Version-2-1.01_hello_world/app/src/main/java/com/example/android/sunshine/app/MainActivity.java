package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    /**
     * onCreate(Bundle savedInstanceState), getSupportFragmentManager
     * MainActivity가 class로 지정되어 있음
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //called to do initial creation of a fragment
        //Bundle에 저장된 Instance State를 불러옴
        //onCreate()는 protected method
        super.onCreate(savedInstanceState);
        //Activity class의 onCreate()를 상속하였기 때문에 super.필요
        setContentView(R.layout.activity_main);
        //override된 것임에 유의
        //content의 view는 layout.activity_main.xml 화일로 지정
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    //beginTransaction()은 activity state저장전에 사용
                    .add(R.id.container, new ForecastFragment())
                            //FragmentTransaction class 참조
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        //in order to display menu, 'true' must be returned,
        //MenuInflator inflator = getMenuInfator();로 써도 마찬가지 결과
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {//main.xml의 item id
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
