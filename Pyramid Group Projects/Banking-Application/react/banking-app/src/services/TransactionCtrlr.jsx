import axios from 'axios'

class TransactionCtrlr{

    getTransaction(transID){
        return axios.get(`http://localhost:8080/getTransaction/${transID}`)
    }

    getAllTrans(userID){
        return axios.get(`http://localhost:8080/getAllTransaction/${userID}`)
    }

    addTransaction(){
        return axios.post(`http://localhost:8080/addTransaction`)
    }

    deleteTransaction(transID){
        return axios.delete(`http://localhost:8080/deleteTransaction/${transID}`)
    }
}
export default new TransactionCtrlr()