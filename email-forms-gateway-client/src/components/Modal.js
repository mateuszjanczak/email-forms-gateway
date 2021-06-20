import {Component} from "react";

class Modal extends Component {
    state = {
        formName: "",
        forwardTo: ""
    }

    handleSubmit = () => {
        const { submitFn, closeFn } = this.props;
        submitFn(this.state).then(closeFn)
    }

    handleChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    }

    render() {
        const {closeFn} = this.props;
        return (
            <div className="modal active" id="modal-id">
                <a className="modal-overlay" aria-label="Close" onClick={closeFn}/>
                <div className="modal-container">
                    <div className="modal-header">
                        <a className="btn btn-clear float-right" aria-label="Close" onClick={closeFn}/>
                        <div className="modal-title h5">New form</div>
                    </div>
                    <div className="modal-body">
                        <div className="content">
                            <div className="form-group">
                                <label className="form-label" htmlFor="formName">Form name</label>
                                <input className="form-input" type="text" id="formName" name="formName" placeholder="Name" onChange={this.handleChange}/>
                            </div>
                            <div className="form-group">
                                <label className="form-label" htmlFor="forwardTo">Forward to</label>
                                <input className="form-input" type="email" id="forwardTo" name="forwardTo" placeholder="Email" onChange={this.handleChange}/>
                            </div>
                            <div className="mt-2">
                                <button className="btn float-right" onClick={this.handleSubmit}>Add new form</button>
                            </div>
                        </div>
                    </div>
                    <div className="modal-footer">

                    </div>
                </div>
            </div>
        );
    }
}

export default Modal;
