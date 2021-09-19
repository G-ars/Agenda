package repository

import entity.ContactEntity

class ContactRepository {

    //companion é responsalvel em manter os dados que estão dentro de seu escopo ao invocar uma nova instancia.
    companion object{

        // lista que tem como função salvar os dados passados
        private  val contactlist = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity){
            contactlist.add(contact)
        }

        fun delete(contact: ContactEntity){

        }

        fun getList(): List<ContactEntity>{
            return contactlist
        }


    }
}