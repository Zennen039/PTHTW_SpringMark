import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../configs/APIs";
import { Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row } from "react-bootstrap";
import { MyDispatchContext, MyUserContext } from "../App";
import { Link } from "react-router-dom";

const Header = () => {
    const [categories, setCates] = useState([]);
    const user = useContext(MyUserContext)
    const dispatch = useContext(MyDispatchContext);

    const loadCates = async () => {
        try {
            let res = await APIs.get(endpoints['categories']);

            setCates(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadCates();
    }, [])

    const styles = {
        btn: {
            backgroundColor: '#9FC0C9'
        }
    }

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="/">GMW</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/">Home</Nav.Link>

                            <NavDropdown title="Categories" id="basic-nav-dropdown">

                                {categories.map(c => {
                                    const url = `/?subjectId=${c.id}`;

                                    return <Link to={url} className='dropdown-item' key={c.id}>{c.name}</Link>;
                                })}

                            </NavDropdown>

                            <Nav.Link href="/subjects/" active>Subjects</Nav.Link>

                            <NavDropdown title="Scores" id="basic-nav-dropdown" active>
                                <NavDropdown.Item href="/scoredetails/">Lớp DH21IT01</NavDropdown.Item>
                                <NavDropdown.Item href="/scoredetails/">Lớp DH21CS01</NavDropdown.Item>
                            </NavDropdown>

                            {user === null ? <>
                                <Link className='btn btn-outline-light rounded-pill m-1' style={styles.btn} to="/login/">Sign in</Link>

                                <Link className='btn btn-outline-light rounded-pill m-1' style={styles.btn} to="/register/">Sign up</Link>


                            </> : <>
                                <Link className='nav-link text-success' to="/login/">
                                    <Image src={user.avatar} width="25" roundedCircle className="m-1" />
                                    Chào {user.firstName}!</Link>

                                <Button variant='secondary' className="btn-outline-light text-center rounded-pill m-1" onClick={() => dispatch({ "type": "logout" })}>
                                    Sign out
                                </Button>
                            </>}
                        </Nav>
                    </Navbar.Collapse>

                    <Form inline>
                        <Row>
                            <Col xs="auto">
                                <Form.Control type="text" placeholder="Nhập môn học" className="m-1" />
                            </Col>

                            <Col xs="auto">
                                <Button type="submit" className="btn-outline-light m-1 rounded-pill">
                                    Tìm
                                </Button>
                            </Col>
                        </Row>
                    </Form>
                </Container>
            </Navbar>
        </>
    );
}

export default Header;