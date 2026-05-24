import './style.css'
import logo from '/src/assets/Assinatura Versão Preferencial Horizontal Reduzida.png'
import { useNavigate } from 'react-router-dom'

function Login() {
  
    const navigate = useNavigate()

  return (
      
        <div className='container'>
        
        <img src={logo} alt="Logo" className='logo' />

        <button className='btn-cadastro' onClick={() => navigate('/cadastro')}>Cadastre-se</button>  
        
          <form>
            <h1>Login</h1> 
            <div className='inputs'>
                <label>Usuário:</label>
                <input name='user' type='text'  placeholder='Digite seu email...'/>
            </div>
          <div className='inputs'>  
            <label>Senha:</label>
            <input name='matricula' type='password' placeholder='Digite sua senha...'/>
          </div>
              <button className="btn-recuperar" type='button'>Recuperar Senha</button>
              <button className="btn-Entrar" type='button'>Entrar</button>
  
          </form>
        </div>
    
  )
}

export default Login
