import React, {Component} from 'react'
import EmployeeDataService from '../../service/EmployeeDataService'

class Employee extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            jobTitle: '',
            firstName: '',
            lastName: '',
            email: ''
        }
        this.handleSubmit = this.handleSubmit.bind(this)
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    handleSubmit() {
        let employee = {
            id: this.state.id,
            jobTitle: this.state.jobTitle,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email
        }
        
        EmployeeDataService.createEmployee(employee)
            .then(this.props.history.push(`/EmployeeRegistry`))
    }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Add Employee</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label>ID:</label>
                            <input className="form-control" type="text" value={this.state.id} disabled></input>
                        </div>
                        <div>
                            <lable>Job Title:</lable>
                            <input className="form-control" type="text" name="jobTitle" onChange={this.handleChange}></input>
                        </div>
                        <div>
                            <lable>First Name:</lable>
                            <input className="form-control" type="text" name="firstName" onChange={this.handleChange}></input>
                        </div>       
                        <div>
                            <lable>Last Name:</lable>
                            <input className="form-control" type="text" name="lastName" onChange={this.handleChange}></input>
                        </div>      
                        <div>
                            <lable>Email:</lable>
                            <input className="form-control" type="text" name="email" onChange={this.handleChange}></input>
                        </div><br/><br/>
                        <button className="btn btn-success" type="submit">Submit</button><br/><br/>
                    </form>
                </div>
            </div>
        )
    }
}

export default Employee