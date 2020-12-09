package io.github.ugwulo.ussd_codes.ui.saved_codes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.databinding.FragmentSavedCodesBinding


class SavedCodesFragment() : Fragment() {

    private lateinit var mContext:  Context
    private var savedCodesAdapter: SavedCodesAdapter? = null
    private lateinit var savedCodesBinding: FragmentSavedCodesBinding
    private lateinit var bottomNavigationImpl: BottomNavigationImpl

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        bottomNavigationImpl = requireActivity() as BottomNavigationImpl
    }

    override fun onDetach() {
        super.onDetach()
        bottomNavigationImpl.enableBottomNavigation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(savedCodesBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        savedCodesBinding.appbarTitle.text = getString(R.string.save_new_code)
        bottomNavigationImpl.disableBottomNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        savedCodesBinding = FragmentSavedCodesBinding.inflate(layoutInflater,
            container,
        false)
        return savedCodesBinding.root
    }

    private fun init() {
        savedCodesAdapter = SavedCodesAdapter(requireContext(), mutableListOf())
        val linearLayoutManager = LinearLayoutManager(this.activity)
        savedCodesBinding.rvSavedCodes.apply {
            adapter = savedCodesAdapter!!
            layoutManager = linearLayoutManager
        }
    }

    interface BottomNavigationImpl{
        fun disableBottomNavigation()
        fun enableBottomNavigation()
    }
}