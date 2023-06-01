import './App.css';
import { useState, useEffect } from "react";


function App() {

  const [course, setCourse] = useState(null)

  useEffect(() => {
    fetch("http://localhost:8080/courses")
    .then(res => res.json())
    .then(data => setCourse(data))
  }, [])



  

  
  return (
    <div className="App">
     
    </div>
  );
}

export default App;
