import axios from 'axios'

class EmployeeDataService {

  retrieveAllEmployees() {
    return axios.get(`http://localhost:8080/retrieveAllEmployees`)
  }

  retrievePasswordByEmail(email) {
    return axios.get(`http://localhost:8080/password/${email}`)
  }

  retrieveAdminByEmail(email) {
    return axios.get(`http://localhost:8080/admin/${email}`)
  }

  retrieveEmployeeByEmail(email) {
    return axios.get(`http://localhost:8080/employee/${email}`)
  }

  addEmployee(employee) {
    return axios.post(`http://localhost:8080/addEmployee`, employee)
  }

  updateEmployee(employee) {
    return axios.put(`http://localhost:8080/updateEmployee`, employee)
  }

  deleteEmployee(id) {
    return axios.delete(`http://localhost:8080/deleteEmployee/${id}`)
  }
}

export default new EmployeeDataService()
