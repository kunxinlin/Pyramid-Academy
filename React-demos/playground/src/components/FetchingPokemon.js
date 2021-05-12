import React, {Component} from 'react';

class FetchingPokemon extends Component{
    constructor(){
        super()
        this.state ={
            loading: true,
            character: {}
        }
    }

    componentDidMount() {
        fetch("https://pokeapi.co/api/v2/pokemon/rayquaza")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    loading: false,
                    character: data
                })
                console.log(data)
            })
    }

    render(){
        const text = this.state.loading ? "Loading...." : this.state.character.name
        const text2 = this.state.loading ? "Loading...." : this.state.character.id
        return(
            <div className = "FetchingPokemon">
                <h1>{text}</h1>
                <h2>id: {text2}</h2>
            </div>
        )
    }
}

export default FetchingPokemon