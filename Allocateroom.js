import React, { useState } from 'react';
import axios from 'axios';
import { CSVLink } from 'react-csv';

const AllocateRooms = () => {
    const [allocations, setAllocations] = useState([]);

    const handleAllocate = () => {
        axios.get('/api/allocate')
            .then(response => {
                setAllocations(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <div>
            <h2>Allocate Rooms</h2>
            <button onClick={handleAllocate}>Allocate Rooms</button>
            {allocations.length > 0 && (
                <CSVLink data={allocations} filename="allocations.csv">
                    Download Allocations
                </CSVLink>
            )}
        </div>
    );
};

export default AllocateRooms;
