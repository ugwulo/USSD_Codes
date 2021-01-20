package nigeria.network.ussd.bank.cod

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import nigeria.network.ussd.bank.cod.databinding.ActivityMainBinding
import nigeria.network.ussd.bank.cod.ui.bank.BankDetailsAdapter
import nigeria.network.ussd.bank.cod.ui.check_network.CheckNetworkFragment
import nigeria.network.ussd.bank.cod.ui.network.NetworkProviderDetailsAdapter
import nigeria.network.ussd.bank.cod.ui.new_code.NewCodeAdapter
import nigeria.network.ussd.bank.cod.ui.new_code.NewCodeFragment
import nigeria.network.ussd.bank.cod.ui.onboarding.OnboardingActivity

@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BankDetailsAdapter.PhoneDialImpl,
    NetworkProviderDetailsAdapter.PhoneDialImpl, NewCodeFragment.BottomNavigationImpl,
    CheckNetworkFragment.BottomNavigationImpl,
    NewCodeAdapter.PhoneDialImpl {
    companion object{
        lateinit var mainBinding: ActivityMainBinding
    }

    private var nightModeActive = false
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var navController: NavController
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initializeViews()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private val bottomNavigationView: BottomNavigationView
        get() {
            return findViewById(R.id.nav_view)
        }

    private fun initializeViews() {

        // check if user has launched app before, if not take them to Onboarding Activity
        viewModel.firstTimeLaunch.observe(this, Observer {
            if (!it) {
                startActivity(Intent(this, OnboardingActivity::class.java))
                finish()
            }
        })

        // check if dark mode is on and update the OS
        viewModel.darkThemeEnabled.observe(this, Observer {nightModeActive ->
            this.nightModeActive = nightModeActive

            val defaultMode = if (nightModeActive) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }

            AppCompatDelegate.setDefaultNightMode(defaultMode)
        })
        supportActionBar?.hide()

        navController = findNavController(R.id.main_nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId) {
           R.id.contact_developer -> {
               composeEmail()
               true
           }
           R.id.share_app -> {
               shareApp()
               true
           }
           R.id.report_bug -> {
               reportBug()
               true
           }
           R.id.rate_app -> {
               rateApp()
               true
           }
           R.id.day_night_mode -> {
               viewModel.toggleNightMode()
               true
           }
           else -> super.onOptionsItemSelected(item)
       }
    }

    private fun rateApp() {
        val appLink = "https://play.google.com/store/apps/details?id=$packageName"
        val rateIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(appLink)
        }
        if (rateIntent.resolveActivity(packageManager) != null){
            startActivity(rateIntent)
        }
    }

    /**  create an issue in the repository */
    private fun reportBug() {
         val url = Uri.parse("https://github.com/ugwulo/USSD_Codes/issues")

        val bugIntent = Intent(Intent.ACTION_VIEW, url)
        if (bugIntent.resolveActivity(packageManager) != null){
            startActivity(bugIntent)
        }
    }

    private fun shareApp() {
        val appLink = "https://play.google.com/store/apps/details?id=$packageName"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_TEXT, appLink)
        }
        if (shareIntent.resolveActivity(packageManager) != null){
            startActivity(shareIntent)
        }
    }

    /** contact developer **/
    private fun composeEmail() {
        val addresses: Array<String> = arrayOf("ugwulon@gmail.com")
        val subject = "Type your subject here"
        val message = "Compose a message..."

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        }

    }

    /** interface implementation [handlePhoneDial] for handling [NetworkProviderDetailsAdapter.PhoneDialImpl],
     *  [BankDetailsAdapter.PhoneDialImpl] and [NewCodeAdapter.PhoneDialImpl] phone dials
     **/
    override fun handlePhoneDial(code: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${Uri.encode(code)}" )
        }
        if (dialIntent.resolveActivity(packageManager) != null){
            startActivity(dialIntent)
        }
        else Toast.makeText(applicationContext, "an error occurred", Toast.LENGTH_SHORT).show()
    }

    /**
     * interface implementation for disabling [NewCodeFragment.BottomNavigationImpl] and
     * [CheckNetworkFragment.BottomNavigationImpl] bottom navigations
     */
    override fun disableBottomNavigation() {
        bottomNavigationView.visibility = View.GONE
    }

    /**
     * interface implementation for enabling [NewCodeFragment.BottomNavigationImpl] and
     * [CheckNetworkFragment.BottomNavigationImpl] bottom navigations
     */
    override fun enableBottomNavigation() {
        bottomNavigationView.visibility = View.VISIBLE
    }
}