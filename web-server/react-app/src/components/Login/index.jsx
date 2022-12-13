import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Config from '../../config';
import { useDispatch } from 'react-redux';
import { connectUserAction } from '../../core/actions/user.action';
import GameService from '../../ws/gameService';
import { socket } from '../../ws';

function Login() {
    const [email, setEmail] = useState([]);
    const [password, setPwd] = useState([]);

    let dispatch = useDispatch();
    //let history = useHistory();
    const navigate = useNavigate();

    function connectUser() {
        const login = {
            mail: email,
            password: password,
        };

        fetch(Config.API_USER_PATH + 'auth', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
            body: JSON.stringify(login),
        })
            .then((response) => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    alert(
                        "Une erreur est survenue lors de la connexion de l'utlisateur"
                    );
                }
            })
            .then((json) => {
                if (json !== undefined || json !== 0) {
                    fetch(Config.API_USER_PATH + 'user/' + json)
                        .then((response) => response.json())
                        .then((json) => {
                            console.log(json);
                            dispatch(connectUserAction(json));
                            navigate('/');
                        });
                }
            });
    }

    //Call
    var gameService = new GameService(socket, navigate);

    return (
        <div
            className="ui middle aligned center aligned grid"
            style={{ height: '100%' }}
        >
            <div
                className="column"
                style={{ maxWidth: '450px', marginTop: '6em' }}
            >
                <h2 className="ui teal image header">
                    <div className="content">Log-in to your account</div>
                </h2>

                <div className="ui large form">
                    <div className="ui stacked segment">
                        <span id="error" className="error"></span>
                        <div className="field">
                            <div
                                id="emailLoginContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="email"
                                    name="email"
                                    placeholder="Email"
                                    onChange={(event) =>
                                        setEmail(event.target.value)
                                    }
                                ></input>
                                <i className="user icon"></i>
                            </div>
                        </div>
                        <div className="field">
                            <div
                                id="pwdLoginContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="password"
                                    name="password"
                                    placeholder="Password"
                                    onChange={(event) =>
                                        setPwd(event.target.value)
                                    }
                                ></input>
                                <i className="lock icon"></i>
                            </div>
                        </div>
                        <button
                            className="ui fluid large teal button"
                            onClick={() => connectUser(email, password)}
                        >
                            Login
                        </button>
                    </div>
                    <div className="ui error message"></div>
                </div>

                <div className="ui message">
                    New to us? <Link to="/register">Sign Up</Link>
                </div>
            </div>
        </div>
    );
}

export default Login;
