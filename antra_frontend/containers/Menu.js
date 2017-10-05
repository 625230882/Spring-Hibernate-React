import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import  userAction from '../actions/userAction';

class Menu extends React.Component {
    render() {
        let {action} = this.props
        return (
            <div>
                 <button onClick={() => action.logout()}>logout</button> <br/>
                <Link to="/AntraProject/employee">employee</Link><br/>
                <Link to="/AntraProject/department">department</Link>
            </div>
        );
    }
}


let buildActionDispatcher = dispatch => ({
      action: bindActionCreators(userAction, dispatch)
})

export default connect(null, buildActionDispatcher)(Menu);

