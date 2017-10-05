import { browserHistory } from "react-router"

let actions = {

    logout: () => dispatch => {
        $.ajax({
            url: '/AntraProject/logout',
            method: 'get'
        }).done(data => {
            browserHistory.push('/AntraProject/')
        }).fail();
    },

    login: (userName, password) => (dispatch, getState) =>{
        let jsonData = 'value=';
        let form = {};
        form.userName = userName;
        form.password = password;
        $.ajax({
            url: '/AntraProject/login',
            method: 'post',
            data: jsonData + JSON.stringify(form),
            contentType: 'application/x-www-form-urlencoded',
            cache: false,
            processData:false
        }).done(data => {
            data = JSON.parse(data);
            //console.log($.parseJSON(data));
            if(data.success != null && data.success != undefined)
                browserHistory.push('/AntraProject/menu');
            else if(data.errorMessage != null && data.errorMessage != undefined)
                dispatch(actions.loginError(data.errorMessage));
        }).fail();
    },

    loginError: (errorMessage) => ({
        type: 'LOGIN_ERROR',
        errorMessage: errorMessage
    })
}

export default actions;