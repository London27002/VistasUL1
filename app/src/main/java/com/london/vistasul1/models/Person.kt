package com.london.vistasul1.models

class Person (name : String, email : String, password: String , url: String) {
    var name: String;
    var email: String
    var password: String
    var url: String

    init {
        this.name = name
        this.email = email
        this.password = password
        this.url = url
    }
}
