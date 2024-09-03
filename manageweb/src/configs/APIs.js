import axios from "axios"

const BASE_URL = 'http://localhost:8080/GradeManageWeb/'

export const endpoints = {
    'categories': '/api/categories/',
    'subjects': '/api/subjects/'
}

export default axios.create({
    baseURL: BASE_URL
});