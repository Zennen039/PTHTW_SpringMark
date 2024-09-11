import { useRef, useState } from "react";
import { useNavigate } from "react-router";
import { Alert, Button, Form } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";

const Register = () => {
    const [user, setUser] = useState({});
    const [err, setErr] = useState();
    const nav = useNavigate();
    const avatar = useRef();

    const register = async (e) => {
        e.preventDefault();

        if (user.password === undefined || user.password !== user.confirm)
            setErr("Wrong password!");

        else {
            let form = new FormData();

            for (let f in user)
                if (f !== 'confirm') {
                    form.append(f, user[f]);
                }

            form.append('avatar', avatar.current.files[0]);

            let res = await APIs.post(endpoints['register'], form, {
                headers: {
                    'Content-Type': "multipart/form-data"
                }
            });

            console.info(res.data);

            nav("/login/");
        }
    }

    const change = (e, field) => {
        setUser({ ...user, [field]: e.target.value })
    }

    return (
        <>
            <h1 className="text-center text-info mt-1">SIGN UP</h1>

            {err && <Alert variant="danger">{err}</Alert>}

            <Form method="post" onSubmit={register}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>First Name: </Form.Label>
                    <Form.Control type="text" placeholder="Tên" value={user["firstName"]} onChange={e => change(e, "firstName")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Last name: </Form.Label>
                    <Form.Control type="text" placeholder="Họ và tên lót" value={user["lastName"]} onChange={e => change(e, "lastName")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Email: </Form.Label>
                    <Form.Control type="text" placeholder="Email của bạn" value={user["email"]} onChange={e => change(e, "email")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Mobile phone: </Form.Label>
                    <Form.Control type="text" placeholder="Số điện thoại" value={user["phone"]} onChange={e => change(e, "phone")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Username: </Form.Label>
                    <Form.Control type="text" placeholder="Tên đăng nhập" value={user["username"]} onChange={e => change(e, "username")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea3">
                    <Form.Label>Password: </Form.Label>
                    <Form.Control type="password" placeholder="Mật khẩu" value={user["password"]} onChange={e => change(e, "password")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea4">
                    <Form.Label>Confirm</Form.Label>
                    <Form.Control type="password" placeholder="Xác nhận mật khẩu" value={user["confirm"]} onChange={e => change(e, "confirm")} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea7">
                    <Form.Label>Avatar: </Form.Label>
                    <Form.Control accept=".png,.jpg" type="file" ref={avatar} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea5">
                    <Button type="submit" variant="success" className="btn-outline-light m-1 rounded-pill">
                        OK
                    </Button>
                </Form.Group>
            </Form>
        </>
    );
}

export default Register;