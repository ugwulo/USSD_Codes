package io.github.ugwulo.ussd_codes.ui.bank

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.BankCodes
import io.github.ugwulo.ussd_codes.databinding.FragmentBankDetailsBinding
import java.lang.IllegalArgumentException


class BankDetailsFragment : Fragment() {

    private var bankDetailsAdapter: BankDetailsAdapter? = null
    private lateinit var bankName: String
    private lateinit var bankDetailsBinding: FragmentBankDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bankDetailsBinding = FragmentBankDetailsBinding.inflate(layoutInflater,
            container,
            false)
        return bankDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveBankCodes()
        init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        loadArguments()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(bankDetailsBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        bankDetailsBinding.appbarTitle.text = bankName
    }
    /** get arguments from bundle to show a specific bank's codes **/
    private fun loadArguments() {
        arguments?.getString("BANK_NAME")?.let {
            bankName = it
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.detail_menu, menu)
        val searchItem = menu.findItem(R.id.search)

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem!!.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.isIconifiedByDefault = false
        searchView.requestFocus()
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        val linearLayoutManager = LinearLayoutManager(this.activity)
        bankDetailsBinding.rvBankDetails.apply {
           try {
               adapter = bankDetailsAdapter!!
           } catch (e: IllegalArgumentException){
               Toast.makeText(requireContext(), "No USSD for this Bank", Toast.LENGTH_SHORT).show()
           }
            layoutManager = linearLayoutManager
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.save -> {
                saveNewBankCode()
                true
            }
            R.id.search -> {
                searchBankCode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun searchBankCode() {
        Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show()
    }

    private fun saveNewBankCode() {
        Toast.makeText(requireContext(), "Save", Toast.LENGTH_SHORT).show()
    }

    /** bundle $bankName determines the parameter passed to the BankDetailsAdapter */
    private fun retrieveBankCodes() {
        when(bankName){
            getString(R.string.access_bank) -> {
                bankDetailsAdapter = BankDetailsAdapter(requireContext(),
                    BankCodes.getAccessBankCodes())
            }
            getString(R.string.gtbank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getGTBankCodes()
                )
            }
            getString(R.string.heritage_bank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getHeritageBankCodes()
                )
            }
            getString(R.string.fidelity_bank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getFidelityBankCodes()
                )
            }
            getString(R.string.firstbank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getFirstBankCodes()
                )
            }
            getString(R.string.ecobank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getEcoBankCodes()
                )
            }
            getString(R.string.fcmb_bank) -> {
                bankDetailsAdapter = BankDetailsAdapter(
                    requireContext(),
                    BankCodes.getFCMBankCodes()
                )
            }
        }

    }
}