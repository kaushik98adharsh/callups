package com.example.callups.helpers.contactmapper

import com.example.callups.models.Contact
import com.example.rocketreserver.AddContactMutation

fun AddContactMutation.Insert_contacts_DETAILS_one.toContact(): Contact {
    return Contact(firstName = name,phone = phone,id = _id)
}