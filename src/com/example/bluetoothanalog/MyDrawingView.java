package com.example.bluetoothanalog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MyDrawingView extends View {

	public MyDrawingView(Context context) {
		super(context);
	}

	public MyDrawingView(Context context, AttributeSet attrs) {
		super(context,attrs);
	}

	public MyDrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context,attrs,defStyle);
	}
		
	@Override
	protected void onDraw (Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);		
		canvas.drawCircle(x, y, r, paint);		
	}
	
	int r= 5; 
	int x = 100;
	int y = 200;
		
	public void setXandY( int rval, int xval, int yval) {
		
		x = xval;
		y = yval;
		r = rval+5; 
			
		invalidate();
	}
	
	// this is where msg come to with event=1 or event=0
	
	public void setYoverTime(int event) {
		int currentEvent = event;
		if (currentEvent == 1){
			setXandY(r,x,y);
			if (r > this.getWidth()) {
				Toast.makeText(this.getContext(), "EXPLOSION!", Toast.LENGTH_LONG).show();
				
				// write "Explosion!" or play Bang! 
				r = 5;						
			}
		}		
	}
}
