import React, { Component } from 'react'
import { withRouter } from 'react-router-dom'
import StudentDataService from '../../service/StudentDataService'
import { FormGroup, FormControl, FormLabel } from 'react-bootstrap'

class AddStudent extends Component {
  constructor(props) {
    super(props)
    this.state = {
        firstname: '',
        lastname: '',
        ssn: null,
        isValid: true
    }
    this.handleSubmit = this.handleSubmit.bind(this)
    this.handleChange = this.handleChange.bind(this)
    this.validateForm = this.validateForm.bind(this)
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    })
    this.validateForm()
  }

  handleSubmit() {
    let student = {
      firstName: this.state.firstname,
      lastName: this.state.lastname,
      ssn: this.state.ssn
    }
    StudentDataService.addStudent(student).then(this.props.history.push(`/addStudent`))
  }

  validateForm() {
    if(this.state.firstname.length === 0) this.setState({isValid: true})
    else if(this.state.lastname.length === 0) this.setState({isValid: true})
    else this.setState({isValid: false})
  }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Add A New Student</h3>
                </div>
                <div className="container containerForm">
                    <form onSubmit={this.handleSubmit}>
                      <FormGroup controlId ="firstname">
                        <FormLabel>First Name</FormLabel>
                        <FormControl 
                          autoFocus
                          type="text"
                          value={this.state.firstname}
                          name="firstname"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                      <FormGroup controlId ="lastname">
                        <FormLabel>Last Name</FormLabel>
                        <FormControl 
                          autoFocus
                          type="text"
                          value={this.state.lastname}
                          name="lastname"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                      <FormGroup controlId ="ssn">
                        <FormLabel>SSN</FormLabel>
                        <FormControl 
                          autoFocus
                          type="text"
                          value={this.state.ssn}
                          name="ssn"
                          maxLength="7"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                        <br/><br/>
                      <button className="btn btn-success" type="submit" disabled={this.state.isValid}>Add</button>&ensp;
                      <button className="btn btn-warning" name="back" onClick={() =>this.props.history.push("/")}>Back</button><br/><br/>
                    </form>
                </div>
            </div>
        )
    }
}

export default withRouter(AddStudent)