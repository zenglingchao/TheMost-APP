package com.example.ziyulibrary.Weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.ziyulibrary.R;


/**
 * 倾斜图片
 * Created by ziyu on 2016/9/23  19:30.
 */

public class TiltView extends ImageView {

    private int imageWidth;     //图片宽高
    private int imageheight;
    private double angle = 6 * Math.PI /180;  // 三角形角度
    private int triangleheight; //三角形高度

    private Paint paint; //画笔
    private Path path ;  //路径  (绘制三角形)
    private int type;    //图片倾斜类型

    public TiltView(Context context) {
        this(context,null);
    }

    public TiltView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TiltView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        praseAttr(attrs);
    }

    //获取自定义属性的 倾斜类型
    private void praseAttr(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.TiltView);
        type = array.getInteger(R.styleable.TiltView_type,1);
        array.recycle();
    }

    //重测大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        imageWidth = measureSpec(widthMeasureSpec);
        imageheight = measureSpec(heightMeasureSpec);
        setMeasuredDimension(imageWidth,imageheight); //设置View 的大小
        triangleheight = (int) Math.abs(Math.tan(angle) * imageheight); //设置三角形高度
    }

    private int measureSpec(int spec) {
        int maxHeight = 400; //设置图片的最大宽高
        int size = MeasureSpec.getSize(spec);
        int mode = MeasureSpec.getMode(spec);

        if( mode == MeasureSpec.AT_MOST ){
                return Math.min(size,maxHeight);
        }
        return size;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initPaint(); //初始化画笔
        //获得原图片
        Bitmap backbitmap = ((BitmapDrawable)getDrawable()).getBitmap();
        //创建要显示的新图片
        Bitmap bitmap = Bitmap.createBitmap(imageWidth,imageheight, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(bitmap);
        mCanvas.drawBitmap(resizeBitmap(backbitmap),0,0,null); //绘制新bitmap

        //设置三角形路径
        setTriangle();
        //设置混合画笔 (删除交集)
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        mCanvas.drawPath(path,paint);

        canvas.drawBitmap(bitmap,0,0,null);
    }
    //设置路径
    private void setTriangle() {
        path = new Path();
        switch (type) {
            case 1: // 右下角
                path.moveTo(0,imageheight);
                path.lineTo(imageWidth,imageheight);
                path.lineTo(imageWidth,imageheight - triangleheight);
                path.lineTo(0,imageheight);
                break;
            case 2: // 左上角 + 左下角
                path.moveTo(0, triangleheight);
                path.lineTo(imageWidth, 0);
                path.lineTo(0, 0);
                path.lineTo(0, imageheight);
                path.lineTo(imageWidth, imageheight);
                path.lineTo(0, imageheight - triangleheight);
                break;
            case 3: // 右上角 + 右下角
                path.moveTo(imageWidth,triangleheight);
                path.lineTo(0,0);
                path.lineTo(imageWidth,0);
                path.lineTo(imageWidth,imageheight);
                path.lineTo(0,imageheight);
                path.lineTo(imageWidth,imageheight - triangleheight);
                break;
            case 4: // 右上角
                path.moveTo(imageWidth,triangleheight);
                path.lineTo(0,0);
                path.lineTo(imageWidth,0);
                path.moveTo(imageWidth,triangleheight);
                break;
            case 5: // 左上角
                path.moveTo(0, triangleheight);
                path.lineTo(imageWidth, 0);
                path.lineTo(0, 0);
                path.moveTo(0, triangleheight);
                break;
            case 6 : //左上角 + 右下角
                path.moveTo(0, triangleheight);
                path.lineTo(imageWidth, 0);
                path.lineTo(0, 0);
                path.lineTo(0, imageheight);
                path.lineTo(imageWidth, imageheight);
                path.lineTo(imageWidth, imageheight - triangleheight);
                path.lineTo(0,imageheight);
                break;
            case 7 : //右上角 + 左下角
                path.moveTo(imageWidth,triangleheight);
                path.lineTo(0,0);
                path.lineTo(imageWidth,0);
                path.lineTo(imageWidth,imageheight);
                path.lineTo(0,imageheight);
                path.lineTo(0,imageheight - triangleheight);
                path.lineTo(imageWidth,imageheight);
                break;
            case 8 ://左下角
                path.moveTo(0,imageheight);
                path.lineTo(0,imageheight - triangleheight);
                path.lineTo(imageWidth,imageheight);
                path.lineTo(0,imageheight);
                break;
        }
    }

    //初始化画笔
    private void initPaint(){
        paint = new Paint();
        paint.setDither(true); //设定是否使用图像抖动 会使绘制出来的图片颜色更加平滑饱满
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5); //描边宽度
        paint.setStyle(Paint.Style.FILL); //使用填充画笔
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);//圆角

    }

    //重新调节图片大小
    private Bitmap resizeBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //设置需要的大小
        int newWidth = imageWidth;
        int newHeight = imageheight;
        //计算缩放比例
        float scaleWidth = (float) newWidth/width;
        float scaleHeight = (float) newHeight/height;
        //取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth,scaleHeight);
        //得到新的图片
        return Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
    }

}
