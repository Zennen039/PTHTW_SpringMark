import { useContext, useState } from "react";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { Navigate } from "react-router";
import { Button, Form } from "react-bootstrap";
import { MyDispatchContext, MyUserContext } from "../../App";

const Login = () => {
    const [username, setUsername] = useState();

    const [password, setPassword] = useState();

    const user = useContext(MyUserContext);

    const dispatch = useContext(MyDispatchContext);

    const login = async (e) => {
        e.preventDefault();

        try {
            let res = await APIs.post(endpoints['login'], {
                "username": username,
                "password": password
            });

            cookie.save("access-token", res.data)

            let user = await authAPIs().get(endpoints['current-user']);

            cookie.save("user", user.data);

            dispatch({
                "type": "login",
                "payload": user.data
            });
        } catch (ex) {
            console.error(ex);
        }
    }

    if (user !== null)
        return <Navigate to="/subjects/" />

    return (<>
        <h1 className="text-center text-info mt-1">SIGN IN</h1>

        <Form method="post" onSubmit={login}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Username:</Form.Label>
                <Form.Control type="text" placeholder="Tên đăng nhập" value={username} onChange={e => setUsername(e.target.value)} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Password: </Form.Label>
                <Form.Control type="password" placeholder="Mật khẩu" value={password} onChange={e => setPassword(e.target.value)} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Button type="submit" variant="success" className="btn-outline-light m-1 rounded-pill">
                    Submit
                </Button>
            </Form.Group>
        </Form>
    </>);
}

export default Login;