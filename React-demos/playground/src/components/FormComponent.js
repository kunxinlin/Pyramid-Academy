import React, {Component} from 'react'

class FormComponent extends Component{
    constructor(){
        super()
        this.state={
            firstName: "",
            lastName: "",
            age: null,
            height: null,
            gender: ""
        }
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event){
        const {name, value, type, checked} = event.target
        type === "checkbox" ? this.setState({[name]: checked}) : this.setState({[name]: value})
    }

    render(){
        return(
            <main>
                <form onSumbit={this.handleSumbit}>
                    <h1>Simple Form</h1>
                    <input type="text" name="firstName" placeholder="First Name" onChange={this.handleChange}/>
                    <input type="text" name="lastName" placeholder="Last Name" onChange={this.handleChange}/>
                    <input type="number" name="age" placeholder="Age" min="1" onChange={this.handleChange}/>
                    <input type="number" name="height" placeholder="Height(cm)" min="1" onChange={this.handleChange}/>
                    <br/>
                    <label>
                        <input type="radio" name="gender" value="male" checked={this.state.gender === "male"} onChange={this.handleChange}/>
                        Male
                    </label>
                    <br/>

                    <br/>
                    <label>
                        <input type="radio" name="gender" value="female" checked={this.state.gender === "female"} onChange={this.handleChange}/>
                        Female
                    </label>
                    <br/>
                    <button>Sumbit</button>
                </form>
                <hr/>
                <h2>Entered Information</h2>
                <p>Your Name: {this.state.firstName} {this.state.lastName}</p>
                <p>Your Gender: {this.state.gender}</p>
                <p>Your Age: {this.state.age}</p>
                <p>Your Height: {this.state.height}</p>
            </main>
        )
    }
}


export default FormComponent