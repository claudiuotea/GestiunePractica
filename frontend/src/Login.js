import React, { useState } from 'react'
import './style.css'

export default function Login({ toRegister }) {
	const [username, setUsername] = useState('')
	const [password, setPassword] = useState('')

	function submit(event) {
		event.preventDefault()

		// Send data to backend
		alert(`Username: ${username} and Password ${password}`)

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
