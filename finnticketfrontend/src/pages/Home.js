import React from 'react'
import Footer from '../components/Footer'
import Carousel from '../modules/home/Carousel'
import HomeCard from '../modules/home/HomeCard'
import NavbarHome from '../components/NavbarHome'


function Home() {
  return (
    <>
      {/*Plantilla para Principal page*/}
      
      <NavbarHome />
      <Carousel />
      <HomeCard />
      <Footer />
    </>
  )
}

export default Home