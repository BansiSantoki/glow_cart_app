package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DB_NM, null, DB_VERSION) {

    companion object {
        var DB_VERSION: Int = 1
        var DB_NM: String = "NewFoodManager"

        const val T_NM1: String = "register"
        const val K_ID1: String = "id1"
        const val K_UNM1: String = "uname1"
        const val K_PWD1: String = "password1"
        const val K_EMAIL1: String = "email1"
        const val K_PHNO1: String = "phone_number1"
        const val K_DT1: String = "date1"
        const val K_SEQ1: String = "sec_que1"
        const val K_SEA1: String = "sec_ans1"

        const val T_NM2: String = "cart"
        const val K_CID2: String = "cid2"
        const val K_UNM2: String = "uname2"
        const val K_ADD2: String = "address2"
        const val K_PHNO2: String = "phone_number2"
        const val K_FINAL_AMT2: String = "final_amount2"
    }

    override fun onCreate(db: SQLiteDatabase) {

        val CREATE_TABLE1 =
            "CREATE TABLE $T_NM1($K_ID1 INTEGER PRIMARY KEY AUTOINCREMENT,$K_UNM1 TEXT,$K_PWD1 TEXT,$K_EMAIL1 TEXT,$K_PHNO1 TEXT,$K_DT1 TEXT,$K_SEQ1 TEXT,$K_SEA1 TEXT)"
        db.execSQL(CREATE_TABLE1)

        val CREATE_TABLE2 =
            "CREATE TABLE $T_NM2($K_CID2 INTEGER PRIMARY KEY AUTOINCREMENT,$K_UNM2 TEXT,$K_ADD2 TEXT, $K_PHNO2 TEXT,$K_FINAL_AMT2 TEXT)"
        db.execSQL(CREATE_TABLE2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $T_NM1")
            db.execSQL("DROP TABLE IF EXISTS $T_NM2")
            onCreate(db)
        }
    }

    //ADDING NEW REGISTER
    fun addRegister(r1: Register) {
        val db = this.writableDatabase
        val v1 = ContentValues()

        v1.put(K_UNM1, r1.getunm1())
        v1.put(K_PWD1, r1.getpwd1())
        v1.put(K_EMAIL1, r1.getemail1())
        v1.put(K_PHNO1, r1.getphno1())
        v1.put(K_DT1, r1.getdt1())
        v1.put(K_SEQ1, r1.getseq1())
        v1.put(K_SEA1, r1.getsea1())

        db.insert(T_NM1, null, v1)
        db.close()
    }

    //ADD TO CART
    fun addCart(c1: cart) {

        val db = this.writableDatabase
        val v1 = ContentValues()

        v1.put(K_UNM2, c1.getunm2())
        v1.put(K_ADD2, c1.getadd2())
        v1.put(K_PHNO2, c1.getphno2())
        v1.put(K_FINAL_AMT2, c1.getfinal_amt2())

        db.insert(T_NM2, null, v1)
        db.close()
    }

    //SELECTED LOGIN
    fun getSingleEntry(username: String): String? {
        val db = this.writableDatabase
        val cursor = db.query(T_NM1, null, "$K_UNM1=?", arrayOf(username), null, null, null)
        if (cursor.count < 1) {
            cursor.close()
            return "Not Exist"
        }
        cursor.moveToFirst()
        val password: String = cursor.getString(2)
        cursor.close()
        return password
    }

    // Get the security answer for a specific username and question
    fun getSecurityAnswer(username: String, question: String): String {
        val db = this.writableDatabase
        val cursor = db.query(T_NM1, arrayOf(K_SEA1), "$K_UNM1=? AND $K_SEQ1=?", arrayOf(username, question), null, null, null)

        if (cursor.count < 1) {
            cursor.close()
            return "Not Exist"
        }

        cursor.moveToFirst()
        val answer: String = cursor.getString(cursor.getColumnIndex(K_SEA1))
        cursor.close()
        return answer
    }

    // Check if the username exists in the database
    fun isUserExist(username: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.query(T_NM1, arrayOf(K_UNM1), "$K_UNM1=?", arrayOf(username), null, null, null)

        return cursor.count > 0
    }

    // Update password for a specific username
    fun updatePassword(username: String, newPassword: String): Boolean {
        if (!isUserExist(username)) {
            return false
        }
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(K_PWD1, newPassword)
        val result = db.update(T_NM1, contentValues, "$K_UNM1=?", arrayOf(username))
        return result > 0
    }
}
