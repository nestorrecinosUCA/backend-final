import React from 'react'

function PermitsTable() {
    return (
        <>
            <div className="overflow-x-auto">
                <table className="table w-full">
                    {/* head*/}
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th>Administrador</th>
                            <th>Moderador</th>
                            <th>Analista</th>
                            <th>Cliente</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* row 1 */}
                        <tr>
                            <th>1</th>
                            <td>Cy Ganderton</td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                        {/* row 2 */}
                        <tr className="active">
                            <th>2</th>
                            <td>Hart Hagerty</td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                        {/* row 3 */}
                        <tr>
                            <th>3</th>
                            <td>Brice Swyre</td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                            <td><input type="checkbox" class="toggle" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default PermitsTable