import React from 'react'

function Joke(props) {
    return(
        <div>
            <p>Question: {props.joke.question}</p>
            <p>Punchline: {props.joke.punchline}</p>
        </div>
    )
}

export default Joke