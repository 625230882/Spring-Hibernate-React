let error = (state = {loginError: ""}, action) => {
    let newState;
    switch(action.type) {
        case 'LOGIN_ERROR': {
            newState = Object.assign({}, state, {
                loginError: action.errorMessage
            });
            return newState;
        }
        default:
            return state;
    }

}

export default error;