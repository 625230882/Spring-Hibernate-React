import React from 'react'
import { Router, Route, browserHistory,IndexRoute } from 'react-router'
import { render } from 'react-dom'
import { Provider } from 'react-redux'


import Login from './containers/Login'
import Menu from './containers/Menu'
import Employee from './containers/Employee'
import Department from './containers/Department'

import configureStore from './store/configureStore'
import { syncHistoryWithStore, routerReducer } from 'react-router-redux'



const store = configureStore()


const history = syncHistoryWithStore(browserHistory, store)

render((
   <Provider store={store}> 
        <Router history={history}>
            <Route path="/AntraProject/" component={Login} />
            <Route path='/AntraProject/menu' component={Menu}/>
            <Route path='/AntraProject/employee' component={Employee}/>
            <Route path='/AntraProject/department' component={Department}/>
        </Router>
   </Provider>
), document.getElementById('root'))