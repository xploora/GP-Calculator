package com.nahim.gpcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;
import android.view.Display;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;

public class MainActivity extends AppCompatActivity
{
	int numberOfCourses=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		ActionBar actionBar = getSupportActionBar();

		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));
		actionBar.setDisplayHomeAsUpEnabled(true);

		findViewById(R.id.next_button).setVisibility(View.INVISIBLE);
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int screenWidth = size.x;
		int screenHeight = size.y;
		
//		LinearLayout.LayoutParams paramsLin = new LinearLayout.LayoutParams((int)(screenWidth/4), (int)(screenHeight/8));

		GridLayout.Spec row1 = GridLayout.spec(0);
		GridLayout.Spec row2 = GridLayout.spec(1);
		GridLayout.Spec row3 = GridLayout.spec(2);
		GridLayout.Spec row4 = GridLayout.spec(3);

		GridLayout.Spec col1 = GridLayout.spec(0);
		GridLayout.Spec col2 = GridLayout.spec(1);
		GridLayout.Spec col3 = GridLayout.spec(2);

		GridLayout.LayoutParams param1 = new GridLayout.LayoutParams(row1, col1);
		GridLayout.LayoutParams param2 = new GridLayout.LayoutParams(row1, col2);
		GridLayout.LayoutParams param3 = new GridLayout.LayoutParams(row1, col3);
		GridLayout.LayoutParams param4 = new GridLayout.LayoutParams(row2, col1);
		GridLayout.LayoutParams param5 = new GridLayout.LayoutParams(row2, col2);
		GridLayout.LayoutParams param6 = new GridLayout.LayoutParams(row2, col3);
		GridLayout.LayoutParams param7 = new GridLayout.LayoutParams(row3, col1);
		GridLayout.LayoutParams param8 = new GridLayout.LayoutParams(row3, col2);
		GridLayout.LayoutParams param9 = new GridLayout.LayoutParams(row3, col3);
		GridLayout.LayoutParams param_clr = new GridLayout.LayoutParams(row4, col1);
		GridLayout.LayoutParams param0 = new GridLayout.LayoutParams(row4, col2);
		GridLayout.LayoutParams param_next = new GridLayout.LayoutParams(row4, col3);

		param0.height = (int)(screenWidth/5);
		param0.width = (int)(screenHeight/8);
		param0.setMargins(10,10,10,10);

		param1.height = (int)(screenWidth/5);
		param1.width = (int)(screenHeight/8);
		param1.setMargins(10,10,10,10);

		param2.height = (int)(screenWidth/5);
		param2.width = (int)(screenHeight/8);
		param2.setMargins(10,10,10,10);

		param3.height = (int)(screenWidth/5);
		param3.width = (int)(screenHeight/8);
		param3.setMargins(10,10,10,10);

		param4.height = (int)(screenWidth/5);
		param4.width = (int)(screenHeight/8);
		param4.setMargins(10,10,10,10);

		param5.height = (int)(screenWidth/5);
		param5.width = (int)(screenHeight/8);
		param5.setMargins(10,10,10,10);

		param6.height = (int)(screenWidth/5);
		param6.width = (int)(screenHeight/8);
		param6.setMargins(10,10,10,10);

		param7.height = (int)(screenWidth/5);
		param7.width = (int)(screenHeight/8);
		param7.setMargins(10,10,10,10);

		param8.height = (int)(screenWidth/5);
		param8.width = (int)(screenHeight/8);
		param8.setMargins(10,10,10,10);

		param9.height = (int)(screenWidth/5);
		param9.width = (int)(screenHeight/8);
		param9.setMargins(10,10,10,10);

		param_next.height = (int)(screenWidth/5);
		param_next.width = (int)(screenHeight/8);
		param_next.setMargins(10,10,10,10);

		param_clr.height = (int)(screenWidth/5);
		param_clr.width = (int)(screenHeight/8);
		param_clr.setMargins(10,10,10,10);

		findViewById(R.id.button_0).setLayoutParams(param0);

		findViewById(R.id.button_1).setLayoutParams(param1);
		findViewById(R.id.button_2).setLayoutParams(param2);
		findViewById(R.id.button_3).setLayoutParams(param3);
		findViewById(R.id.button_4).setLayoutParams(param4);
		findViewById(R.id.button_5).setLayoutParams(param5);
		findViewById(R.id.button_6).setLayoutParams(param6);
		findViewById(R.id.button_7).setLayoutParams(param7);
		findViewById(R.id.button_8).setLayoutParams(param8);
		findViewById(R.id.button_9).setLayoutParams(param9);
		findViewById(R.id.next_button).setLayoutParams(param_next);
		findViewById(R.id.clear_button).setLayoutParams(param_clr);
	}

//    @Override
//    public void onPause()
//    {
//        super.onPause();
//
//        Intent intent = new Intent(this, MenuPage.class);
//        startActivity(intent);
//        finish();
//    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home) {
			Intent intent = new Intent(this, MenuPage.class);
			startActivity(intent);
			finish();
		}

		if (Chartboost.hasInterstitial(CBLocation.LOCATION_DEFAULT)) {
			Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
		}
		return true;
	}

	public void onButtonClick(View view)
	{
		Button button = (Button)view;
		TextView screen = (TextView)findViewById(R.id.screen);

		if (numberOfCourses == 0)
		{
			String numberOfCoursesString = button.getText().toString();
			if (Integer.parseInt(numberOfCoursesString) == 0)
			{
				findViewById(R.id.next_button).setVisibility(View.INVISIBLE);
			}
			else
			{
				findViewById(R.id.next_button).setVisibility(View.VISIBLE);
				numberOfCourses += Integer.parseInt(numberOfCoursesString);
			}
		}
		else
		{
			findViewById(R.id.next_button).setVisibility(View.VISIBLE);
			String numberOfCoursesString = button.getText().toString();
			if (!((10*numberOfCourses) + Integer.parseInt(numberOfCoursesString) >= 100))
			{
				numberOfCourses = (10*numberOfCourses) + Integer.parseInt(numberOfCoursesString);
			}
		}
		screen.setText(Integer.toString(numberOfCourses));
	}

	public void onClearClick(View view)
	{
		findViewById(R.id.next_button).setVisibility(View.INVISIBLE);

		TextView screen = (TextView)findViewById(R.id.screen);
		screen.setText("");

		numberOfCourses = 0;
	}

	public void onNextClick(View view)
	{
		Intent intent = new Intent(getApplicationContext(), InputGrades.class);
		intent.putExtra("numberOfCourses", numberOfCourses);
		startActivity(intent);
		finish();
	}
}