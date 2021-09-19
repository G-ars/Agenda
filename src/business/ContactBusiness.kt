package business

import entity.ContactEntity
import repository.ContactRepository

//regra de nogócio

class ContactBusiness {
    private fun validate(name: String, phone: String){
        if(name == ""){
            throw Exception("Nome é obrigatório!")
        }
        if(phone == ""){
            throw Exception("Telefone é obrigatório!")
        }
    }

    private fun validateDelete(name: String, phone: String){
        if(name == "" || phone == ""){
            throw Exception("É necessário selecionar um contato antesd de remover.")
        }

    }

    fun save(name:String, phone:String ){
        validate(name, phone)

        val contact = ContactEntity(name , phone)
        ContactRepository.save(contact)
    }

    fun delete(name:String, phone:String ){
        validate(name, phone)

        val contact = ContactEntity(name , phone)
        ContactRepository.delete(contact)

    }

    fun getList(): List<ContactEntity>{
        return ContactRepository.getList()
    }

}
