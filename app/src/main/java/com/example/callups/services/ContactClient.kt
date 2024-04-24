package com.example.callups.services

import com.example.callups.models.Contact

interface ContactClient {
    suspend fun getContacts(): List<Contact>
    suspend fun getContact(phone: String): Contact?
    suspend fun addContact(phone: String, name: String): Contact
}