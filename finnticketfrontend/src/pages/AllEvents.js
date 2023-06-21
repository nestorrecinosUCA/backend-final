import React from 'react'
import EventCard from '../modules/EventContainer/EventCard' 
import EventCardSO from '../modules/EventContainer/EventCardSO'
import EventCardPanic from '../modules/EventContainer/EventCardPanic'
import Navbar from '../components/Navbar'

function AllEvents() {
  return (
    <>
      <Navbar />
      <div className='mx-4 lg:mx-20 text-4xl mt-10'>
        <a>Eventos</a>
      </div>
      <div className='mx-4 border-b-2 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded'></div>
      <div className='mx-4 lg:mx-20'>
        <div class="navbar">
          <div class="flex-1">
            
          </div>
          <div class="flex-none">
            <ul class="menu menu-horizontal px-1 lg:mr-12">
              <li><a>Todos</a></li>
              <li><a>Sold Out</a></li>
              <li tabindex="0">
                <a>
                  Categoria
                  <svg class="fill-current" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><path d="M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z" /></svg>
                </a>
                <ul class="p-2 bg-card-grey">
                  <li><a>Musica</a></li>
                  <li><a>Teatro</a></li>
                  <li><a>Danza</a></li>
                  <li><a>Literatura</a></li>
                  <li><a>Debate</a></li>
                  <li><a>Forums</a></li>
                  <li><a>Stand Up Comedy</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div className='mx-4 lg:mx-20 border-t'>
        <EventCard/>
        <EventCardSO/>
        <EventCardPanic/>
      </div>
    </>
  )
}

export default AllEvents