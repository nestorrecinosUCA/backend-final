import React from 'react'
import Navbar from '../components/Navbar'
import PurchasedTickerCard from '../modules/PurchasedTicket/PurchasedTickerCard'

function PurchasedTicket() {
  return (
    <>
        <Navbar />
        <div className='mx-4 lg:mx-20 text-3xl mt-6 z-10'>
                <a>Tickets Comprados</a>
            </div>  
            <div className='mx-4 border-b-2 lg:mx-20 lg:border-b-4 md:border-b-4 2xl:border-b-4 rounded m-4'/>
            <div className='mx-4 lg:mx-20'>
                <PurchasedTickerCard />
                <PurchasedTickerCard />
            </div>
    </>
  )
}

export default PurchasedTicket