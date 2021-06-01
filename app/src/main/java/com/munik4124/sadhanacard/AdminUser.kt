package com.munik4124.sadhanacard

public class AdminUser(val uniqueId : String, val user_name : String, val password : String, val full_name : String)
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

    var fullName : String = full_name
        get() {
            return field
        }
        set(value) {
            field = value
        }
}