package com.thiennm77.angdetector;

import android.graphics.Bitmap;

/**
 * Created by nmthi on 28/10/2016.
 */

public class FaceInfo {
    protected Bitmap bitmap;
    protected double age;
    protected String gender;

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public double getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public FaceInfo(Bitmap bitmap, double age, String gender)
    {
        this.bitmap = bitmap;
        this.age = age;
        this.gender = gender;
    }
}
