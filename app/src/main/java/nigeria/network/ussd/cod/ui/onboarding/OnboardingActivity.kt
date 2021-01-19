package nigeria.network.ussd.cod.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import nigeria.network.ussd.cod.MainActivity
import nigeria.network.ussd.cod.MainActivityViewModel
import nigeria.network.ussd.cod.R
import nigeria.network.ussd.cod.databinding.ActivityOnboardingBinding

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity(), Fragment3.ShowDoneTextImpl {

    private val viewModel: MainActivityViewModel by viewModels()
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

        onboardingBinding.tvDone.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            // enable first time launch
            viewModel.setFirstTimeLaunch()
        }
    }

    override fun showText() {
        onboardingBinding.tvDone.visibility = View.VISIBLE
    }

    override fun disableText() {
        onboardingBinding.tvDone.visibility = View.INVISIBLE
    }
}