import axios from "axios"
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/GradeManageWeb/api/';

export const endpoints = {
    'categories': '/categories/',
    'subjects': '/subjects/',
    'users': '/users/',
    'current-user': '/current-user/',
    'login': '/login/',
    'register': '/users/'
}

export const authAPIs = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': cookie.load("access-token")
        }
    })
}

export default axios.create({
    baseURL: BASE_URL
});