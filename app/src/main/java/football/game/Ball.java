package football.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

class Ball extends View{

    private Bitmap bitmapFootball;

    int ballCenterX = 200;
    int ballCenterY = 500;
    int ballSpeedX = 0;
    int ballSpeedY = 0;
    int ballRadius = 62;

    float startX = 0;
    float startY = 0;
    float endX = 0;
    float endY = 0;

    boolean win =false;

    float previousX = 0;
    float previousY = 0;

    public Ball(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        //Paint paint = new Paint();
        bitmapFootball = BitmapFactory.decodeResource(getResources(), R.drawable.football);
        bitmapFootball= Bitmap.createScaledBitmap(bitmapFootball, ballRadius * 2, ballRadius * 2, true);
    }


    protected void Update(int ballSpeedX, int ballSpeedY){
        this.ballSpeedX = ballSpeedX;
        this.ballSpeedY = ballSpeedY;

        ballCenterX += ballSpeedX;
        ballCenterY += ballSpeedY;

        /*
        if(ballCenterX + ballRadius > 350 && ballCenterY + ballRadius < 75 && ballCenterX - ballRadius < 750){
            ballSpeedY = -ballSpeedY;
        }*/
    }

    //Piirretään pallot
    @Override
    protected void onDraw ( Canvas canvas){
        //Log.d("ball", "2");
        //super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(700, 800, 62, paint);

        canvas.drawBitmap(bitmapFootball, ballCenterX, ballCenterY, null);

        //canvas.drawCircle(ballCenterX, ballCenterY, ballRadius, paint);
        /*
        Paint paintOutLine = new Paint();
        paintOutLine.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(ballCenterX, ballCenterY, ballRadius, paintOutLine);*/

    }

}
