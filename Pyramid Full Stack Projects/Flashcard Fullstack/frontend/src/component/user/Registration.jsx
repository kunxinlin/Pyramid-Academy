import React, { Component } from 'react'
import { withRouter } from 'react-router-dom'
import UserDataService from '../../service/UserDataService'
import { FormGroup, FormControl, FormLabel } from 'react-bootstrap'

class Registration extends Component {
  constructor(props) {
    super(props)
    this.state = {
      email: '',
      password: '',
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
    let user = {
      id: -1,
      email: this.state.email,
      password: this.state.password,
    }
    UserDataService.addUser(user).then(this.props.history.push(`/`))
  }

  validateForm() {
    if(this.state.email.length === 0) this.setState({isValid: true})
    else if(this.state.password.length === 0) this.setState({isValid: true})
    else this.setState({isValid: false})
  }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Register</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                      <FormGroup controlId ="email">
                        <FormLabel>Email</FormLabel>
                        <FormControl 
                          autoFocus
                          type="email"
                          value={this.state.email}
                          name="email"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                      <FormGroup controlId ="password">
                        <FormLabel>Password</FormLabel>
                        <FormControl 
                          autoFocus
                          type="password"
                          value={this.state.password}
                          name="password"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                        <br/><br/>
                      <button className="btn btn-success" type="submit" disabled={this.state.isValid}>Submit</button>&ensp;
                      <button className="btn btn-warning" name="back" onClick={() =>this.props.history.push("/")}>Back</button><br/><br/>
                    </form>
                </div>
            </div>
        )
    }
}

export default withRouter(Registration)
