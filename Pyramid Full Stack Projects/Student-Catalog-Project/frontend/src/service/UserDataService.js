import axios from "axios";

class UserDataService{
    retrieveAllUser(){
        return axios.get(`http://localhost:8080/getAllUsers`)
    }

    retrieveUserById(id){
        return axios.get(`http://localhost:8080/getUser/${id}`)
    }
    
    retrievePassword(email){
        return axios.get(`http://localhost:8080/getPassword/${email}`)
    }

    retrieveIsProfessor(email){
        return axios.get(`http://localhost:8080/professor/${email}`)
    }
    
    addUser(user){
        return axios.post(`http://localhost:8080/addUser/`, user)
    }
   
    updateUser(user){
        return axios.put(`http://localhost:8080/updateUser/`, user)
    }

    deleteUser(id){
        return axios.delete(`http://localhost:8080/deleteUser/${id}`)
    }
}

export default new UserDataService();