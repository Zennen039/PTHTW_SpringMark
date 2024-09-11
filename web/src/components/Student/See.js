import { Table } from "react-bootstrap";

const See = () => {
    return (
        <div className="container mt-4">
            <h1 className="mb-4">Subject List</h1>
            
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Subject name</th>
                        <th>Lecturer</th>
                        <th>Midterm</th>
                        <th>Final</th>
                        <th>Additional score</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>
                            <a href="#!">Phát triển hệ thống web</a>
                        </td>
                        <td>Dương Hữu Thành</td>
                        <td>5.0</td>
                        <td>5.5</td>
                        <td>0.0</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>
                            <a href="#!">Triết Học Mác-Lênin</a>
                        </td>
                        <td>Huỳnh Kim Ngân</td>
                        <td>8.5</td>
                        <td>8.4</td>
                        <td>8.0</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
}

export default See;