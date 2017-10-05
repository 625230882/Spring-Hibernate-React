
let department = (state = {departments:[], ds:[]}, action) => {
    switch(action.type) {
        case 'ADD_DEPARTMENT':
            return Object.assign({}, state, {
                departments: [
                    ...state.departments,
                    {
                        name: action.data.name,
                        email: action.data.email
                    }
                ]
            });
        case 'NAME_CHANGE': 
            return Object.assign({}, state, {
                name: action.data
            });
        case 'EMAIL_CHANGE': 
            return Object.assign({}, state, {
                email: action.data
            });
        case 'CHECKEDBOX_CHANGE':
            return Object.assign({}, state, {
                ds: [
                        ...state.ds,
                    {
                        id: action.data
                    }
                ]
            });
        default :
            return state;
    }
}

export default department;