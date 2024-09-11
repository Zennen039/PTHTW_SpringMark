import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { useNavigate, useSearchParams } from "react-router-dom";
import APIs, { endpoints } from "../../configs/APIs";

const Subject = () => {
    const [subjects, setSubs] = useState([]);
    const [q] = useSearchParams();
    const navigate = useNavigate();

    const loadSubs = async () => {
        try {
            let url = endpoints['subjects'];

            let subjectId = q.get('subjectId');

            if (subjectId)
                url = `${url}?subjectId=${subjectId}`;

            let res = await APIs.get(url);

            setSubs(res.data);
        } catch (ex) {
            console.error(ex);
        }
    };

    useEffect(() => {
        loadSubs();
    }, [q]);

    const handleSubjectDetailsClick = () => {
        navigate('/subjectdetails/');
    };

    const handleAddUserClick = () => {
        navigate('/adduser/')
    };

    return (
        <>
            <h1 className="text-center text-info mt-1">SUBJECT</h1>

            <Button type="submit" value="primary" onClick={handleSubjectDetailsClick} className="btn-outline-light m-1 rounded-pill">
                Add subject
            </Button>{' '}

            <Button type="submit" value="primary" onClick={handleAddUserClick} variant="success" className="btn-outline-light m-1 rounded-pill">
                Add user
            </Button>

            {subjects.map(s => {
                <Table striped bordered hover key={s.id}>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Lecturer</th>
                            <th>Details</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td>{s.id}</td>
                            <td>{s.name}</td>
                            <td>{s.description}</td>
                            <td>{s.lecturerName}</td>
                            <td>
                                <Button>See details</Button>{' '}
                                <Button variant="success">Update</Button>{' '}
                                <Button variant="danger">Delete</Button>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </Table>
            })}
        </>
    );
}

export default Subject;