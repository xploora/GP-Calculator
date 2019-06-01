package com.nahim.gpcalculator;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.MenuItem;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;


public class ShowGP extends AppCompatActivity
{
	float gp;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_gp);

        ActionBar actionBar = getSupportActionBar();

		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));
		actionBar.setDisplayHomeAsUpEnabled(true);

		Bundle extras = getIntent().getExtras();
		gp = extras.getFloat("gp");

		TextView gradePoint = (TextView)findViewById(R.id.gp);
		gradePoint.setText(Float.toString(gp));
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
		if (item.getItemId() == android.R.id.home)
		{
			Intent intent = new Intent(this, MenuPage.class);
			startActivity(intent);
			finish();
		}

		if (Chartboost.hasInterstitial(CBLocation.LOCATION_DEFAULT)) {
			Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
		}
		return true;
	}
}