package io.github.ugwulo.ussd_codes.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.github.ugwulo.ussd_codes.R

class OnboardingActivity : AppCompatActivity() {
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        val fragmentList = arrayListOf(
            Fragment0.newInstance(),
            Fragment1.newInstance(),
            Fragment2.newInstance(),
            Fragment3.newInstance()
        )
        viewPager2.adapter = ViewPagerAdapter(this, fragmentList)

        TabLayoutMediator(tabLayout, viewPager2!!)
        { tab, position ->}.attach()
    }


}