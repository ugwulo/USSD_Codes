package io.github.ugwulo.ussd_codes.data

class NetworkProviderCodes {

    companion object{
        /** MTN Codes */
        fun getMTNCodes(): HashMap<String, String> {
            val mTNCodes = HashMap<String, String>()

            return mTNCodes.apply {
                put("Customer Care", "180")
            }
        }
    }
}