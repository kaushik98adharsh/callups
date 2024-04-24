package com.example.callups.services

import com.apollographql.apollo3.ApolloClient
import com.example.callups.helpers.contactmapper.toContact
import com.example.callups.models.Contact
import com.example.rocketreserver.AddContactMutation

class Network(private val apolloClient: ApolloClient): ContactClient {
    override suspend fun getContacts(): List<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun getContact(phone: String): Contact? {
        TODO("Not yet implemented")
    }

    override suspend fun addContact(phone: String, name: String): Contact {
        return apolloClient.mutation(AddContactMutation(name,phone)).execute()
            .data?.insert_contacts_DETAILS_one?.toContact()?:Contact(firstName = "nullNull",phone="null",id= -1)
    }
}