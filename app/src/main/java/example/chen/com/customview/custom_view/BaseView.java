package example.chen.com.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class BaseView extends View {
    private static final String TAG = "MyPieChart";
    protected Paint mPaint;
    protected float mScreenWidth;
    protected float mScreenHeight;
    protected float mCenterX;
    protected float mCenterY;

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        setPaint(mPaint);
        //获取屏幕宽高
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        mScreenWidth = metrics.widthPixels;
        mScreenHeight = metrics.heightPixels;
        setScreenWidth(mScreenWidth);
        setScreenHeight(mScreenHeight);
        Log.d(TAG, "mScreenWidth : " + mScreenWidth);
        Log.d(TAG, "mScreenHeight : " + mScreenHeight);
        mCenterX = mScreenWidth / 2;
        mCenterY = mScreenHeight / 2;
        setCenterX(mCenterX);
        setCenterY(mCenterY);
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    public float getScreenWidth() {
        return mScreenWidth;
    }

    public void setScreenWidth(float screenWidth) {
        mScreenWidth = screenWidth;
    }

    public float getScreenHeight() {
        return mScreenHeight;
    }

    public void setScreenHeight(float screenHeight) {
        mScreenHeight = screenHeight;
    }

    public float getCenterX() {
        return mCenterX;
    }

    public void setCenterX(float centerX) {
        mCenterX = centerX;
    }

    public float getCenterY() {
        return mCenterY;
    }

    public void setCenterY(float centerY) {
        mCenterY = centerY;
    }
}
