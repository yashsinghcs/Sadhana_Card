package com.munik4124.sadhanacard

public class AdminUser(val uniqueId : String, val user_name : String, val password : String, val emailId : String)
{
     var unique_Id : String = uniqueId
     get() {
         return field
     }
    set(value) {
        field = value
    }

    var userName : String = user_name
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var _password : String = password
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var email_Id : String = emailId
        get() {
            return field
        }
        set(value) {
            field = value
        }
}