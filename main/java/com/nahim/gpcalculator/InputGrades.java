package com.nahim.gpcalculator;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;
import android.view.Display;
import android.widget.GridLayout;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;

public class InputGrades extends AppCompatActivity
{

	int credit;
	int totalCredits = 0;
	int totalPossibleCredits = 0;
	int flag = 1;
	int numberOfCourses;
	float gp;
	boolean inputCredit = true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_grades);


        ActionBar actionBar = getSupportActionBar();

		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));
		actionBar.setDisplayHomeAsUpEnabled(true);

		Bundle extras = getIntent().getExtras();
		numberOfCourses = extras.getInt("numberOfCourses");

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int screenWidth = size.x;
		int screenHeight = size.y;

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
        GridLayout.LayoutParams param0 = new GridLayout.LayoutParams(row4, col2);

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
	}

//	@Override
//	public void onPause()
//	{
//		super.onPause();
//
//		Intent intent = new Intent(this, MainActivity.class);
//		startActivity(intent);
//		finish();
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home)
		{
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		return true;
	}

	public void onButtonClick(View view)
	{
		TextView creditOrGrade = (TextView)findViewById(R.id.credit_or_grade);
		TextView courseIndex = (TextView)findViewById(R.id.course);

		Button button1 = (Button)findViewById(R.id.button_1);
		Button button2 = (Button)findViewById(R.id.button_2);
		Button button3 = (Button)findViewById(R.id.button_3);
		Button button4 = (Button)findViewById(R.id.button_4);
		Button button5 = (Button)findViewById(R.id.button_5);
		Button button6 = (Button)findViewById(R.id.button_6);

		Button button = (Button)view;

		if (inputCredit == true)
		{
			creditOrGrade.setText("GRADE?");

			String creditString = button.getText().toString();
			credit = Integer.parseInt(creditString);

			totalPossibleCredits += credit * 5;

			button1.setText("A");
			button2.setText("B");
			button3.setText("C");
			button4.setText("D");
			button5.setText("E");
			button6.setText("F");

			findViewById(R.id.button_0).setVisibility(View.INVISIBLE);
			findViewById(R.id.button_7).setVisibility(View.INVISIBLE);
			findViewById(R.id.button_8).setVisibility(View.INVISIBLE);
			findViewById(R.id.button_9).setVisibility(View.INVISIBLE);

			inputCredit = false;
		}
		else
		{
			if (!(flag == numberOfCourses))
			{
				creditOrGrade.setText("UNIT?");
			}
			String gradeString = button.getText().toString();

			switch (gradeString)
			{
			case ("A"):
				totalCredits += credit*5;
				break;
			case ("B"):
				totalCredits += credit*4;
				break;
			case ("C"):
				totalCredits += credit*3;
				break;
			case ("D"):
				totalCredits += credit*2;
				break;
			case ("E"):
				totalCredits += credit*1;
				break;
			case ("F"):
				totalCredits += credit*0;
			}

			if (!(flag >= numberOfCourses))
			{
				button1.setText("1");
				button2.setText("2");
				button3.setText("3");
				button4.setText("4");
				button5.setText("5");
				button6.setText("6");

				findViewById(R.id.button_0).setVisibility(View.VISIBLE);
				findViewById(R.id.button_7).setVisibility(View.VISIBLE);
				findViewById(R.id.button_8).setVisibility(View.VISIBLE);
				findViewById(R.id.button_9).setVisibility(View.VISIBLE);

				flag += 1;
				inputCredit = true;
				courseIndex.setText("COURSE " + Integer.toString(flag) + ":");
			}
			else
			{
				if (Chartboost.hasInterstitial(CBLocation.LOCATION_DEFAULT)) {
					Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
				}

				gp = ((float)totalCredits / (float)totalPossibleCredits) * 5;
				Intent intent = new Intent(getApplicationContext(), ShowGP.class);
				intent.putExtra("gp", gp);
				startActivity(intent);
				finish();
			}
		}
	}

	public void refreshClicked(View view)
	{
		finish();
		startActivity(getIntent());
	}
}