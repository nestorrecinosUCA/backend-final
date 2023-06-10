import React, { useState } from 'react';
import { BsChevronCompactLeft, BsChevronCompactRight } from 'react-icons/bs';
import { Outlet, Link } from 'react-router-dom'
import { RxDotFilled } from 'react-icons/rx';

function Carousel() {

    const slides = [
        {
            url: 'https://i.pinimg.com/originals/24/b3/2e/24b32e53341202e5f52bf1609468fd05.jpg',
        },
        {
            url: 'https://i.pinimg.com/originals/05/0f/0a/050f0a3bd19ce811522f0c63256637e9.jpg',
        },
        {
            url: 'https://pbs.twimg.com/media/Em6NX7KWEAMJEka.jpg:large',
        },

        {
            url: 'https://t4.ftcdn.net/jpg/04/46/93/93/360_F_446939375_83iP0UYTg5F9vHl6icZwgrEBHXeXMVaU.jpg',
        }
    ];

    const [currentIndex, setCurrentIndex] = useState(0);

    const prevSlide = () => {
        const isFirstSlide = currentIndex === 0;
        const newIndex = isFirstSlide ? slides.length - 1 : currentIndex - 1;
        setCurrentIndex(newIndex);
    };

    const nextSlide = () => {
        const isLastSlide = currentIndex === slides.length - 1;
        const newIndex = isLastSlide ? 0 : currentIndex + 1;
        setCurrentIndex(newIndex);
    };

    const goToSlide = (slideIndex) => {
        setCurrentIndex(slideIndex);
    };

    return (
        <>
            <div class=" flex items-center z-10">
                <div className='w-full h-96 lg:w-3/4 lg:h-96 lg:py-16 m-auto py-20 px-4 relative group'>
                    <div
                        style={{ backgroundImage: `url(${slides[currentIndex].url})` }}
                        className='w-full h-full rounded-2xl bg-center bg-cover duration-500'
                    ></div>
                    {/* Left Arrow */}
                    <div className='hidden group-hover:block absolute top-[50%] -translate-x-0 translate-y-[-50%] left-5 text-2xl rounded-full p-2 bg-black/20 text-white cursor-pointer'>
                        <BsChevronCompactLeft onClick={prevSlide} size={30} />
                    </div>
                    {/* Right Arrow */}
                    <div className='hidden group-hover:block absolute top-[50%] -translate-x-0 translate-y-[-50%] right-5 text-2xl rounded-full p-2 bg-black/20 text-white cursor-pointer'>
                        <BsChevronCompactRight onClick={nextSlide} size={30} />
                    </div>
                    <div className='flex top-4 justify-center py-2'>
                        {slides.map((slide, slideIndex) => (
                            <div
                                key={slideIndex}
                                onClick={() => goToSlide(slideIndex)}
                                className='text-2xl cursor-pointer'
                            >
                                <RxDotFilled />
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </>
    );
};

export default Carousel