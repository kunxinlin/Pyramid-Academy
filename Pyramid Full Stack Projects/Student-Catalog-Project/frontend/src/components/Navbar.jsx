import React, {Component} from 'react'
import {Link} from 'react-router-dom'

class Navbar extends Component {
    render(){
        return(
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <ul className="navbar-nav">
                        <li><Link className="nav-link">  </Link></li>
                    </ul>
                </nav>
            </header>
        )
    }
}

export default Navbar;