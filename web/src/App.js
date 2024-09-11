import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './layout/header';
import Login from './components/User/Login';
import MyUserReducer from './reducers/MyUserReducer';
import { createContext, useReducer } from 'react';
import Subject from './components/Volume/Subject';
import SubjectDetails from './components/Volume/SubjectDetails';
import AddUser from './components/Volume/AddUser';
import See from './components/Student/See';
import Register from './components/User/Register';
import ScoreDetails from './components/Lecturer/ScoreDetails';
import Forum from './components/Forum/Forum';
import AddForum from './components/Forum/AddForum';
import AddScore from './components/Lecturer/AddScore';

export const MyUserContext = createContext();
export const MyDispatchContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, null);

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
        <BrowserRouter>
          <Header />
          <Container>
            <Routes>
              <Route path='/' />
              <Route path='/register/' element={<Register />} />
              <Route path='/login/' element={<Login />} />
              <Route path='/subjects/' element={<Subject />} />
              <Route path='/subjectdetails/' element={<SubjectDetails />} />
              <Route path='/adduser/' element={<AddUser />} />
              <Route path='/see/' element={<See />} />
              <Route path='/scoredetails/' element={<ScoreDetails />} />
              <Route path='/addscores/' element={<AddScore />} />
              <Route path='/forums/' element={<Forum />} />
              <Route path='/addforums/' element={<AddForum />} />
            </Routes>
          </Container>
        </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
  );
}

export default App;