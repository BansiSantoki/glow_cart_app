package com.example.myapplication

class cart {
    var cid2: String? = null
    var unm2: String? = null
    var add2: String? = null
    var phno2: String? = null
    var final_amt2: Int=0

    constructor(usernm2: String?, address2: String?, phoneno2: String?,final_amount2: Int) {
        unm2=usernm2
        add2=address2
        phno2=phoneno2
        final_amt2=final_amount2
    }
    fun getunm2(): String? {
        return unm2
    }
    fun getadd2(): String? {
        return add2
    }
    fun getphno2(): String? {
        return phno2
    }
    fun getfinal_amt2(): Int {
        return final_amt2
    }
}

