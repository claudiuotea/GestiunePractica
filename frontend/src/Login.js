import React, { useState } from 'react'
import './style.css'
import axios from 'axios'

const PORT = '3306'
const BASE_URL = `http://localhost:${PORT}`

export default function Login({ toRegister, authenticate }) {
	const [username, setUsername] = useState('')
	const [password, setPassword] = useState('')

	function submit(event) {
		event.preventDefault()

		// Send data to backend
		axios.post(`${BASE_URL}/user/login`, {
			username,
			password
		}).then(res => {
			authenticate(res.data)
		}).catch(e => {
			console.log(e)
			alert('Something went wrong')
		})

		// Reset form
		setUsername('')
		setPassword('')
	}

	return (
		<div className='component'>
			<h1>Login</h1>
			<form onSubmit={submit} className='form'>
				<label>
					<span>Username</span>
					<input type='text' value={username} onChange={e => setUsername(e.target.value)} />
				</label>
				<label>
					<span>Password</span>
					<input type='password' value={password} onChange={e => setPassword(e.target.value)} />
				</label>
				<button type='submit'>Log in</button>
			</form>
			<button onClick={toRegister} className='secondary-btn'>
				Go to Register
			</button>
		</div>
	)
}
