package com.vitasport.starlabs.vitasport.views.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.vitasport.starlabs.vitasport.R;

public class RoundRelativeLayout extends RelativeLayout {

    private StateListDrawable selector = null;
    private int leftTopRadius = 0;
    private int leftBottomRadius = 0;
    private int rightBottomRadius = 0;
    private int rightTopRadius = 0;
    private int normalSolid;
    private int pressedSolid;

    private int strokeWidth = 0;
    private int strokeColor;
    private int strokeActiveColor;
    private boolean isSelected = false;

    public RoundRelativeLayout(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public RoundRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public RoundRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RoundRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyleAttr, int defStyleRes) {
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RoundRelativeLayout, defStyleAttr, defStyleRes);

            normalSolid = typedArray.getColor(R.styleable.RoundRelativeLayout_rrl_normalSolidColor, Color.TRANSPARENT);
            pressedSolid = typedArray.getColor(R.styleable.RoundRelativeLayout_rrl_pressedSolidColor, Color.TRANSPARENT);
            leftTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundRelativeLayout_rrl_leftTopRadius, 0);
            leftBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundRelativeLayout_rrl_leftBottomRadius, 0);
            rightBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundRelativeLayout_rrl_rightBottomRadius, 0);
            rightTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundRelativeLayout_rrl_rightTopRadius, 0);

            strokeColor = typedArray.getColor(R.styleable.RoundRelativeLayout_rrl_strokeColor, Color.TRANSPARENT);
            strokeActiveColor = typedArray.getColor(R.styleable.RoundRelativeLayout_rrl_strokeActiveColor, Color.TRANSPARENT);
            strokeWidth = typedArray.getDimensionPixelSize(R.styleable.RoundRelativeLayout_rrl_strokeWidth, 0);
            isSelected = typedArray.getBoolean(R.styleable.RoundRelativeLayout_rrl_isSelected, false);
            typedArray.recycle();

            selector = new StateListDrawable();
            setPressedState(selector, leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius, pressedSolid);
            setNormalState(selector, leftTopRadius, leftBottomRadius, rightBottomRadius, rightTopRadius, normalSolid);
            setBackground(selector);
        }
    }

    private void setRadius(GradientDrawable drawable, int leftTopRadius, int leftBottomRadius, int rightBottomRadius, int rightTopRadius){
        drawable.setCornerRadii(new float[]{leftTopRadius, leftTopRadius, rightTopRadius,
                rightTopRadius, rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius});
    }

    private void setNormalState(StateListDrawable selector, int leftTopRadius,int leftBottomRadius, int rightBottomRadius,int rightTopRadius, int normalSolid){
        GradientDrawable normalGD = new GradientDrawable();
        normalGD.setColor(normalSolid);
        setRadius(normalGD,leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius);
        setStrokeWidthWithColor(normalGD, strokeColor, strokeActiveColor);
        LayerDrawable normalLayerDrawable = new LayerDrawable(new Drawable[]{normalGD});
        selector.addState(new int[]{}, normalLayerDrawable);
    }

    private void setPressedState(StateListDrawable selector, int leftTopRadius,int leftBottomRadius,int rightBottomRadius,int rightTopRadius, int pressedSolid){
        GradientDrawable pressedGD = new GradientDrawable();
        if (pressedSolid != Color.TRANSPARENT) {
            pressedGD.setColor(pressedSolid);
            setRadius(pressedGD,leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius);
            LayerDrawable pressedLayerDrawable = new LayerDrawable(new Drawable[]{pressedGD});
            selector.addState(new int[]{android.R.attr.state_pressed}, pressedLayerDrawable);
        }
    }

    private void setStrokeWidthWithColor(GradientDrawable drawable,int strokeColor, int strokeActiveColor){
        if (isSelected) {
            if (strokeColor != Color.TRANSPARENT) {
                drawable.setStroke(strokeWidth, strokeActiveColor);
            }
        } else {
            if (strokeColor != Color.TRANSPARENT) {
                drawable.setStroke(strokeWidth, strokeColor);
            }
        }
    }

    public void setNormalSolidColor(int normalSolid){
        this.normalSolid = normalSolid;
        GradientDrawable normalGD = new GradientDrawable();
        normalGD.setColor(normalSolid);
        setRadius(normalGD, leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius);
        LayerDrawable normalLayerDrawable = new LayerDrawable(new Drawable[]{normalGD});
        StateListDrawable selector = new StateListDrawable();
        selector.addState(new int[]{}, normalLayerDrawable);
        setBackground(selector);
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
        StateListDrawable selector = new StateListDrawable();
        setPressedState(selector, leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius, pressedSolid);
        setNormalState(selector, leftTopRadius,leftBottomRadius,rightBottomRadius,rightTopRadius, normalSolid);
        setBackground(selector);
    }
}