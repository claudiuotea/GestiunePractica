import React, { useState } from 'react'
import Login from './Login'
import Home from './Home'
import './style.css'
import Register from './Register'

export default function App() {
	const [login, setLogin] = useState(true)
	const [user, setUser] = useState(null)

	function toRegister() {
		setLogin(false)
	}

	function toLogin() {
		setLogin(true)
	}

	function authenticate(jwt) {
		setUser(jwt)
	}

	return <div>{user ? <Home/> : (login ? <Login authenticate={authenticate} toRegister={toRegister} /> : <Register authenticate={authenticate} toLogin={toLogin} />)}</div>
}
