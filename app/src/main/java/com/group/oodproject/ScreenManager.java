package com.group.oodproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by User on 4/18/2017.
 */
//Comment
public class ScreenManager
{
    private Context context;
    private Canvas canvas;
    private Paint paint;

    public ScreenManager(Context context)
    {
        this.context = context;
        this.paint = new Paint();
    }
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }

    public Bitmap getImage(int ID, int width, int height)
    {
        return decodeSampledBitmapFromResource(context.getResources(), ID, width, height);
    }
    public void render(Bitmap image, DynamicCoordinate coordinate)
    {
        canvas.drawBitmap(image, (float) coordinate.getX(), (float) coordinate.getY(), paint);

    }
    public void render(Bitmap image, float x, float y)
    {
        canvas.drawBitmap(image, x, y, paint);
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
    private Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight)
    {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
