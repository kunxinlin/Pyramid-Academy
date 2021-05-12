import React, { Component } from 'react'
import { withRouter } from 'react-router-dom'
import FlashcardDataService from '../../service/FlashcardDataService'
import { FormGroup, FormControl, FormLabel } from 'react-bootstrap'

class AddCard extends Component {
  constructor(props) {
    super(props)
    this.state = {
        answer: '',
        question: '',
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
    let card = {
      question: this.state.question,
      answer: this.state.answer,
    }
    FlashcardDataService.addCard(card).then(this.props.history.push(`/manageCards`))
  }

  validateForm() {
    if(this.state.question.length === 0) this.setState({isValid: true})
    else if(this.state.answer.length === 0) this.setState({isValid: true})
    else this.setState({isValid: false})
  }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Add A New Card</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                      <FormGroup controlId ="question">
                        <FormLabel>Question</FormLabel>
                        <FormControl 
                          autoFocus
                          type="text"
                          value={this.state.question}
                          name="question"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                      <FormGroup controlId ="answer">
                        <FormLabel>Answer</FormLabel>
                        <FormControl 
                          autoFocus
                          type="text"
                          value={this.state.answer}
                          name="answer"
                          onChange={this.handleChange}
                        />
                      </FormGroup>
                        <br/><br/>
                      <button className="btn btn-success" type="submit" disabled={this.state.isValid}>Add</button>&ensp;
                      <button className="btn btn-warning" name="back" onClick={() =>this.props.history.push("/manageCards/")}>Back</button><br/><br/>
                    </form>
                </div>
            </div>
        )
    }
}

export default withRouter(AddCard)