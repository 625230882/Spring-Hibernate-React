import { createStore, applyMiddleware} from 'redux'
import thunkMiddleware from "redux-thunk"
import reducer from '../reducers'
import  { createLogger }  from "redux-logger";

//applyMiddleware来自redux可以包装 store 的 dispatch
//thunk作用是使action创建函数可以返回一个function代替一个action对象


const loggerMiddleware = createLogger()

export default function configureStore(preloadedState) {
  return createStore(
    reducer,
    preloadedState,
    applyMiddleware(
      thunkMiddleware,
      loggerMiddleware
    )
  )
}