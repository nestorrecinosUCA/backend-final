import React, { useState, useEffect } from 'react';

function PInfoCard() {

    const [isHovered, setIsHovered] = useState(false);
    const [showAlert, setShowAlert] = useState(false);

    useEffect(() => {
        let timeoutId;

        if (isHovered) {
            timeoutId = setTimeout(() => {
                setShowAlert(true);
            }, 200); // Tiempo de aparición de la alerta (en milisegundos)
        } else {
            timeoutId = setTimeout(() => {
                setShowAlert(false);
            }, 200); // Tiempo de desaparición de la alerta (en milisegundos)
        }

        return () => clearTimeout(timeoutId);
    }, [isHovered]);

    const handleMouseEnter = () => {
        setIsHovered(true);
    };

    const handleMouseLeave = () => {
        setIsHovered(false);
    };

    const [showModal, setShowModal] = React.useState(false);
    return (
        <div className="relative">
            <div
                className="bg-card-grey w-full sm:w-full rounded-lg p-4 lg:p-6 shadow shadow-gray-400 transform hover:bg-gray-900 duration-200"
                onMouseEnter={handleMouseEnter}
                onMouseLeave={handleMouseLeave}
                onClick={() => setShowModal(true)}
            >
                <p className='font-bold pb-2 text-center'>LITTLE BIG BOY</p>
                <p>Precio:</p>
                <p>cantidad:2</p>
                <p>Total:$60</p>
                {showAlert && (
                    <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-red-500 text-white p-2 rounded text-sm transition-opacity duration-500 ease-in-out opacity-75 hover:cursor-pointer">
                        <p>Generar codigo QR</p>
                    </div>
                )}
            </div>

            {showModal ? (
                <>
                    <div className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none">
                        <div className="relative w-auto my-6 mx-auto max-w-3xl">
                            {/*content*/}
                            <div className="justify-center items-center  border-4 rounded-lg shadow-lg relative flex flex-col w-96 bg-white outline-none focus:outline-none border-black">
                                {/*body*/}
                                <div className="relative p-2 flex-auto">
                                    <img src="https://inlab.fib.upc.edu/sites/default/files/field/image/api.qrserver.com__0.png" />
                                </div>

                                <div className="flex items-center justify-center">
                                    <button
                                        className="text-red-500 background-transparent font-bold uppercase text-sm mb-8 ease-linear transition-all duration-150"
                                        type="button"
                                        onClick={() => setShowModal(false)}
                                    >
                                        Close
                                    </button>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
                </>
            ) : null}
        </div>




    );
};

export default PInfoCard