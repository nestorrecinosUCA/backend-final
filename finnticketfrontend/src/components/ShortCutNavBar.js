import React from 'react'
import iconlogo from '../assets/img/iconlogo.png';
import nezukoicon from '../assets/img/nezukoicon.png'

function ShortCutNavBar() {
    return (
        <>
            <div class="navbar bg-base-100 flex items-center justify-between">
                <div class="navbar-start">
                    <img class="w-20 sm:w-28 h-auto" src={iconlogo} alt='icon logo'></img>
                </div>
                <div class="navbar-end">
                    <img src={nezukoicon} class="rounded-full h-10 sm:h-14 w-10 sm:w-14 object-cover" alt='user_icon'></img>
                </div>
            </div>
        </>
    )
}

export default ShortCutNavBar