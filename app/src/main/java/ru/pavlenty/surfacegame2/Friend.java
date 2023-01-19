package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Friend {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;

    private int maxY;
    private int maxX;
    private int minY;
    private int minX;

    private Rect detectCollision;

    public Friend(Context context, int screenX, int screenY) {
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = 15 + generator.nextInt(5);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.friend);
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update() {

        x -= speed;

        if (x + bitmap.getWidth() < 0) {
            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = 15 + generator.nextInt(5);
        }

        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();

    }


    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
