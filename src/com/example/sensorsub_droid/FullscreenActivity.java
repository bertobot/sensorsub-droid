package com.example.sensorsub_droid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.sensorsub_droid.util.SystemUiHider;

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
        
        final Submarine sub = new Submarine(getIntent().getExtras().getString("submarine-address") );
                
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
        			midx = (maxx - minx) / 2.0f,
        			midy = (maxy - miny) / 2.0f,
        			
        			relx = rawx - midx,
        			rely = rawy - midy,
        			
        			percentx = relx / midx * 100,
        			percenty = rely / midy * 100;
        		
        		//mPreviousX[0] = motionEvent.getX();
        		//mPreviousY[0] = motionEvent.getY();
        			
            	//Log.d("sensorsub-droid", percentx + "," + percenty );
            	//Log.d("sensorsub-droid", sub.right() + "/" + percentx);
            	//Log.d("sensorsub-droid", sub.down() + "/" + percenty);
        		
        		Log.d("sensorsub-droid", sub.move() + "/" + percentx + "/" + percenty);
            	
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}
