let actions = {
    upload: (firstName, lastName, age) => (dispatch) => {
        // let formData = new FormData();
        var employee = {}
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.age = age;
        var jsonData = "employee=" + JSON.stringify(employee);
        $.ajax({
            url: '/AntraProject/employee',
            method: 'post',
            data: jsonData,
            contentType: 'application/x-www-form-urlencoded',
            cache: false,
            processData: false
        }).done((data) => {
            console.log(data);
            if(data.employees != null && data.employees != undefined)
                dispatch(actions.addEmployee(data.employees));
        })
    },

    addEmployee: (employees) => ({
        type: 'ADD_EMPLOYEE',
        data: employees
    })

}

export default actions;