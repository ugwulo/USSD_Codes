package io.github.ugwulo.ussd_codes

import SettingsManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import io.github.ugwulo.ussd_codes.databinding.ActivityMainBinding
import io.github.ugwulo.ussd_codes.ui.bank.BankDetailsAdapter
import io.github.ugwulo.ussd_codes.ui.network.NetworkProviderDetailsAdapter

@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
class MainActivity : AppCompatActivity(), BankDetailsAdapter.ClickHandler, NetworkProviderDetailsAdapter.ClickHandler {
    companion object{
        lateinit var mainBinding: ActivityMainBinding
    }

    /**
     * {@param toolbar} sets custom {@link Toolbar}
     *
     * */
    var toolbar: Toolbar? = null

    private lateinit var settingsManager: SettingsManager
    private var isDarkMode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initializeViews()

        settingsManager = SettingsManager(applicationContext)
//        observeUiPreferences()

    }

//    private fun observeUiPreferences() {
//        settingsManager.uiModeFlow.asLiveData().observe(this) { uiMode ->
//            when (uiMode) {
//                UiMode.LIGHT -> onLightMode()
//                UiMode.DARK -> onDarkMode()
//            }
//        }
//    }

    private fun initializeViews() {
        supportActionBar?.hide()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.main_nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_network_provider, R.id.navigation_bank))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        mainBinding.darkModeIcon.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
//        })
//        imageButton.setOnClickListener {
//            lifecycleScope.launch {
//                when (isDarkMode) {
//                    true -> settingsManager.setUiMode(UiMode.LIGHT)
//                    false -> settingsManager.setUiMode(UiMode.DARK)
//                }
//            }
//        }
    }

//    private fun onLightMode() {
//        isDarkMode = false
//
//        rootView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
//        imageButton.setImageResource(R.drawable.ic_moon)
//
//        // Actually turn on Light mode using AppCompatDelegate.setDefaultNightMode() here
//    }

//    private fun onDarkMode() {
//        isDarkMode = true
//
//        rootView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.black))
//        imageButton.setImageResource(R.drawable.ic_sun)
//
//        // Actually turn on Dark mode using AppCompatDelegate.setDefaultNightMode() here
//    }


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

    /** interface to handle phone dial for Network Providers **/
    override fun handleNetworkProviderPhoneDial(code: String) {
        val networkDialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${Uri.encode(code)}" )
        }
        if (networkDialIntent.resolveActivity(packageManager) != null){
            startActivity(networkDialIntent)
        }
        else Toast.makeText(applicationContext, "an error occurred", Toast.LENGTH_SHORT).show()
    }

    /** interface to handle phone dial for Banks **/
    override fun handleBankPhoneDial(code: String) {
        val bankDialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${Uri.encode(code)}" )
        }
        if (bankDialIntent.resolveActivity(packageManager) != null){
            startActivity(bankDialIntent)
        }
        else Toast.makeText(applicationContext, "an error occurred", Toast.LENGTH_SHORT).show()
    }
}