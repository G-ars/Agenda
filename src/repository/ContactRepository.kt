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
            //contactlist.remove(contact)

            var index = 0
            for (item in contactlist.withIndex()){
                if(item.value.name == contact.name && item.value.phone == contact.phone){
                    index = item.index
                    break
                }
            }
            contactlist.removeAt(index)
        }

        fun getList(): List<ContactEntity>{
            return contactlist
        }


    }
}