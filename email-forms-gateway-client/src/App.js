import Table from "./components/Table";
import Navbar from "./components/Navbar";
import {Component} from "react";
import Modal from "./components/Modal";

class App extends Component {

    state = {
        items: [],
        isModalVisible: false
    }

    componentDidMount() {
        this.fetchItems();
    }

    fetchItems = () => {
        fetch(`${process.env.REACT_APP_API_URL}/api/forms`)
            .then((res) => res.json())
            .then((items) => this.setState({items}))
    }

    newItem = ({ formName, forwardTo }) => {
        return fetch(`${process.env.REACT_APP_API_URL}/api/forms`, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify({
                formName,
                forwardTo
            })
        }).then(() => {
            this.fetchItems()
        })
    }

    toggleModal = () => {
        this.setState({
            isModalVisible: !this.state.isModalVisible
        })
    }

    render() {
        const { items, isModalVisible } = this.state;
        return (
            <>
                <Navbar/>

                <div className="container grid-xl mt-2">
                    <Table items={items}/>
                    <div className="mt-2">
                        <button className="btn float-right" onClick={this.toggleModal}>Add new form</button>
                    </div>
                </div>

                {isModalVisible &&
                    <Modal closeFn={this.toggleModal} submitFn={this.newItem}/>
                }
            </>
        );
    }
}

export default App;
