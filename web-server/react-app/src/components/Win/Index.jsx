import React from 'react';
import { useNavigate } from 'react-router-dom';

function Win() {
    const navigate = useNavigate();

    return (
        <>
            {' '}
            <div
                className="ui middle aligned center aligned grid"
                style={{ height: '100%' }}
            >
                <div
                    className="column"
                    style={{ maxWidth: '450px', marginTop: '6em' }}
                ></div>
            </div>
        </>
    );
}

export default Win;
