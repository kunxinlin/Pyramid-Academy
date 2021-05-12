import React, { Component } from 'react';
import {withRouter} from 'react-router-dom'
import FlashcardDataService from '../../service/FlashcardDataService';

class ManageCards extends Component {
    constructor(props) {
        super(props)
        this.state={
            cards: []
        }

        this.refreshCardsList = this.refreshCardsList.bind(this)
        this.deleteCardClicked = this.deleteCardClicked.bind(this)
        this.updateCardClicked =  this.updateCardClicked.bind(this)
        this.addCardClicked = this.addCardClicked.bind(this)
    }

    componentDidMount(){
        this.refreshCardsList();
    }

    refreshCardsList(){
        FlashcardDataService.retrieveAllCards().then(response => {this.setState({cards: response.data})})
    }

    deleteCardClicked(id){
        FlashcardDataService.deleteCard(id).then(response => {
            this.setState({message: `Deleted Card: ${id}`})
            alert(this.state.message)
            this.refreshCardsList()
        })
    }

    updateCardClicked(id){
        this.props.history.push(`/updateCard/${id}/`)
    }

    addCardClicked(){
        this.props.history.push(`/addCard`)
    }

    render() {
        return(
            <div className="container">
               <br></br> <h1 style={{textAlign:"center"}}>Flashcards</h1><br></br>
                <div className="jumbotron" style={{backgroundColor: "grey", color: "white"}}>
                    <table className="table">
                        <thead>
                            <tr style={{textAlign: "center", color: "black"}}>
                                <th>id</th>
                                <th>Question</th>
                                <th>Answer</th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.cards.map(card =>
                                <tr style={{textAlign: "center"}} key={card.id}>
                                    <td>{card.id}</td>
                                    <td>{card.question}</td>
                                    <td>{card.answer}</td>
                                    <td><button className="btn btn-success" onClick={() => this.updateCardClicked(card.id, card.question, card.answer)}>Update</button></td>
                                    <td><button className="btn btn-warning" onClick={() => this.deleteCardClicked(card.id)}>Delete</button></td>
                                </tr>
                            )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <br/>
                        <button className="btn btn-success" onClick={this.addCardClicked}>Add New Card</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default withRouter(ManageCards);