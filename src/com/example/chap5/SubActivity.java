package com.example.chap5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SubActivity extends Activity 
	implements OnTouchListener
{
	private String text ="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			text = extras.getString("param");
		}
		
		TextView tv = new TextView(this);
		tv.setText("SubActivity: " + text);
		setContentView(tv);
		
		tv.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		if((action & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN){
			Intent it = new Intent();
			it.putExtra("return", text);
			setResult(Activity.RESULT_OK, it);
			finish();
		}
		return false;
	}

}
