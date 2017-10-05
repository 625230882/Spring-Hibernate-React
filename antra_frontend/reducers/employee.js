let employee = (state={employees: []}, action) => {
    switch(action.type) {
        case 'ADD_EMPLOYEE':
            return Object.assign({}, state, {
                employees: [
                    ...state.employees,
                    {
                        firstName: action.data.firstName,
                        lastName: action.data.lastName,
                        age: action.data.age
                    }
                ]
            });
        default:
            return state;
    }
}
export default employee;