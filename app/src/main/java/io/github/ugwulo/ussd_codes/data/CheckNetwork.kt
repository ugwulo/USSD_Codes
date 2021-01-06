package io.github.ugwulo.ussd_codes.data

class CheckNetwork {

    companion object{

        /** Network Prefixes */
        fun getNetworkPrefixes(): HashMap<String, String> {
            val prefix = HashMap<String, String>()

            return prefix.apply {
                // mtn
                put("0803", "MTN Nigeria")
                put("0806", "MTN Nigeria")
                put("0706", "MTN Nigeria")
                put("0810", "MTN Nigeria")
                put("0703", "MTN Nigeria")
                put("0813", "MTN Nigeria")
                put("0816", "MTN Nigeria")
                put("0814", "MTN Nigeria")
                put("0906", "MTN Nigeria")

                // glo
                put("0805", "Glo Nigeria")
                put("0807", "Glo Nigeria")
                put("0705", "Glo Nigeria")
                put("0815", "Glo Nigeria")
                put("0811", "Glo Nigeria")
                put("0905", "Glo Nigeria")

                // airtel
                put("0802", "Airtel Nigeria")
                put("0808", "Airtel Nigeria")
                put("0708", "Airtel Nigeria")
                put("0812", "Airtel Nigeria")
                put("0701", "Airtel Nigeria")
                put("0902", "Airtel Nigeria")

                // 9 mobile
                put("0809", "9Mobile")
                put("0818", "9Mobile")
                put("0817", "9Mobile")
                put("0909", "9Mobile")

                // smile
                put("0702", "Smile")

                // ntel
                put("0804", "NTEL")
            }
        }

        /**
         * prefix for spinner array adapter population
         */
        fun getAdapterArray(): ArrayList<String> {

            val prefixArray: ArrayList<String> = ArrayList()
            return prefixArray.apply {
                // mtn
                add("0803")
                add("0806")
                add("0706")
                add("0810")
                add("0703")
                add("0813")
                add("0816")
                add("0814")
                add("0906")

                // glo
                add("0805")
                add("0807")
                add("0705")
                add("0815")
                add("0811")
                add("0905")

                // airtel
                add("0802")
                add("0808")
                add("0708")
                add("0812")
                add("0701")
                add("0902")

                // 9mobile
                add("0809")
                add("0818")
                add("0817")
                add("0909")

                // smile
                add("0702")

                // ntel
                add("0804")
            }
        }
    }
}