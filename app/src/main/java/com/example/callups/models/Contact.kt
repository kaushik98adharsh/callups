package com.example.callups.models

import android.net.Uri

class Contact constructor(
    private var firstName: String, // This class is to maintain the contact information
    private var phone: String, id: Int) {

    override fun toString(): String {
        return "$firstName, $phone"
    }
}