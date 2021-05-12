import React, { Component } from 'react';
import {withRouter} from 'react-router-dom'

class Welcome extends Component {
    constructor(props) {
        super(props)
        this.state={
        }
    }
    render() {
        return(
            <div className="container">
                <br></br><br></br>
                <div className="jumbotron" style={{textAlign:"center", backgroundColor:"Grey"}}>
                    <h1 style={{color:"White"}}>Welcome to the Flashcard Study App</h1>
                    <br></br>
                </div>
                <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
                <button className="btn btn-warning" onClick={() =>this.props.history.push("/")}>Logout</button>
            </div>
        )
    }
}

export default withRouter(Welcome);