import React, { useState } from 'react'
import Login from './Login'
import './style.css'
import Register from './Register'

export default function App() {
	const [login, setLogin] = useState(true)

	function toRegister() {
		setLogin(false)
	}

	function toLogin() {
		setLogin(true)
	}

	return <div>{login ? <Login toRegister={toRegister} /> : <Register toLogin={toLogin} />}</div>
}
