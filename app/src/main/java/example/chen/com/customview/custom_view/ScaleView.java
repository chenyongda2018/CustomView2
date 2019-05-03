package example.chen.com.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Canvas 的缩放操作
 *
 */
public class ScaleView extends BaseView {

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testScale(canvas);
    }


    private void testScale(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        canvas.translate(mCenterX, mCenterY);
        RectF rectF = new RectF(-400, -400, 400, 400);

        for (int i = 0; i < 30; i++) {
            canvas.drawRect(rectF, mPaint);
            canvas.scale(0.9f,0.9f );
        }
    }
}
