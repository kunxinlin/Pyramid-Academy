import React from 'react'
import Joke from './Joke'

function AppComponent(){
    return(
        <div className="jokes">
            <Joke
                joke={{question: "why 1", punchline: "asd"}}
            />
            <Joke
                joke={{question: "why 2", punchline: "zxc"}}
            />
            <Joke
                joke={{question: "why 3", punchline: "qwe"}}
            />
            <Joke
                joke={{question: "why 4", punchline: "fgh"}}
            />
            <Joke
                joke={{question: "why 5", punchline: "jkl"}}
            />
        </div>
    )
}

export default AppComponent