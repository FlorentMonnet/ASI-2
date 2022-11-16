import React from 'react';
import HomeButton from '../HomeButton';

function Home() {
    const buttons = [
        {
            id: 1,
            links: '/buy',
            icon: 'shopping cart',
            label: 'Buy',
            classElem: 'top-line-btn-first',
        },
        {
            id: 2,
            links: '/sell',
            icon: 'money',
            label: 'Sell',
            classElem: 'top-line-btn-last',
        },
        {
            id: 3,
            links: '/selectCard',
            icon: 'gamepad',
            label: 'Play',
            classElem: 'bottom-line-btn',
        },
    ];

    return (
        <div className="ui three column grid" style={{ marginTop: '10em' }}>
            {buttons.map((button) => (
                <HomeButton
                    key={button.id}
                    link={button.links}
                    icon={button.icon}
                    label={button.label}
                    classElem={button.classElem}
                />
            ))}
        </div>
    );
}

export default Home;
