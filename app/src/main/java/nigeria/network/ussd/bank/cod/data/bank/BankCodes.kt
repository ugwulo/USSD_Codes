package nigeria.network.ussd.bank.cod.data.bank

/**
 * class for retrieving all bank codes
 */
class BankCodes {

    companion object{

        /** Access Bank Codes **/
        fun getAccessBankCodes(): HashMap<String, String> {
            var accessBank: HashMap<String, String> = HashMap()

             accessBank.apply {
                put("Self service", "*901#")
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

            return accessBank
        }

        fun getCitiBankCodes(): HashMap<String, String>{
            var citiBank: HashMap<String, String> = HashMap()

            return citiBank.apply {
                put("No USSD code for this bank yet", "000")

            }
        }

        fun getGTBankCodes(): HashMap<String, String> {
            var gTBank: HashMap<String, String> = HashMap()

            return gTBank.apply {
                put("Self service","*737")
                put("Account Opening", "*737*0#")
                put("Airtime (Self)", "*737*Amount#")
                put("Airtime to others", "*737*Amount*PhoneNo#")
                put("Transfers (GTBank)", "*737*1*Amount*Account No#")
                put("Transfers (Other Banks)", "*737*2*Amount*Account No#")
                put("Cardless Withdrawal", "*737*3*Amount#")
                put("Fast Track Deposit", "*737*48*Amount*Account No#")
                put("Data Purchase", "*737*4#")
                put("Check Acc Balance, Acc No or BVN", "*737*6*1#")
                put("Loan Balance", "*737*6*2#")
                put("Card Status", "*737*6*3#")
                put("Cheque Book Status", "*737*6*4#")
                put("Generate OTP", "*737*7#")
                put("Airtime Advance", "*737*8*1#")
                put("Give", "*737*32*Amount*Church Code#")
                put("Edu", "*737*31*Amount*School Code#")
                put("Checkout", "*737*35*Amount*Merchant Code#")
                put("Total Cashout", "*737*50*Amount*50#")
                put("StarTimes Subscription", "*737*37*Amount*SmartcardNo#")
                put("Swift Network Subscription", "*737*50*Amount*4#")
                put("Salary Advance", "*737*8*2#")
            }
        }

        fun getHeritageBankCodes(): HashMap<String, String>{
            var heritageBank: HashMap<String, String> = HashMap()

            return heritageBank.apply {
                put("Self service", "*322#")
                put("Register Number", "*322*030#")
                put("Airtime for Self", "*322*030*Amount#")
                put("Airtime for Others", "*322*030**Phone No*Amount#")
                put("Transfer Money", "*322*030**Account No*Amount#")
                put("GoTV", "*322*030*1088*AMOUNT#")
                put("DSTV", "*322*030*1099*AMOUNT#")
            }
        }

        fun getFidelityBankCodes(): HashMap<String, String>{
            var fidelityBank: HashMap<String, String> = HashMap()

            return fidelityBank.apply {
                put("Self service", "*770#")
                put("Account balance", "*770*0#")
                put("Transfer Money", "*770*Account Number*Amount#")
                put("Airtime for Others", "*770*Phone Number*Amount#")
                put("Airtime for Self", "*770*Amount#")
                put("Cardless Withdrawal", "*770*8*Amount#")
                put("Change USSD Pin", "*770*00#")
                put("DStv", "*770*1099*SmartCard No*Amount#")
                put("GOtv", "*770*1088*Decoder No*Amount#")
                put("StarTimes", "*770*1077*SmartCard No*Amount#")
                put("Swift 4G", "*770*1033*Customer ID*Amount#")
                put("EEDC Prepaid", "*770*1021*Meter No*Amount#")
                put("EEDC Postpaid", "*770*1022*Customer Acc No*Amount#")
                put("IBEDC Bills", "*770*1044*Customer Acc No*Amount#")
                put("KEDCO Postpaid", "*770*1014*Acc No*Amount#")
                put("KEDCO Prepaid", "*770*1013*Meter No*Amount#")
                put("PHED", "*770*1017*Customer Acc No*Amount#")
                put("BEDC Postpaid", "*770*1015*Customer Acc No*Amount#")
                put("EKEDP Postpaid", "*770*1012*Customer Acc No*Amount#")
                put("EKEDP Prepaid", "*770*1011*Meter No*Amount#")
                put("LCC Toll Payment", "*770*1066*LCC Acc No*Amount#")
                put("NairaBet", "*770*1055*Customer RefCode*Amount#")
                put("Lagos Toll Company", "*770*1068*LTC Acc No*Amount#")
                put("Pay Airtel Bills", "*770*1122*Phone No*Amount#")
            }
        }

        fun getFirstBankCodes(): HashMap<String, String>{
            var firstBank: HashMap<String, String> = HashMap()

            return firstBank.apply {
                put("Self service", "*894#")
                put("Register", "*894*0#")
                put("Transfer Money", "*894*Amount*Account Number#")
                put("Statement of Account", "*894*Account Number#")
                put("Recharge for Self*", "*894*Amount#")
                put("Recharge for Others", "*894*Amount*Phone Number#")
                put("Account Opening", "*894*0#")
                put("Check balance", "*894*00#")
                put("Deactivate USSD", "*894*911#")
            }
        }

        fun getEcoBankCodes(): HashMap<String, String>{
            var ecoBank: HashMap<String, String> = HashMap()

            return ecoBank.apply {
                put("Self service", "*326#")
                put("Airtime for Self", "*326*Amount#")
                put("Airtime for Self/Others", "*326*1*Amount#")
                put("Check Acc Balance", "*326*0#")

            }
        }

        fun getFCMBankCodes(): HashMap<String, String>{
            var fCMBank: HashMap<String, String> = HashMap()

            return fCMBank.apply {
                put("Register", "*329*")
                put("Airtime for Self", "*329*Amount#")
                put("Airtime for Others", "*329*Amount*Phone Number#")
                put("Buy data", "*329*1*Phone Number#")
                put("Transfer money", "*329*Amount*Account No#")
                put("Pay DStv/Gotv", "*329*2*Amount*Smartcard Number#")
                put("Check Balance", "*329*00#")
                put("Buy Data", "*329*1*Phone Number#")
            }
        }

        fun getKeystoneBankCodes(): HashMap<String, String>{
            var keyStoneBank: HashMap<String, String> = HashMap()

            return keyStoneBank.apply {
                put("Register Number", "*7111*0#")
                put("Self service", "*7111#")
                put("Airtime to self", "*7111*Amount#")
                put("Airtime to others", "*7111*Amount*Phone Num#")
                put("Transfer Money", "*7111*Amount*Account Num#")
                put("Buy Data", "*7111*5#")
                put("Check Account Number", "*7111*1#")
                put("Pay Bills", "*7111*2#")
                put("Check Account Number/Balance", "*7111*1#")

            }
        }

        fun getPolarisBankCodes(): HashMap<String, String>{
            var polarisBank: HashMap<String, String> = HashMap()

            return polarisBank.apply {
                put("Self Service/Register", "*833#")
                put("Airtime for Self", "*833*Amount#")
                put("Airtime for Others", "*833*Amount*Phone Num#")
                put("Transfer Money", "*833*Amount*Account Num#")
                put("Check Account Balance", "*833*6#")
                put("Open Account", "*833*1#")
                put("Pay Bills", "*833*2#")
                put("Transfer Funds", "*833*3#")
                put("Pay with Master Pass", "*833*7#")
                put("Hotlist Card", "*833*4#")
            }
        }

        fun getStanbicBankCodes(): HashMap<String, String>{
            var stanbicBank: HashMap<String, String> = HashMap()

            return stanbicBank.apply {
                put("Self Service", "*909#")
                put("Reset Pin", "*909*11*1#")
                put("Register Number", "*909*1*7#")
                put("Transfer to Other Banks", "*909*22*Amount*Account Num#")
                put("Transfer to Stanbic Account", "*909*11*Amount*Account Num#")
                put("Airtime for Others", "*909*Amount*Phone Num#")
                put("Airtime for Self", "*909*Amount#")
                put("Check Account Balance", "*909*1*1#")
            }
        }

        fun getSterlingBankCodes(): HashMap<String, String>{
            var sterlingBank: HashMap<String, String> = HashMap()

            return sterlingBank.apply {
                put("Self Service", "*822#")
                put("Reset Pin", "*822*9#")
                put("Transfer to Other Banks", "*822*5*Amount*Account Num#")
                put("Transfer to Sterling Account", "*822*4*Amount*Account Num#")
                put("Airtime for Others", "*822*Amount*Phone Num#")
                put("Airtime for Self", "*822*Amount#")
                put("Check Account Balance", "*822*6#")
                put("Check Account Number", "*822*8#")
                put("Open Account", "*822*7#")
            }
        }

        fun getStandardCharteredBankCodes(): HashMap<String, String>{
            var standardCharteredBank: HashMap<String, String> = HashMap()

            return standardCharteredBank.apply {
                put("Self Service", "*977#")
            }
        }

        fun getUBABankCodes(): HashMap<String, String>{
            var uBA: HashMap<String, String> = HashMap()

            return uBA.apply {
                put("Self Service", "*919#")
                put("Transfer to Other Banks", "*919*4*Account Num*Amount#")
                put("Transfer to UBA Account", "*919*3*Account Num*Amount#")
                put("Airtime for Others", "*919*Phone Num*Amount#")
                put("Airtime for Self", "*919*Amount#")
                put("Check Account Balance", "*919*0#")
                put("Pay Bills", "*919*5#")
                put("ATM Cardless Withdrawal", "*919*30*Amount#")
                put("Update BVN", "*919*6#")
            }
        }

        fun getUnionBankCodes(): HashMap<String, String>{
            var unionBank: HashMap<String, String> = HashMap()

            return unionBank.apply {
                put("Self Service", "*826#")
                put("Transfer to Other Banks", "*826*2*Amount*Account Num#")
                put("Transfer to Union Account", "*826*1*Amount*Account Num#")
                put("Airtime for Others", "*826*Amount*Phone Num#")
                put("Airtime for Self", "*826*Amount#")
                put("Check Account Balance", "*826*4#")
                put("Pay Merchants", "*826*22*Merchant Code*Amount#")
                put("ATM Cardless Withdrawal", "*826*7*Amount#")
                put("Locate a Branch/Agent", "*826*19#")
                put("Request a Debit Card", "*826*21#")
                put("Request a Loan", "*826*41#")
            }
        }

        fun getWemaBankCodes(): HashMap<String, String>{
            var wemaBank: HashMap<String, String> = HashMap()

            return wemaBank.apply {
                put("Self Service", "*945#")
                put("Account Registration", "*945*911#")
                put("Open Account", "*945*1#")
                put("Bank Transfer (All Banks)", "*945*Account Num*Amount#")
                put("Airtime for Others", "*945*Phone Num*Amount#")
                put("Airtime for Self", "*945*Amount#")
                put("Airtime/Data", "*945*2#")
                put("Check Account Balance", "*945*0#")
                put("Check Account Number", "*945*000#")
                put("ATM Cardless Withdrawal", "*945*8*Amount#")
                put("Link BVN", "*945*4*BVN#")
                put("Change Account", "*945*2*Old Acc*New Acc#")
                put("Mcash", "*945*22*Merchant Code*Amount#")
                put("Coral Pay", "*945*000*Reference No#")
                put("Deactivate Account", "*945*911#")
            }
        }

        fun getZenithBankCodes(): HashMap<String, String>{
            var zenithBank: HashMap<String, String> = HashMap()

            return zenithBank.apply {
                put("Self Service", "*966#")
                put("Open Account", "*966*0#")
                put("Bank Transfer (All Banks)", "*966*Amount*Account Num#")
                put("Buy Airtime", "*966*Amount*Phone Num#")
                put("Check Account Balance", "*966*00#")
                put("ATM Cardless Withdrawal", "*966*60#")
                put("Update BVN", "*966*BVN#")
                put("Reset USSD PIN", "*966*60#")
                put("DSTV and PHCN", "*966*7*Amount*Customer ID#")
                put("Pay Bills", "*966*6*Biller Code#")
                put("Deactivate Mobile Bank Profile", "*966*20*0#")
                put("Deactivate Account", "*966*911#")
                put("Activate Agent Banking", "*966*66#")
            }
        }
    }
}