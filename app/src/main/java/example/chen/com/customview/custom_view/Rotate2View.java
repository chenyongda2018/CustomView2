package example.chen.com.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class Rotate2View extends BaseView {
    public Rotate2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testRotate(canvas);
    }

    private void testRotate(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.translate(mCenterX, mCenterY);
        canvas.drawCircle(0, 0, 370, mPaint);
        canvas.drawCircle(0, 0, 400, mPaint);
        for (int i = 0; i <36 ; i++) {
            canvas.drawLine(370, 0, 400, 0, mPaint);
            canvas.rotate(10);
        }
    }
}
