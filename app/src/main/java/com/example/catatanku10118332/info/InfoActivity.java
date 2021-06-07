package com.example.catatanku10118332.info;

//7 Juni 2021 - Nais Farid - IF8 - 10118332

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.catatanku10118332.MainActivity;
import com.example.catatanku10118332.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);
        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem()+1 < onboardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }else{
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnboardingItems(){
        List<Onboardingitem> onboardingitems = new ArrayList<>();

        Onboardingitem item1 = new Onboardingitem();
        item1.setTitle("Catatanku Apps");
        item1.setDescription("Apps yang mempermudah catatan harianmu");
        item1.setImage(R.drawable.notepad);

        Onboardingitem item2 = new Onboardingitem();
        item2.setTitle("UI yang simpel");
        item2.setDescription("Dengan UI yang simpel menjadi mudah untuk digunakan");
        item2.setImage(R.drawable.note);

        Onboardingitem item3 = new Onboardingitem();
        item3.setTitle("Limited Notes");
        item3.setDescription("Jumlah yang tak terbatas untuk menyimpan Catatanmu");
        item3.setImage(R.drawable.studying);

        onboardingitems.add(item1);
        onboardingitems.add(item2);
        onboardingitems.add(item3);

        onboardingAdapter = new OnboardingAdapter(onboardingitems);
    }

    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i=0; i< indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator (int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0 ; i<childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboard_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onboardingAdapter.getItemCount()-1){
            buttonOnboardingAction.setText("Back");
        } else {
            buttonOnboardingAction.setText("Next");
        }
    }
}