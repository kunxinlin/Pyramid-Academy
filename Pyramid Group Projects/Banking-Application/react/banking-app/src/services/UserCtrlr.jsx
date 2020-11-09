import axios from 'axios'

class UserCtrlr{
    getAllUsers(){
        return axios.get(`http://localhost:8080/getAllUsers`)
    }

    addUser(){
        return axios.post(`http://localhost:8080/addUser`)
    }

    updateUser(){
        return axios.put(`http://localhost:8080/updateUser`)
    }

    deleteUser(userID){
        return axios.delete(`http://localhost:8080/deleteUser/${userID}`)
    }

}

export default new UserCtrlr()