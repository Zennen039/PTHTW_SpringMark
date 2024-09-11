import { Button, Container, Form } from "react-bootstrap";

const AddUser = () => {
    return (
        <Container>
            <h1 className="text-center text-info mt-1">USER MANAGEMENT</h1>

            <Form>
                <Form.Group className="mb-3" controlId="firstName">
                    <Form.Label>First name: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="lastName">
                    <Form.Label>Last name: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="email">
                    <Form.Label>Email: </Form.Label>
                    <Form.Control type="email" placeholder="email@edu.vn" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="phone">
                    <Form.Label>Mobile phone: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="username">
                    <Form.Label>Username: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="password">
                    <Form.Label>Password: </Form.Label>
                    <Form.Control type="password" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="userRole">
                    <Form.Label>Role: </Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Lecturer</option>
                        <option value="2">Student</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group className="mb-3" controlId="avatar">
                    <Form.Label>Avatar: </Form.Label>
                    <Form.Control type="file" accept=".png, .jpg" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Button type="submit" value="primary" className="btn-outline-light m-1 rounded-pill">
                        Add
                    </Button>
                </Form.Group>
            </Form>

        </Container>
    );
}

export default AddUser;