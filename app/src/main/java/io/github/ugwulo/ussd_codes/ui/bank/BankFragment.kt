package io.github.ugwulo.ussd_codes.ui.bank


import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.BankModel
import io.github.ugwulo.ussd_codes.databinding.FragmentBankBinding

class BankFragment : Fragment()  {
    lateinit var navController: NavController
    lateinit var  bankBinding: FragmentBankBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bankBinding = FragmentBankBinding.inflate(layoutInflater, container, false)
        return bankBinding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?){
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    private fun init() {

        /** create a list of banks with their names and logo **/
        val listData: ArrayList<BankModel> = ArrayList()
        listData.apply {
            add(BankModel(getString(R.string.access_bank), R.mipmap.access_round))
            add(BankModel(getString(R.string.citi_bank), R.mipmap.citi_round))
            add(BankModel(getString(R.string.ecobank), R.mipmap.ecobank_round))
            add(BankModel(getString(R.string.fcmb_bank), R.mipmap.fcmb_round))
            add(BankModel(getString(R.string.fidelity_bank), R.mipmap.fidelity_round))
            add(BankModel(getString(R.string.firstbank), R.mipmap.firstbank_round))
            add(BankModel(getString(R.string.gtbank), R.mipmap.gtbank_round))
            add(BankModel(getString(R.string.heritage_bank), R.mipmap.heritage_round))
            add(BankModel(getString(R.string.keystone_bank), R.mipmap.keystone_round))
            add(BankModel(getString(R.string.polaris_bank), R.mipmap.polaris_round))
            add(BankModel(getString(R.string.stanbic_bank), R.mipmap.stanbic_round))
            add(BankModel(getString(R.string.standard_chartered_bank), R.mipmap.standard_chartered_round))
            add(BankModel(getString(R.string.sterling_bank), R.mipmap.sterling_round))
            add(BankModel(getString(R.string.uba_bank), R.mipmap.uba_round))
            add(BankModel(getString(R.string.union_bank), R.mipmap.union_round))
            add(BankModel(getString(R.string.wema_bank), R.mipmap.wema_round))
            add(BankModel(getString(R.string.zenith_bank), R.mipmap.zenith_round))
        }

        val bankAdapter = BankAdapter(listData)
        val gridLayoutManager = GridLayoutManager(this.activity, 2)
        bankBinding.rvBank.apply {
            adapter = bankAdapter
            layoutManager = gridLayoutManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(bankBinding.toolbar)
    }

}