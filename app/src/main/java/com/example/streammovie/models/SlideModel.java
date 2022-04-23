package com.example.streammovie.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class SlideModel
{
    int img;
    String title;

    public SlideModel(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @BindingAdapter("android:setImage")
    public static void setImage(ImageView img,int res){
        img.setImageResource(res);
    }
}
