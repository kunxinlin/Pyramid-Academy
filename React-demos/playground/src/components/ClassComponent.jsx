import React, {Component} from 'react';

class ClassComponent extends Component{
    constructor(){
        super()
        this.state ={
            name: "Kris",
            age: 24,
            height: 182
        }
    }

    render(){
        return(
            <div className = "class-component">
                <h1>{this.state.name}</h1>
                <h2>age: {this.state.age}</h2>
                <h3>height: {this.state.height}cm</h3>
            </div>
        )
    }
}


export default ClassComponent;