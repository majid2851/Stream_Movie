package com.example.streammovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.streammovie.adapter.SliderPagerAdapter;
import com.example.streammovie.databinding.ActivityHomeBinding;
import com.example.streammovie.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity
{
    ActivityHomeBinding binding;
    private List<SlideModel> slideList =new ArrayList<>();
    SliderPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        slideList.add(new SlideModel(R.drawable.a_beautiful_mind,"slide title\nmore text here"));
        slideList.add(new SlideModel(R.drawable.dead_silence,"slide title\nmore text here"));
        slideList.add(new SlideModel(R.drawable.lord_of_the_rings1,"slide title\nmore text here"));
        slideList.add(new SlideModel(R.drawable.the_machinist,"slide title\nmore text here"));

        adapter=new SliderPagerAdapter(slideList, this);
        binding.viewPagerSlide.setAdapter(adapter);
        binding.indicator.animatePageSelected(2);
        binding.indicator.setViewPager(binding.viewPagerSlide);
        binding.indicator.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),3000,6000);



    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (binding.viewPagerSlide.getCurrentItem()<slideList.size()-1){
                        binding.viewPagerSlide.setCurrentItem(binding.viewPagerSlide.getCurrentItem()+1);
                    }else
                    {
                        binding.viewPagerSlide.setCurrentItem(0);
                    }

                }
            });
        }
    }


}