package com.example.sensorsub_droid;

import com.example.sensorsub_droid.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {

	private float mPreviousX[] = { 0, 0 };
	
	private float mPreviousY[] = { 0, 0 };
	
    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_fullscreen);

        final View contentView = findViewById(R.id.fullscreen_content);

        
        // Set up the user interaction to manually show or hide the system UI.
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        
        // respond to touch movement
        contentView.setOnTouchListener(new View.OnTouchListener() {
        	@Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
        		
    			int
        			minx = view.getMinimumWidth(),
        			maxx = view.getMeasuredWidth(),
        			miny = view.getMinimumHeight(),
        			maxy = view.getMeasuredHeight();
        		
        		float
        			rawx = motionEvent.getRawX(),
        			rawy = motionEvent.getRawY();

        		// relative from center
        		
        		float
        			relx = rawx - (( maxx - minx) / 2.0f),
        			rely = rawy - ((maxy - miny) / 2.0f);
        		
        		mPreviousX[0] = motionEvent.getX();
        		mPreviousY[0] = motionEvent.getY();
        			
        		Log.d("sensorsub-droid", minx + "," + maxx + "; " + miny + "," + maxy);
            	Log.d("sensorsub-droid", motionEvent.getRawX() + "," + motionEvent.getRawY() );
            	Log.d("sensorsub-droid", relx + "," + rely );
            	
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}
