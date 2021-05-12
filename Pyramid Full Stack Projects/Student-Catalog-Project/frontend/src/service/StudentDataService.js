import axios from "axios";

class StudentDataService{
    retrieveAllStudents(){
        return axios.get(`http://localhost:8080/getAllStudents/`)
    }

    addStudent(student){
        return axios.post(`http://localhost:8080/addStudent/`, student)
    }
   
    updateStudent(student){
        return axios.put(`http://localhost:8080/updateStudent/`, student)
    }

    deleteStudent(id){
        return axios.delete(`http://localhost:8080/deleteStudent/${id}`)
    }
}

export default new StudentDataService();