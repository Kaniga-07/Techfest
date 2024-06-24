import React, { useState } from 'react';
import axios from 'axios';

const FileUpload = () => {
    const [groupFile, setGroupFile] = useState(null);
    const [hostelFile, setHostelFile] = useState(null);

    const handleFileChange = (e, setFile) => {
        setFile(e.target.files[0]);
    };

    const uploadFile = (file, endpoint) => {
        const formData = new FormData();
        formData.append('file', file);

        axios.post(`/api/${endpoint}`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        })
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleSubmit = () => {
        if (groupFile) uploadFile(groupFile, 'uploadGroups');
        if (hostelFile) uploadFile(hostelFile, 'uploadHostels');
    };

    return (
        <div>
            <h2>Upload Files</h2>
            <input type="file" onChange={(e) => handleFileChange(e, setGroupFile)} />
            <input type="file" onChange={(e) => handleFileChange(e, setHostelFile)} />
            <button onClick={handleSubmit}>Upload</button>
        </div>
    );
};

export default FileUpload;
