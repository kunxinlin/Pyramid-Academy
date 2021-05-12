import axios from "axios";

class FlashcardDataService{
    retrieveAllCards(){
        return axios.get(`http://localhost:8080/getAllCards/`)
    }

    retrieveRandomCard(){
        return axios.get(`http://localhost:8080/getRandomCard/`)
    }
    
    addCard(card){
        return axios.post(`http://localhost:8080/addCard/`, card)
    }
   
    updateCard(card){
        return axios.put(`http://localhost:8080/updateCard/`, card)
    }

    deleteCard(id){
        return axios.delete(`http://localhost:8080/deleteCard/${id}`)
    }
}

export default new FlashcardDataService();