import React from 'react';

import { Routes, Route } from 'react-router-dom';
import Sign from "./pages/Sign";
import Home from './pages/Home';
import ShowInfo from './pages/ShowInfo';
import AllEvents from './pages/AllEvents';
import PersonalHistory from './pages/PersonalHistory';
import Mod from './pages/Mod';
import Permits from './pages/Permits';
import Collaborators from './pages/Collaborators';
import AdminEventsHistory from './pages/AdminEventsHistory';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} /> 
        <Route path="signin" element={<Sign />}/>
        <Route path='event' element={<ShowInfo/>}/>
        <Route path='allEvents' element={<AllEvents/>}/>
        <Route path='personalHistory' element={<PersonalHistory/>}/>
        <Route path='mod' element={<Mod/>}/>
        <Route path='permits' element={<Permits/>}/>
        <Route path='collaborators' element={<Collaborators/>}/>
        <Route path='eventsHistory' element={<AdminEventsHistory/>}/>
      </Routes>
    </>
  );
}

export default App;
