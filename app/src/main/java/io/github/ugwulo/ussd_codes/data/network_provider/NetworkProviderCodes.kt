package io.github.ugwulo.ussd_codes.data.network_provider

/**
 * class for retrieving all network provider codes
 */
class NetworkProviderCodes {

    companion object{

        /** MTN Codes */
        fun getMTNCodes(): HashMap<String, String> {
            val mTNCodes = HashMap<String, String>()

            return mTNCodes.apply {
                put("Customer Care", "180")
                put("Self service", "*901#")
                put("9 Payment Service Bank", "*990#")
                put("Merchant Payment", "*901*1*Merchant code*Amount#")
                put("Airtime to Self", "*901*amount#")
                put("Airtime to Others", "*901*Amount*Phone No#")
                put("Bank Transfer", "*901*Amount*Account No#")
                put("Balance Enquiry", "*901*00#")
                put("Pin Reset", "*901*0#")
                put("LCC toll Topup", "*901*000*522+etag number+Amount#")
                put("Deactivate USSD Number", "*901*911#")
                put("Bill Payments", "*901*3#")
                put("POS on USSD", "*901*000*RefCode#")
                put("Diamond Extra", "*901*5#")
                put("Payday Loan", "*901*11#")
                put("Dual Transaction", "*901*14#")
                put("Access Yellow", "*901*10#")
                put("Update Customer Info", "*901*12#")
            }
        }

        /**
         * Glo Codes
         */
        fun getGloCodes(): HashMap<String, String> {
            val gloCodes = HashMap<String, String>()

            return gloCodes.apply {
                put("9 Payment Service Bank", "*990#")
            }
        }

        /**
         * _9Mobile Codes
         */
        fun get9MobileCodes(): HashMap<String, String> {
            val _9MobileCodes = HashMap<String, String>()

            return _9MobileCodes.apply {
                put("9 Payment Service Bank", "*990#")
            }
        }

        /**
         * Airtel Codes
         */
        fun getAirtelCodes(): HashMap<String, String> {
            val airtelCodes = HashMap<String, String>()

            return airtelCodes.apply {
                put("9 Payment Service Bank", "*990#")
            }
        }
    }
}