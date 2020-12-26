package io.github.ugwulo.ussd_codes.ui.check_network

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.ugwulo.ussd_codes.R

/**
 * [CheckNetworkFragment] class for verifying network provider prefixes
 */
class CheckNetworkFragment : Fragment() {
    // TODO: implement the necessary features

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_network, container, false)
    }

}