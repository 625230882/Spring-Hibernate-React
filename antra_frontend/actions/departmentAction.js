let action = {
    upload: () => (dispatch, getState) => {
        let department = getState().department;
        if (department.name == null || department.name.trim() == "" || department.email == null 
            || department.email.trim() == ""){
            alert("please input the required fields!");
            return;
        }
        let data = {};
        data.name = department.name;
        data.email = department.email;
        let jsonData = 'value=' + JSON.stringify(data);
        $.ajax({
            url: '/AntraProject/department',
            method: 'post',
            data: jsonData,
            contentType: 'application/x-www-form-urlencoded',
            cache: false,
            processData: false
        }).done((data) => {
            if(data.success != null || data.success != undefined)
                dispatch(action.addDepartment(data));
        })
    },

    addDepartment: (department) => ({
        type: 'ADD_DEPARTMENT',
        data: department
    }),

    nameChange: (name) => ({
        type: 'NAME_CHANGE',
        data: name
    }),
    
    emailChange: (email) => ({
        type: 'EMAIL_CHANGE',
        data: email
    }),

    checkedBoxChange: (department) => ({
        type: 'CHECKEDBOX_CHANGE',
        data: department
    })
}

export default action;