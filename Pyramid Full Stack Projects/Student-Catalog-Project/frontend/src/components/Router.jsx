import React, {Component} from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Registration from './Registration';
import Navbar from './Navbar';
import Login from './Login';
import MainPage from './MainPage';
import AddStudent from './student/AddStudent';
import ProfessorPage from './ProfessorPage';

class Router extends Component {
    render() {
        return(
            <div>
                <BrowserRouter>
                    <Navbar/>
                        <Switch>
                            <Route exact path="/" component={Login}></Route>
                            <Route path="/register" component={Registration}></Route>
                            <Route path="/mainpage" component={MainPage}></Route>
                            <Route path="/addStudent" component={AddStudent}></Route>
                            <Route path="/professorpage" component={ProfessorPage}></Route>
                        </Switch>
                </BrowserRouter>
            </div>
        )
    }
}

export default Router;