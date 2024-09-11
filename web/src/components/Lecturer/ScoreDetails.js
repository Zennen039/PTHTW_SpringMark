import { Button, Col, Container, Form, Row, Table } from "react-bootstrap";

const ScoreDetails = () => {
    return (
        <Container>
            <Row className="mb-3 p-3">
                <Col xs={12} md={8} className="d-flex align-items-center">
                    <Form className="w-100">
                        <Form.Group as={Row} className="mb-3" controlId="formSearch">
                            <Col xs={9}>
                                <Form.Control type="text" placeholder="Tìm kiếm sinh viên theo MSSV, họ tên" />
                            </Col>

                            <Col xs={3}>
                                <Button variant="primary" type="submit">Tìm</Button>
                            </Col>
                        </Form.Group>
                    </Form>
                </Col>
            </Row>

            <Row>
                <Col>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>MSSV</th>
                                <th>Tên</th>
                                <th>Lớp</th>
                                <th>Giữa kỳ</th>
                                <th>Cuối kì</th>
                                <th>Điểm cộng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>2151050020</td>
                                <td>Nguyễn Vân Anh</td>
                                <td>DH21IT01</td>
                                <td>5</td>
                                <td>5</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>2151011129</td>
                                <td>Trương Thị Bảo Ngọc</td>
                                <td>DH21CS01</td>
                                <td>7</td>
                                <td>7</td>
                                <td>2</td>
                            </tr>
                        </tbody>
                    </Table>
                </Col>
            </Row>

            <Button variant="warning" className="btn-outline-light rounded-pill m-1">
                Save
            </Button>

            <Button variant="success" className="btn-outline-light rounded-pill m-1" href="/addscores/">
                Add
            </Button>

            <Button variant="danger" className="btn-outline-light rounded-pill m-1">
                Delete
            </Button>

            <Button variant="secondary" className="btn-outline-light rounded-pill m-1" href="/forums/">
                Forum
            </Button>
        </Container>
    );
}

export default ScoreDetails;