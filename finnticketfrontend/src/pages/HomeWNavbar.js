import React from 'react'
import Footer from '../components/Footer'
import Carousel from '../modules/home/Carousel'
import HomeCard2 from '../modules/home/HomeCard2'
import Navbar from '../components/Navbar'


function HomeWNavbar() {
  return (
    <>
      {/*Plantilla para Principal page*/}
      
      <Navbar />
      <Carousel />
      <HomeCard2 />
      <Footer />
    </>
  )
}

export default HomeWNavbar