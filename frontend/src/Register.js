import React, { useState } from 'react'
import './style.css'
import axios from 'axios'

const PORT = '3306'
const BASE_URL = `http://localhost:${PORT}`

export default function Register({ toLogin, authenticate }) {
	const [userName, setUserName] = useState('')
	const [firstName, setFirstName] = useState('')
	const [lastName, setLastName] = useState('')
	const [email, setEmail] = useState('')
	const [password, setPassword] = useState('')
	const [confirmPassword, setConfirmPassword] = useState('')

	function submit(event) {
		event.preventDefault()

		// Send data to backend
		if (password !== confirmPassword) {
			alert('Passwords do not match')
			return
		}

		axios.post(`${BASE_URL}/user/register`, {
			username: userName,
			email,
			password
		}).then(res => {
			authenticate(res.data)
		}).catch(e => {
			alert('Something went wrong')
		})

		// Reset form
		setUserName('')
		setFirstName('')
		setLastName('')
		setEmail('')
		setPassword('')
		setConfirmPassword('')
	}

	return (
		<div className='component inverse'>
			<h1>Register</h1>
			<form onSubmit={submit} className='form'>
				<div className='form-section'>
					<div className='form-part'>
						<label>
							<span>First Name</span>
							<input type='text' value={firstName} onChange={e => setFirstName(e.target.value)} />
						</label>
						<label>
							<span>Last Name</span>
							<input type='text' value={lastName} onChange={e => setLastName(e.target.value)} />
						</label>
						<label>
							<span>Username</span>
							<input type='text' value={userName} onChange={e => setUserName(e.target.value)} />
						</label>
					</div>
					<div className='form-part'>
						<label>
							<span>Email</span>
							<input type='email' value={email} onChange={e => setEmail(e.target.value)} />
						</label>
						<label>
							<span>Password</span>
							<input type='password' value={password} onChange={e => setPassword(e.target.value)} />
						</label>
						<label>
							<span>Confirm Password</span>
							<input type='password' value={confirmPassword} onChange={e => setConfirmPassword(e.target.value)} />
						</label>
					</div>
				</div>
				<button type='submit'>Register</button>
			</form>
			<button onClick={toLogin} className='secondary-btn'>
				Go to Login
			</button>
		</div>
	)
}
