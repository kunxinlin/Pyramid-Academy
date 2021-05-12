import React, { Component } from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import Login from './Login';
import Welcome from './Welcome';
import Registration from '../user/Registration';
import Header from './Header';
import ManageCards from '../flashcard/ManageCards';
import StudyCards from '../flashcard/StudyCards';
import UpdateCard from '../flashcard/UpdateCard';
import AddCard from '../flashcard/AddCard';



class Router extends Component {
  render() {
    return(
      <div>
        <BrowserRouter>
          <Header/>
            <Switch>
              <Route exact path="/" component={Login}></Route>
              <Route path="/welcome" component={Welcome}></Route>
              <Route path="/register" component={Registration}></Route>
              <Route path="/manageCards" component={ManageCards}></Route>
              <Route path="/studyCards" component={StudyCards}></Route>
              <Route path="/updateCard/:id/" component={UpdateCard}></Route>
              <Route path="/addCard" component={AddCard}></Route>
            </Switch>
        </BrowserRouter>
      </div>
    )
  }
}

export default Router;
