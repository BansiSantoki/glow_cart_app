package com.example.myapplication

class Register {
    var unm: String? = null
    var pwd: String? = null
    var email: String? = null
    var phno: String? = null
    var dt: String? = null
    var seq: String? = null
    var sea: String? = null

    constructor(user_name: String?, password: String?, email_id: String?, phone_number: String?, mydate: String?, seq_que: String?, seq_ans: String?) {
        unm=user_name
        pwd=password
        email=email_id
        phno=phone_number
        dt=mydate
        seq=seq_que
        sea=seq_ans
    }

    fun getunm1(): String? {
        return unm
    }

    fun getpwd1(): String? {
        return pwd
    }

    fun getemail1(): String? {
        return email
    }

    fun getphno1(): String? {
        return phno
    }

    fun getdt1(): String? {
        return dt
    }

    fun getseq1(): String? {
        return seq
    }

    fun getsea1(): String? {
        return sea
    }
}
