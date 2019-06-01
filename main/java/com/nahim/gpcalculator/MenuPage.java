package com.nahim.gpcalculator;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.view.Window;

import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;




public class MenuPage extends AppCompatActivity
{
	private static final String APP_ID = "204760018";

	private StartAppAd startAppAd = new StartAppAd(this);

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR);

		StartAppSDK.init(this, APP_ID, true);

		StartAppSDK.setUserConsent (this,
				"pas",
				System.currentTimeMillis(),
				true);

		setContentView(R.layout.menu_page);



        ActionBar actionBar = this.getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));


	}

//	@Override
//    public void onPause()
//    {
//        super.onPause();
//    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{

		if (item.getItemId() == R.id.about) {
			startAppAd.showAd();
			startAppAd.loadAd();

			Intent intent = new Intent(this, About.class);
			startActivity(intent);
		}

		return true;
	}

	public void calculatorClicked(View view)
	{
		startAppAd.showAd();
		startAppAd.loadAd();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	public void exitClicked(View view)
	{
		moveTaskToBack(true);
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
	}



	@Override
	public void onResume(){
		super.onResume();
		startAppAd.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		startAppAd.onPause();
	}

	@Override
	public void onBackPressed() {
		StartAppAd.onBackPressed(this);
		super.onBackPressed();
	}

}