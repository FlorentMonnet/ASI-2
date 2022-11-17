import './App.css';
import 'semantic-ui-css/semantic.min.css';

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import Home from './components/Home';
import Header from './components/Header';
import Error from './components/Error';
import CardList from './components/CardList';
import Register from './components/Register';
import Login from './components/Login';
import Chat from './components/Chat/Chat';

import Config from './config';
import GameZone from './components/GameZone';
import SelectCardForGame from './components/SelectCardForGame';

function App() {
    return (
        <Router>
            <Routes>
                <Route
                    exact
                    path="/"
                    element={
                        <>
                            <Header
                                iconHeader={''}
                                title={'Home'}
                                subTitle={''}
                            />{' '}
                            <Home />
                        </>
                    }
                />
                <Route
                    exact
                    path="/buy"
                    element={
                        <>
                            <Header
                                iconHeader={Config.HEADER_CONFIG.buy.iconHeader}
                                title={Config.HEADER_CONFIG.buy.title}
                                subTitle={Config.HEADER_CONFIG.buy.subTitle}
                            />{' '}
                            <CardList mode={Config.MODE.BUY} />
                        </>
                    }
                />
                <Route
                    exact
                    path="/sell"
                    element={
                        <>
                            <Header
                                iconHeader={
                                    Config.HEADER_CONFIG.sell.iconHeader
                                }
                                title={Config.HEADER_CONFIG.sell.title}
                                subTitle={Config.HEADER_CONFIG.sell.subTitle}
                            />{' '}
                            <CardList mode={Config.MODE.SELL} />
                        </>
                    }
                />
                <Route
                    exact
                    path="/selectCard"
                    element={
                        <>
                            <Header
                                iconHeader={
                                    Config.HEADER_CONFIG.play.iconHeader
                                }
                                title={Config.HEADER_CONFIG.play.title}
                                subTitle={Config.HEADER_CONFIG.play.subTitle}
                            />{' '}
                            <SelectCardForGame />
                        </>
                    }
                />
                <Route
                    exact
                    path="/play"
                    element={
                        <>
                            <Header
                                iconHeader={
                                    Config.HEADER_CONFIG.play.iconHeader
                                }
                                title={Config.HEADER_CONFIG.play.title}
                                subTitle={Config.HEADER_CONFIG.play.subTitle}
                            />{' '}
                            <GameZone />
                        </>
                    }
                />
                <Route exact path="/register" element={<Register />} />
                <Route exact path="/login" element={<Login />} />
                <Route
                    path="*"
                    element={
                        <>
                            <Header /> <Error />
                        </>
                    }
                />
            </Routes>
        </Router>
    );
}

export default App;
