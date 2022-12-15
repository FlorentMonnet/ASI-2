import React from 'react';
import { useNavigate } from 'react-router-dom';

function Loose() {
    const navigate = useNavigate();

    return (
        <div
            className="ui middle aligned center aligned grid"
            style={{ height: '100%' }}
        >
            <div
                className="column"
                style={{ maxWidth: '450px', marginTop: '6em' }}
            >
                <h1 className="ui red header">You loose !</h1>
                <button
                    className="ui secondary basic button"
                    onClick={() => navigate('/')}
                >
                    Home
                </button>
            </div>
        </div>
    );
}

export default Loose;
