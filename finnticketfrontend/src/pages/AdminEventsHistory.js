import React from 'react'
import ShortCutNavBar from '../components/ShortCutNavBar'
import EventHistoryCard from '../modules/EventHistory/EventHistoryCard'

function AdminEventsHistory() {
    return (
        <>
            <ShortCutNavBar />
            <div className='mx-4 lg:mx-20 text-3xl mt-10'>
                <a>Archivo de eventos</a>
            </div>
            <div className='mx-4 border-b-2 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded mb-8' />
            <div className='mx-4 lg:mx-20'>
                <EventHistoryCard />
            </div>
        </>
    )
}

export default AdminEventsHistory