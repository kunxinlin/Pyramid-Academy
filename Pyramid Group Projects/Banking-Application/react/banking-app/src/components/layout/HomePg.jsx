import React from 'react'
import {Link} from 'react-router-dom'

function HomePg(){
    return(
        <div>
            <h1>Banking n Stuff</h1>
            <br></br>
            <h2>Tmp Holder</h2>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/login">Login</Link></button>
            <button className='btn btn-link' style={{color: "black"}} type="button"><Link to="/userHome">User Home Test</Link></button>
        </div>
    )
}
export default HomePg