package example.chen.com.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 1- Canvas rotate操作
 */
public class RotateView extends BaseView {

    public RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testRotate(canvas);

    }

    private void testRotate(Canvas canvas) {
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setStrokeWidth(5);
        canvas.translate(getCenterX(), getCenterY());
        RectF rectF = new RectF(-400, -400, 400, 400);
        for (int i = 0; i < 180; i++) {
            canvas.drawRect(rectF, getPaint());
            canvas.rotate(2);
        }
    }
}
