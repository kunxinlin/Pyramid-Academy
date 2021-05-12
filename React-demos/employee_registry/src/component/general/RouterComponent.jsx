import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import FooterComponent from '../header_footer/FooterComponent'
import WelcomeComponent from './WelcomeComponent'
import HeaderComponent from '../header_footer/HeaderComponent'
import ListEmployeeComponent from '../employee/ListEmployeeComponent'
import EmployeeComponent from '../employee/UpdateEmployee'
import Employee from '../employee/AddEmployee'

class RouterComponent extends Component {
   render() {
       return(
           <div>
            <Router>
                <HeaderComponent />
                    <Switch>
                        <Route exact path="/"><WelcomeComponent name="Everett"/></Route> />                       
                        <Route path="/theEmployee/:id" component={Employee} />
                        <Route path="/employee/:id/:jobTitle" component={EmployeeComponent} />
                        <Route path="/EmployeeRegistry" exact component={ListEmployeeComponent} />                                              
                    </Switch>
                <FooterComponent /> 
            </ Router>
            </div>
       )
   } 
}

export default RouterComponent; 