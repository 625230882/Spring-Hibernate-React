import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import departmentAction from '../actions/departmentAction';
import userAction from '../actions/userAction';

class Department extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            checked: false
        }
    }
    handleNameChange(event) {
        this.props.departmentAction.nameChange(event.target.value);
    }

    handleEmailChange(event) {
        this.props.departmentAction.emailChange(event.target.value);
    }

    handleCheckedBoxChange(event) {
        if(event.target.checked == 'true')
            this.props.departmentAction.checkedBoxChange(event.target.value);

    }
    render() {
        const {department, departmentAction, userAction} = this.props;
        return (
            <div>
                Department Name: <input type="text" onChange={this.handleNameChange.bind(this)}></input><p/>
                email:          <input type="text" onChange={this.handleEmailChange.bind(this)}></input><p/>
                check1: <input type="checkbox" value="1" onChange={this.handleCheckedBoxChange.bind(this)}></input><p/>
                check2: <input type="checkbox" value="2" onChange={this.handleCheckedBoxChange.bind(this)}></input><p/>


                <button onClick={() => departmentAction.upload()}>add</button>
                <button onClick={() => userAction.logout()}>logout</button> <br/>

                <div>
                    {
                    department.departments != null && department.departments != undefined ? 
                        department.departments.length > 0 ?
                            department.departments.map(dept =>
                                <li>{dept.name + ' ' + dept.email}</li>
                            ) : null
                    : null
                    }
                </div>
            </div>
        )
    }
}


let selectState = (state) => ({
        department: state.department
})

let buildActionDispatcher = (dispatch) =>({
      departmentAction: bindActionCreators(departmentAction, dispatch),
      userAction: bindActionCreators(userAction, dispatch)
})

export default connect(selectState, buildActionDispatcher)(Department);


