import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { Link } from 'react-router';

import employeeAction from '../actions/employeeAction';
import userAction from '../actions/userAction';

class Employee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: '',
            LastName: '',
            age: '',
        }
    }

    handleFirstNameChange(event) {
        this.setState({
            lastName: event.target.value
        });
    } 

    handleLastNameChange(event) {
        this.setState({
            firstName: event.target.value
        });
    } 

    handleAgeChange(event) {
        this.setState({
            age: event.target.value
        });
    } 
    render() {
        //console.log(this.props)
        const {userAction, employeeAction, employeeData} = this.props
        return (
            <div>
                FirstName: <input type="text" onChange={this.handleFirstNameChange.bind(this)}></input><p/>
                LastName: <input type="text" onChange={this.handleLastNameChange.bind(this)}></input><p/>
                Age: <input type="text" onChange={this.handleAgeChange.bind(this)}></input><p/>
                <button onClick={() => employeeAction.upload(this.state.firstName, this.state.lastName, this.state.age)}>add</button>
                <button onClick={() => userAction.logout()}>logout</button> <br/>
                <div>
                    {
                    employeeData.employees != null && employeeData.employees != undefined ? 
                        employeeData.employees.length > 0 ?
                            employeeData.employees.map(employee =>
                                <li>{employee.firstName + ' ' + employee.lastName + ' ' + employee.age}</li>
                            ) : null
                    : null
                    }
                </div>
            </div>
        )
    }
}

let selectState = (state) => ({
        employeeData: state.employee
})

let buildActionDispatcher = (dispatch) =>({
      userAction: bindActionCreators(userAction, dispatch),
      employeeAction: bindActionCreators(employeeAction, dispatch)
})

export default connect(selectState, buildActionDispatcher)(Employee);