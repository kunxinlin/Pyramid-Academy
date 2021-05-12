import React from 'react'

function handleClick(){
    console.log("This was clicked")
}

function mouseEnter() {
    console.log("Mouse entered")
  }
  
  function mouseLeave() {
      console.log("Mouse left")
  }

function EventComponent(){
    return(
        <div className="event-component">
            <img onMouseOver={() => console.log("Hovered Over!")} src="/images/Kaneki.jpg" alt="kaneki" style={{width:"60%", height:"auto"}}></img>
            <br/>
            <button onClick={handleClick}>Click Me!</button>
            <br/>
            <img onMouseEnter={mouseEnter} onMouseLeave={mouseLeave} src="/images/avatar.png" alt="blank"></img>
        </div>
    )
}

export default EventComponent