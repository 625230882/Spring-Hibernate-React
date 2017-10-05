import { combineReducers } from 'redux'


import error from './error'
import employee from './employee'
import department from './department'

import { syncHistoryWithStore, routerReducer } from 'react-router-redux'

// Add the reducer to your store on the `routing` key

//使用redux的combineReducers方法将所有reducer打包起来
const rootReducer = combineReducers({
  error,
  employee,
  department,
  routing: routerReducer
})

export default rootReducer
