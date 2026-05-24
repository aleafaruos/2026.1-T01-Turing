import './style.css'
import logo from '/src/assets/Assinatura Versão Preferencial Horizontal Reduzida.png'
import { useNavigate } from 'react-router-dom'


function Cadastro() {
  
      const navigate = useNavigate()

  return (
    
        <div className='container'>
        
        <img src={logo} alt="Logo" className='logo' />

        <button className='btn-login' onClick={() => navigate('/')}>Entrar</button>
          <form>
            <h1>Cadastro</h1> 
            <div className='inputs'>
                <label>Usuário:</label>
                <input name='user' type='text'  placeholder='Digite seu nome...'/>
            </div>
          <div className='inputs'>  
            <label>Email:</label>
            <input name='matricula' type='email' placeholder='Digite seu email...'/>
          </div>
          <div className='inputs'>  
            <label>Senha:</label>
            <input name='matricula' type='password' placeholder='Digite sua senha...'/>
          </div>
            <button className="btn-confirmar" type='button'>Confirmar Cadastro</button>
  
          </form>
        </div>
    
  )
}

export default Cadastro
