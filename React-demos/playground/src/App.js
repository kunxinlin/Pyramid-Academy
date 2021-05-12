import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import HeaderComponent from './components/HeaderComponent';
import MainComponent from './components/MainComponenet';
import FooterComponent from './components/FooterComponent';
import MyInfo from './components/MyInfo';
import AppComponent from './components/AppComponent';
import ClassComponent from './components/ClassComponent'
import EventComponent from './components/EventComponent';
import IncDecButton from './components/IncDecButton';
import FetchingPokemon from './components/FetchingPokemon';
import FormComponent from './components/FormComponent';


class App extends Component{
  constructor(){
    super()
    this.state={
      name: "Kris",
      age: 24,
      height: 182
    }
  }
  
  render(){
    return (
      <div className="App">
        <HeaderComponent/>
        <FormComponent/>
        <IncDecButton/>
        <FetchingPokemon/>
        <MyInfo/>
        <EventComponent/>
        <ClassComponent/>
        <AppComponent/>
        <FooterComponent/>
      </div>
    )
  }
}



// function App() {
//   return (
//     <div className="App">
//       <HeaderComponent/>
//       <MyInfo/>
//       <ClassComponent/>
//       <AppComponent/>
//       <FooterComponent/>
//     </div>
//   );
// }

export default App;
