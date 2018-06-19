package com.lcf.kzcfrx.baselibrary.widget.material;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.animation.Animation;

import com.lcf.kzcfrx.baselibrary.R;


/**
 * .
 */

public class MaterialCircleProgressBar extends android.support.v7.widget.AppCompatImageView {

    private static final int KEY_SHADOW_COLOR = 0x1E000000;
    private static final int FILL_SHADOW_COLOR = 0x3D000000;
    // PX
    private static final float X_OFFSET = 0f;
    private static final float Y_OFFSET = 1.75f;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final int SHADOW_ELEVATION = 4;
    private static final int DEFAULT_RADIUS = 56;

    private Animation.AnimationListener mListener;
    private int mShadowRadius;

    private MaterialProgressDrawable mProgressDrawable;

    private int mProgressColor;//进度条颜色

    private int mBackgroundColor;//背景颜色

    private boolean mBackgroundEnabled;//是否显示背景

    private int mProgressSize;//进度条大小

    public MaterialCircleProgressBar(Context context) {
        this(context, null);
    }

    public MaterialCircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MaterialCircleProgressBar, defStyleAttr, 0);
        mProgressColor = a.getColor(R.styleable.MaterialCircleProgressBar_progressColor, context.getResources().getColor(R.color.colorOrange));
        mBackgroundColor = a.getColor(R.styleable.MaterialCircleProgressBar_backgroundColor, 0xFFFAFAFA);
        mBackgroundEnabled = a.getBoolean(R.styleable.MaterialCircleProgressBar_backgroundEnabled, true);
        mProgressSize = a.getInt(R.styleable.MaterialCircleProgressBar_progressSize, 1);
        a.recycle();

        mProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        if (1 == mProgressSize) {
            mProgressDrawable.updateSizes(MaterialProgressDrawable.DEFAULT);
        } else {
            mProgressDrawable.updateSizes(MaterialProgressDrawable.LARGE);
        }
        mProgressDrawable.setAlpha(255);
        mProgressDrawable.showArrow(false);
        mProgressDrawable.setColorSchemeColors(new int[]{mProgressColor});
        mProgressDrawable.start();
        setImageDrawable(mProgressDrawable);
    }

    private boolean elevationSupported() {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + mShadowRadius*2, getMeasuredHeight()
                    + mShadowRadius*2);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        final float density = getContext().getResources().getDisplayMetrics().density;
        int diameter = (int) (Math.max(getMeasuredHeight(), getMeasuredWidth()) * density * 2);
        if(diameter <= 0) {
            diameter = (int) (DEFAULT_RADIUS * density * 2);
        }
        final int shadowYOffset = (int) (density * Y_OFFSET);
        final int shadowXOffset = (int) (density * X_OFFSET);

        mShadowRadius = (int) (density * SHADOW_RADIUS);

        ShapeDrawable circle;
        if (elevationSupported()) {
            circle = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, SHADOW_ELEVATION * density);
        } else {
            OvalShape oval = new MaterialCircleProgressBar.OvalShadow(mShadowRadius, diameter);
            circle = new ShapeDrawable(oval);
            ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, circle.getPaint());
            circle.getPaint().setShadowLayer(mShadowRadius, shadowXOffset, shadowYOffset,
                    KEY_SHADOW_COLOR);
            final int padding = mShadowRadius;
            // set padding so the inner image sits correctly within the shadow.
            setPadding(padding, padding, padding, padding);
        }
        circle.getPaint().setColor(mBackgroundColor);
        if(mBackgroundEnabled) {
            setBackgroundDrawable(circle);
        }
    }

    public void setAnimationListener(Animation.AnimationListener listener) {
        mListener = listener;
    }

    @Override
    public void onAnimationStart() {
        super.onAnimationStart();
        if (mListener != null) {
            mListener.onAnimationStart(getAnimation());
        }
    }

    @Override
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (mListener != null) {
            mListener.onAnimationEnd(getAnimation());
        }
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (mProgressDrawable != null) {
            mProgressDrawable.setVisible(visibility == VISIBLE, false);
            if (visibility != VISIBLE) {
                mProgressDrawable.stop();
            } else {
                /*if (mProgressDrawable.isRunning()) {

                }*/
                mProgressDrawable.stop();
                mProgressDrawable.start();
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mProgressDrawable != null && getVisibility() == VISIBLE) {
            mProgressDrawable.stop();
            mProgressDrawable.start();
            mProgressDrawable.setVisible(true, false);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mProgressDrawable != null) {
            mProgressDrawable.stop();
            mProgressDrawable.setVisible(false, false);
        }
    }

    /**
     * Update the background color of the circle image view.
     *
     * @param colorRes Id of a color resource.
     */
    public void setBackgroundColorRes(int colorRes) {
        setBackgroundColor(getContext().getResources().getColor(colorRes));
    }

    @Override
    public void setBackgroundColor(int color) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }

    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        private int mCircleDiameter;

        public OvalShadow(int shadowRadius, int circleDiameter) {
            super();
            mShadowPaint = new Paint();
            mShadowRadius = shadowRadius;
            mCircleDiameter = circleDiameter;
            mRadialGradient = new RadialGradient(mCircleDiameter / 2, mCircleDiameter / 2,
                    mShadowRadius, new int[] {
                    FILL_SHADOW_COLOR, Color.TRANSPARENT
            }, null, Shader.TileMode.CLAMP);
            mShadowPaint.setShader(mRadialGradient);
        }

        @Override
        public void draw(Canvas canvas, Paint paint) {
            final int viewWidth = MaterialCircleProgressBar.this.getWidth();
            final int viewHeight = MaterialCircleProgressBar.this.getHeight();
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, (mCircleDiameter / 2 + mShadowRadius),
                    mShadowPaint);
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, (mCircleDiameter / 2), paint);
        }
    }
}

