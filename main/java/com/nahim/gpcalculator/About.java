
package com.nahim.gpcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError;

public class About extends AppCompatActivity
	{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		ActionBar actionBar = getSupportActionBar();

		Spannable text = new SpannableString(actionBar.getTitle());
		text.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000FF")));
		actionBar.setTitle(text);

		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home) {
			this.finish();
		}

		if (Chartboost.hasInterstitial(CBLocation.LOCATION_DEFAULT)) {
			System.out.println("opopopopopo");
			Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
		}

		return true;
	}


		/**
		 *  DELEGATE METHODS
		 */
		private ChartboostDelegate delegateObject = new ChartboostDelegate() {

			/**
			 * REWARDED VIDEO DELEGATE METHODS
			 */

			// Called before requesting an interstitial via the Chartboost API server.
			public boolean shouldRequestInterstitial(String location){

				return true;
			}

			// Called before an interstitial will be displayed on the screen.
			public boolean shouldDisplayInterstitial(String location){

				return true;
			}

			// Called after an interstitial has been displayed on the screen.
			public void didDisplayInterstitial(String location){

				System.out.println("INTERSTITIAL SHOWN");

			}

			// Called after an interstitial has been loaded from the Chartboost API
			// servers and cached locally.
			public void didCacheInterstitial(String location){

				System.out.println("INTERSTITIAL LOADED");
			}

			// Called after an interstitial has attempted to load from the Chartboost API
			// servers but failed.
			public void didFailToLoadInterstitial(String location, CBError.CBImpressionError error){

				System.out.println("INTERSTITIAL FAILED TO LOAD");
				Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
			}

			// Called after an interstitial has been dismissed.
			public void didDismissInterstitial(String location){

				System.out.println("INTERSTITIAL DISMISSED");
				Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
			}

			// Called after an interstitial has been closed.
			public void didCloseInterstitial(String location){

				System.out.println("INTERSTITIAL CLOSED");
				Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
			}

			// Called after an interstitial has been clicked.
			public void didClickInterstitial(String location){

				System.out.println("INTERSTITIAL CLICKED");
				Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
			}
		};
}