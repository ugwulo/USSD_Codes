package io.github.ugwulo.ussd_codes.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity(), Fragment3.ShowDoneTextImpl {
    private lateinit var navController : NavController
    private lateinit var onboardingBinding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboardingBinding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(onboardingBinding.root)

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

    override fun showText() {
        onboardingBinding.tvDone.visibility = View.VISIBLE
    }

    override fun disableText() {
        onboardingBinding.tvDone.visibility = View.INVISIBLE
    }


}