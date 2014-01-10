package com.example.sensorsub_droid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
		
	private Button mButton;
	
	private EditText mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButton = (Button) findViewById(R.id.button1);
		
		mEdit = (EditText) findViewById(R.id.editText1);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
								
				Intent intent = new Intent(getApplicationContext(), FullscreenActivity.class);
				
				intent.putExtra("submarine-address", mEdit.getText().toString() );
			    
				startActivity(intent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
