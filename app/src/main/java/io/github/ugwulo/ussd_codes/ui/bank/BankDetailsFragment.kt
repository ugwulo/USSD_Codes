package io.github.ugwulo.ussd_codes.ui.bank

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.BankCodes
import io.github.ugwulo.ussd_codes.databinding.FragmentBankDetailsBinding
import java.lang.IllegalArgumentException
import java.lang.NullPointerException


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
        init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadArguments()
    }

    /** get arguments from bundle to show a specific bank's codes **/
    private fun loadArguments() {
        arguments?.getString("BANK_NAME")?.let {
            bankName = it
        }
    }

    private fun init() {

        /** bundle $bankName determines the parameter passed to the BankDetailsAdapter **/
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
}