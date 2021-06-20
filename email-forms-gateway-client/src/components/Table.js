function Table({items}) {
    return (
        <table className="table">
            <thead>
            <tr>
                <th>Form name</th>
                <th>Forward to</th>
                <th>URL</th>
            </tr>
            </thead>
            <tbody>

            {items.length > 0 && items.map(({id, formName, forwardTo}) => (
                <tr key={id}>
                    <td>{formName}</td>
                    <td>{forwardTo}</td>
                    <td>http://localhost:8080/api/forms/{id}</td>
                </tr>
            ))}

            </tbody>
        </table>
    );
}

export default Table;
