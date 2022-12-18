import React from 'react';
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Config from '../../config';

function Register() {
    const navigate = useNavigate();

    const [email, setEmail] = useState([]);
    const [login, setLogin] = useState([]);
    const [password, setPwd] = useState([]);
    const [repassword, setRePwd] = useState([]);
    const [surname, setSurname] = useState([]);
    const [name, setName] = useState([]);

    function createUser() {
        if (
            repassword === password &&
            login !== '' &&
            password !== '' &&
            repassword !== '' &&
            name !== '' &&
            surname !== '' &&
            email !== ''
        ) {
            const user = {
                password: password,
                money: 0,
                name: name,
                surname: surname,
                mail: email,
            };

            fetch(Config.API_USER_PATH + 'register', {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                    Accept: 'application/json; charset=UTF-8',
                },
                body: JSON.stringify(user),
            }).then((response) => {
                if (response.status === 200) {
                    navigate('/login');
                } else {
                    alert(
                        "Une erreur est survenue lors de la création d'un utlisateur"
                    );
                }
            });
        } else {
            alert(
                'Le mots de passe est sa confirmation ne sont pas identiques ou un des champs est manquant'
            );
        }
    }

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
                    <div className="content">User form</div>
                </h2>
                <div className="ui large form">
                    <div className="ui stacked segment">
                        <span id="error" className="error"></span>
                        <div className="field">
                            <div
                                id="loginRegisterContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="text"
                                    name="login"
                                    placeholder="Login"
                                    onChange={(event) =>
                                        setLogin(event.target.value)
                                    }
                                ></input>
                                <i className="user icon"></i>
                            </div>
                        </div>
                        <div className="field">
                            <div
                                id="emailRegisterContainer"
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
                                id="nameRegisterContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="text"
                                    name="name"
                                    placeholder="Name"
                                    onChange={(event) =>
                                        setName(event.target.value)
                                    }
                                ></input>
                                <i className="user icon"></i>
                            </div>
                        </div>
                        <div className="field">
                            <div
                                id="surnameRegisterContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="text"
                                    name="surname"
                                    placeholder="Surname"
                                    onChange={(event) =>
                                        setSurname(event.target.value)
                                    }
                                ></input>
                                <i className="user icon"></i>
                            </div>
                        </div>
                        <div className="field">
                            <div
                                id="passwordRegisterContainer"
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
                        <div className="field">
                            <div
                                id="RePasswordRegisterContainer"
                                className="ui left icon input"
                            >
                                <input
                                    type="password"
                                    name="repassword"
                                    placeholder="RePassword"
                                    onChange={(event) =>
                                        setRePwd(event.target.value)
                                    }
                                ></input>
                                <i className="lock icon"></i>
                            </div>
                        </div>
                        <button
                            className="ui fluid large teal submit button"
                            onClick={() =>
                                createUser(
                                    login,
                                    password,
                                    repassword,
                                    name,
                                    surname,
                                    email
                                )
                            }
                        >
                            Register
                        </button>
                    </div>
                    <div className="ui error message"></div>
                </div>

                <div className="ui message">
                    Have already an accout? <Link to="/login">Login</Link>
                </div>
            </div>
        </div>
    );
}

export default Register;
