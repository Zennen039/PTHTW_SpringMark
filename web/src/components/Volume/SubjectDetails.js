import { Button, Container, Form } from "react-bootstrap";

const SubjectDetails = () => {
    return (
        <Container>
            <h1 className="text-center text-info mt-1">SUBJECT MANAGEMENT</h1>

            <Form>
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>Id</Form.Label>
                    <Form.Control type="number" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="name">
                    <Form.Label>Subject name: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="description">
                    <Form.Label>Subject description: </Form.Label>
                    <Form.Control type="text" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="lecturerName">
                    <Form.Label>Lecturer: </Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Võ Thùy Linh</option>
                        <option value="2">Dương Hữu Thành</option>
                        <option value="3">Huỳnh Kim Ngân</option>
                        <option value="4">Nguyễn Vanh</option>
                        <option value="5">Trương Văn Tài</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group className="mb-3" controlId="cateId">
                    <Form.Label>Category: </Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Đại cương</option>
                        <option value="2">Chuyên ngành</option>
                        <option value="3">Ngoại ngữ</option>
                        <option value="4">Thể chất</option>
                    </Form.Select>
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

export default SubjectDetails;