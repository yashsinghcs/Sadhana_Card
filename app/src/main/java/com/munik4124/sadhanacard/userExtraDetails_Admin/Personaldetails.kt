package com.munik4124.sadhanacard.userExtraDetails_Admin

class Personaldetails(val firstName : String, val lastName : String, val bloodgroup : String, val age : Int, val address : String , val phoneNo : String) {
    var first_name : String = firstName
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var last_name : String = lastName
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var blood_group : String = bloodgroup
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var _age : Int = age
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var _address : String = address
    get() {
        return field
    }
    set(value) {
        field = value
    }

    var phone_NO : String = phoneNo
        get() {
            return field
        }
        set(value) {
            field = value
        }
}