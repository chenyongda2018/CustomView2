package example.chen.com.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


/**
 * 2. 绘制饼图
 *
 * @param canvas
 */
public class PieChartView extends BaseView {

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        testPieChart(canvas);
    }


    private void testPieChart(Canvas canvas) {
        RectF rect = new RectF(mCenterX - 200, mCenterY - 200, mCenterX + 200, mCenterY + 200);
        canvas.drawArc(rect, 0, 90, true, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawArc(rect, 90, 90, true, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rect, 180, 90, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rect, 270, 90, true, mPaint);
    }
}
