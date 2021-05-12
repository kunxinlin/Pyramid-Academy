import React, {Component} from 'react';

class IncDecButton extends Component{
    constructor(){
        super()
        this.state={
            count: 0
        }
        this.incCount = this.incCount.bind(this)
        this.decCount = this.decCount.bind(this)
    }

    incCount(){
        console.log("clicked!")
        this.setState(prevState =>{
            return{
                count: prevState.count + 1
            }
        })
    }
    
    decCount(){
        console.log("clicked!")
        this.setState(prevState =>{
            return{
                count: prevState.count - 1
            }
        })
    }

    render(){
        return(
            <div className="inc-dec-button">
                <h1>{this.state.count}</h1>
                <button onClick={this.decCount}>Decrement</button>
                <button onClick={this.incCount}>Increment</button>
            </div>
        )
    }
}

export default IncDecButton