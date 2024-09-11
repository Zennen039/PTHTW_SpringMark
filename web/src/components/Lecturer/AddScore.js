import { Button, Form } from "react-bootstrap";

const AddScore = () => {
    return (
        <>
            <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>MSSV: </Form.Label>
                    <Form.Control type="number" placeholder="Nhập MSSV" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Tên: </Form.Label>
                    <Form.Control type="text" placeholder="Nhập họ và tên" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Lớp: </Form.Label>
                    <Form.Control type="text" placeholder="Nhập lớp" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Giữa kỳ: </Form.Label>
                    <Form.Control type="number" placeholder="Nhập điểm giữa kỳ" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Cuối kỳ: </Form.Label>
                    <Form.Control type="number" placeholder="Nhập điểm cuối kỳ" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Điểm cộng || Điểm bổ sung: </Form.Label>
                    <Form.Control type="number" placeholder="Nhập điểm cộng hoặc điểm bổ sung (nếu có)" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Button variant="success" type="submit" className="btn-outline-light m-1 rounded-pill">
                        Submit
                    </Button>
                </Form.Group>
            </Form>
        </>
    );
}

export default AddScore;