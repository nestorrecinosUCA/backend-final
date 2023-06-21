import React from 'react'
import HistoryTickerCard from '../modules/PersonalHistory/HistoryTickerCard'
import Navbar from '../components/Navbar'

function PersonalHistory() {
    return (
        <>
            <Navbar />
            <div className='mx-4 lg:mx-20 text-3xl mt-10 z-10'>
                <a>Historial de eventos asistidos</a>
            </div>  
            <div className='mx-4 border-b-4 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded mb-8'/>
            <div className='mx-4 lg:mx-20'>
                <HistoryTickerCard />
                <HistoryTickerCard/>
            </div>
        </>
    )
}

export default PersonalHistory