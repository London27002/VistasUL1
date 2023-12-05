package com.london.vistasul1.models

class Parameters {

    companion object{
        @JvmStatic
         var persons: ArrayList<Person> = ArrayList<Person>()
        fun setPersonsList(personElement: Person){
            persons.add(personElement)
        }
        @JvmStatic fun getPersonsList(): ArrayList<Person>{
            return persons
        }

        @JvmStatic
        var cars: ArrayList<Car> = ArrayList<Car>()
        fun setCarsList(carsElement:Car){
            cars.add(carsElement)
        }
        @JvmStatic fun getCarsList(): ArrayList<Car>{
            return  cars
        }

        @JvmStatic
        var pokers: ArrayList<Poker> = ArrayList<Poker>()
        fun setPokerList(pokersElement: Poker){
            pokers.add(pokersElement)
        }
        @JvmStatic fun getPokerList(): ArrayList<Poker>{
            return pokers
        }

    }
}