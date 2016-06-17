package com.example.mypic;

import android.R.color;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView iv;
    Bitmap alterbitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iv=(ImageView)this.findViewById(R.id.iv);
        Bitmap bm =BitmapFactory.decodeResource(getResources(), R.drawable.guaguale);//不可修改的图片
        
       //创建自己的可以修改的位图
        alterbitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), bm.getConfig());
        //创建画布
        Canvas canvas= new Canvas(alterbitmap);
        
        Matrix matrix=new Matrix();
		Paint paint=new Paint();
		paint.setColor(Color.BLACK);
		canvas.drawBitmap(bm, matrix, paint);
       
		iv.setImageBitmap(alterbitmap);
		
        iv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				
				if(arg1.getAction()==MotionEvent.ACTION_MOVE){
					//取出位置
					int x=(int) arg1.getX();
					int y=(int)arg1.getY();
					for(int i=-5;i<5;i++){
						for(int j=-5;j<5;j++){
							alterbitmap.setPixel(x+i, y+j, Color.TRANSPARENT);
						}
					}
					
				}
				
				iv.setImageBitmap(alterbitmap);
				
				return true;
			}
		});
		
    }


    
    
}
