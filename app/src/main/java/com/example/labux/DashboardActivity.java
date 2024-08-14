package com.example.labux;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private ViewPager2 imageCarousel;
    private ImageButton prevButton, nextButton;
    private Handler handler = new Handler();
    private Runnable autoScrollRunnable;

//    private RecyclerView recyclerView;
//    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // TODO: Placeholder for Navbar integration
        // Initialize ViewPager2 for the image carousel
        imageCarousel = findViewById(R.id.imageCarousel);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        // List of image resources for the carousel
        List<Integer> imageList = Arrays.asList(
                R.drawable.character_003,
                R.drawable.character_004,
                R.drawable.character_005
        );

        // Set up the adapter and attach it to ViewPager2
        ImageCarouselAdapter adapter = new ImageCarouselAdapter(this, imageList);
        imageCarousel.setAdapter(adapter);

        // Set up the auto-scroll functionality
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                int nextItem = (imageCarousel.getCurrentItem() + 1) % imageList.size();
                imageCarousel.setCurrentItem(nextItem, true);
                handler.postDelayed(this, 3000); // Auto-scroll every 3 seconds
            }
        };
        handler.postDelayed(autoScrollRunnable, 3000);

        // Set up buttons for manual carousel navigation
        prevButton.setOnClickListener(v -> {
            int prevItem = (imageCarousel.getCurrentItem() - 1 + imageList.size()) % imageList.size();
            imageCarousel.setCurrentItem(prevItem, true);
            resetAutoScroll();
        });

        nextButton.setOnClickListener(v -> {
            int nextItem = (imageCarousel.getCurrentItem() + 1) % imageList.size();
            imageCarousel.setCurrentItem(nextItem, true);
            resetAutoScroll();
        });

        // Enable swipe gestures on the carousel
        imageCarousel.setUserInputEnabled(true); // Allow user to swipe

        // Setting up the ViewPager2 and TabLayout for swiping through fragments
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new TabPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Terms");
                    break;
                case 1:
                    tab.setText("Conditions");
                    break;
            }
        }).attach();

        // Set custom background for selected and unselected tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.view.setBackgroundResource(R.drawable.tab_selected_background);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.view.setBackgroundResource(R.drawable.tab_unselected_background);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Optional: Handle reselection if needed
            }
        });

// Set initial background for the first tab (to handle the initial selection)
        TabLayout.Tab firstTab = tabLayout.getTabAt(0);
        if (firstTab != null) {
            firstTab.view.setBackgroundResource(R.drawable.tab_selected_background);
        }

        // RecyclerView setup using your friend's code
//        recyclerView = findViewById(R.id.trendingSearchRecycler); // Assuming you keep the same ID
//        itemAdapter = new ItemAdapter();
//
//        recyclerView.setAdapter(itemAdapter);
//
//        // Change the layout to horizontal
//        recyclerView.setLayoutManager(new GridLayoutManager(, GridLayoutManager.HORIZONTAL, false));

    }

    // Method to reset auto-scroll when user interacts with the carousel
    private void resetAutoScroll() {
        handler.removeCallbacks(autoScrollRunnable);
        handler.postDelayed(autoScrollRunnable, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(autoScrollRunnable); // Stop auto-scroll when activity is destroyed
    }
}
