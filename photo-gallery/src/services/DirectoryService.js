// DirectoryService.js

const createParentDirectory = async (directoryName) => {
    try {
        const response = await fetch('http://localhost:8080/directories', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify([
                {
                    directoryName,
                }
            ]),
        });

        if (response.ok) {
            // Parent directory created successfully
            console.log('Parent directory created successfully:', directoryName);
            return true;
        } else {
            // Handle error
            console.error('Failed to create parent directory:', response.status);
            return false;
        }
    } catch (error) {
        console.error('Error creating parent directory:', error);
        return false;
    }
};

const createSubDirectory = async (parentDirectoryId, directoryName) => {
    try {
        const response = await fetch(`http://localhost:8080/directories/subDirectories/${parentDirectoryId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify([
                {
                    directoryName,
                    parentDirectory: parentDirectoryId,
                }
            ]),
        });

        if (response.ok) {
            // Sub-directory created successfully
            console.log('Sub-directory created successfully:', directoryName);
            return true;
        } else {
            // Handle error
            console.error('Failed to create sub-directory:', response.status);
            return false;
        }
    } catch (error) {
        console.error('Error creating sub-directory:', error);
        return false;
    }
};

export { createParentDirectory, createSubDirectory };
