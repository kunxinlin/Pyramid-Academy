import React, { Component } from 'react';
import {withRouter} from 'react-router-dom'
import FlashcardDataService from '../../service/FlashcardDataService';

class StudyCards extends Component {
    constructor(props) {
        super(props)
        this.state={
            card: [],
            answer: ''
        }

        this.getRandomCard = this.getRandomCard.bind(this)
        this.showAnswer = this.showAnswer.bind(this)
    }

    componentDidMount(){
        this.getRandomCard();
    }

    getRandomCard(){
        FlashcardDataService.retrieveRandomCard().then(response => {this.setState({card: response.data})})
        this.setState({answer: ''})
    }

    showAnswer(){
        this.setState({answer: this.state.card.answer})
    }


    render() {
        return(
            <div className="container">
                <br/><br/>
                <button onClick={this.getRandomCard}>Next</button>
                <br/><br/>
                <div className="flash-card">
                    <h1>{this.state.card.question}</h1>
                    <br/><br/><br/>
                    <p>{this.state.answer}</p>
                </div>
                <button onClick={this.showAnswer}>Show Answer</button>
            </div>
        )
    }
}

export default withRouter(StudyCards);