import { React } from 'react';

function Loading() {
    return (
        <div className="ui segment" style={{ height: '90%' }}>
            <div className="ui active dimmer">
                <div className="ui text loader">Loading</div>
            </div>
        </div>
    );
}

export default Loading;
