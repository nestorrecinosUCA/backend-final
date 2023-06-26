import React from 'react'

function CollabTable() {
    return (
        <>
            <div className="overflow-x-auto">
                <table className="table w-full">
                    {/* head*/}
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th></th>
                            <th>Activo</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* row 1 */}
                        <tr>
                            <th>1</th>
                            <td>Cy Ganderton</td>
                            <td></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                        {/* row 2 */}
                        <tr className="active">
                            <th>2</th>
                            <td>Hart Hagerty</td>
                            <td></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                        {/* row 3 */}
                        <tr>
                            <th>3</th>
                            <td>Brice Swyre</td>
                            <td></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default CollabTable