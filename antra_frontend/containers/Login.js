import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import  userAction from '../actions/userAction';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            password: ''
        };
    }
    componentDidMount() {

    }

    handleClick(){
        this.props.userAction.logout();
    }

    handleUserNameChange(event) {
        this.setState ({
            userName: event.target.value
        })
    }

    handlePasswordChange(event) {
        this.setState ({
            password: event.target.value
        })
    }

    render() {
        
        let {error, action } = this.props;
        
        return (

            <div>
                <div>{error.loginError}</div>
                Username: <input type="userName"  onChange={this.handleUserNameChange.bind(this)}></input>
                Password: <input type="password"  onChange={this.handlePasswordChange.bind(this)}></input> 
                <button onClick={() => action.login(this.state.userName,this.state.password)}>login</button>
            </div>
        )
    }
}

let selectState = (state) => ({
        error: state.error
})

let buildActionDispatcher = (dispatch) =>({
      action: bindActionCreators(userAction, dispatch)
})

export default connect(selectState, buildActionDispatcher)(Login);

