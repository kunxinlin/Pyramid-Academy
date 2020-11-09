import React, {Component} from 'react'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Header from './Header'
import Footer from './Footer'
import HomePg from './HomePg'
import UserHome from "../users/UserHome";
import ShowTransactions from "../users/ShowTransactions";

//<Route path="/" component={} />

class RouterComponent extends Component{
    render() {
        return(
            <div>
                <Router>
                    <Header/>
                    <Switch>
                        <Route exact path="/"><HomePg/></Route>
                        <Route path="/userHome" component={UserHome} />
                        <Route path ="/showTransactions" component={ShowTransactions} />
                    </Switch>
                    <Footer/>
                </Router>
            </div>
        )
    }
}
export default RouterComponent