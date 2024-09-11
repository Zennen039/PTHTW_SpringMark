import { Button, Form, Table } from "react-bootstrap";
import { useNavigate } from "react-router";

const AddForum = () => {
    const nav = useNavigate();

    const handleAddForumsClick = () => {
        nav('/forums/');
    };

    return (
        <>
            <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Chủ đề:</Form.Label>
                    <Form.Control type="text" placeholder="Nhập chủ đề" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Người khởi tạo:</Form.Label>
                    <Form.Control type="text" placeholder="Tên" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Ngày khởi tạo:</Form.Label>
                    <Form.Control type="date" placeholder="2024-09-05" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label></Form.Label>
                    <Form.Control as="textarea" rows={12} />
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

export default AddForum;