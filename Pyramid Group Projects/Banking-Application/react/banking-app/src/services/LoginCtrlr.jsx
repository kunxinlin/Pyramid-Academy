import axios from 'axios'

class LoginCtrlr{
    getAllLogins(){
        return axios.get(`http://localhost:8080/getAllLogins`)
    }

    getUserLogin(userID){
        return axios.get(`http://localhost:8080/getUserLogin/${userID}`)
    }

    getPassword(email){
        return axios.get(`http://localhost:8080/getPassword/${email}`)
    }

    addUserLogin(){
        return axios.post(`http://localhost:8080/addUserLogin`)
    }

    updateUserLogin(){
        return axios.put(`http://localhost:8080/updateUserLogin`)
    }

    deleteUserLogin(userID){
        return axios.delete(`http://localhost:8080/deleteUserLogin/${userID}`)
    }
}

export default new LoginCtrlr()