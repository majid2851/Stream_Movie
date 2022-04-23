package com.example.streammovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.streammovie.R;
import com.example.streammovie.databinding.PatternSliderBinding;
import com.example.streammovie.models.SlideModel;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter
{

    private Context context;
    private List<SlideModel> arrayList;
    public SliderPagerAdapter(List<SlideModel> arrayList,Context context )
    {
        this.context=context;
        this.arrayList=arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PatternSliderBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.pattern_slider,container,false);
       // binding.sliderImg.setImageResource(arrayList.get(position).getImg());
        binding.setSlider(arrayList.get(position));


        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }



}
