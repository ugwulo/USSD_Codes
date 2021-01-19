package nigeria.network.ussd.cod.data.network_provider

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
                put("Airtime balance", "*556#")
                put("Airtime bonus balance", "*123*1*3#")
                put("Data balance", "*131*4#")
                put("Data balance 2", "*559#")
                put("Recharge airtime", "*555*pin#")
                put("Buy data plan", "*131#")
                put("Buy data from bank", "*904#")
                put("Buy data from bank", "*904*amount#")
                put("Borrow airtime", "*606#")
                put("Check your number", "*123*1*1#")
                put("Transfer airtime (Share N Sell)", "*600*num*amt*pin#")
                put("Change transfer pin", "*600*old pin*new pin*new pin#")
                put("Cancel data auto renewal", "*123*5#")
                put("Please call me back", "*133*1*num#")
                put("Change Tariff plan", "*123*1*2#")
                put("Please send me credit", "*133*2*num#")
                put("Buy caller tunez", "*410#")
                put("MTN Pulse night plan (11:pm-6:am)", "*406#")
                put("1 day plan #100 100MB", "*131*104#")
                put("1 day plan #200 200MB", "*131*113#")
                put("7 days plan #300 350MB + 350MB YouTube night", "*131*102#")
                put("7 days plan #500 750MB + 750MB YouTube night", "*131*103#")
                put("30 days plan #1,000 1.5GB", "*131*106#")
                put("30 days plan #1,200 2GB", "*131*130#")
                put("30 days plan #2,000 4.5GB", "*131*110#")
                put("30 days plan #3,500 10GB", "*131*107#")
                put("30 days plan #5,000 15GB", "*131*116#")
                put("30 days plan #10,000 40GB", "*131*117#")
                put("60 days plan #20,000 75GB", "*131*118#")
                put("90 days plan #50,000 150GB", "*131*133#")
                put("International bundles", "*131*5#")
                put("Check international bundle balance", "*559*7#")
                put("Migrate to Beta Talk plan", "*123*2*1#")
                put("Migrate to MTN pulse", "*123*2*2#")
                put("Migrate to MTN Extra Special", "*123*2*3#")
                put("Migrate to MTN Extra Value", "*123*2*4#")
                put("Migrate to MTN Tru Talk", "*123*20#")
                put("Cancel all MTN services", "*447#")

                // bank codes
                put("Access/Diamond bank", "*901#")
                put("Eco Bank", "*326#")
                put("FCMB bank", "*329#")
                put("Fidelity bank", "*770#")
                put("First bank", "*894#")
                put("Stanbic bank", "*909#")
                put("UBA", "*919#")
                put("Union bank", "*826#")
                put("Wema bank", "*945#")
                put("Zenith bank", "*966#")
                put("Zenith bank", "*966#")
                put("Sterling bank", "*822#")
                put("Polaris bank", "*833#")
                put("Keystone bank", "*7111#")
                put("Unity bank", "*7799#")
                put("Jaiz bank", "*389*301#")
                put("Gtbank", "*737#")
            }
        }

        /**
         * Glo Codes
         */
        fun getGloCodes(): HashMap<String, String> {
            val gloCodes = HashMap<String, String>()

            return gloCodes.apply {
                put("Check airtime balance", "*124#")
                put("Check data balance", "*127*0#")
                put("Recharge airtime", "*123*pin#")
                put("Check number", "*135*8#")
                put("Customer care", "121")
                put("Borrow airtime", "*321#")
                put("Please call me back", "*125*num#")
                put("Share data", "*127*01#")
                put("Transfer airtime (Easy share)", "*131*num*amt*pin#")
                put("Change transfer pin", "*132*old pin*new pin*new pin#")
                put("Buy data plan", "*777#")
                put("1 day plan #25 10MB", "*127*32#")
                put("1 day plan #50 22MB", "*127*14#")
                put("1 day plan #100 80MB + 100MB bonus", "*127*51#")
                put("5 days plan #200 210MB + 262MB bonus", "*127*56#")
                put("14 days plan #500 800MB + 1GB bonus", "*127*57#")
                put("30 days plan #1,000 3.6GB", "*127*53#")
                put("30 days plan #2,000 4.5GB", "*127*55#")
                put("30 days plan #2,500 7.2GB", "*127*58#")
                put("30 days plan #3,000 8.75GB", "*127*54#")
                put("30 days plan #4,000 12.5GB", "*127*59#")
                put("30 days plan #5,000 15.5GB", "*127*2#")
                put("30 days plan #8,000 20GB", "*127*1#")
                put("30 days plan #10,000 32.5GB", "*127*11#")
                put("30 days plan #15,000 52.5GB", "*127*12#")
                put("30 days plan #18,000 62.5GB", "*127*13#")
                put("30 days plan #20,000 78.78GB", "*127*33#")
                put("TGIF Weekend plan #500 3GB", "*127*61#")
                put("Night plan #200 1GB", "*127*60#")

                // bank codes
                put("Access/Diamond bank", "*901#")
                put("Eco Bank", "*326#")
                put("FCMB bank", "*329#")
                put("Fidelity bank", "*770#")
                put("First bank", "*894#")
                put("Stanbic bank", "*909#")
                put("UBA", "*919#")
                put("Union bank", "*826#")
                put("Wema bank", "*945#")
                put("Zenith bank", "*966#")
                put("Zenith bank", "*966#")
                put("Sterling bank", "*822#")
                put("Polaris bank", "*833#")
                put("Keystone bank", "*7111#")
                put("Unity bank", "*7799#")
                put("Jaiz bank", "*389*301#")
                put("Gtbank", "*737#")
            }
        }

        /**
         * _9Mobile Codes
         */
        fun get9MobileCodes(): HashMap<String, String> {
            val _9MobileCodes = HashMap<String, String>()

            return _9MobileCodes.apply {
                // data plans
                put("Buy data plan", "*917#")
                put("9 Payment Service Bank", "*990#")
                put("Data  balance", "*228#")
                put("1 day plan #50 25MB", "*229*3*8#")
                put("1 day plan #100 100MB", "*229*3*1#")
                put("1 day plan #200 650MB", "*229*3*2#")
                put("1 day plan #300 1GB", "*229*3*3#")
                put("3 days plan #500 2GB", "*229*3*4#")
                put("1 night plan #200 1GB", "*229*3*11#")
                put("30 nights plan #1000 2GB", "*229*3*12#")
                put("30 nights plan #2000 5GB", "*229*3*13#")
                put("7 days plan #1500 7GB", "*229*2*2#")
                put("7 days plan #200 250MB", "*229*2*10#")
                put("7 days plan #500 1GB", "*229*2*1#")
                put("30 days plan #500 500MB", "*229*2*12#")
                put("30 days plan #1,200 2GB", "*229*2*25#")
                put("30 days plan #1,500 3GB", "*229*2*3#")
                put("30 days plan #2,000 4.5GB", "*229*2*8#")
                put("30 days plan #4,000 11GB", "*229*2*36#")
                put("30 days plan #5,000 15GB", "*229*2*37#")
                put("30 days plan #10,000 40GB", "*229*4*1#")
                put("30 days plan #15,000 75GB", "*229*2*4#")

                // bank codes
                put("Access/Diamond bank", "*901#")
                put("Eco Bank", "*326#")
                put("FCMB bank", "*329#")
                put("Fidelity bank", "*770#")
                put("First bank", "*894#")
                put("Stanbic bank", "*909#")
                put("UBA", "*919#")
                put("Union bank", "*826#")
                put("Wema bank", "*945#")
                put("Zenith bank", "*966#")
                put("Zenith bank", "*966#")
                put("Sterling bank", "*822#")
                put("Polaris bank", "*833#")
                put("Keystone bank", "*7111#")
                put("Unity bank", "*7799#")
                put("Jaiz bank", "*389*301#")
                put("Gtbank", "*737#")

                // misc
                put("Check airtime balance", "*232#")
                put("Self service", "*200#")
                put("Customer care", "200")
                put("Check your number", "*248#")
                put("Recharge airtime", "*222*pin#")
                put("Borrow airtime", "*665#")
                put("Borrow data", "*665*2#")
                put("Disable data auto renewal", "*229*0#")
                put("Transfer data", "*229*pin*volume of mb*recipient's num#")
                put("Share data with family and friends", "*229*9*pin*data quota*recipient's num*3#")
                put("Data gift", "*229*data plan code*recipient's num#")
                put("Use your data on another 9mobile sim", "*215*pin*1*new num*new PUK#")
                put("9mobile prepaid", "*244*2#")
                put("You and me", "*233*1*9mobile num#")
                put("List of you and me numbers", "*233#")
                put("Receiver pays call", "dial 268 + person's num")
                put("Please call me back", "*266*4*recipient's num#")
            }
        }

        /**
         * Airtel Codes
         */
        fun getAirtelCodes(): HashMap<String, String> {
            val airtelCodes = HashMap<String, String>()

            return airtelCodes.apply {
                put("Check airtime balance", "*123#")
                put("Check data balance", "*140#")
                put("Check data balance 2", "*141*712*0#")
                put("Check your number", "*121*3*4#")
                put("Customer care", "111")
                put("Self service", "*121#")
                put("Recharge airtime", "*126*pin#")
                put("Get 6X data on recharge", "*555*pin#")
                put("Borrow airtime", "*500#")
                put("Please call me back", "*140*number#")
                put("Activate caller tunes", "*791#")
                put("Buy data plan", "*141#")
                put("Smart Trybe night plan (12:am-5:am)", "*312#")
                put("1 day plan #50 40MB", "*141*50#")
                put("1 day plan #100 100MB", "*141*100#")
                put("3 days plan #200 200MB", "*141*200#")
                put("7 days plan #300 350MB", "*141*300#")
                put("30 days plan #1,500 3GB", "*141*1500#")
                put("30 days plan #1,000 1.5GB", "*141*1000#")
                put("30 days plan #2,000 4.5GB", "*141*2000#")
                put("30 days plan #2,500 6GB", "*141*2500#")
                put("30 days plan #3,000 8GB", "*141*3000#")
                put("30 days plan #4,000 11GB", "*141*4000#")
                put("30 days plan #5,000 15GB", "*141*5000#")
                put("30 days plan #10,000 40GB", "*141*10000#")
                put("30 days plan #10,000 40GB", "*141*10000#")
                put("30 days plan #15,000 75GB", "*141*15000#")
                put("30 days plan #20,000 120GB", "*141*20000#")
                put("1 day WhatsApp #25 20MB", "*948*4#")
                put("1 day All Social plan #50 40MB", "*991*4#")
                put("5 days All Social plan #100 200MB", "*688*3#")
                put("25 days All Social plan #300 700MB", "*688*1#")
                put("Migrate to Smart Trybe (data)", "*312#")
                put("Migrate to Smart Talk (call 11k/sec)", "*315#")
                put("Migrate to Smart Premier (unlimited voice)", "*470#")
                put("Migrate to TalkMore (5X recharge)", "*234#")

                // bank codes
                put("Access/Diamond bank", "*901#")
                put("Eco Bank", "*326#")
                put("FCMB bank", "*329#")
                put("Fidelity bank", "*770#")
                put("First bank", "*894#")
                put("Stanbic bank", "*909#")
                put("UBA", "*919#")
                put("Union bank", "*826#")
                put("Wema bank", "*945#")
                put("Zenith bank", "*966#")
                put("Zenith bank", "*966#")
                put("Sterling bank", "*822#")
                put("Polaris bank", "*833#")
                put("Keystone bank", "*7111#")
                put("Unity bank", "*7799#")
                put("Jaiz bank", "*389*301#")
                put("Gtbank", "*737#")
            }
        }
    }
}